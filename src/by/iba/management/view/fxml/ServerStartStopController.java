package by.iba.management.view.fxml;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerStartStopController {
    @FXML
    Button serverStartButton;
    Button serverStopButton;
    Button cancelButton;
    Label serverStatus;

    @FXML
    private void startServer(){
        Socket clientAccepted = null;
        ServerSocket serverSocket = null;
        serverStartButton.setOnAction(event -> {
            serverStatus.setText("Server running...");
        });

    }

    @FXML
    private void stopServer(ActionEvent event){
       serverStatus.setText("Server stopped.");
    }

    @FXML
    private void closeButton(ActionEvent event){
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }

}
