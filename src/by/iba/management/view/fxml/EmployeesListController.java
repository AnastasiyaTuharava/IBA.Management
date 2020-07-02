package by.iba.management.view.fxml;

import by.iba.management.dao.EmployeeDAO;
import by.iba.management.model.entity.Employee;
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
import java.util.List;
import java.util.Optional;

public class EmployeesListController {

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
    Label employeeIdLabel;
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
        List<Employee> employeesList = EmployeeDAO.getEmployeesAndProject();
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

    private void showEmployeeDetails(Employee employee) {
        if (employee != null) {
            employeeIdLabel.setText(String.valueOf(employee.getEmployeeId()));
            if (employee.getEnglishLanguageLevel() != null) {
                englishLevel.setText(String.valueOf(employee.getEnglishLanguageLevel()));
            } else {
                englishLevel.setText("N/A");
            }
            if (employee.getProgrammingLanguage() != null) {
                programming.setText(String.valueOf(employee.getProgrammingLanguage()));
            } else {
                programming.setText("N/A");
            }
            if (employee.getTesting() != null) {
                testing.setText(String.valueOf(employee.getTesting()));
            } else {
                testing.setText("N/A");
            }
            if (employee.getTools() != null) {
                tools.setText(String.valueOf(employee.getTools()));
            } else {
                tools.setText("N/A");
            }
            if (employee.getSkills() != null) {
                otherSkills.setText(String.valueOf(employee.getSkills()));
            } else {
                otherSkills.setText("N/A");
            }
        } else {
            englishLevel.setText("empty");
            programming.setText("empty");
            testing.setText("empty");
            tools.setText("empty");
            otherSkills.setText("empty");
        }
    }

    private void prepare(ActionEvent event, String link) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(link));
        Parent employeesListPage = loader.load();
        Object mainPageController = loader.getController();
        if (mainPageController instanceof EmployeeProfileController) {
            ((EmployeeProfileController) mainPageController).initEmployee(employeesListTable.getSelectionModel().selectedItemProperty().get().getEmployeeId());
        }
        Scene mainPageScene = new Scene(employeesListPage);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(mainPageScene);
        window.centerOnScreen();
        window.show();
    }

    @FXML
    private void openEmployeeProfile(ActionEvent event) throws IOException {
        String employeeProfileLink = "/by/iba/management/view/fxml/EmployeeProfile.fxml";
        prepare(event, employeeProfileLink);
    }

    @FXML
    private void addNewEmployee(ActionEvent event) throws IOException {
        String addNewEmployeeLink = "/by/iba/management/view/fxml/AddNewEmployee.fxml";
        prepare(event, addNewEmployeeLink);
    }

    @FXML
    private void deleteEmployee(ActionEvent event) throws IOException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText("Are you sure you want to delete this employee from the system?");
        alert.setContentText("Please note that data cannot be restored.");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            //employee delete logic here
            alert.close();
            //String employeesListLink = "/by/iba/management/view/fxml/EmployeesList.fxml";
            //prepare(event, employeesListLink);
        } else {
            alert.close();
        }
    }

    @FXML
    private void findEmployeeByName(ActionEvent event) throws IOException {

    }

    @FXML
    private void backToMain(ActionEvent event) throws IOException {
        String mainPageLink = "/by/iba/management/view/fxml/mainPage.fxml";
        prepare(event, mainPageLink);
    }

    @FXML
    private void exportEmployeesToExcel(ActionEvent event) throws IOException {

    }
}
