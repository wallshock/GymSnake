package org.example;

import org.example.interfaces.IMapElement;

public class EmptyField implements IMapElement {
    @Override
    public String getImagePath() {
        return null;
    }
    @Override
    public String toString(){
        return "X";
    }
}
