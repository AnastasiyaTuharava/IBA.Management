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

public class NewProjectAddedConfirmationController {
    @FXML
    Button ok;

    @FXML
    private void confirmAddProject(ActionEvent event) throws IOException {
        String projectsListLink = "/by/iba/management/view/fxml/ProjectsList.fxml";
        Parent popup = FXMLLoader.load(getClass().getResource(projectsListLink));
        Scene projectsList = new Scene(popup);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(projectsList);
        window.show();
    }
}
