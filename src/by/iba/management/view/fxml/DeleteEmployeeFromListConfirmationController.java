package by.iba.management.view.fxml;

import by.iba.management.dao.EmployeeDAO;
import by.iba.management.dao.impl.EmployeeDAOImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class DeleteEmployeeFromListConfirmationController {
    private final EmployeeDAO employeeDAO = new EmployeeDAOImpl();

    @FXML
    Button ok;
    @FXML
    Button cancel;

    private void prepare(ActionEvent event, String link) throws IOException {
        Parent popup = FXMLLoader.load(getClass().getResource(link));
        Scene employeesList = new Scene(popup);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(employeesList);
        window.show();
    }

    @FXML
    private void confirmDeleteEmployee(ActionEvent event) throws IOException {
        String popup = "/by/iba/management/view/fxml/EmployeeDeletedConfirmation.fxml";
        prepare(event, popup);
    }

    @FXML
    private void cancelDeleteEmployee(ActionEvent event) throws IOException {
        String employeesListLink = "/by/iba/management/view/fxml/EmployeesList.fxml";
        prepare(event, employeesListLink);
    }
}
