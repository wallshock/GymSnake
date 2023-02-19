package org.example.gui;

import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import org.example.Configuration;
import org.example.Map;

public class MapVisualiser {

    private final Map map;
    private GridPane gridPane;
    private int sideLengthOfSquarePx;

    public MapVisualiser(Map map, GridPane gridPane) {
        this.map = map;
        this.gridPane = gridPane;
        calculateColumnsAndRowsSize();
    }

    private void calculateColumnsAndRowsSize() {
        int squareHeight = (int) Math.ceil(1.0 * Configuration.GRID_HEIGHT / map.getN());
        int squareWidth  = (int) Math.ceil(1.0 * Configuration.GRID_WIDTH / map.getN());
        this.sideLengthOfSquarePx = Math.max(40, Math.max(squareWidth, squareHeight));
        gridPane.getColumnConstraints().add(new ColumnConstraints(sideLengthOfSquarePx));
        gridPane.getRowConstraints().add(new RowConstraints(sideLengthOfSquarePx));
    }

    public void visualiseMap() {
        gridPane.getChildren().clear();
        for (int x = 0; x < map.getN(); x++) {
            for (int y = 0; y < map.getN(); y++) {
                GuiElementBox guiElementBox = new GuiElementBox(map, x,y, sideLengthOfSquarePx);
                gridPane.add(guiElementBox.getVBox(), x, y);
            }
        }
    }

}