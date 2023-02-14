package org.example;

import org.example.interfaces.IMapElement;
import org.example.interfaces.Item;

import java.util.ArrayList;

import static org.example.Configuration.*;

public class Map {
    private static final double NUM_ITEM_TYPES = 6;
    private int N; // Size of the map
    Object[][] map;

    private ArrayList<Item> backpack;

    private Snake snake; // Snake object
    private Item[][] items; // 2D array to store all the items on the map

    public Map(int N, Snake snake) {
        this.N = N;
        this.snake = snake;
        map = new Object[N][N];
        fillTheMap();
    }

    //todo test this
    public void fillTheMap(){
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = null;
            }
        }
        for(int i=0;i<snake.getX().size();i++){
            for(int j=0;j<snake.getX().get(0).size();j++){
                map[snake.getX().get(i).get(j)][snake.getY().get(i).get(j)]= new SnakeField(i);
            }
        }
    }
    // Method to add an item to the map
    public void addItem(Object item, int x, int y) {
        map[x][y] = item;
    }

    // Method to remove an item from the map
    public void removeItem(int x, int y) {
        map[x][y] = null;
    }
//todo call random on map few times on star
    public static Item randomItem(int x, int y) {
        // Generate a random number between 0 and the number of item types
        int itemType = (int) (Math.random() * NUM_ITEM_TYPES);

        // Create and return the item based on the random number
        switch (itemType) {
            case 0:
                return new Bench(x, y);
            case 1:
                return new Deadlift(x, y);
            case 2:
                return new Testosterone(x, y);
            case 3:
                return new Proviron(x, y);
            case 4:
                return new Winstrol(x, y);
            case 5:
                return new MongolianSalesman(x, y);
            default:
                throw new IllegalArgumentException("Invalid item type: " + itemType);
        }
    }
    public void addToBackpack(Item item){
        this.backpack.add(item);
    }
    //todo test this
    public void injectSteroids(Snake snake) throws Exception {
        int g = backpack.size();
        int before = snake.getAnabolicDose();
        for(int i = 0;i<g;i++){
            backpack.get(0).applyEffect(snake);
            backpack.remove(0);
            if(snake.getAnabolicDose()>LD){
                throw new Exception();
            }
        if(snake.getAnabolicDose()-before>(LD/2)){
            applyBonus(snake);
        }
        }
    }

    private void applyBonus(Snake snake) {
        snake.extend();
        snake.setSpeed(snake.getSpeed()+1);
    }

    // Method to update the map in each time interval
    public void update() {
        // Move the snake and update its position on the map
        snake.move();
        ArrayList<Integer> snakeX = snake.getX().get(0);
        ArrayList<Integer> snakeY = snake.getY().get(0);

        // Check if the snake intersects with any item on the map
        for (int i = 0; i < snake.width; i++) {
            Object item = map[snakeX.get(i)][snakeY.get(i)];
            if (item instanceof Item) {
                Item item1 = (Item) item;
                this.addToBackpack(item1);
                removeItem(snakeX.get(i), snakeY.get(i));
                int posX = (int) (Math.random() * N);
                int posY = (int) (Math.random() * N);
                if (!this.isOccupied(posX, posY)) {
                    addItem(Map.randomItem(posX, posY), posX, posY);
                }


            }
        }
    }

    private boolean isOccupied(int posX, int posY) {
        return map[posY][posX] != null;
    }

    //todo check if we touched the tail
    private boolean CheckForSteroidApplication() {
        return false;
    }

    public void print(){
        for(int g=0;g<N;g++){
            System.out.println(map[g]);
        }
    }
}

