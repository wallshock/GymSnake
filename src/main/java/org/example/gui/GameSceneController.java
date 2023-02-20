package org.example.gui;

import javafx.fxml.FXML;
import javafx.scene.layout.GridPane;
import org.example.Game;

public class GameSceneController {
    @FXML
    private GridPane mapGridPane;

    private MapVisualiser mapV;

    private Game game;

    public void init() {
        this.game = new Game();
        this.mapV = new MapVisualiser(game.getMap(), mapGridPane);
    }
}
