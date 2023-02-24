package org.example;

import org.example.interfaces.AnabolicDoseObserver;
import org.example.interfaces.IGuiObserver;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Scanner;

import static org.example.Configuration.N;

public class Game extends Thread implements AnabolicDoseObserver {
    private Snake snake;

    private IGuiObserver observer;
    private boolean dead = false;
    private GridMap map;

    public Snake getSnake() {
        return snake;
    }

    public GridMap getMap() {
        return map;
    }

    public Game(){
        Configuration testCfg = new Configuration(100, 4, 1, 0.25, 2, 10, 6, 1, 1.25);
        this.snake = new Snake(this);
        this.map = new GridMap(N,snake);
    }

    public void run() {
        observer.endingScreenHide();
        while (!dead) {
            map.update();
            snake.reduceToxicity();
            observer.updateGuiViews();
        }
        observer.endingScreenShow();
    }

    @Override
    public void onSnakeOverdose() {
        dead = true;
    }
    public boolean isDead(){
        return dead;
    }
    public void setObserver(IGuiObserver o){
        this.observer = o;
    }
}
