package org.example.gui;

import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import org.example.Direction;
import org.example.Main;
import org.example.Snake;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainSceneController implements Initializable {
    @FXML
    private GameSceneController newController;

    @FXML
    private Stage stage;

    @FXML private AnchorPane ap;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    public void onNewSimulationButtonClicked() throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/game-scene.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1350, 860);
        stage = (Stage) ap.getScene().getWindow();
        newController = fxmlLoader.getController();
        newController.start();
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                Platform.exit();
                System.exit(0);
            }
        });
        stage.show();
    }
}
