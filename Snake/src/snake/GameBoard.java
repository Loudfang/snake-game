/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snake;

import java.awt.*;

/**
 *
 * @author Madduck
 */
public class GameBoard {
    
    public static final int TILE_SIZE = 25;
    public static final int MAP_SIZE = 20;
    private tiletype[] tiles;

    tiletype getTile(int x, int y) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public static enum tiletype{
        
        SNAKE(Color.GREEN),
        
        FRUIT(Color.RED),
        
        /**
         * tiles without anything in them
         */
        EMPTY(null);
        
        private Color tilecolor;
        
        private tiletype(Color color){
            this.tilecolor = color;
        }
            
        public Color getColor(){
            return tilecolor;
        }
    }
    
    public GameBoard(){
        /**
         * Resets the board and creates new instance of empty tiles
         */
        tiles = new tiletype [MAP_SIZE * TILE_SIZE];
        resetBoard();
    }
    
    public void resetBoard(){
        for(int i = 0; i <= tiles.length;i++){
            tiles[i] = tiletype.EMPTY;
       }
    }
    
    public void setTile(int x,int y,tiletype type){
        tiles [y* MAP_SIZE + x] = type;        
    }
  
    
}
