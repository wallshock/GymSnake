package org.example.gui;

import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import org.example.Game;
import org.example.Snake;
import org.example.interfaces.IGuiObserver;
import org.example.interfaces.Item;

import java.util.ArrayList;

public class GameSceneController implements IGuiObserver {
    @FXML
    private GridPane mapGridPane;

    @FXML
    private GridPane mapGridPane1;

    @FXML
    private Label scoreLabel;
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

    public void start() {
        new Thread(game).start();
    }

    public void updateGuiViews() {
        try {
            long speed =(long) (500/game.getSnake().getSpeed());
            Platform.runLater(this::updateScore);
            Platform.runLater(this::updateItems);
            Platform.runLater(this::updateGui);
            Thread.sleep(speed);
        } catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
        }
    }
    public void updateScore(){
        scoreLabel.setText(Double.toString(getScore()));
    }

    public void updateItems(){
        Snake snake = game.getSnake();
        ArrayList<Item> backpack = snake.getBackpack();
        mapGridPane1.getChildren().clear();
        mapGridPane1.setGridLinesVisible(true);
        for (int x = 0; x < snake.getBackpack().size(); x++) {
            String imagePath =backpack.get(x).getPath();
            if (imagePath != null) {
                Image image = new Image(imagePath);
                ImageView imageView = new ImageView(image);
                imageView.setFitWidth(69); // adjust size as needed
                imageView.setFitHeight(65);
                mapGridPane1.add(imageView, x, x/4); // add to GridPane (column, row)
                }
            }
    }
    public double getScore(){
        if(!game.isDead()) {
            return this.game.getSnake().getScore();
        }
        return 0;
    }
    @Override
    public void updateGui() {
        mapV.visualiseMap();
    }
    //todo make gui for backpack
    //todo make toxicity indicator
    //todo better visuals
}
