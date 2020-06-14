package by.iba.management.view.fxml;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainPageController {

    @FXML
    public void initialize() {
    }

    @FXML
    private void openEmployeesListPage(ActionEvent event) throws IOException {
        String employeesListLink = "/by/iba/management/view/fxml/EmployeesList.fxml";
        Parent mainPage = FXMLLoader.load(getClass().getResource(employeesListLink));
        Scene mainPageScene = new Scene(mainPage);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(mainPageScene);
        window.show();
    }

    @FXML
    private void openProjectsListPage(ActionEvent event) throws IOException {
        String projectsListLink = "/by/iba/management/view/fxml/ProjectsList.fxml";
        Parent mainPage = FXMLLoader.load(getClass().getResource(projectsListLink));
        Scene mainPageScene = new Scene(mainPage);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(mainPageScene);
        window.show();
    }
}
