package by.iba.management.view.fxml;

import by.iba.management.model.entity.Project;
import by.iba.management.model.logic.ProjectLogic;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class AddNewProjectController {

    @FXML
    Label projectNameLabel;
    @FXML
    TextField projectName;
    @FXML
    TextField projectDescription;
    @FXML
    Button fxCancelButton;
    @FXML
    Button fxSaveButton;

    private void prepare(ActionEvent event, String link) throws IOException {
        Parent newProjectPage = FXMLLoader.load(getClass().getResource(link));
        Scene mainPageScene = new Scene(newProjectPage);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(mainPageScene);
        window.centerOnScreen();
        window.show();
    }

    @FXML
    private void handleSaveProject(ActionEvent event) throws IOException {
        Project newProject = new Project();
        projectName.getText();
        case1: if ((projectName.getText() == null || projectName.getText().isEmpty())) {
            Alert alert = new Alert(Alert.AlertType.NONE);
            alert.setAlertType(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setContentText("Project Name is empty!");
            alert.showAndWait();
            break case1;
        } else {
            newProject.setProjectName(projectName.getText());
            newProject.setProjectDescription(projectDescription.getText());
            ProjectLogic.addProject(newProject);

            Alert alert = new Alert(Alert.AlertType.NONE);
            alert.setAlertType(Alert.AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setContentText("The project is successfully added!");
            alert.showAndWait();

            String projectsListLink = "/by/iba/management/view/fxml/ProjectsList.fxml";
            prepare(event, projectsListLink);
        }
    }

    @FXML
    private void backToProjectsList(ActionEvent event) throws IOException {
        String projectsListLink = "/by/iba/management/view/fxml/ProjectsList.fxml";
        prepare(event, projectsListLink);
    }
}
