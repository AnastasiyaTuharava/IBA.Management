package by.iba.management.controller;

import by.iba.management.model.entity.Project;
import by.iba.management.model.entity.ProjectsRepository;
import by.iba.management.util.DataWriterProject;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.StageStyle;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application{

        public static void main(String[] args) {
                launch(args);
        }

        @Override
        public void start(Stage primaryStage) throws IOException {
                Stage stage = new Stage();
                String fxmlLink = "/by/iba/management/view/fxml/mainPage.fxml";
                Parent root = FXMLLoader.load(getClass().getResource(fxmlLink));
                stage.setTitle("Management Tool");
                stage.setScene(new Scene(root));
                stage.sizeToScene();
                stage.show();
        }
}
