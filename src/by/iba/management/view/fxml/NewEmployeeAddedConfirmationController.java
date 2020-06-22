package by.iba.management.view.fxml;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class NewEmployeeAddedConfirmationController {
    @FXML
    Button ok;

    @FXML
    private void confirmAddEmployee(ActionEvent event) throws IOException {
        String employeesListLink = "/by/iba/management/view/fxml/EmployeesList.fxml";
        Parent popup = FXMLLoader.load(getClass().getResource(employeesListLink));
        Scene employeesList = new Scene(popup);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(employeesList);
        window.show();
    }
}
