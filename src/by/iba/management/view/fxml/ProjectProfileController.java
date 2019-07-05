package by.iba.management.view.fxml;

import by.iba.management.model.entity.Employee;
import by.iba.management.model.entity.EmployeesRepository;
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
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class ProjectProfileController {

    @FXML
    public void initialize() {
        ArrayList<Employee> allEmployeesList = EmployeesRepository.getEmployeesList();
        for (Employee e : allEmployeesList) {
            employeeId.setCellValueFactory(new PropertyValueFactory<>("employeeId"));
            firstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
            lastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        }
        ObservableList<Employee> fxOTeamList = FXCollections.observableList(allEmployeesList);
        candidates.setItems(fxOTeamList);
    }

    @FXML
    TextField projectId;
    @FXML
    TextField projectName;
    @FXML
    TextField projectDescription;
    @FXML
    TableView<Project> fxProjectsListTable;
    @FXML
    TableView<Employee> candidates;
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
    private void handleDeleteProject() {
        int line = fxProjectsListTable.getSelectionModel().getSelectedIndex();
        fxProjectsListTable.getItems().remove(line);
        EditProjectImpl deleteProject = new EditProjectImpl();
        deleteProject.removeProject(line);
    }

    @FXML
    private void backToProjectsList(ActionEvent event) throws IOException {
        String projectProfileLink = "/by/iba/management/view/fxml/ProjectsList.fxml";
        Parent projectProfile = FXMLLoader.load(getClass().getResource(projectProfileLink));
        Scene projectsList = new Scene(projectProfile);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(projectsList);
        window.show();
    }

    @FXML
    private void handleAssignEmployee() {
        String candidate = fxOTeamList.getSelectionModel().getSelectedItem();
        candidates.getItems().remove(candidate);
        int selectedEmployee = teamList.getSelectionModel().getSelectedIndex();
        //fxTeamList.getItems().add(selectedEmployee);



        String potential = candidates.getSelectionModel().getSelectedItem();
            if (potential != null) {
                candidates.getSelectionModel().clearSelection();
                candidates.remove(potential);
                selected.add(potential);
            }
        });

    }

    @FXML
    private void handleUnassignEmployee() {

    }
}
