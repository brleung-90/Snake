package com.company;

import java.awt.Rectangle;
import java.util.ArrayList;

public class Snake {
    private ArrayList<Rectangle> body;

    private int w = Game.WIDTH;
    private int h = Game.HEIGHT;
    private int d = Game.DIMENSION;

    private String move;

    public Snake() {
        body = new ArrayList<>();

        Rectangle temp = new Rectangle(Game.DIMENSION, Game.DIMENSION);
        temp.setLocation(Game.WIDTH / 2 * Game.DIMENSION, Game.HEIGHT / 2 * Game.DIMENSION);
        body.add(temp);

        temp = new Rectangle(d, d);
        temp.setLocation((w / 2 - 1) * d, (h / 2) * d);
        body.add(temp);

        temp = new Rectangle(d, d);
        temp.setLocation((w / 2 - 2) * d, (h / 2) * d);
        body.add(temp);

        move = "NOTHING";
    }

    public void move() {
        if (move != "NOTHING") {
            Rectangle first = body.get(0);

            Rectangle temp = new Rectangle(Game.DIMENSION, Game.DIMENSION);

            if(move.equals("UP")) {
                temp.setLocation(first.x, first.y - Game.DIMENSION);
            } else if(move.equals("DOWN")) {
                temp.setLocation(first.x, first.y + Game.DIMENSION);
            } else if(move.equals("LEFT")) {
                temp.setLocation(first.x - Game.DIMENSION, first.y);
            } else {
                temp.setLocation(first.x + Game.DIMENSION, first.y);
            }
            body.add(0, temp);
            body.remove(body.size() - 1);
        }
    }

    public void grow() {
            Rectangle first = body.get(0);

            Rectangle temp = new Rectangle(Game.DIMENSION, Game.DIMENSION);

            if (move.equals("UP")) {
                temp.setLocation(first.x, first.y - Game.DIMENSION);
            } else if (move.equals("DOWN")) {
                temp.setLocation(first.x, first.y + Game.DIMENSION);
            } else if (move.equals("LEFT")) {
                temp.setLocation(first.x - Game.DIMENSION, first.y);
            } else {
                temp.setLocation(first.x + Game.DIMENSION, first.y);
            }
            body.add(0, temp);
        }


    public ArrayList<Rectangle> getBody() {
        return body;
    }

    public void setBody(ArrayList<Rectangle> body) {
        this.body = body;
    }

    public int getX() {
        return body.get(0).x;
    }

    public int getY() {
        return body.get(0).y;
    }

    public void up() {
        if (move != "DOWN") {
            move = "UP";
        }
    }

    public void down() {
        if (move != "UP") {
            move = "DOWN";
        }
    }

    public void left() {
        if (move != "RIGHT") {
            move = "LEFT";
        }
    }

    public void right() {
        if (move != "LEFT") {
            move = "RIGHT";
        }
    }
}
