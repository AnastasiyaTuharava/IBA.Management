package by.iba.management.view.fxml;

import by.iba.management.dao.EmployeeDAO;
import by.iba.management.dao.ProjectDAO;
import by.iba.management.model.entity.Employee;
import by.iba.management.model.entity.Project;
import by.iba.management.model.logic.ProjectLogic;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProjectProfileController {

    @FXML
    TextField projectId;
    @FXML
    TextField projectName;
    @FXML
    TextField projectDescription;
    @FXML
    TableView<Employee> allEmployeesListView;
    @FXML
    TableColumn<Employee, String> employeeId;
    @FXML
    TableColumn<Employee, String> firstName;
    @FXML
    TableColumn<Employee, String> lastName;
    @FXML
    TableView<Employee> teamList;
    @FXML
    TableColumn<Employee, String> teamEmployeeId;
    @FXML
    TableColumn<Employee, String> teamFirstName;
    @FXML
    TableColumn<Employee, String> teamLastName;
    @FXML
    Button fxCancelButton;
    @FXML
    Button fxAssignEmployeeButton;
    @FXML
    Button fxUnassignEmployeeButton;
    @FXML
    Button fxSaveButton;
    @FXML
    Button fxDeleteButton;

    @FXML
    public void initialize() {

    }

    private void prepare(ActionEvent event, String link) throws IOException {
        Parent projectProfile = FXMLLoader.load(getClass().getResource(link));
        Scene projectsList = new Scene(projectProfile);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(projectsList);
        window.show();
    }

    @FXML
    public void handleDeleteProject(ActionEvent event) throws IOException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText("Are you sure you want to delete this project from the system?");
        alert.setContentText("Please note that data cannot be restored.");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            ProjectLogic.unassignEmployee(Long.parseLong(projectId.getText()));
            ProjectLogic.removeProject(Long.parseLong(projectId.getText()));
            String projectsPageLink = "/by/iba/management/view/fxml/ProjectsList.fxml";
            prepare(event, projectsPageLink);
        } else {
            alert.close();
        }
    }

    @FXML
    private void handleSaveProject(ActionEvent event) throws IOException {
        Project newProject = new Project();
        newProject.setProjectName(projectName.getText());
        newProject.setProjectDescription(projectDescription.getText());
        newProject.setProjectId(Long.parseLong(projectId.getText()));
        ObservableList<Employee> observableList = allEmployeesListView.getItems();
        List<Long> employeeIds = new ArrayList<>(observableList.size());
        for (Employee employee : observableList) {
            employeeIds.add(employee.getEmployeeId());
        }

        ObservableList<Employee> observableTeamList = teamList.getItems();
        List<Long> teamEmployeeIds = new ArrayList<>(observableTeamList.size());
        for (Employee employee : observableTeamList) {
            teamEmployeeIds.add(employee.getEmployeeId());
        }
        ProjectLogic.updateProject(newProject, employeeIds, teamEmployeeIds);

        //alert information
        Alert alert = new Alert(Alert.AlertType.NONE);
        alert.setAlertType(Alert.AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setContentText("The project is successfully updated!");
        alert.showAndWait();

        String projectsListLink = "/by/iba/management/view/fxml/ProjectsList.fxml";
        prepare(event, projectsListLink);
    }

    @FXML
    private void backToProjectsList(ActionEvent event) throws IOException {
        String projectsListLink = "/by/iba/management/view/fxml/ProjectsList.fxml";
        prepare(event, projectsListLink);
    }

    @FXML
    private void handleAssignEmployee() {
        Employee candidate = allEmployeesListView.getSelectionModel().getSelectedItem();
        int candidateIndex = allEmployeesListView.getSelectionModel().getFocusedIndex();
        if (candidate != null) {
            teamList.getItems().add(candidate);
            allEmployeesListView.getItems().remove(candidate);
        }
    }

    @FXML
    private void handleUnassignEmployee() {
        Employee candidate = teamList.getSelectionModel().getSelectedItem();
        if (candidate != null) {
            allEmployeesListView.getItems().add(candidate);
            teamList.getItems().remove(candidate);
        }
    }

    public void initProject(int currentProjectId) {
        Project project = ProjectDAO.getProject(currentProjectId);
        projectId.setText(String.valueOf(project.getProjectId()));
        projectName.setText(project.getProjectName());
        projectDescription.setText(project.getProjectDescription());

        List<Employee> allEmployeesList = EmployeeDAO.getEmployees();
        List<Employee> assignTeamList = new ArrayList<>();
        List<Employee> notAssignTeamList = new ArrayList<>();
        for (Employee e : allEmployeesList) {
            employeeId.setCellValueFactory(new PropertyValueFactory<>("employeeId"));
            firstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
            lastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
            teamEmployeeId.setCellValueFactory(new PropertyValueFactory<>("employeeId"));
            teamFirstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
            teamLastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));

            if (e.getProjectId() != 0 && currentProjectId == e.getProjectId()) {
                assignTeamList.add(e);
            } else if (e.getProjectId() == 0) {
                notAssignTeamList.add(e);
            }
        }
        ObservableList<Employee> fxOTeamList = FXCollections.observableList(notAssignTeamList);
        ObservableList<Employee> fxOAssignTeamList = FXCollections.observableList(assignTeamList);
        this.allEmployeesListView.setItems(fxOTeamList);
        this.teamList.setItems(fxOAssignTeamList);
    }
}
