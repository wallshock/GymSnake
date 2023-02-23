package org.example.gui;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import org.example.Configuration;
import org.example.GridMap;
import org.example.Snake;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapVisualiser {

    private final GridMap map;
    private GridPane gridPane;
    private int sideLengthOfSquarePx;

    public MapVisualiser(GridMap map, GridPane gridPane) {
        this.map = map;
        this.gridPane = gridPane;
        visualiseMap();

    }

    private final Map<String, Image> imageCache = new HashMap<>();

    public void visualiseMap() {
        gridPane.getChildren().clear();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setGridLinesVisible(true);
        for (int x = 0; x < map.getN(); x++) {
            for (int y = 0; y < map.getN(); y++) {
                String imagePath = map.getPathImageAtPosition(x, y);
                if (imagePath != null) {
                    Image image = imageCache.computeIfAbsent(imagePath, Image::new);
                    ImageView imageView = new ImageView(image);
                    imageView.setFitWidth(800/map.getN()); // adjust size as needed
                    imageView.setFitHeight(800/map.getN());
                    gridPane.add(imageView, x, y); // add to GridPane (column, row)
                }
            }
        }
        Snake snake = map.getSnake();
        List<Integer> flattenedCoords = new ArrayList<>();
        for (int l = 0; l < snake.getLength(); l++) {
            for (int w = 0; w < snake.getWidth(); w++) {
                flattenedCoords.add(snake.getX().get(l).get(w));
                flattenedCoords.add(snake.getY().get(l).get(w));
            }
        }
        int headX = snake.getX().get(0).get(0);
        int headY = snake.getY().get(0).get(0);
        Image headImage = imageCache.computeIfAbsent(Snake.getHeadImagePath(), Image::new);
        ImageView headImageView = new ImageView(headImage);
        headImageView.setFitWidth(800/map.getN()); // adjust size as needed
        headImageView.setFitHeight(800/map.getN());
        gridPane.add(headImageView, headX, headY);
        Image bodyImage = imageCache.computeIfAbsent(Snake.getImagePath(), Image::new);
        for (int i = 2; i < flattenedCoords.size(); i += 2) {
            int x = flattenedCoords.get(i);
            int y = flattenedCoords.get(i+1);
            ImageView imageView = new ImageView(bodyImage);
            imageView.setFitWidth(800/map.getN()); // adjust size as needed
            imageView.setFitHeight(800/map.getN());
            gridPane.add(imageView, x, y); // add to GridPane (column, row)
        }
    }
}
