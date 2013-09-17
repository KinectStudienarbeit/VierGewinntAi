/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package viergewinntai;

/**
 *
 * @author Dawid
 */
public class VierGewinntAi {
    
    public static GUI mainGUI;
    public static GameEngine mainGameEngine;
    public static ArtificialIntelligence playerOneAI;
    public static ArtificialIntelligence playerTwoAI;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        //mainGameEngine.playingField={{0,0,0,0,0,0,0},{0,0,0,0,0,0,0},{0,0,0,0,0,0,0},{0,0,0,0,0,0,0},{0,0,0,0,0,0,0},{0,0,0,0,0,0,0},{0,0,0,0,0,0,0}};
        mainGameEngine= new GameEngine(); 
        mainGameEngine.initialize();
        
        
        mainGUI = new GUI(); 
        mainGUI.initialize();
        
    }
}
