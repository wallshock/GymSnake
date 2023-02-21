package org.example.gui;

import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import org.example.Configuration;
import org.example.Map;
import org.example.Snake;

public class MapVisualiser {

    private final Map map;
    private GridPane gridPane;
    private int sideLengthOfSquarePx;

    public MapVisualiser(Map map, GridPane gridPane) {
        this.map = map;
        this.gridPane = gridPane;
        visualiseMap();

    }

    public void visualiseMap() {
        gridPane.getChildren().clear();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setGridLinesVisible(true);
        for (int x = 0; x < map.getN(); x++) {
            for (int y = 0; y < map.getN(); y++) {
                String imagePath = map.getPathImageAtPosition(x, y);
                if (imagePath != null) {
                    Image image = new Image(imagePath);
                    ImageView imageView = new ImageView(image);
                    imageView.setFitWidth(80); // adjust size as needed
                    imageView.setFitHeight(80);
                    gridPane.add(imageView, x, y); // add to GridPane (column, row)
                }
            }
        }
        Snake snake = map.getSnake();
        for (int l = 0; l < snake.getLength(); l++) {
            for (int w = 0; w < snake.getWidth(); w++) {
                if (l == 0 & w == 0) {
                    int x = snake.getX().get(l).get(w);
                    int y = snake.getY().get(l).get(w);
                    Image image = new Image(Snake.getHeadImagePath());
                    ImageView imageView = new ImageView(image);
                    imageView.setFitWidth(80); // adjust size as needed
                    imageView.setFitHeight(80);
                    gridPane.add(imageView, x, y);
                } else {
                    int x = snake.getX().get(l).get(w);
                    int y = snake.getY().get(l).get(w);
                    Image image = new Image(Snake.getImagePath());
                    ImageView imageView = new ImageView(image);
                    imageView.setFitWidth(80); // adjust size as needed
                    imageView.setFitHeight(80);
                    gridPane.add(imageView, x, y); // add to GridPane (column, row)
                }
            }
        }
    }

}
