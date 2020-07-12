package by.iba.management.view.fxml;

import by.iba.management.model.entity.*;
import by.iba.management.model.logic.EmployeeLogic;
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

public class AddNewEmployeeController {

    @FXML
    Label firstNameLabel;
    @FXML
    Label lastNameLabel;
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
    Button saveProfile;

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
        window.show();
    }

    @FXML
    private void backToEmployeesList(ActionEvent event) throws IOException {
        String employeesListLink = "/by/iba/management/view/fxml/EmployeesList.fxml";
        prepare(event, employeesListLink);
    }

    @FXML
    private void saveEmployee(ActionEvent event) throws IOException {

        Employee newEmployee = new Employee();
        firstName.getText();
        lastName.getText();
        case1: if ((firstName.getText() == null || firstName.getText().isEmpty())
                & (lastName.getText() == null || lastName.getText().isEmpty())) {
            Alert alert = new Alert(Alert.AlertType.NONE);
            alert.setAlertType(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setContentText("Employee`s First and/or Last Name is empty!");
            alert.showAndWait();
            break case1;
        } else {
        newEmployee.setProjectId(0);
        newEmployee.setFirstName(firstName.getText());
        newEmployee.setLastName(lastName.getText());
        newEmployee.setTeamLead(isTeamLead.isSelected());
        newEmployee.setPosition(position.getValue());
        newEmployee.setEnglishLanguageLevel(englishLevel.getValue());

        ProgrammingLanguage pl = new ProgrammingLanguage();
        pl.setcPlusPlus(isCplusPlus.isSelected());
        pl.setcSharp(isCsharp.isSelected());
        pl.setDotNet(isDotNet.isSelected());
        pl.setJava(isJava.isSelected());
        pl.setcSharp(isCsharp.isSelected());
        newEmployee.setProgrammingLanguage(pl);

        Skills skills = new Skills();
        skills.setSql(isSql.isSelected());
        skills.setJavaScript(isJavaScript.isSelected());
        skills.setHtml(isHtml.isSelected());
        skills.setCss(isCss.isSelected());
        skills.setjQuery(isJquery.isSelected());
        newEmployee.setSkills(skills);

        Tools tools = new Tools();
        tools.setEclipse(isEclipse.isSelected());
        tools.setIntellijIdea(isIdea.isSelected());
        tools.setNetBeans(isDotNet.isSelected());
        tools.setVisualStudio(isVisualStudio.isSelected());
        newEmployee.setTools(tools);

        Testing testing = new Testing();
        testing.setAutomation(isAutomation.isSelected());
        testing.setManual(isManual.isSelected());
        testing.setTestingDeskTopApplications(isDesktop.isSelected());
        testing.setTestingMobileApplications(isMobile.isSelected());
        newEmployee.setTesting(testing);

        EmployeeLogic.addEmployee(newEmployee);

        Alert alert = new Alert(Alert.AlertType.NONE);
        alert.setAlertType(Alert.AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setContentText("The employee is successfully added!");
        alert.showAndWait();

        String employeesListLink = "/by/iba/management/view/fxml/EmployeesList.fxml";
        prepare(event, employeesListLink);
        }
    }
}