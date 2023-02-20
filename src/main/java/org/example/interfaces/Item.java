package org.example.interfaces;

import org.example.Snake;

public interface Item {
    void applyEffect(Snake snake);
    int getX();
    int getY();

    String getPath();
}
