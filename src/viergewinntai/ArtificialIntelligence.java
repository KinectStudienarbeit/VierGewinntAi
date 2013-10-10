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
    
    private final int ALPHABETADEPTH = 3;
    private int[][] field;
    private int[][] processingField;
    
    private int heuristicVals[][] = {{3, 4, 5, 5, 4, 3},{4,6,8,8,6,4},{5,8,11,11,8,5},{7,10,13,13,10,7},{5,8,11,11,8,5},{4,6,8,8,6,4}, {3, 4, 5, 5, 4, 3}};
            
    public void startAi(){
        
//        randomMove();
        startAlphaBetaMove();
    }
    
    private void startAlphaBetaMove(){
        field = VierGewinntAi.mainGameEngine.getPlayingField();
        processingField = VierGewinntAi.cloneArray((field));
        
        AlphaBetaTree a = new AlphaBetaTree(field, ALPHABETADEPTH, heuristicVals);
        
        int currentDepth = 0;
        
        
    }
    
    
    private int max(int currentDepth){
        

        return 13;
    }
    
    private int min(int currentDepth){
        
        return -13;
    }
    
    private void randomMove(){
        int i;
        Random r = new Random();
        while(!VierGewinntAi.mainGameEngine.checkMove((i = r.nextInt(7))));
        VierGewinntAi.mainGameEngine.tryMove(i);
        
    }
}
