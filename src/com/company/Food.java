package com.company;

import java.awt.Rectangle;

public class Food {
    private int x;
    private int y;

    public Food(Snake snake) {
        this.random_spawn(snake);
    }

    public void random_spawn(Snake snake) {

        boolean onSnake = true;
        while(onSnake) {
            onSnake = false;
            x = (int)(Math.random() * Game.WIDTH - 1);
            y = (int)(Math.random() * Game.HEIGHT - 1);

            for(Rectangle r: snake.getBody()) {
                if(r.x == x && r.y == y) {
                    onSnake = true;
                }
            }
        }
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
