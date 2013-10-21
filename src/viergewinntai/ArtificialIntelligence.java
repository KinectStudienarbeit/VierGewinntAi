/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package viergewinntai;

import com.sun.media.sound.AlawCodec;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author rusinda
 */
public class ArtificialIntelligence {
    
    private static int counter = 0;
    public final int THIS_PLAYER;
    private final int ALPHABETADEPTH = 4;
    private int[][] field;
    private int[][] processingField;
//    private int heuristicVals[][] = {{3, 4, 5, 5, 4, 3}, {4, 6, 8, 8, 6, 4}, {5, 8, 11, 11, 8, 5}, {7, 10, 13, 13, 10, 7}, {5, 8, 11, 11, 8, 5}, {4, 6, 8, 8, 6, 4}, {3, 4, 5, 5, 4, 3}};
    
    public ArtificialIntelligence(int thisPlayer){
        this.THIS_PLAYER = thisPlayer;        
    }

    public void startAi() {

//        randomMove();
        startAlphaBetaMove();
    }

    private void startAlphaBetaMove() {
        field = VierGewinntAi.mainGameEngine.getPlayingField();
        processingField = VierGewinntAi.cloneArray((field));

        AlphaBetaTree alphaBetaTree = new AlphaBetaTree(field, ALPHABETADEPTH, THIS_PLAYER);
        VierGewinntAi.mainGameEngine.tryMove(alphaBetaTree.getMove());




    }

    public static int max(LinkedList<AlphaBetaTree.Node> nodes) {
        int returnVal = nodes.getFirst().value;
        // nodes muss die 7 (Kind)Knoten enthalten, dessen Max/Min Wert gefunden werden muss
        for (int i = 0; i < nodes.size(); i++) {
            if (!nodes.get(i).empty && nodes.get(i).value > returnVal) {
                returnVal = nodes.get(i).value;
            }
        }

        if(returnVal == Integer.MAX_VALUE){
            int test = 0;
        }
        return returnVal;
    }

    public static int min(LinkedList<AlphaBetaTree.Node> nodes) {
        int returnVal = nodes.getFirst().value;

        for (int i = 0; i < nodes.size(); i++) {
            if (!nodes.get(i).empty && nodes.get(i).value < returnVal) {
                returnVal = nodes.get(i).value;
            }
        }

        return returnVal;
    }

    private void randomMove() {
        int i;
        Random r = new Random();
        while (!VierGewinntAi.mainGameEngine.checkMove((i = r.nextInt(7))));
        VierGewinntAi.mainGameEngine.tryMove(i);

    }

