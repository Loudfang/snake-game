/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snake;

import java.util.*;

/**
 *
 * @author Madduck
 */
public class TheSnake {
    
    private GameBoard board;
    private LinkedList points;
    
    
    public TheSnake(GameBoard board){
        this.board = board;
        this.points = new LinkedList();
    }
    
}
