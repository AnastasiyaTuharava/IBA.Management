package by.iba.management.view.fxml;

import by.iba.management.model.entity.Employee;
import by.iba.management.model.entity.EmployeesRepository;
import by.iba.management.model.entity.Project;
import by.iba.management.model.entity.ProjectsRepository;
import by.iba.management.model.logic.impl.FindProjectImpl;
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
        ArrayList<Employee> teamList = EmployeesRepository.getEmployeesList();
        for (Employee e : teamList) {
            employeeId.setCellValueFactory(new PropertyValueFactory<>("employeeId"));
            firstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
            lastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        }
        ObservableList<Employee> fxOTeamList = FXCollections.observableList(teamList);
        fxTeamList.setItems(fxOTeamList);
    }

    @FXML
    TextField projectId;
    @FXML
    TextField projectName;
    @FXML
    TextField projectDescription;
    @FXML
    TableColumn<Employee, String> employeeId;
    @FXML
    TableColumn<Employee, String> firstName;
    @FXML
    TableColumn<Employee, String> lastName;
    @FXML
    TableView<Employee> fxTeamList;
    @FXML
    Button fxCancelButton;

    @FXML
    private void backToProjectsList(ActionEvent event) throws IOException {
        String projectProfileLink = "/by/iba/management/view/fxml/ProjectsList.fxml";
        Parent projectProfile = FXMLLoader.load(getClass().getResource(projectProfileLink));
        Scene projectsList = new Scene(projectProfile);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(projectsList);
        window.show();
    }
}
