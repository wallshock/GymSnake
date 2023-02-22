package org.example;

import org.example.interfaces.IMapElement;
import org.example.interfaces.Item;

import java.util.ArrayList;

import static org.example.Configuration.*;

public class Map {
    private static final double NUM_ITEM_TYPES = 6;
    private int N; // Size of the map
    Object[][] map;



    private Snake snake; // Snake object

    public Snake getSnake() {
        return snake;
    }

    public Map(int N, Snake snake) {
        this.N = N;
        this.snake = snake;
        map = new Object[N][N];
        generateItems(N/2);
    }
    // Method to add an item to the map
    public void addItem(Object item, int x, int y) {
        map[y][x] = item;
    }

    // Method to remove an item from the map
    public void removeItem(int x, int y) {
        map[y][x] = null;
    }
    
    public void generateItems(int numberofitems){
        for(int i=0;i<numberofitems;i++) {
            int posX = (int) (Math.random() * N);
            int posY = (int) (Math.random() * N);
            if (!this.isOccupied(posX, posY)) {
                addItem(Map.randomItem(posX, posY), posX, posY);
            }
        }
        
    }
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

    // Method to update the map in each time interval
    public void update() {
        snake.changeDirection(snake.getQueue());
        snake.move();
        ArrayList<Integer> snakeX = snake.getX().get(0);
        ArrayList<Integer> snakeY = snake.getY().get(0);

        for (int i = 0; i < snake.width; i++) {
            Object item = map[snakeY.get(i)][snakeX.get(i)];
            if (item instanceof Item) {
                Item item1 = (Item) item;
                snake.addToBackpack(item1);
                removeItem(snakeX.get(i), snakeY.get(i));
                generateItems(1);
            }
        }
    }
    private boolean isOccupied(int posX, int posY) {
        return !(map[posY][posX] == null);
    }

    public String getPathImageAtPosition(int x,int y){
        if(map[y][x] !=null){
            if(map[y][x] instanceof Item){
                Item item =(Item) map[y][x];
                return item.getPath();
            }
            else{
                return "C:\\Users\\rudy7\\IdeaProjects\\Snake\\src\\main\\resources\\snake.png";
            }
        }
        return "C:\\Users\\rudy7\\IdeaProjects\\Snake\\src\\main\\resources\\bg2.png";
    }
    public void print(){
        for(int g=0;g<N;g++){
            System.out.println(map[g]);
        }
    }

    public int getN() {
        return N;
    }
}

