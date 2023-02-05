package org.example;

import static org.example.Configuration.N;

public class Snake {
    // Fields
    int x, y; // Coordinates of the snake's head
    int length; // Length of the snake
    int width; // Width of the snake
    int speed; // Speed of the snake's movement
    int anabolicDose; // Current dose of anabolics
    Direction direction; // Direction of the snake's movement (up, down, left, right)

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public Direction getDirection() {
        return direction;
    }

    // Constructor
    public Snake(int x, int y) {
        this.x = x;
        this.y = y;
        this.anabolicDose=0;
        this.length = 1;
        this.width = 1;
        this.speed = 1;
        this.direction = Direction.UP;
    }

    // Methods
    public void move() {
        // Update the snake's position based on its current direction
        if (direction == Direction.UP) {
            y--;
            y=y%N;
        } else if (direction == Direction.DOWN) {
            y++;
            y=y%N;
        } else if (direction == Direction.LEFT) {
            x--;
            x=x%N;
        } else if (direction == Direction.RIGHT) {
            x++;
            x=x%N;
        }
    }

    public void changeDirection(Direction newDirection) {
        direction = newDirection;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getAnabolicDose() {
        return anabolicDose;
    }

    public void setAnabolicDose(int dose) {
        this.anabolicDose = dose;
    }

    public void expand() {
        width += 2;
    }
}