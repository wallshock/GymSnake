package org.example;

import org.example.interfaces.AnabolicDoseObserver;
import org.example.interfaces.IMapElement;
import org.example.interfaces.Item;

import java.util.ArrayList;

import static java.lang.Math.abs;
import static org.example.Configuration.*;

public class Snake {
    // Fields
    ArrayList<ArrayList<Integer>> x;
    private ArrayList<Item> backpack = new ArrayList<Item>();
    ArrayList<ArrayList<Integer>> y;
    int length; // Length of the snake
    int snakeExtendAmmount= 0;
    int width; // Width of the snake
    double speed; // Speed of the snake's movement
    int anabolicDose; // Current dose of anabolics
    Direction prevdirection;
    private AnabolicDoseObserver SnakeObserver;
    Direction direction;
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
    public Snake(AnabolicDoseObserver observer) {
        this.x = new ArrayList<ArrayList<Integer>>();
        this.y = new ArrayList<ArrayList<Integer>>();
        initializeSnake();
        this.anabolicDose=0;
        this.length = IL;
        this.width = IW;
        this.speed = IS;
        this.prevdirection= Direction.UP;
        this.direction = Direction.UP;
        this.SnakeObserver = observer;
    }

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
                        this.x.get(0).set(j, modulo((this.x.get(0).get(j)- (this.width-1)-j), N));
                        this.y.get(0).set(j, modulo((this.y.get(0).get(j) - 1-j), N));
                        System.out.println(x);
                        System.out.println(y);
                        if(CheckForSteroidApplication(this.x.get(0).get(j),this.y.get(0).get(j))){
                            injectSteroids();
                        }
                    }
                }else if(prevdirection == Direction.LEFT){
                    for (int j = 0; j < this.width; j++) {
                        this.x.get(0).set(j, modulo((this.x.get(0).get(j)+j), N));
                        this.y.get(0).set(j, modulo((this.y.get(0).get(j) - (this.width)+j), N));
                        if(CheckForSteroidApplication(this.x.get(0).get(j),this.y.get(0).get(j))){
                            injectSteroids();
                        }
                    }
                }else{
                    for (int j = 0; j < this.width; j++){
                        this.y.get(0).set(j,modulo((this.y.get(0).get(j)-1),N));
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
                        this.x.get(0).set(j, modulo((this.x.get(0).get(j)-j), N));
                        this.y.get(0).set(j, modulo((this.y.get(0).get(j) + ((this.width)-j)), N));
                        if(CheckForSteroidApplication(this.x.get(0).get(j),this.y.get(0).get(j))){
                            injectSteroids();
                        }
                    }
                }else if(prevdirection == Direction.LEFT){
                    for (int j = 0; j < this.width; j++) {
                        this.x.get(0).set(j, modulo((this.x.get(0).get(j) +(this.width-1-j)), N));
                        this.y.get(0).set(j, modulo((this.y.get(0).get(j) +1+j), N));
                        if(CheckForSteroidApplication(this.x.get(0).get(j),this.y.get(0).get(j))){
                            injectSteroids();
                        }
                    }
                }else{
                    for (int j = 0; j < this.width; j++){
                        this.y.get(0).set(j,modulo((this.y.get(0).get(j)+1),N));
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
                        this.x.get(0).set(j, modulo((this.x.get(0).get(j)-1-j), N));
                        this.y.get(0).set(j, modulo((this.y.get(0).get(j) +(this.width-1-j)), N));
                        if(CheckForSteroidApplication(this.x.get(0).get(j),this.y.get(0).get(j))){
                            injectSteroids();
                        }
                    }
                }else if(prevdirection == Direction.DOWN){
                    for (int j = 0; j < this.width; j++) {
                        this.x.get(0).set(j, modulo((this.x.get(0).get(j)-(this.width-j)), N));
                        this.y.get(0).set(j, modulo((this.y.get(0).get(j) - j), N));
                        if(CheckForSteroidApplication(this.x.get(0).get(j),this.y.get(0).get(j))){
                            injectSteroids();
                        }
                    }
                }
                else{
                    for (int j = 0; j < this.width; j++){
                        this.x.get(0).set(j,modulo(this.x.get(0).get(j)-1,N));
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
                        this.x.get(0).set(j, modulo(this.x.get(0).get(j)+(this.width-j), N));
                        this.y.get(0).set(j, modulo(this.y.get(0).get(j) + j, N));
                        if(CheckForSteroidApplication(this.x.get(0).get(j),this.y.get(0).get(j))){
                            injectSteroids();
                        }
                    }
                }else if(prevdirection == Direction.DOWN){
                    for (int j = 0; j < this.width; j++) {
                        this.x.get(0).set(j, modulo(this.x.get(0).get(j)+1+j, N));
                        this.y.get(0).set(j, modulo(this.y.get(0).get(j) - (this.width-1-j), N));
                        if(CheckForSteroidApplication(this.x.get(0).get(j),this.y.get(0).get(j))){
                            injectSteroids();
                        }
                    }
                }
                else{
                    for (int j = 0; j < this.width; j++){
                        this.x.get(0).set(j,modulo(this.x.get(0).get(j)+1,N));
                        if(CheckForSteroidApplication(this.x.get(0).get(j),this.y.get(0).get(j))){
                            injectSteroids();
                        }
                    }
                }
                prevdirection = Direction.RIGHT;
                break;
        }
        if(snakeExtendAmmount>0){
            this.setLength(this.getLength()+1);
            snakeExtendAmmount-=1;
        }
    }
    private boolean CheckForSteroidApplication(int x, int y) {
        for(int i=0; i<P;i++){
            for(int j=0;j<this.getX().get(getX().size()-1).size();j++){
                if(this.getX().get(getX().size()-1-i).get(j)==x){
                    if(this.getY().get(getY().size()-1-i).get(j)==y){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public void initializeSnake(){
        int center =(int) roundUp(N-this.getWidth(),2);
        for(int i=0;i<IL;i++){
            ArrayList<Integer> xs = new ArrayList<Integer>();
            ArrayList<Integer> ys = new ArrayList<Integer>();
            for(int g=0;g<IW;g++){
                xs.add(center+g);
                ys.add((center+i)%N);
            }
            this.x.add(xs);
            this.y.add(ys);
        }
    }

    public void addToBackpack(Item item){
        this.backpack.add(item);
    }

    public void injectSteroids() {
        int g = this.getBackpack().size();
        int before = this.getAnabolicDose();
        for(int i = 0;i<g;i++){
            this.getBackpack().get(0).applyEffect(this);
            this.getBackpack().remove(0);
            if(this.getAnabolicDose()>LD){
                this.SnakeObserver.onSnakeOverdose();
            }
            if(this.getAnabolicDose()-before>(LD/2)){
                applyBonus(this);
            }
        }
    }
    private void applyBonus(Snake snake) {
        snake.extend(BD);
        snake.setSpeed(snake.getSpeed()+BP);
    }
    public void changeDirection(Direction newDirection) {
        prevdirection = direction;
        direction = newDirection;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
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

    public static String getImagePath() {
        return "C:\\Users\\rudy7\\IdeaProjects\\Snake\\src\\main\\resources\\snek.png";
    }

    public static String getHeadImagePath() {
        return "C:\\Users\\rudy7\\IdeaProjects\\Snake\\src\\main\\resources\\snekhead.png";
    }


    public void extend(int n) {
        for(int i=0;i<n;i++) {
            ArrayList<Integer> newx = this.getX().get(getX().size() - 1);
            ArrayList<Integer> newy = this.getY().get(getX().size() - 1);
            this.x.add(newx);
            this.y.add(newy);
        }
        snakeExtendAmmount +=n;
        System.out.println("extend successfull");
    }

    public static long roundUp(long num, long divisor) {
        int sign = (num > 0 ? 1 : -1) * (divisor > 0 ? 1 : -1);
        return sign * (abs(num) + abs(divisor) - 1) / abs(divisor);
    }

    public int modulo(int dividend, int divisor) {
        int result = dividend % divisor;
        if (result < 0) {
            result += divisor;
        }
        return result;
    }

    public ArrayList<Item> getBackpack() {
        return backpack;
    }
}