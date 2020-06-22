package by.iba.management.view.fxml;

import by.iba.management.dao.EmployeeDAO;
import by.iba.management.dao.ProjectDAO;
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

public class DeleteProjectConfirmationController {

    @FXML
    Button ok;
    @FXML
    Button cancel;

    private void prepare(ActionEvent event, String link) throws IOException {
        Parent popup = FXMLLoader.load(getClass().getResource(link));
        Scene projectsList = new Scene(popup);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(projectsList);
        window.show();
    }

    @FXML
    private void confirmDeleteProject(ActionEvent event) throws IOException {
        String popup = "/by/iba/management/view/fxml/ProjectDeletedConfirmation.fxml";
        prepare(event, popup);
    }

    @FXML
    private void cancelDeleteProject(ActionEvent event) throws IOException {
        String projectProfileLink = "/by/iba/management/view/fxml/ProjectProfile.fxml";
        prepare(event, projectProfileLink);
    }
}
