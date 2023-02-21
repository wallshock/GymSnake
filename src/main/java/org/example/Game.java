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
    private int dead = 0;
    private Map map;

    public Snake getSnake() {
        return snake;
    }

    public Map getMap() {
        return map;
    }

    public Game(){
        Configuration testCfg = new Configuration(100, 2, 1, 0.5, 1, 10, 5, 1, 1.1);
        this.snake = new Snake(this);
        this.map = new Map(N,snake);
    }

    public void run() {
        while (dead==0) {
            map.update();
            observer.updateGuiViews();
        }
    }

    @Override
    public void onSnakeOverdose() {
        dead = 1;
    }

    public void setObserver(IGuiObserver o){
        this.observer = o;
    }
}
