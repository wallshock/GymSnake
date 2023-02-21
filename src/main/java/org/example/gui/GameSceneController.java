package org.example.gui;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.layout.GridPane;
import org.example.Game;
import org.example.Snake;
import org.example.interfaces.IGuiObserver;

public class GameSceneController implements IGuiObserver {
    @FXML
    private GridPane mapGridPane;

    private MapVisualiser mapV;

    private Game game;

    public void init() {
        this.game = new Game();
        game.setObserver(this);
        this.mapV = new MapVisualiser(game.getMap(), mapGridPane);
        updateGuiViews();
    }
    public Snake getSnake(){
        return game.getSnake();
    }

    public void start(){
        new Thread(game).start();
    }


    public void updateGuiViews() {
        try {
            long speed =(long) (500/game.getSnake().getSpeed());
            Platform.runLater(this::updateGui);
            Thread.sleep(speed);
        } catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
        }
    }
    @Override
    public void updateGui() {
        mapV.visualiseMap();
    }
    //todo make gui for backpack
    //todo make toxicity indicator
    //todo better visuals
}
