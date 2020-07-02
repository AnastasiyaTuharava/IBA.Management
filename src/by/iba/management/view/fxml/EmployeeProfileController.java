package by.iba.management.view.fxml;

import by.iba.management.dao.EmployeeDAO;
import by.iba.management.model.entity.Employee;
import by.iba.management.model.entity.EnglishLanguageLevel;
import by.iba.management.model.entity.Position;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;

public class EmployeeProfileController {

    @FXML
    TextField employeeId;
    @FXML
    TextField firstName;
    @FXML
    TextField lastName;
    @FXML
    TextField projectName;
    @FXML
    CheckBox isTeamLead;
    @FXML
    ChoiceBox<Position> position;
    @FXML
    ChoiceBox<EnglishLanguageLevel> englishLevel;
    @FXML
    CheckBox isJava;
    @FXML
    CheckBox isCplusPlus;
    @FXML
    CheckBox isCsharp;
    @FXML
    CheckBox isPhp;
    @FXML
    CheckBox isDotNet;
    @FXML
    CheckBox isSql;
    @FXML
    CheckBox isJavaScript;
    @FXML
    CheckBox isHtml;
    @FXML
    CheckBox isCss;
    @FXML
    CheckBox isJquery;
    @FXML
    CheckBox isVisualStudio;
    @FXML
    CheckBox isIdea;
    @FXML
    CheckBox isEclipse;
    @FXML
    CheckBox isNetBeans;
    @FXML
    CheckBox isAutomation;
    @FXML
    CheckBox isManual;
    @FXML
    CheckBox isDesktop;
    @FXML
    CheckBox isMobile;

    @FXML
    Button fxGoHomeButton;
    @FXML
    Button deleteEmployeeButton;
    @FXML
    Button saveEmployee;

    private Position ObservableList;

    @FXML
    public void initialize() {
        position.setItems(FXCollections.observableArrayList(Position.values()));
        englishLevel.setItems(FXCollections.observableArrayList(EnglishLanguageLevel.values()));
    }

    private void prepare(ActionEvent event, String link) throws IOException {
        Parent employeeProfile = FXMLLoader.load(getClass().getResource(link));
        Scene employeesList = new Scene(employeeProfile);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(employeesList);
        window.centerOnScreen();
        window.show();
    }

    @FXML
    private void backToEmployeesList(ActionEvent event) throws IOException {
        String employeesListLink = "/by/iba/management/view/fxml/EmployeesList.fxml";
        prepare(event, employeesListLink);
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
            //alert.close();
            String employeesListLink = "/by/iba/management/view/fxml/EmployeesList.fxml";
            prepare(event, employeesListLink);
        } else {
            alert.close();
        }
    }

    @FXML
    private void saveEmployee(ActionEvent event) throws IOException {
        //logic to be written here
        //alert information
        Alert alert = new Alert(Alert.AlertType.NONE);
        alert.setAlertType(Alert.AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setContentText("The employee is successfully updated!");
        alert.showAndWait();

        String employeesListLink = "/by/iba/management/view/fxml/EmployeesList.fxml";
        prepare(event, employeesListLink);
    }

    public void initEmployee(long emplId) {
        Employee employee = EmployeeDAO.getEmployee(emplId);
        employeeId.setText(String.valueOf(employee.getEmployeeId()));
        firstName.setText(employee.getFirstName());
        lastName.setText(employee.getLastName());
        projectName.setText(employee.getProjectName());
        isTeamLead.setSelected(employee.isTeamLead());
        position.setValue(employee.getPosition());
        englishLevel.setValue(employee.getEnglishLanguageLevel());
        isJava.setSelected(employee.getProgrammingLanguage().isJava());
        isCplusPlus.setSelected(employee.getProgrammingLanguage().iscPlusPlus());
        isCsharp.setSelected(employee.getProgrammingLanguage().iscSharp());
        isPhp.setSelected(employee.getProgrammingLanguage().isPhp());
        isDotNet.setSelected(employee.getProgrammingLanguage().isDotNet());
        isSql.setSelected(employee.getSkills().isSql());
        isJavaScript.setSelected(employee.getSkills().isJavaScript());
        isHtml.setSelected(employee.getSkills().isHtml());
        isCss.setSelected(employee.getSkills().isCss());
        isJquery.setSelected(employee.getSkills().isjQuery());
        isVisualStudio.setSelected(employee.getTools().isVisualStudio());
        isIdea.setSelected(employee.getTools().isIntellijIdea());
        isEclipse.setSelected(employee.getTools().isEclipse());
        isNetBeans.setSelected(employee.getTools().isNetBeans());
        isAutomation.setSelected(employee.getTesting().isAutomation());
        isManual.setSelected(employee.getTesting().isManual());
        isDesktop.setSelected(employee.getTesting().isTestingDeskTopApplications());
        isMobile.setSelected(employee.getTesting().isTestingMobileApplications());
    }
}
