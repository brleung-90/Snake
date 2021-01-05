package com.company;

import javax.swing.JFrame;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Game implements KeyListener {

    private Snake snake;
    private Food food;
    private Graphics graphics;

    private JFrame window;

    public static final int WIDTH = 30;
    public static final int HEIGHT = 30;
    public static final int DIMENSION = 20;


    public Game() {
        window = new JFrame();

        snake = new Snake();
        food = new Food(snake);
        graphics = new Graphics(this);

        window.add(graphics);

        window.setTitle("Snake");
        window.setSize(WIDTH * DIMENSION + 2, HEIGHT * DIMENSION + DIMENSION + 4);
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void start() {
        graphics.state = "RUNNING";
    }

    public void update() {
        if(graphics.state == "RUNNING") {
            if(check_food_collision()) {
                snake.grow();
                food.random_spawn(snake);
            }
            else if(check_wall_collision() || check_self_collision()) {
                graphics.state = "END";
            }
            else {
                snake.move();
            }
        }
    }

    private boolean check_wall_collision() {
        if(snake.getX() < 0 || snake.getX() >= WIDTH * DIMENSION || snake.getY() < 0 || snake.getY() > HEIGHT * DIMENSION) {
            return true;
        }
        return false;
    }

    private boolean check_food_collision() {
        if(snake.getX() == food.getX() * DIMENSION && snake.getY() == food.getY() * DIMENSION) {
            return true;
        }
        return false;
    }

    private boolean check_self_collision() {
        for(int i = 1; i < snake.getBody().size(); i++) {
            if(snake.getX() == snake.getBody().get(i).x && snake.getY() == snake.getBody().get(i).y) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();

        if (graphics.state.equals("RUNNING")) {
            if (keyCode == KeyEvent.VK_W) {
                snake.up();
            }
            else if (keyCode == KeyEvent.VK_S) {
                snake.down();
            }
            else if (keyCode == KeyEvent.VK_A) {
                snake.left();
            }
            else {
                snake.right();
            }
        }
        else {
            this.start();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {}

    public Snake getSnake() {
        return snake;
    }

    public void setSnake(Snake snake) {
        this.snake = snake;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public JFrame getWindow() {
        return window;
    }

    public void setWindow(JFrame window) {
        this.window = window;
    }
}
