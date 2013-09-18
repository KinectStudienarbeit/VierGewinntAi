/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package viergewinntai;

import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 * The graphical user interface of the application
 *
 * @author rusinda
 */
public class GUI extends JFrame {

    JLabel PlayerTurnDisplay = new JLabel();
    private JFrame window;
    public Panel field;

    /**
     * Constuctor for the GIU-Class creation of the window
     *
     */
    public void initialize() {




//Selection of Game-Mode
        Object[] options = {"Spieler vs. Spieler", "Spieler vs. KI", "KI vs. Spieler", "KI vs. KI"};

        int selected = JOptionPane.showOptionDialog(null,
                "Bitte wählen sie einen Spielmodi",
                "Vier Gewinnt",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null, options, options[0]);

        //setting the game-mode
        switch (selected) {
            case 0: {
                VierGewinntAi.mainGameEngine.playerOneHuman = true;
                VierGewinntAi.mainGameEngine.playerTwoHuman = true;
                break;
            }
            case 1: {
                VierGewinntAi.mainGameEngine.playerOneHuman = true;
                VierGewinntAi.mainGameEngine.playerTwoHuman = false;
                break;
            }
            case 2: {
                VierGewinntAi.mainGameEngine.playerOneHuman = false;
                VierGewinntAi.mainGameEngine.playerTwoHuman = true;
                break;
            }
            case 3: {
                VierGewinntAi.mainGameEngine.playerOneHuman = false;
                VierGewinntAi.mainGameEngine.playerTwoHuman = false;
                break;

            }

        }







        int xfield = 50;
        int yfield = 150;
        int xwidth = 444;
        int ywidth = 378;


        window = new JFrame("Vier Gewinnt");

        // close operation
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);





        // set framesize
        window.setSize(600, 600);



        // show frame
        window.setVisible(true);
        window.setLayout(null);

        //panel for visualization
        field = new Panel();
        field.setBounds(xfield, yfield, xwidth, ywidth);
        window.add(field);


//setting the buttons for the coloumns with function_calls
        Button[] buttons = new Button[7];
        
        for(int i = 0; i < 7; i++){
            buttons[i] = new Button(xfield + i*60, yfield, 60, ywidth, (char)(i+65));
            window.add(buttons[i]);
        }
                
//        JButton one = new JButton();
//        one.setOpaque(false);
//        one.setContentAreaFilled(false);
//        one.setBorderPainted(false);
//        one.setBounds(xfield, yfield, 63, ywidth);
//        one.addActionListener(new java.awt.event.ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent evt) {
//                System.out.println("one");
//                VierGewinntAi.mainGameEngine.tryMove('a');
//
//            }
//        });
//
//        JButton two = new JButton();
//        two.setOpaque(false);
//        two.setContentAreaFilled(false);
//        two.setBorderPainted(false);
//        two.setBounds(xfield + 63, yfield, 60, ywidth);
//        two.addActionListener(new java.awt.event.ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent evt) {
//                System.out.println("two");
//                //aufruf der tryturnfunktion
//                VierGewinntAi.mainGameEngine.tryMove('b');
//
//            }
//        });
//
//        JButton three = new JButton();
//        three.setOpaque(false);
//        three.setContentAreaFilled(false);
//        three.setBorderPainted(false);
//        three.setBounds(xfield + 2 * 60, yfield, 63, ywidth);
//        three.addActionListener(new java.awt.event.ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent evt) {
//                System.out.println("three");
//                //aufruf der tryturnfunktion
//                VierGewinntAi.mainGameEngine.tryMove('c');
//
//            }
//        });
//
//        JButton four = new JButton();
//        four.setOpaque(false);
//        four.setContentAreaFilled(false);
//        four.setBorderPainted(false);
//        four.setBounds(xfield + 3 * 60, yfield, 63, ywidth);
//        four.addActionListener(new java.awt.event.ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent evt) {
//                System.out.println("four");
//                //aufruf der tryturnfunktion
//                VierGewinntAi.mainGameEngine.tryMove('d');
//
//            }
//        });
//
//        JButton five = new JButton();
//        five.setOpaque(false);
//        five.setContentAreaFilled(false);
//        five.setBorderPainted(false);
//        five.setBounds(xfield + 4 * 60, yfield, 63, ywidth);
//        five.addActionListener(new java.awt.event.ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent evt) {
//                System.out.println("five");
//                //aufruf der tryturnfunktion
//                VierGewinntAi.mainGameEngine.tryMove('e');
//
//            }
//        });
//
//        JButton six = new JButton();
//        six.setOpaque(false);
//        six.setContentAreaFilled(false);
//        six.setBorderPainted(false);
//        six.setBounds(xfield + 5 * 60, yfield, 63, ywidth);
//        six.addActionListener(new java.awt.event.ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent evt) {
//                System.out.println("six");
//                //aufruf der tryturnfunktion
//                VierGewinntAi.mainGameEngine.tryMove('f');
//
//            }
//        });
//
//        JButton seven = new JButton();
//        seven.setOpaque(false);
//        seven.setContentAreaFilled(false);
//        seven.setBorderPainted(false);
//        seven.setBounds(xfield + 6 * 60, yfield, 63, ywidth);
//        seven.addActionListener(new java.awt.event.ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent evt) {
//                System.out.println("seven");
//                //aufruf der tryturnfunktion
//                VierGewinntAi.mainGameEngine.tryMove('g');
//
//            }
//        });



