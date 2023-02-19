package org.example.gui;

import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import org.example.Map;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class GuiElementBox {
    private final VBox vBox = new VBox();

    GuiElementBox(Map map, int x, int y, int sideLengthOfSquarePx) {
        try {
            Image image = new Image(new FileInputStream(map.getPathImageAtPosition(x, y)));
            ImageView imageView = new ImageView(image);
            imageView.setFitHeight(sideLengthOfSquarePx);
            imageView.setFitWidth(sideLengthOfSquarePx);
            vBox.getChildren().add(imageView);
            vBox.setAlignment(Pos.BASELINE_CENTER);
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public VBox getVBox() {
        return vBox;
    }
}
