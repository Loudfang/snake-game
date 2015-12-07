/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snake;

import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author Madduck
 */
public class TheEngine extends KeyAdapter {

    private GameBoard board;
    private TheSnake snake;
    private Canvas canvas;
    private static final int UPDATES_PER_SECOND = 10;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Snake ");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        Canvas canvas = new Canvas();
        canvas.setBackground(Color.BLACK);
        canvas.setPreferredSize(new Dimension(GameBoard.MAP_SIZE * GameBoard.TILE_SIZE, GameBoard.MAP_SIZE * GameBoard.TILE_SIZE));
        frame.add(canvas);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        TheEngine engine = new TheEngine(canvas);
        engine.startGame();
    }

    private TheEngine(Canvas canvas) {

        this.canvas = canvas;
        snake = new TheSnake(board);
        canvas.addKeyListener((KeyListener) this);
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    public void startGame() {

        canvas.createBufferStrategy(2);
        Graphics2D g = (Graphics2D) canvas.getBufferStrategy().getDrawGraphics();

        long start = 0L;
        long sleepDuration = 0L;

        while (true) {
            start = System.currentTimeMillis();
            update();
            render(g);
            canvas.getBufferStrategy().show();
            g.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
            sleepDuration = (1000L / UPDATES_PER_SECOND) - (System.currentTimeMillis() - start);

            if (sleepDuration > 0) {
                try {
                    Thread.sleep(sleepDuration);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }
    }

    private void update() {
        // TODO 

    }

    private void render(Graphics2D g) {

        //TODO
    }

}
