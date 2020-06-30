package by.iba.management.view.fxml;

import by.iba.management.dao.EmployeeDAO;
import by.iba.management.dao.ProjectDAO;
import by.iba.management.model.entity.Employee;
import by.iba.management.model.entity.Project;
import by.iba.management.model.logic.ProjectLogic;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class ProjectProfileController {

    private final EmployeeDAO employeeDAO = new EmployeeDAO();
    //private final ProjectDAO projectDAO = new ProjectDAOImpl();

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
        List<Employee> allEmployeesList = employeeDAO.getEmployees();
        for (Employee e : allEmployeesList) {
            employeeId.setCellValueFactory(new PropertyValueFactory<>("employeeId"));
            firstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
            lastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        }
        ObservableList<Employee> fxOTeamList = FXCollections.observableList(allEmployeesList);
        this.allEmployeesListView.setItems(fxOTeamList);
    }

    private void prepare(ActionEvent event, String link) throws IOException {
        Parent projectProfile = FXMLLoader.load(getClass().getResource(link));
        Scene projectsList = new Scene(projectProfile);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(projectsList);
        window.show();
    }

    @FXML
    private void handleDeleteProject(ActionEvent event) throws IOException {
        //int line = fxProjectsListTable.getSelectionModel().getSelectedIndex();
        //fxProjectsListTable.getItems().remove(line);
        // TODO: 19.06.2020 Does line equal projectId?
        //ProjectLogic.removeProject(line);

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText("Are you sure you want to delete this project from the system?");
        alert.setContentText("Please note that data cannot be restored.");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
            //project delete logic here
            //alert.close();
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
        //TO DO: add other fields
        ProjectLogic.addProject(newProject);

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
//        // Candidates
//        final ObservableList<String> candidates = FXCollections.observableArrayList("Z", "A", "B", "C", "D");
//        final ListView<String> candidatesListView = new ListView<>(candidates);
//        gridpane.add(candidatesListView, 0, 1);

        Employee candidate = allEmployeesListView.getSelectionModel().getSelectedItem();
        int candidateIndex = allEmployeesListView.getSelectionModel().getFocusedIndex();
//        List<Employee> teamMembers = List<Employee>;
//        String teamMember = String.valueOf(teamList.getSelectionModel().getSelectedItem());
//        this.allEmployeesListView.getItems().setAll();

//        ObservableList<Employee> list = FXCollections.observableList();
//        this.teamList = new TableView<Employee>(list);
        if (candidate != null) {
            this.teamList.getItems().add(candidate);
        }
    }

    @FXML
    private void handleUnassignEmployee() {

    }
}
