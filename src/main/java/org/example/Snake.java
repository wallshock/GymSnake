package org.example;

public class Snake {
    // Fields
    int x, y; // Coordinates of the snake's head
    int length; // Length of the snake
    int width; // Width of the snake
    int speed; // Speed of the snake's movement
    Direction direction; // Direction of the snake's movement (up, down, left, right)

    // Constructor
    public Snake(int x, int y, int length, int width, int speed, Direction direction) {
        this.x = x;
        this.y = y;
        this.length = length;
        this.width = width;
        this.speed = speed;
        this.direction = direction;
    }

    // Methods
    public void move() {
        // Update the snake's position based on its current direction
        if (direction == Direction.UP) {
            y--;
        } else if (direction == Direction.DOWN) {
            y++;
        } else if (direction == Direction.LEFT) {
            x--;
        } else if (direction == Direction.RIGHT) {
            x++;
        }
    }

    public void changeDirection(Direction newDirection) {
        direction = newDirection;
    }

    public void expand() {
        width += 2;
    }
}