package by.iba.management.controller;

import by.iba.management.db.DBConnector;
import by.iba.management.model.logic.ProjectLogic;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    public static void main(String[] args) {
        initDB();
        // TODO: 22.06.2020 Test DB
        //System.out.println(ProjectLogic.getProject(5));
        //System.out.println((ProjectLogic.getProject("The")));
        launch(args);
    }

    private static void initDB() {
        DBConnector.createDBAndTables();
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
