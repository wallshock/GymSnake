package org.example;

import org.example.interfaces.AnabolicDoseObserver;

import static org.example.Configuration.N;

public class Game extends Thread implements AnabolicDoseObserver {
    private Snake snake;
    private int dead = 0;
    private Map map;

    public Snake getSnake() {
        return snake;
    }

    public Map getMap() {
        return map;
    }

    public Game(){
        this.snake = new Snake(this);
        this.map = new Map(N,snake);
    }

    @Override
    public void run() {
        while (dead==0) {
            simulate();
        }
    }

    public void simulate() {

    }



    @Override
    public void onSnakeOverdose() {
        dead = 1;
    }
}
