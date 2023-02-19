package org.example.gui;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import org.example.Game;
import org.example.Main;
import java.io.IOException;

public class App extends Application {
    private Game game;
    private MapVisualiser mapV;

    @FXML
    private GridPane mapGridPane;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/main-scene.fxml"));
        fxmlLoader.setController(this);
        Scene scene = new Scene(fxmlLoader.load(), 1530, 790);
        stage.setResizable(true);
        stage.setMaximized(true);
        stage.setTitle("GymSnake");
        stage.setScene(scene);
        this.game = new Game();
        stage.show();
        initMapVisualiser();
    }

    private void initMapVisualiser() {
        this.mapV = new MapVisualiser(game.getMap(), mapGridPane);
    }
}
