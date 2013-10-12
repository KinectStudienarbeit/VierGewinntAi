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
    public static ArtificialIntelligence[] AI = {new ArtificialIntelligence(1), new ArtificialIntelligence(2)};

    public static int[][] cloneArray(int[][] toClone) {

        int[][] myInt = new int[toClone.length][];
        for (int i = 0; i < toClone.length; i++) {
            int[] aMatrix = toClone[i];
            int aLength = aMatrix.length;
            myInt[i] = new int[aLength];
            System.arraycopy(aMatrix, 0, myInt[i], 0, aLength);
        }

        return myInt;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        mainGUI.initialize();

        mainGameEngine.initialize();


//        mainGUI.showMove(1, 1, 1);
//        mainGUI.showMove(2, 2, 2);
//        mainGUI.showMove(1, 3, 3);
//        mainGUI.showMove(2, 4, 4);
//        mainGUI.showMove(1, 5, 5);
//        mainGUI.showMove(2, 6, 6);
//        mainGUI.showMove(1, 7, 1);
    }
}
