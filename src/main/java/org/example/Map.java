package org.example;

public class Map {
    private static final double NUM_ITEM_TYPES = 6;
    private int N; // Size of the map
    private Snake snake; // Snake object
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
        int[] snakeX = snake.getX()[0];
        int[] snakeY = snake.getY()[0];

        // Check if the snake intersects with any item on the map
        for(int i=0;i<snake.width;i++) {
            Item item = items[snakeX[i]][snakeY[i]];
            if (item != null) {
                item.applyEffect(snake);
                removeItem(snakeX[i], snakeY[i]);
                //todo make it not rng to existing object
                int posX = (int) (Math.random() * N);
                int posY = (int) (Math.random() * N);

                addItem(Map.randomItem(posX, posY), posX, posY);
            }
        }
    }




}
