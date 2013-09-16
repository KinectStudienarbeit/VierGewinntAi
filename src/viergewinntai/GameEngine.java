/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package viergewinntai;

/**
 * Contains all game logic
 * @author rusinda
 */
public class GameEngine {
    
    public boolean playerOneHuman;  //indicates if the first player is human
    public boolean playerTwoHuman;  //indicates if the second player is human
    public byte[][] playingField = new byte[7][6];  //the field with all positions, 0=empty, 1=first player, 2=second player
    public byte playerTurn; //1=first player's turn, 2=second player's turn
    public byte winRule = 4;    //how many pieces in a line to win
    
    
    /**
     * Sets all variables and initializes the game engine
     */
    public void initialize(){
    
    }
    
    /**
     * Tries to take a move using the specified column, handles all checks
     * @param column specifies the column where the piece should be placed
     */
    public void tryMove(char column){
        
    }
    
    /**
     * Checks if a move is valid
     * @param column specifies the column
     * @return true if the move is valid, false otherwise
     */
    public boolean checkMove(char column){
        
        return true;
    }
    
    private void startAI(){
        
    }
    
    /**
     * Checks if the turn taken resulted in a player winning the game
     * @return
     */
    public boolean checkWin(){
        
        return true;
    }
    
    /**
     * Resets the game
     */
    public void resetGame(){
        
    }
}
