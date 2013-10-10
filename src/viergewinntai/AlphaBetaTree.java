package viergewinntai;

import java.util.LinkedList;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author rusinda
 */
public class AlphaBetaTree {

    private LinkedList<Node> data = new LinkedList<>();

    public AlphaBetaTree(int[][] field, int depth, int[][] heuristicVals) {

        recTree(field, depth, 1, heuristicVals);

        for (int column1 = 0; column1 < 7; column1++) {
            int[][] processingField1 = VierGewinntAi.cloneArray((field));   
            int row1 = 0;
            while (row1 < 5 && processingField1[column1][row1] != 0) {
                row1++;
            }
            data.add(new Node((heuristicVals[column1][row1])));

            processingField1[column1][row1] = 2;    // mit Modulo2(der Tiefe)+1 für Spieler 1 oder 2

            for (int column2 = 0; column2 < 7; column2++) {
                int[][] processingField2 = VierGewinntAi.cloneArray((processingField1));
                int row2 = 0;
                while (row2 < 5 && processingField2[column2][row2] != 0) {
                    row2++;
                }
                data.get(column1).addChild(new Node((heuristicVals[column2][row2])));

                processingField2[column2][row2] = 1;


                for (int column3 = 0; column3 < 7; column3++) {
                    int[][] processingField3 = VierGewinntAi.cloneArray((processingField2));

                    int row3 = 0;

                    while (row3 < 5 && processingField3[column3][row3] != 0) {

                        row3++;
                    }
//                    System.out.println(column3 + " " + row3 + " " + processingField[column3][row3]);
                    data.get(column1).children.get(column2).addChild(new Node((heuristicVals[column3][row3])));


                    int test__ = 0;
                }
                int test_ = 0;
            }
        }



        int test = 0;


    }
    
    public void recTree(int[][] processingField_above, int depth, int depth_current, int[][] heurVals){
        // go through columns from left to right
        for (int column = 0; column < 7; column++) {
            int[][] processingField_current = VierGewinntAi.cloneArray((processingField_above));   
                        
            // go through rows of the current column until a free space to set a new coin
            // in the end "row" represents the coin that was set
            int row = 0;
            while (row < 5 && processingField_current[column][row] != 0) {
                row++;
            }
                
            // depending on current depth player 1 or player 2 is chosen
            // depth is odd (1,3,5,...) = player 2
            // depth is even (2,4,6,...) = player 1
            processingField_current[column][row] = depth_current % 2 +1;
            
            // only in final depth:
            // Evaluation of processingField_current so that heurVals will be filled
            if (depth == depth_current){
                depth_current=1;
                data.add(new Node((heurVals[column][row])));
            }
            // next depth-step
            else{
                depth_current++;
                recTree(processingField_current, depth, depth_current, heurVals);
            }
        }
        
    }

    private class Node {

        public int value;
        public LinkedList<Node> children = new LinkedList<>();

        public Node(int value) {
            this.value = value;
        }

        public void addChild(Node n) {
            children.add(n);
        }
    }
}
