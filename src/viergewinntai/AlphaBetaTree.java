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



        for (int column1 = 0; column1 < 7; column1++) {
            int[][] processingField1 = VierGewinntAi.cloneArray((field));
            int row1 = 0;
            while (row1 < 5 && processingField1[column1][row1] != 0) {
                row1++;
            }
            data.add(new Node((heuristicVals[column1][row1])));

            processingField1[column1][row1] = 2;

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
