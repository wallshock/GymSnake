package org.example;

import org.example.interfaces.IMapElement;
import org.example.interfaces.Item;

public class HolyCleanse implements Item, IMapElement {

    public final int x;
    public final int y;

    public HolyCleanse(int x,int y){
        this.x=x;
        this.y=y;
    }
    @Override
    public String getImagePath() {
        return null;
    }

    @Override
    public void applyEffect(Snake snake) {
        snake.setAnabolicDose(0);
        snake.clearBackpack();
    }

    @Override
    public int getX() {
        return this.x;
    }

    @Override
    public int getY() {
        return this.y;
    }

    @Override
    public String getPath() {
        return "saint.png";
    }
}
