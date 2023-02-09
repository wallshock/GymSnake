package org.example;

import java.util.ArrayList;

import static org.example.Configuration.*;

public class Snake {
    // Fields
    ArrayList<ArrayList<Integer>> x;
    ArrayList<ArrayList<Integer>> y;
    // Coordinates of the snake's head
    int length; // Length of the snake
    int width; // Width of the snake
    int speed; // Speed of the snake's movement
    int anabolicDose; // Current dose of anabolics

    Direction prevdirection;
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

    public ArrayList<ArrayList<Integer>> getX() {
        return x;
    }

    public ArrayList<ArrayList<Integer>> getY() {
        return y;
    }

    // Constructor
    public Snake(ArrayList<ArrayList<Integer>> x, ArrayList<ArrayList<Integer>> y) {
        this.x = x;
        this.y = y;
        this.anabolicDose=0;
        this.length = IL;
        this.width = IW;
        this.speed = IS;
        this.prevdirection= Direction.UP;
        this.direction = Direction.UP;
    }

    //todo we have to handle how to make the snake with width!=1 move correctly
    public void move() {
        for (int i = this.length - 1; i > 0; i--) {
            for(int j=0; j<this.width;j++) {
                this.x.get(i).set(j,this.x.get(i - 1).get(j));
                this.y.get(i).set(j,this.y.get(i - 1).get(j));
            }
        }

        //todo here we have to manage that somehow
        switch (this.direction) {
            case UP:
                for(int j=0; j<this.width;j++) {
                    this.y.get(0).set(j,(this.y.get(0).get(j)-this.speed)%N);
                }
                break;
            case DOWN:
                for(int j=0; j<this.width;j++) {
                    this.y.get(0).set(j,(this.y.get(0).get(j)+this.speed)%N);
                }
                break;
            case LEFT:
                for(int j=0; j<this.width;j++) {
                    this.x.get(0).set(j,(this.x.get(0).get(j)-this.speed)%N);
                }
                break;
            case RIGHT:
                for(int j=0; j<this.width;j++) {
                    this.x.get(0).set(j,(this.x.get(0).get(j)+this.speed)%N);
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