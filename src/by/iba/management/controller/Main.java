package by.iba.management.controller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.StageStyle;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

        public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        Stage stage = new Stage();
        String name = "/by/iba/management/view/fxml/ProjectsList.fxml";
        Parent root = FXMLLoader.load(getClass().getResource(name));
        stage.setTitle("Projects List");
        stage.setScene(new Scene(root));
        stage.sizeToScene();
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.show();
    }

}