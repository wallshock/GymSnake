package org.example.gui;

import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
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
    @FXML
    private ImageView start;

    @FXML
    private ImageView options;


    @FXML private AnchorPane ap;

//todo add audio music plus sound effects
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        start.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    onStartButtonClicked();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            }
        });
        options.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                settingsPopUp();
            }
        });
    }

    private void settingsPopUp() {
        //todo add settings
    }

    public void onStartButtonClicked() throws IOException {

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
