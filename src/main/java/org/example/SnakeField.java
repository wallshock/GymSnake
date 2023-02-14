package org.example;

import org.example.interfaces.IMapElement;

public class SnakeField implements IMapElement {
    public SnakeField(int blockid) {
        this.blockid = blockid;
    }

    @Override
    public String getImagePath() {
        return null;
    }
    @Override
    public String toString(){
        return "S";
    }
    public int blockid;

    public int getBlockid() {
        return blockid;
    }
}