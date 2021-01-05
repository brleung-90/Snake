package com.company;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Graphics extends JPanel implements ActionListener {
    private Timer t = new Timer(100, this);
    public String state;

    private Snake s;
    private Food f;
    private Game game;

    public Graphics(Game g) {
        t.start();
        state = "START";

        game = g;
        s = g.getSnake();
        f = g.getFood();

        this.addKeyListener(g);
        this.setFocusable(true);
        this.setFocusTraversalKeysEnabled(false);
    }

    public void paintComponent(java.awt.Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(Color.black);
        g2d.fillRect(0, 0, Game.WIDTH * Game.DIMENSION + 5, Game.HEIGHT * Game.DIMENSION + 5);

        if (state.equals("START")) {
            g2d.setColor(Color.white);
            g2d.drawString("Press Any Key", Game.WIDTH / 2 * Game.DIMENSION - 40, Game.HEIGHT / 2 * Game.DIMENSION - 20);
        } else if (state.equals("RUNNING")) {
            g2d.setColor(Color.red);
            g2d.fillRect(f.getX() * Game.DIMENSION, f.getY() * Game.DIMENSION, Game.DIMENSION, Game.DIMENSION);

            g2d.setColor(Color.green);
            for (Rectangle r : s.getBody()) {
                g2d.fill(r);
            }
        }
        else {
            g2d.setColor(Color.white);
            g2d.drawString("Your Score: " + (s.getBody().size() -3), Game.WIDTH / 2 * Game.DIMENSION - 40, Game.HEIGHT / 2 * Game.DIMENSION - 20);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();

        game.update();
    }
}
