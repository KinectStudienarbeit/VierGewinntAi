/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package viergewinntai;

import java.io.Console;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Contains all game logic
 * @author rusinda
 */
public class GameEngine {
    
    public boolean playerOneHuman;  //indicates if the first player is human
    public boolean playerTwoHuman;  //indicates if the second player is human
    public int[][] playingField = new int[7][6];  //the field with all positions, 0=empty, 1=first player, 2=second player
    public int playerTurn; //1=first player's turn, 2=second player's turn
    public int winRule = 4;    //how many pieces in a line to win
    
    
    /**
     * Sets all variables and initializes the game engine
     */
    public void initialize(){
        for(int i = 0; i <playingField.length; i++){
            for(int j = 0; j<playingField[i].length; j++){
                playingField[i][j] = 0;
            }
        }
        playerTurn = 1;
    }
    
    /**
     * Tries to take a move using the specified column, handles all checks
     * @param column specifies the column where the piece should be placed
     */
    public void tryMove(char column){
        tryMove((Character.toUpperCase(column) - 65));
    }
    
    public void tryMove(int column){
        if(!checkMove(column)) {
            displayError();
        } else {
            int i = 0;
            while(playingField[column][i] != 0){
                i++;
            }
            int row = i;
            playingField[column][row] = playerTurn;
            if(playerTurn == 1){
                playerTurn = 2;
            } else {
                playerTurn = 1;
            }
            if(checkWin(column, row)){
                System.out.println(playerTurn + " won!");
            }
                        displayPlayerTurn(column, row);
        }
    }
    
    /**
     * Checks if a move is valid
     * @param column specifies the column
     * @return true if the move is valid, false otherwise
     */
    public boolean checkMove(char column){
        
        return checkMove((Character.toUpperCase(column) - 65));
    }
    
    public boolean checkMove(int column){
        if(playingField[column][5] != 0) {
            return false;
        }
        return true;
    }
    
    private void startAI(){
        
    }
    
    /**
     * Checks if the turn taken resulted in a player winning the game
     * @return
     */
    public boolean checkWin(int column, int row){
        
        int sum;
        int row_;
        int column_;
        
        sum = 1;
        row_ = row;
        column_ = column -1;
        while(column_ >= 0 && playingField[column_][row_] == playerTurn){
            sum++;
            column_ --;
        }
        column_ = column +1;
        while(column_ < 7 && playingField[column_][row_] == playerTurn){
            sum++;
            column_ ++;
        }
        if(sum >= 4) return true;
        
        sum = 1;
        row_ = row -1;
        column_ = column;
        while(row_ >= 0 && playingField[column_][row_] == playerTurn){
            sum++;
            row_ --;
        }
        row_ = row +1;
        while(row_ < 6 && playingField[column_][row_] == playerTurn){
            sum++;
            row_ ++;
        }
        if(sum >= 4) return true;
        
        sum = 1;
        row_ = row -1;
        column_ = column -1;
        while(column_ >= 0 && row_ >= 0 && playingField[column_][row_] == playerTurn){
            sum++;
            column_ --;
            row_ --;
        }
        row_ = row +1;
        column_ = column +1;
        while(column_ < 7 && row_< 6 && playingField[column_][row_] == playerTurn){
            sum++;
            column_ ++;
            row_++;
        }
        if(sum >= 4) return true;
        
        sum = 1;
        row_ = row +1;
        column_ = column -1;
        while(column_ >= 0 && row_ < 6 && playingField[column_][row_] == playerTurn){
            sum++;
            column_ --;
            row_ ++;
        }
        row_ = row -1;
        column_ = column +1;
        while(column_ < 7 && row_>=0 && playingField[column_][row_] == playerTurn){
            sum++;
            column_ ++;
            row_--;
        }
        if(sum >= 4) return true;
        
        
        return false;
    }
    
    /**
     * Resets the game
     */
    public void resetGame(){
        
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GameEngine mainGameEngine = new GameEngine();
        mainGameEngine.playerOneHuman = true;
        mainGameEngine.playerOneHuman = true;
        mainGameEngine.initialize();
        mainGameEngine.displayPlayerTurn(0,0);
        while (true){
            InputStreamReader r = new InputStreamReader(System.in);
            try{
            mainGameEngine.tryMove((char)r.read());
            } catch(Exception e)
                
            {
                System.out.println("mist");
                e.printStackTrace();
            }
        }
    }
    
    private void display(){
        for(int i = 5; i >= 0; i--){
            String s = "";
            for(int j = 0; j < 7; j++){
                s += playingField[j][i] + " ";
            }
            System.out.println(s);
        }
        System.out.println("a b c d e f g");
    }
    
    private void displayError(){
        System.out.println("Not a valid move!");
        display();
    }
    
    private void displayPlayerTurn(int column, int row){
        System.out.println("Player " + Integer.toString(playerTurn) + " ist dran");
        display();
    }
}
