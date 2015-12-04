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
    
    public tiletype getTile(int x, int y){
        return tiles[y * MAP_SIZE +x];
    }
    
    public void draw(Graphics2D g){
        g.setColor(tiletype.SNAKE.getColor());
        
        for(int i = 0;i<MAP_SIZE * MAP_SIZE; i++){
                int x = i% MAP_SIZE;
                int y = i/ MAP_SIZE;
            if(tiles[i].equals(tiletype.EMPTY)){
               
            }
            if(tiles[i].equals(tiletype.FRUIT)){
                g.setColor(tiletype.FRUIT.getColor());
                g.fillOval(x * TILE_SIZE + 4, y * TILE_SIZE+4, TILE_SIZE - 8, TILE_SIZE - 8);
                g.setColor(tiletype.SNAKE.getColor());
            }
            else{
                g.fillRect(x * TILE_SIZE +1, y*TILE_SIZE+1,TILE_SIZE -2, TILE_SIZE-2);}
            
            }
        }
    }
  
    