    public static int evaluate(int[][] field, int player) {

        int[][] evals = {{0, 0}, {0, 0}, {0, 0}, {0, 0}};

        for (int column = 0; column < 7; column++) {
            for (int row = 0; row < 6; row++) {
                if (field[column][row] == 0) {
                    break;
                }
                
                /*
                 * ###########################################
                 * ########## all the "usual cases" ##########
                 * ###########################################
                 */

                for (int i = 0; i < 4; i++) {
                    if (evalHelp(field, column, row, i + 1, Mode.LEFT)) {
                        evals[i][field[column][row] - 1]++;
//                        System.out.println(column + " " + row + " " + (i + 1) + "o4 left");
                    }
                    if (evalHelp(field, column, row, i + 1, Mode.LEFT_UP)) {
                        evals[i][field[column][row] - 1]++;
//                        System.out.println(column + " " + row + " " + (i + 1) + "o4 leftup");
                    }
                    if (evalHelp(field, column, row, i + 1, Mode.UP)) {
                        evals[i][field[column][row] - 1]++;
//                        System.out.println(column + " " + row + " " + (i + 1) + "o4 up");
                    }
                    if (evalHelp(field, column, row, i + 1, Mode.RIGHT_UP)) {
                        evals[i][field[column][row] - 1]++;
//                        System.out.println(column + " " + row + " " + (i + 1) + "o4 rightup");
                    }
                    if (evalHelp(field, column, row, i + 1, Mode.RIGHT)) {
                        evals[i][field[column][row] - 1]++;
//                        System.out.println(column + " " + row + " " + (i + 1) + "o4 right");
                    }
                    if (evalHelp(field, column, row, i + 1, Mode.LEFT_DOWN)) {
                        evals[i][field[column][row] - 1]++;
//                        System.out.println(column + " " + row + " " + (i + 1) + "o4 leftdown");
                    }
                    if (evalHelp(field, column, row, i + 1, Mode.RIGHT_DOWN)) {
                        evals[i][field[column][row] - 1]++;
//                        System.out.println(column + " " + row + " " + (i + 1) + "o4 rightdown");
                    }
                }

                /*
                 * #################################
                 * ####### 'Special cases' #########
                 * #################################
                 */
                
                //00x0
                if (column > 1 && column < 6) {
                    if (field[column - 2][row] == 0 && field[column - 1][row] == 0 && field[column + 1][row] == 0) {
                        evals[0][field[column][row] - 1]++;
//                        System.out.println(column + " " + row + " 1o4 00x0");
                    }
                }
                //0x00
                if (column > 0 && column < 5) {
                    if (field[column - 1][row] == 0 && field[column + 1][row] == 0 && field[column + 2][row] == 0) {
                        evals[0][field[column][row] - 1]++;
//                        System.out.println(column + " " + row + " 1o4 0x00");
                    }
                }
                //00x0 diagonal left up
                if (column > 1 && column < 6 && row > 0 && row < 4) {
                    if (field[column - 2][row + 2] == 0 && field[column - 1][row + 1] == 0 && field[column + 1][row - 1] == 0) {
                        evals[0][field[column][row] - 1]++;
//                        System.out.println(column + " " + row + " 1o4 00x0 diagleftup");
                    }
                }
                //0x00 diagonal left up
                if (column > 0 && column < 5 && row > 1 && row < 5) {
                    if (field[column - 1][row + 1] == 0 && field[column + 1][row - 1] == 0 && field[column + 2][row - 2] == 0) {
                        evals[0][field[column][row] - 1]++;
//                        System.out.println(column + " " + row + " 1o4 0x00diagleftup");
                    }
                }
                //00x0 diagonal right up
                if (column > 1 && column < 6 && row > 1 && row < 5) {
                    if (field[column - 2][row - 2] == 0 && field[column - 1][row - 1] == 0 && field[column + 1][row + 1] == 0) {
                        evals[0][field[column][row] - 1]++;
//                        System.out.println(column + " " + row + " 1o4 00x0diagrightup");
                    }
                }
                
                //0x00 diagonal right up
                if (column > 0 && column < 5 && row > 0 && row < 4) {
                    if (field[column - 1][row - 1] == 0 && field[column + 1][row + 1] == 0 && field[column + 2][row + 2] == 0) {
                        evals[0][field[column][row] - 1]++;
//                        System.out.println(column + " " + row + " 1o4 0x00diagrightup");
                    }
                }
                
                //0xx0
                if (column > 0 && column < 5) {
                    if (field[column + 1][row] == field[column][row] && field[column - 1][row] == 0 && field[column + 2][row] == 0) {
                        evals[1][field[column][row] - 1]++;
//                        System.out.println(column + " " + row + " 2o4 0xx0");
                    }
                }

                //0xx0 diagonal left up
                try{
                if (column > 1 && column < 5 && row > 1 && row < 4) {
                    if (field[column - 1][row + 1] == field[column][row] && field[column - 2][row + 2] == 0 && field[column + 1][row - 1] == 0) {
                        evals[1][field[column][row] - 1]++;
//                        System.out.println(column + " " + row + " 2o4 0xx0 diagonalleftup");
                    }
                }
                } catch (Exception e){
                    e.printStackTrace();
                    int ab = 0;
                }
                //0xx0 diagonal right up
                try{
                if (column > 0 && column < 5 && row > 0 && row < 4) {
                    if (field[column + 1][row + 1] == field[column][row] && field[column + 2][row + 2] == 0 && field[column - 1][row - 1] == 0) {
                        evals[1][field[column][row] - 1]++;
//                        System.out.println(column + " " + row + " 2o4 0xx0 diagonalrightup");
                    }
                }
                } catch(Exception e){
                    e.printStackTrace();
                    int abc = 0;
                }
            }
        }

        for (int i = 0; i < 4; i++) {
//            System.out.println(Arrays.toString(evals[i]));

        }
        int left;
        int right;
        if (player == 1){
            left = 0;
            right = 1;
        } else {
            left = 1;
            right = 0;
        }
        
        if(evals[3][left] > 0){
            return Integer.MAX_VALUE;
        }
        if(evals[3][right] > 0){
            return Integer.MIN_VALUE;
        }
        
        int returnVal = evals[0][left] + evals[1][left] * 10 + evals[2][left] * 100 - evals[0][right] - evals[1][right] * 10 - evals[2][right] * 100;
//        System.out.println("Field score for player " + player + ": " + returnVal);
        
//        counter++;
//        System.out.println(counter);
        
//        for(int i = 5; i >=0; i--){
//            for(int j = 0; j<7 ; j++){
//                System.out.print(field[j][i]);
//            }
//            System.out.println("");
//        }
//        System.out.println(returnVal);
        
        return returnVal;
    }

