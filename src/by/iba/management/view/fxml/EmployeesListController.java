package by.iba.management.view.fxml;

import by.iba.management.dao.EmployeeDAO;
import by.iba.management.dao.impl.EmployeeDAOImpl;
import by.iba.management.model.entity.Employee;
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
import javafx.scene.layout.FlowPane;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class EmployeesListController {

    private final EmployeeDAO employeeDAO = new EmployeeDAOImpl();

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
    TableView<Employee> employeesListTable;
    @FXML
    TextField fxFindEmployeeTextField;
    @FXML
    Button fxGoHomeButton;
    @FXML
    Button addNewEmployeeButton;
    @FXML
    Button deleteEmployeeButton;
    @FXML
    Button fxSearchByEmployeeNameButton;
    @FXML
    Button fxExportEmployeesToExcelButton;
    @FXML
    Label englishLevel;
    @FXML
    Label programming;
    @FXML
    Label testing;
    @FXML
    Label tools;
    @FXML
    Label otherSkills;
    @FXML
    Button openEmployeeProfileButton;

    @FXML
    public void initialize() {
        fxFindEmployeeTextField.setPromptText("Search");
        List<Employee> employeesList = employeeDAO.getEmployees();
        for (Employee e : employeesList) {
            employeeId.setCellValueFactory(new PropertyValueFactory<>("employeeId"));
            firstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
            lastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
            projectName.setCellValueFactory(new PropertyValueFactory<>("projectName"));
            position.setCellValueFactory(new PropertyValueFactory<>("position"));
        }
        ObservableList<Employee> fxOEmployeesList = FXCollections.observableList(employeesList);
        this.employeesListTable.setItems(fxOEmployeesList);
        showEmployeeDetails(null);
        employeesListTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) ->
                        showEmployeeDetails(newValue));
    }

    @FXML
    private void backToMain(ActionEvent event) throws IOException {
        String mainPageLink = "/by/iba/management/view/fxml/mainPage.fxml";
        Parent employeesList = FXMLLoader.load(getClass().getResource(mainPageLink));
        Scene mainPage = new Scene(employeesList);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(mainPage);
        window.show();
    }

    @FXML
    private void openEmployeeProfile(ActionEvent event) throws IOException {
        String employeeProfileLink = "/by/iba/management/view/fxml/EmployeeProfile.fxml";
        Parent employeesList = FXMLLoader.load(getClass().getResource(employeeProfileLink));
        Scene EmployeeProfile = new Scene(employeesList);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(EmployeeProfile);
        window.show();
    }

    private void showEmployeeDetails(Employee employee) {
        if (employee != null) {
            englishLevel.setText(String.valueOf(employee.getEnglishLanguageLevel()));
            programming.setText(String.valueOf(employee.getProgrammingLanguage()));
            testing.setText(String.valueOf(employee.getTesting()));
            tools.setText(String.valueOf(employee.getTools()));
            otherSkills.setText(String.valueOf(employee.getSkills()));
        } else {
            englishLevel.setText("empty");
            programming.setText("empty");
            testing.setText("empty");
            tools.setText("empty");
            otherSkills.setText("empty");
        }
    }

    @FXML
    private void deleteEmployee(ActionEvent event) throws IOException {

    }

    @FXML
    private void addNewEmployee(ActionEvent event) throws IOException {

    }

    @FXML
    private void getSearchText(ActionEvent event) throws IOException{

    }

    @FXML
    private void findEmployeeByName(ActionEvent event) throws IOException{

    }

    @FXML
    private void exportEmployeesToExcel(ActionEvent event) throws IOException{

    }
}