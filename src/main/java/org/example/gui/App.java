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
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/main-scene.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1210, 720);
        stage.setResizable(true);
        stage.setTitle("GymSnake");
        stage.setScene(scene);
        stage.show();
    }
}
