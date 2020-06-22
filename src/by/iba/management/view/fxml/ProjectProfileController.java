package by.iba.management.view.fxml;

import by.iba.management.dao.EmployeeDAO;
import by.iba.management.dao.ProjectDAO;
import by.iba.management.dao.impl.EmployeeDAOImpl;
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
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class ProjectProfileController {

    private final EmployeeDAO employeeDAO = new EmployeeDAOImpl();
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

    private void popup(ActionEvent event, String link) throws IOException {
        Parent projectProfile = FXMLLoader.load(getClass().getResource(link));
        Scene popup = new Scene(projectProfile);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(popup);
        window.show();
    }

    @FXML
    private void handleDeleteProject(ActionEvent event) throws IOException {
        //int line = fxProjectsListTable.getSelectionModel().getSelectedIndex();
        //fxProjectsListTable.getItems().remove(line);
        // TODO: 19.06.2020 Does line equal projectId?
        //ProjectLogic.removeProject(line);

        //before DELETE project logic:
        String popupLink = "/by/iba/management/view/fxml/DeleteProjectConfirmation.fxml";
        popup(event, popupLink);

        //proceed with logic:
    }

    @FXML
    private void handleSaveProject(ActionEvent event) throws IOException {
        Project newProject = new Project();
        newProject.setProjectName(projectName.getText());
        //TO DO: add other fields
        ProjectLogic.addProject(newProject);

        String popupLink = "/by/iba/management/view/fxml/ProjectUpdatedConfirmation.fxml";
        popup(event, popupLink);
    }

    @FXML
    private void backToProjectsList(ActionEvent event) throws IOException {
        String projectsListLink = "/by/iba/management/view/fxml/ProjectsList.fxml";
        prepare(event, projectsListLink);
    }

    @FXML
    private void handleAssignEmployee() {
        String candidate = String.valueOf(allEmployeesListView.getSelectionModel().getSelectedItem());
        String teamMember = String.valueOf(teamList.getSelectionModel().getSelectedItem());
        this.allEmployeesListView.getItems().setAll();
        this.teamList.getItems().setAll();
        if (candidate != null) {
            allEmployeesListView.getSelectionModel().clearSelection();
            //allEmployeesListView.remove(candidate);
            //teamList.getItems(candidate);
        }
    }

    @FXML
    private void handleUnassignEmployee() {

    }
}
