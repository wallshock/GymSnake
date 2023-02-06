package org.example;

import static org.example.Configuration.*;

public class Snake {
    // Fields
    int[][] x, y; // Coordinates of the snake's head
    int length; // Length of the snake
    int width; // Width of the snake
    int speed; // Speed of the snake's movement
    int anabolicDose; // Current dose of anabolics
    Direction direction; // Direction of the snake's movement (up, down, left, right)

//    public int getX() {
//        return x;
//    }
//
//    public int getY() {
//        return y;
//    }

    public int getWidth() {
        return width;
    }

    public Direction getDirection() {
        return direction;
    }

    public int[][] getX() {
        return x;
    }

    public int[][] getY() {
        return y;
    }

    // Constructor
    public Snake(int[][] x, int[][] y) {
        this.x = x;
        this.y = y;
        this.anabolicDose=0;
        this.length = IL;
        this.width = IW;
        this.speed = IS;
        this.direction = Direction.UP;
    }

    // Methods
    public void move() {
        for (int i = this.length - 1; i > 0; i--) {
            for(int j=0; j<this.width;j++) {
                this.x[i][j] = this.x[i - 1][j];
                this.y[i][j] = this.y[i - 1][j];
            }
        }

        switch (this.direction) {
            case UP:
                for(int j=0; j<this.width;j++) {
                    this.y[0][j] -= this.speed;
                    this.y[0][j] = this.y[0][0] % N;
                }
                break;
            case DOWN:
                for(int j=0; j<this.width;j++) {
                    this.y[0][0] += this.speed;
                    this.y[0][0] = this.y[0][0] % N;
                }
                break;
            case LEFT:
                for(int j=0; j<this.width;j++) {
                    this.x[0][0] -= this.speed;
                    this.x[0][0] = this.x[0][0] % N;
                }
                break;
            case RIGHT:
                for(int j=0; j<this.width;j++) {
                    this.x[0][0] += this.speed;
                    this.x[0][0] = this.x[0][0] % N;
                }
                break;
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
//todo figure out how to expand the snake correctly
    public void expand() {
        width += 2;
    }
}