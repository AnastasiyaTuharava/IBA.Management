package by.iba.management.view.fxml;

import by.iba.management.dao.EmployeeDAO;
import by.iba.management.dao.impl.EmployeeDAOImpl;
import by.iba.management.model.entity.Position;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;

public class EmployeeProfileController {

    private final EmployeeDAO employeeDAO = new EmployeeDAOImpl();

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
    ChoiceBox position;
    @FXML
    ChoiceBox englishLevel;
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
    public void initialize(Position p) {
        //Employee employee = employeeDAO.setEmployeeData();
        //employeeId.setText(String.valueOf(employee.setEmployeeId());
        //firstName.setText(String.valueOf(employee.setFirstName());
        //lastName.setText(String.valueOf(employee.getLastName()));
        //projectName.setText(String.valueOf(employee.getProjectId())); //how set Project Name by Project Id?
        //isTeamLead.setSelected(employee.isTeamLead());

        String positionList[] = { "JUNIOR_QA",
                        "MIDDLE_QA",
                        "SENIOR_QA",
                        "LEAD_QA",
                        "JUNIOR_DEV",
                        "MIDDLE_DEV",
                        "SENIOR_DEV",
                        "LEAD_DEV"
        };

        // Create a combo box
        ComboBox positionDropDown =
                new ComboBox(FXCollections
                        .observableArrayList(positionList));
        TilePane tile_pane = new TilePane(positionDropDown);
        position.setItems((javafx.collections.ObservableList) positionDropDown);
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
        if (result.get() == ButtonType.OK){
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
}