package org.example.gui;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import org.example.Direction;
import org.example.Game;
import org.example.Main;
import org.example.Snake;

import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainSceneController implements Initializable {

    @FXML
    private Scene scene;

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
        Scene scene = new Scene(fxmlLoader.load(), 1050, 860);
        stage = (Stage) ap.getScene().getWindow();
        newController = fxmlLoader.getController();
        newController.init();
        Snake snake = newController.getSnake();
        Direction queuedDirection;
//        stage.getIcons().add(new Image(new FileInputStream("src/main/resources/com/example/evolutiongenerator/icon.png")));
        scene.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.W &&
                    (newController.getSnake().getDirection()== Direction.LEFT || snake.getDirection()==Direction.RIGHT))  {
                snake.queueDirection(Direction.UP);
            } else if (e.getCode() == KeyCode.A &&
            (snake.getDirection()==Direction.UP || snake.getDirection()==Direction.DOWN)){
                snake.queueDirection(Direction.LEFT);
            } else if (e.getCode() == KeyCode.S &&
            (snake.getDirection()==Direction.LEFT || snake.getDirection()==Direction.RIGHT))  {
                snake.queueDirection(Direction.DOWN);
            } else if (e.getCode() == KeyCode.D &&
            (snake.getDirection()==Direction.UP || snake.getDirection()==Direction.DOWN)){
                snake.queueDirection(Direction.RIGHT);
            }
        });
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
        newController.start();
    }
}