        PlayerTurnDisplay.setBounds(250, 50, 350, 80);

//        VierGewinntAi.mainGUI.showPlayerTurnMessage();

        //initialization of the field
        field.repaint();

        // adding all components
//        window.add(one);
//        window.add(two);
//        window.add(three);
//        window.add(four);
//        window.add(five);
//        window.add(six);
//        window.add(seven);
        window.add(PlayerTurnDisplay);

        showPlayerTurnMessage();


    }

    /**
     * Builds and displays the playing field
     */
    public void showField() {
    }

    /**
     * Displays the move taken, will be called from the game engine after
     * checking for a valid move
     *
     * @param column specifies the column
     * @param row specifies the row
     */
    public void showMove() {
        VierGewinntAi.mainGUI.field.repaint();
    }

    /**
     * Shows which players turn it is, called from game engine
     */
    public void showPlayerTurnMessage() {



        PlayerTurnDisplay.setText("Spieler " + Integer.toString(VierGewinntAi.mainGameEngine.playerTurn) + " ist am Zug");



    }

    /**
     * Shows that the move taken by the player was invalid, called from game
     * engine
     */
    public void showInvalidMoveMessage() {
        JOptionPane.showMessageDialog(null, "Zug ungültig", "Fehler!", JOptionPane.ERROR_MESSAGE);


    }

    /**
     * Shows a game over message with the winner
     */
    public void showWinMessage() {
        JOptionPane.showMessageDialog(null, "Sie haben gewonnen!", "Glückwunsch!!", JOptionPane.INFORMATION_MESSAGE);

    }

    /**
     * Empties the field, called from game engine
     */
    public void resetField() {

        VierGewinntAi.mainGUI.field.repaint();

    }

    public void showFullMessage() {
        JOptionPane.showMessageDialog(null, "Gleichstand!", "Gleichstand!", JOptionPane.INFORMATION_MESSAGE);
    }

    private class Button extends JButton {

        public Button(int xfield, int yfield, int xwidth, int ywidth, final char column) {
            this.setOpaque(false);
            this.setContentAreaFilled(false);
            this.setBorderPainted(false);
            this.setBounds(xfield, yfield, xwidth, ywidth);
            this.addActionListener(new java.awt.event.ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {

                    VierGewinntAi.mainGameEngine.tryMove(column);

                }
            });
        }
    }
}
