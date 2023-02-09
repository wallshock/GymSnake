package org.example;

import java.util.ArrayList;

public class Map {
    private static final double NUM_ITEM_TYPES = 6;
    private int N; // Size of the map
    private Snake snake; // Snake object
    private Item[] backpack;
    private Item[][] items; // 2D array to store all the items on the map

    public Map(int N, Snake snake) {
        this.N = N;
        this.snake = snake;
        items = new Item[N][N];
    }

    // Method to add an item to the map
    public void addItem(Item item, int x, int y) {
        items[x][y] = item;
    }

    // Method to remove an item from the map
    public void removeItem(int x, int y) {
        items[x][y] = null;
    }
    public static Item randomItem(int x,int y) {
        // Generate a random number between 0 and the number of item types
        int itemType = (int) (Math.random() * NUM_ITEM_TYPES);

        // Create and return the item based on the random number
        switch (itemType) {
            case 0:
                return new Bench(x,y);
            case 1:
                return new Deadlift(x,y);
            case 2:
                return new Testosterone(x,y);
            case 3:
                return new Proviron(x,y);
            case 4:
                return new Winstrol(x,y);
            case 5:
                return new MongolianSalesman(x,y);
            default:
                throw new IllegalArgumentException("Invalid item type: " + itemType);
        }
    }


    // Method to update the map in each time interval
    public void update() {
        // Move the snake and update its position on the map
        snake.move();
        ArrayList<Integer> snakeX = snake.getX().get(0);
        ArrayList<Integer> snakeY = snake.getY().get(0);

        // Check if the snake intersects with any item on the map
        for(int i=0;i<snake.width;i++) {
            Item item = items[snakeX.get(i)][snakeY.get(i)];
            if (item != null) {
                item.applyEffect(snake);
                removeItem(snakeX.get(i), snakeY.get(i));
                int posX = (int) (Math.random() * N);
                int posY = (int) (Math.random() * N);
                if(this.isOccupied(posX,posY)){
                    addItem(Map.randomItem(posX, posY), posX, posY);
                }


            }
        }
    }
//todo we have to do map NxN
    //todo add observers to notify map about position changed of the snake
    private boolean isOccupied(int posX, int posY) {
        return false;
    }

    private boolean CheckForSteroidApplication() {
        return false;
    }

}
