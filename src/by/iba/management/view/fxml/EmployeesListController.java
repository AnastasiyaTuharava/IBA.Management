package by.iba.management.view.fxml;

import by.iba.management.model.entity.Employee;
import by.iba.management.model.entity.EmployeesRepository;
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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class EmployeesListController {

    @FXML
    public void initialize() {
        ArrayList<Employee> employeesList = EmployeesRepository.getEmployeesList();
        for (Employee e : employeesList) {
            employeeId.setCellValueFactory(new PropertyValueFactory<>("employeeId"));
            firstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
            lastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
            projectName.setCellValueFactory(new PropertyValueFactory<>("projectName"));
            position.setCellValueFactory(new PropertyValueFactory<>("position"));
        }
        ObservableList<Employee> fxOEmployeesList = FXCollections.observableList(employeesList);
        this.employeesList.setItems(fxOEmployeesList);
    }

    @FXML
    TableColumn<Employee, String> employeeId;
    @FXML
    TableColumn<Employee, String> firstName;
    @FXML
    TableColumn<Employee, String> lastName;
    @FXML
    TableColumn<Employee, String> projectName;
    @FXML
    TableColumn<Employee, String> position;
    @FXML
    TableView<Employee> employeesList;
    @FXML
    Button fxGoHomeButton;

    @FXML
    private void backToMain(ActionEvent event) throws IOException {
        String mainPageLink = "/by/iba/management/view/fxml/mainPage.fxml";
        Parent employeesList = FXMLLoader.load(getClass().getResource(mainPageLink));
        Scene mainPage = new Scene(employeesList);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(mainPage);
        window.show();
    }
}