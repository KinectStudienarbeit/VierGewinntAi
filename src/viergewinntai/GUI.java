/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package viergewinntai;

import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * The graphical user interface of the application
 *
 * @author rusinda
 */
public class GUI extends JFrame {

     JLabel PlayerTurnDisplay = new JLabel(); 
    
    
    /**
     * Constuctor for the GIU-Class creation of the window
     *
     */
    public GUI() {
        // als fenster-titel gleich mit übergeben)

        int xfield = 50;
        int yfield = 150;
        int xwidth = 444;
        int ywidth = 378;


        JFrame fenster = new JFrame("Vier Gewinnt");

        // close operation
        fenster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

       

       

        // set framesize
        fenster.setSize(600, 600);



        // show frame
        fenster.setVisible(true);
        fenster.setLayout(null);
        
        //panel for visualization
        Panel field = new Panel();
        field.setBounds(xfield, yfield, xwidth, ywidth);
        fenster.add(field);
        
        
        
        JButton eins = new JButton();
        eins.setOpaque(false);
        eins.setContentAreaFilled(false);
        eins.setBorderPainted(false);
        eins.setBounds(xfield, yfield, 63, ywidth);
        eins.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                System.out.println("eins");
                //aufruf der tryturnfunktion
                
            }
        });
        
        JButton zwei = new JButton();
        zwei.setOpaque(false);
        zwei.setContentAreaFilled(false);
        zwei.setBorderPainted(false);
        zwei.setBounds(xfield+63, yfield, 60, ywidth);
        zwei.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                System.out.println("zwei");
                //aufruf der tryturnfunktion
                
            }
        });

        JButton drei = new JButton();
        drei.setOpaque(false);
        drei.setContentAreaFilled(false);
        drei.setBorderPainted(false);
        drei.setBounds(xfield+2*60, yfield, 63, ywidth);
        drei.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                System.out.println("drei");
                //aufruf der tryturnfunktion
                
            }
        });

        JButton vier = new JButton();
        vier.setOpaque(false);
        vier.setContentAreaFilled(false);
        vier.setBorderPainted(false);
        vier.setBounds(xfield+3*60, yfield, 63, ywidth);
        vier.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                System.out.println("vier");
                //aufruf der tryturnfunktion
                
            }
        });
        
        JButton fünf = new JButton();
        fünf.setOpaque(false);
        fünf.setContentAreaFilled(false);
        fünf.setBorderPainted(false);
        fünf.setBounds(xfield+4*60, yfield, 63, ywidth);
        fünf.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                System.out.println("fünf");
                //aufruf der tryturnfunktion
                
            }
        });
        
         JButton sechs = new JButton();
        sechs.setOpaque(false);
        sechs.setContentAreaFilled(false);
        sechs.setBorderPainted(false);
        sechs.setBounds(xfield+5*60, yfield, 63, ywidth);
        sechs.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                System.out.println("sechs");
                //aufruf der tryturnfunktion
                
            }
        });
        
        JButton sieben = new JButton();
        sieben.setOpaque(false);
        sieben.setContentAreaFilled(false);
        sieben.setBorderPainted(false);
        sieben.setBounds(xfield+6*60, yfield, 63, ywidth);
        sieben.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                System.out.println("sieben");
                //aufruf der tryturnfunktion
                
            }
        });
        
        
       
        PlayerTurnDisplay.setBounds(250, 50, 350, 80);
        
        
        field.repaint();
        fenster.add(eins);
        fenster.add(zwei); 
        fenster.add(drei); 
        fenster.add(vier); 
        fenster.add(fünf); 
        fenster.add(sechs); 
        fenster.add(sieben); 




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
    public void showMove(char column, byte row) {
    }

    /**
     * Shows which players turn it is, called from game engine
     */
    public void showPlayerTurnMessage() {
        
        
       
       PlayerTurnDisplay.setText(null);
        
        
        
    }

    /**
     * Shows that the move taken by the player was invalid, called from game
     * engine
     */
    public void showInvalidMoveMessage() {
    }

    /**
     * Shows a game over message with the winner
     */
    public void showWinMessage() {
    }

    /**
     * Empties the field, called from game engine
     */
    public void resetField() {
    }
}