    private static boolean evalHelp(int[][] field, int column, int row, int outOfFour, Mode mode) {

        int columnMod = 0;
        int rowMod = 0;
        boolean shorten = false;
        int leftBorder = 0;
        int rightBorder = 0;
        int lowBorder = 0;
        int upBorder = 0;

        switch (mode) {
            case LEFT:
                columnMod = -1;
                rowMod = 0;
                leftBorder = 3;
                rightBorder = 6;
                upBorder = 5;
                lowBorder = 0;
                break;
            case LEFT_UP:
                columnMod = -1;
                rowMod = +1;
                leftBorder = 3;
                rightBorder = 6;
                upBorder = 2;
                lowBorder = 0;
                break;
            case UP:
                columnMod = 0;
                rowMod = +1;
                leftBorder = 0;
                rightBorder = 6;
                upBorder = 2;
                lowBorder = 0;
                break;
            case RIGHT_UP:
                columnMod = +1;
                rowMod = +1;
                leftBorder = 0;
                rightBorder = 3;
                upBorder = 2;
                lowBorder = 0;
                break;
            case RIGHT:
                columnMod = +1;
                rowMod = 0;
                leftBorder = 0;
                rightBorder = 3;
                upBorder = 5;
                lowBorder = 0;
                shorten = true;
                break;
            case LEFT_DOWN:
                columnMod = -1;
                rowMod = -1;
                leftBorder = 3;
                rightBorder = 6;
                upBorder = 5;
                lowBorder = 3;
                shorten = true;
                break;
            case RIGHT_DOWN:
                columnMod = +1;
                rowMod = -1;
                leftBorder = 0;
                rightBorder = 3;
                upBorder = 5;
                lowBorder = 3;
                shorten = true;
                break;
        }

        int currColumn = column + columnMod;
        int currRow = row + rowMod;

        
        if (column >= leftBorder && column <= rightBorder && row >= lowBorder && row <= upBorder) {
            int i = 0;
            int addPiece = 0;
            int maxI = 4;
            if (outOfFour == 1) {
                maxI--;
            }
            while (i <= maxI - outOfFour && addPiece < outOfFour && Math.abs(column - currColumn) < 4 && Math.abs(row - currRow) < 4) {
                if (field[currColumn][currRow] == 0) {
                    i++;
                    currColumn += columnMod;
                    currRow += rowMod;

                } else {
                    if (field[currColumn][currRow] == field[column][row] && !(shorten && (Math.abs(column - currColumn) == 3 || Math.abs(row - currRow) == 3))) {
                        addPiece++;
                        currColumn += columnMod;
                        currRow += rowMod;
                    } else {
                        break;
                    }
                }
            }
            if (addPiece + 1 == outOfFour && i + outOfFour == 4) {
                return true;
            }
        }
          
        return false;

    }

    private enum Mode {

        LEFT, LEFT_UP, UP, RIGHT_UP, RIGHT, RIGHT_DOWN, LEFT_DOWN
    }
}
