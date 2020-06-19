package by.iba.management.view.fxml;

import by.iba.management.dao.EmployeeDAO;
import by.iba.management.dao.ProjectDAO;
import by.iba.management.dao.impl.EmployeeDAOImpl;
import by.iba.management.dao.impl.ProjectDAOImpl;
import by.iba.management.model.entity.Employee;
import by.iba.management.model.entity.Project;
import by.iba.management.model.logic.impl.EditProjectImpl;
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
    private final ProjectDAO projectDAO = new ProjectDAOImpl();

    @FXML
    TextField projectId;
    @FXML
    TextField projectName;
    @FXML
    TextField projectDescription;
    @FXML
    TableView<Project> fxProjectsListTable;
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

    @FXML
    private void handleDeleteProject() {
        int line = fxProjectsListTable.getSelectionModel().getSelectedIndex();
        fxProjectsListTable.getItems().remove(line);
        EditProjectImpl deleteProject = new EditProjectImpl();
        deleteProject.removeProject(line);
    }

    @FXML
    private void handleSaveProject() {
        Project newProject = new Project();
        newProject.setProjectName(projectName.getText());
        //projectDAO.saveProject(newProject);
    }

    @FXML
    private void backToProjectsList(ActionEvent event) throws IOException {
        String projectProfileLink = "/by/iba/management/view/fxml/projects/ProjectsList.fxml";
        Parent projectProfile = FXMLLoader.load(getClass().getResource(projectProfileLink));
        Scene projectsList = new Scene(projectProfile);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(projectsList);
        window.show();
    }

    @FXML
    private void handleAssignEmployee() {
        String candidate = String.valueOf(allEmployeesListView.getSelectionModel().getSelectedItem());
        this.allEmployeesListView.getItems().setAll();
        if (candidate != null) {
            allEmployeesListView.getSelectionModel().clearSelection();
            //allEmployeesListView.remove(candidate);
            //teamList.add(candidate);
        }
    }

    @FXML
    private void handleUnassignEmployee() {

    }
}
