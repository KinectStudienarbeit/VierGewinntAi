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
    
    public static GUI mainGUI = new GUI();
    public static GameEngine mainGameEngine = new GameEngine();
    public static ArtificialIntelligence[] AI = {new ArtificialIntelligence(), new ArtificialIntelligence()};
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        mainGUI.initialize();
        
        mainGameEngine.initialize();
        
        
    }
}
