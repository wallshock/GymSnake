package org.example;

import org.example.interfaces.IMapElement;
import org.example.interfaces.Item;

import java.util.ArrayList;

import static org.example.Configuration.*;

public class Snake implements IMapElement {
    // Fields
    ArrayList<ArrayList<Integer>> x;
    private ArrayList<Item> backpack;
    ArrayList<ArrayList<Integer>> y;
    // Coordinates of the snake's head
    int length; // Length of the snake
    boolean snakeExtendFlag= false;
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

    public void move() {
        for (int i = this.length - 1; i > 0; i--) {
            for(int j=0; j<this.width;j++) {
                this.x.get(i).set(j,this.x.get(i - 1).get(j));
                this.y.get(i).set(j,this.y.get(i - 1).get(j));
            }
        }

        switch (this.direction) {
            case UP:
                if(prevdirection == Direction.RIGHT) {
                    for (int j = 0; j < this.width; j++) {
                        this.x.get(0).set(j, ((this.x.get(0).get(j)- ((this.width-1)-j))) % N);
                        this.y.get(0).set(j, ((this.y.get(0).get(j) - 1-j)) % N);
                        if(CheckForSteroidApplication(this.x.get(0).get(j),this.y.get(0).get(j))){
                            injectSteroids();
                        }
                    }
                }else if(prevdirection == Direction.LEFT){
                    for (int j = 0; j < this.width; j++) {
                        this.x.get(0).set(j, ((this.x.get(0).get(j)+j)) % N);
                        this.y.get(0).set(j, ((this.y.get(0).get(j) - (this.width)+j)) % N);
                        if(CheckForSteroidApplication(this.x.get(0).get(j),this.y.get(0).get(j))){
                            injectSteroids();
                        }
                    }
                }else{
                    for (int j = 0; j < this.width; j++){
                        this.y.get(0).set(j,(this.y.get(0).get(j)-1)%N);
                        if(CheckForSteroidApplication(this.x.get(0).get(j),this.y.get(0).get(j))){
                            injectSteroids();
                        }
                    }
                }
                prevdirection = Direction.UP;
                break;
            case DOWN:
                if(prevdirection == Direction.RIGHT) {
                    for (int j = 0; j < this.width; j++) {
                        this.x.get(0).set(j, ((this.x.get(0).get(j)-j)) % N);
                        this.y.get(0).set(j, ((this.y.get(0).get(j) + ((this.width)-j))) % N);
                        if(CheckForSteroidApplication(this.x.get(0).get(j),this.y.get(0).get(j))){
                            injectSteroids();
                        }
                    }
                }else if(prevdirection == Direction.LEFT){
                    for (int j = 0; j < this.width; j++) {
                        this.x.get(0).set(j, ((this.x.get(0).get(j) +(this.width-1-j))) % N);
                        this.y.get(0).set(j, ((this.y.get(0).get(j) +1+j) % N));
                        if(CheckForSteroidApplication(this.x.get(0).get(j),this.y.get(0).get(j))){
                            injectSteroids();
                        }
                    }
                }else{
                    for (int j = 0; j < this.width; j++){
                        this.y.get(0).set(j,(this.y.get(0).get(j)+1)%N);
                        if(CheckForSteroidApplication(this.x.get(0).get(j),this.y.get(0).get(j))){
                            injectSteroids();
                        }
                    }
                }
                prevdirection = Direction.DOWN;
                break;
            case LEFT:
                if(prevdirection == Direction.UP) {
                    for (int j = 0; j < this.width; j++) {
                        this.x.get(0).set(j, ((this.x.get(0).get(j)-1-j)) % N);
                        this.y.get(0).set(j, ((this.y.get(0).get(j) +(this.width-1-j))) % N);
                        if(CheckForSteroidApplication(this.x.get(0).get(j),this.y.get(0).get(j))){
                            injectSteroids();
                        }
                    }
                }else if(prevdirection == Direction.DOWN){
                    for (int j = 0; j < this.width; j++) {
                        this.x.get(0).set(j, ((this.x.get(0).get(j)-(this.width-j))) % N);
                        this.y.get(0).set(j, ((this.y.get(0).get(j) - j) % N));
                        if(CheckForSteroidApplication(this.x.get(0).get(j),this.y.get(0).get(j))){
                            injectSteroids();
                        }
                    }
                }
                else{
                    for (int j = 0; j < this.width; j++){
                        this.x.get(0).set(j,(this.x.get(0).get(j)-1)%N);
                        if(CheckForSteroidApplication(this.x.get(0).get(j),this.y.get(0).get(j))){
                            injectSteroids();
                        }
                    }
                }
                prevdirection = Direction.LEFT;
                break;
            case RIGHT:
                if(prevdirection == Direction.UP) {
                    for (int j = 0; j < this.width; j++) {
                        this.x.get(0).set(j, ((this.x.get(0).get(j)+(this.width-j))) % N);
                        this.y.get(0).set(j, ((this.y.get(0).get(j) + j)) % N);
                        if(CheckForSteroidApplication(this.x.get(0).get(j),this.y.get(0).get(j))){
                            injectSteroids();
                        }
                    }
                }else if(prevdirection == Direction.DOWN){
                    for (int j = 0; j < this.width; j++) {
                        this.x.get(0).set(j, ((this.x.get(0).get(j)+1+j) % N));
                        this.y.get(0).set(j, ((this.y.get(0).get(j) - (this.width-1-j)) % N));
                        if(CheckForSteroidApplication(this.x.get(0).get(j),this.y.get(0).get(j))){
                            injectSteroids();
                        }
                    }
                }
                else{
                    for (int j = 0; j < this.width; j++){
                        this.x.get(0).set(j,(this.x.get(0).get(j)+1)%N);
                        if(CheckForSteroidApplication(this.x.get(0).get(j),this.y.get(0).get(j))){
                            injectSteroids();
                        }
                    }
                }
                prevdirection = Direction.RIGHT;
                break;
        }
        if(snakeExtendFlag){
            this.setLength(this.getLength()+1);
            snakeExtendFlag=false;
        }
    }
    //todo test this
    private boolean CheckForSteroidApplication(int x, int y) {
        for(int i=0; i<P;i++){
            for(int j=0;j<this.getX().get(-1).size();j++){
                if(this.getX().get(-1-i).get(j)==x){
                    if(this.getY().get(-1-i).get(j)==y){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    //todo test this
    public void addToBackpack(Item item){
        this.backpack.add(item);
    }

    //todo test this
    public void injectSteroids() {
        int g = this.getBackpack().size();
        int before = this.getAnabolicDose();
        for(int i = 0;i<g;i++){
            this.getBackpack().get(0).applyEffect(this);
            this.getBackpack().remove(0);
            if(this.getAnabolicDose()>LD){
                //todo end the game somehow
            }
            if(this.getAnabolicDose()-before>(LD/2)){
                applyBonus(this);
            }
        }
    }
    //todo test this
    private void applyBonus(Snake snake) {
        snake.extend();
        snake.setSpeed(snake.getSpeed()+1);
    }
    public void changeDirection(Direction newDirection) {
        prevdirection = direction;
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

    public Direction getPrevdirection() {
        return prevdirection;
    }

    @Override
    public String getImagePath() {
        return null;
    }

    //todo test this
    public void extend() {
        ArrayList<Integer> newx = this.getX().get(-1);
        ArrayList<Integer> newy= this.getY().get(-1);
        this.x.add(newx);
        this.y.add(newy);
        snakeExtendFlag=true;
    }

    public ArrayList<Item> getBackpack() {
        return backpack;
    }
}