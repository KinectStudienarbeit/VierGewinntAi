/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package viergewinntai;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rusinda
 */
public class ArtificialIntelligence {
    
    public void startAi(){
        
        randomMove();
    }
    
    private void randomMove(){
        int i;
        Random r = new Random();
        while(!VierGewinntAi.mainGameEngine.checkMove((i = r.nextInt(7))));
        VierGewinntAi.mainGameEngine.tryMove(i);
        
    }
}
