///*
// * To change this template, choose Tools | Templates
// * and open the template in the editor.
// */
//package viergewinntai;
//
//import java.awt.event.ActionEvent;
//import javax.swing.JButton;
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JOptionPane;
//
///**
// * The graphical user interface of the application
// *
// * @author rusinda
// */
//public class GUI extends JFrame {
//
//    JLabel PlayerTurnDisplay = new JLabel();
//    private JFrame window;
//    public Panel field;
//
//    /**
//     * Constuctor for the GIU-Class creation of the window
//     *
//     */
//    public void initialize() {
//
//
//
//
////Selection of Game-Mode
//        Object[] options = {"Spieler vs. Spieler", "Spieler vs. KI", "KI vs. Spieler", "KI vs. KI"};
//
//        int selected = JOptionPane.showOptionDialog(null,
//                "Bitte wählen sie einen Spielmodi",
//                "Vier Gewinnt",
//                JOptionPane.DEFAULT_OPTION,
//                JOptionPane.INFORMATION_MESSAGE,
//                null, options, options[0]);
//
//        //setting the game-mode
//        switch (selected) {
//            case 0: {
//                VierGewinntAi.mainGameEngine.setPlayerOneHuman(true);
//                VierGewinntAi.mainGameEngine.setPlayerTwoHuman(true);
//                break;
//            }
//            case 1: {
//                VierGewinntAi.mainGameEngine.setPlayerOneHuman(true);
//                VierGewinntAi.mainGameEngine.setPlayerTwoHuman(false);
//                break;
//            }
//            case 2: {
//                VierGewinntAi.mainGameEngine.setPlayerOneHuman(false);
//                VierGewinntAi.mainGameEngine.setPlayerTwoHuman(true);
//                break;
//            }
//            case 3: {
//                VierGewinntAi.mainGameEngine.setPlayerOneHuman(false);
//                VierGewinntAi.mainGameEngine.setPlayerTwoHuman(false);
//                break;
//
//            }
//
//        }
//
//        int xfield = 50;
//        int yfield = 150;
//        int xwidth = 444;
//        int ywidth = 378;
//
//
//        window = new JFrame("Vier Gewinnt");
//
//        // close operation
//        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//
//
//
//
//        // set framesize
//        window.setSize(600, 600);
//
//
//
//        // show frame
//        window.setVisible(true);
//        window.setLayout(null);
//
//        //panel for visualization
//        field = new Panel();
//        field.setBounds(xfield, yfield, xwidth, ywidth);
//        window.add(field);
//
//
////setting the buttons for the coloumns with function_calls
//        Button[] buttons = new Button[7];
//
//        for (int i = 0; i < 7; i++) {
//            buttons[i] = new Button(xfield + i * 60, yfield, 60, ywidth, (char) (i + 65));
//            window.add(buttons[i]);
//        }
//
//
//        PlayerTurnDisplay.setBounds(250, 50, 350, 80);
//
////        VierGewinntAi.mainGUI.showPlayerTurnMessage();
//
//        //initialization of the field
//        field.repaint();
//
//
//        window.add(PlayerTurnDisplay);
//
//        showPlayerTurnMessage();
//
//
//    }
//
//    /**
//     * Builds and displays the playing field
//     */
//    public void showField() {
//    }
//
//    /**
//     * Displays the move taken, will be called from the game engine after
//     * checking for a valid move
//     *
//     * @param column specifies the column
//     * @param row specifies the row
//     */
//    public void showMove() {
//
//        VierGewinntAi.mainGUI.field.repaint();
//
//    }
//
//    /**
//     * Shows which players turn it is, called from game engine
//     */
//    public void showPlayerTurnMessage() {
//
//
//
//        PlayerTurnDisplay.setText("Spieler " + Integer.toString(VierGewinntAi.mainGameEngine.playerTurn) + " ist am Zug");
//
//
//
//    }
//
//    /**
//     * Shows that the move taken by the player was invalid, called from game
//     * engine
//     */
//    public void showInvalidMoveMessage() {
//        JOptionPane.showMessageDialog(null, "Zug ungültig", "Fehler!", JOptionPane.ERROR_MESSAGE);
//
//
//    }
//
//    /**
//     * Shows a game over message with the winner
//     */
//    public void showWinMessage() {
//        JOptionPane.showMessageDialog(null, "Sie haben gewonnen!", "Glückwunsch!!", JOptionPane.INFORMATION_MESSAGE);
//
//    }
//
//    /**
//     * Empties the field, called from game engine
//     */
//    public void resetField() {
//
//        VierGewinntAi.mainGUI.field.repaint();
//
//    }
//
//    public void showFullMessage() {
//        JOptionPane.showMessageDialog(null, "Gleichstand!", "Gleichstand!", JOptionPane.INFORMATION_MESSAGE);
//    }
//
//    private class Button extends JButton {
//
//        public Button(int xfield, int yfield, int xwidth, int ywidth, final char column) {
//            this.setOpaque(false);
//            this.setContentAreaFilled(false);
//            this.setBorderPainted(false);
//            this.setBounds(xfield, yfield, xwidth, ywidth);
//            this.addActionListener(new java.awt.event.ActionListener() {
//                @Override
//                public void actionPerformed(ActionEvent evt) {
//
//                    VierGewinntAi.mainGameEngine.tryMove(column);
//
//                }
//            });
//        }
//    }
//}
