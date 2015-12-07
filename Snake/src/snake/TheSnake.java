/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snake;

import java.awt.*;
import java.util.*;
import snake.GameBoard.*;

/**
 *
 * @author Madduck
 */
public class TheSnake {

    private GameBoard board;
    private LinkedList points;
    private Direction currentDirection;
    private Direction temporaryDirection;

    public TheSnake(GameBoard board) {
        this.board = board;
        this.points = new LinkedList();
    }
   

    public static enum Direction {

        UP, DOWN, LEFT, RIGHT, NONE
    }

    public void resetSnake() {
        this.currentDirection = Direction.NONE;
        this.temporaryDirection = Direction.NONE;

        Point head = new Point(GameBoard.MAP_SIZE / 2, GameBoard.MAP_SIZE / 2);
        points.clear();
        points.add(head);
        board.setTile(head.x, head.y, tiletype.SNAKE);
    }

    public tiletype updateSnake() {

        this.currentDirection = temporaryDirection;

        Point head = (Point) points.getFirst();

        /*
         * Gets the current direction of the snake, and returns false if the direction leads
         * us into a wall. Otherwise, it pushes a new point onto the first position of the
         * list (the head) in the new position of the head.
         */
        switch (currentDirection) {

            case UP:
                if (head.y <= 0) {
                    return null;
                }
                points.push(new Point(head.x, head.y - 1));
                break;

            case DOWN:
                if (head.y >= GameBoard.MAP_SIZE - 1) {
                    return null;
                }
                points.push(new Point(head.x, head.y + 1));
                break;

            case LEFT:
                if (head.x <= 0) {
                    return null;
                }
                points.push(new Point(head.x - 1, head.y));
                break;

            case RIGHT:
                if (head.x >= GameBoard.MAP_SIZE - 1) {
                    return null;
                }
                points.push(new Point(head.x + 1, head.y));
                break;

            case NONE:
                return tiletype.EMPTY;
        }

        head = (Point) points.getFirst();

        tiletype oldType = board.getTile(head.x, head.y);
        if (!oldType.equals(tiletype.FRUIT)) {
            Point last = (Point) points.removeLast();
            board.setTile(last.x, last.y, tiletype.EMPTY);
            oldType = board.getTile(head.x, head.y);
        }

        return oldType;
    }

    public void setDirection(Direction direction) {
        if (direction.equals(Direction.UP) && currentDirection.equals(Direction.DOWN)) {
            return;
        } else if (direction.equals(Direction.DOWN) && currentDirection.equals(Direction.UP)) {
            return;
        } else if (direction.equals(Direction.LEFT) && currentDirection.equals(Direction.RIGHT)) {
            return;
        } else if (direction.equals(Direction.RIGHT) && currentDirection.equals(Direction.LEFT)) {
            return;
        }
        this.temporaryDirection = direction;
    }
}
