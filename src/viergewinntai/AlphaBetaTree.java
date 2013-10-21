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

    private Node data = new Node();
    private int playColumn;
    
    public int getMove(){
        return playColumn;
    }

    public AlphaBetaTree(int[][] field, int depth, int player) {

        recTree(field, depth, 1, data, player);

        recMinMax(data, depth - 1, player);
        
        int test = 0;

        // nun prüfen in welchem Kindknoten von Data data.value steht --> Spalte, die man spielen soll
        // for Schleife
        for(int i = 0; i<data.children.size(); i++){
            if(data.children.get(i).value == data.value){
                playColumn = i;
                break;
            }
        }

//        for (int column1 = 0; column1 < 7; column1++) {
//            int[][] processingField1 = VierGewinntAi.cloneArray((field));   
//            int row1 = 0;
//            while (row1 < 5 && processingField1[column1][row1] != 0) {
//                row1++;
//            }
//            data.add(new Node((heuristicVals[column1][row1])));
//
//            processingField1[column1][row1] = 2;    // mit Modulo2(der Tiefe)+1 für Spieler 1 oder 2
//
//            for (int column2 = 0; column2 < 7; column2++) {
//                int[][] processingField2 = VierGewinntAi.cloneArray((processingField1));
//                int row2 = 0;
//                while (row2 < 5 && processingField2[column2][row2] != 0) {
//                    row2++;
//                }
//                data.get(column1).addChild(new Node((heuristicVals[column2][row2])));
//
//                processingField2[column2][row2] = 1;
//
//
//                for (int column3 = 0; column3 < 7; column3++) {
//                    int[][] processingField3 = VierGewinntAi.cloneArray((processingField2));
//
//                    int row3 = 0;
//
//                    while (row3 < 5 && processingField3[column3][row3] != 0) {
//
//                        row3++;
//                    }
//                 
////                    System.out.println(column3 + " " + row3 + " " + processingField[column3][row3]);
//                    data.get(column1).children.get(column2).addChild(new Node((heuristicVals[column3][row3])));

//                }
//            }
//        }


    }

    public void recTree(int[][] processingField_above, int depth, int depth_current, Node currentNode, int player) {
        
        int[][] processingField_current;
        int nextPlayer = 0;

        // End-Kondition für Rekursion. Dann wird aktuelle Node mit ihrem Tiefenwert und Score bestückt
        if (depth == depth_current) {
            processingField_current = VierGewinntAi.cloneArray((processingField_above));

            //Hier evaluate aufrufen, um werte zu bekommen
            //keine neue Node nötig, weil vorher (vor Aufruf des nächsten RekursionsStep) ja schon erstellt
//                currentNode.children.add(new Node());
//                currentNode.children.getLast().nodeDepth = depth_current;
//                currentNode.children.getLast().value = ArtificialIntelligence.evaluate(processingField_current, player);
//                currentNode.children.add(new Node());
            currentNode.nodeDepth = depth_current;
// TO DO Player muss wechseln zw. Zügen --> Modulo
            currentNode.value = ArtificialIntelligence.evaluate(processingField_current, player);
        } // next depth-step
        else {

            // go through columns from left to right
            for (int column = 0; column < 7; column++) {
                // processingField zurückseten von vorigem Rekursionsschritt
                processingField_current = VierGewinntAi.cloneArray((processingField_above));

                // go through rows of the current column until a free space to set a new coin
                // in the end "row" represents the coin that was set
                int row = 0;
                while (row < 6 && processingField_current[column][row] != 0) {
                    row++;
                }

                //detect if the column is full and skip  
                if (row > 5) {
                    currentNode.addChild(new Node());
                    currentNode.children.getLast().empty = true;
                    continue;
                }

                // depending on current depth player 1 or player 2 is chosen
                // depth is odd (1,3,5,...) = current player
                // depth is even (2,4,6,...) = opponent

                int nextPiece;
                if (player == 2) {
                    nextPiece = depth_current % 2 + 1;
                } else {
//     Was wolltest du hiermit Dawid?^^
                    nextPiece = 2 - depth_current % 2;
                }
//            processingField_current[column][row] = depth_current % 2 +1;
                processingField_current[column][row] = nextPiece;
//                processingField_current[column][row] = player;
              
                // save current depth value to orientate in which tree depth it is
                currentNode.nodeDepth = depth_current;

                // new children for currentNode to operate the next recursion step
                currentNode.children.add(new Node());

//                if (player == 1){
//                    nextPlayer = 2;
//                } else{
//                    nextPlayer = 1;
//                }

                AlphaBetaTree.this.recTree(processingField_current, depth, depth_current + 1, currentNode.children.getLast(), player);
            }
        }

    }

    public void recMinMax(Node currentNode, int depth_lastParentNode, int player) {
        // depth_lpnode = depth of (l)ast (p)arent node

        // until last node with children (max_depth -1 means depth_lpnode = last parent node)
        if (currentNode.nodeDepth != depth_lastParentNode) {
            for (int i = 0; i < currentNode.children.size(); i++) {
                recMinMax(currentNode.children.get(i), depth_lastParentNode, player);
            }
        }
        
        if(currentNode.empty){
            return;
        }
        
        // now we are in right depth. currentNode has 7 children

        int minOrMax = currentNode.nodeDepth % 2;
        if (minOrMax == 1) {
            // odd depth value --> maximize
            currentNode.value = ArtificialIntelligence.max(currentNode.children);
        } else {
            // even depth value --> minimize
            currentNode.value = ArtificialIntelligence.min(currentNode.children);
        }


    }

    public class Node {

        public int value;
        public int nodeDepth;
        public boolean empty = false;
        public LinkedList<Node> children = new LinkedList<>();

        public void addChild(Node n) {
            children.add(n);
        }
    }
}
