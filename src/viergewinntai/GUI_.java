/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package viergewinntai;

import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;

/**
 *
 * @author rusinda
 */
public class GUI_ {
    
    JLabel field;
    JPanel mainPanel = new JPanel();
    JFrame mainFrame = new JFrame();
    private final int FRAMEWIDTH = 1200;
    private final int FRAMEHEIGHT = 700;
    private final int PLAYINGFIELDX = 50;
    private final int PLAYINGFIELDY = 100;
    private final int ROWBUTTONOFFSETX = 30;
    private final int ROWBUTTONWIDTH = 93;
    private final int ROWBUTTONHEIGHT = 525;
    private final boolean SHOWROWBUTTONS = false;
    
    public void initialize(){
        
        
        showField();
    }

    /**
     * Builds and displays the playing field
     */
    public void showField() {
        mainFrame.setSize(FRAMEWIDTH, FRAMEHEIGHT);
        BufferedImage myPicture = null;
        try {
            myPicture = ImageIO.read(new File("graphics\\playingfield.png"));
        } catch (IOException ex) {

        }
        field = new JLabel(new ImageIcon(myPicture));
        mainFrame.setLayout(null);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.add(mainPanel);
        mainPanel.setBounds(0, 0, FRAMEWIDTH, FRAMEHEIGHT);
        mainPanel.setLayout(null);
        mainPanel.add(field);
        field.setBounds(PLAYINGFIELDX,PLAYINGFIELDY,myPicture.getWidth(),myPicture.getHeight());
        field.setVisible(true);
        System.out.println(field.getLocation());
        
        RowButton[] buttons = new RowButton[7];

        for (int i = 0; i < 7; i++) {
            buttons[i] = new RowButton(PLAYINGFIELDX + ROWBUTTONOFFSETX + i * ROWBUTTONWIDTH, PLAYINGFIELDY, ROWBUTTONWIDTH, ROWBUTTONHEIGHT, (char) (i + 65));
            mainPanel.add(buttons[i]);
        }
        
        mainFrame.setVisible(true);
    }

    /**
     * Displays the move taken, will be called from the game engine after
     * checking for a valid move
     *
     * @param column specifies the column
     * @param row specifies the row
     */
    public void showMove(char column, int row) {
    }

    /**
     * Shows which players turn it is, called from game engine
     */
    public void showPlayerTurnMessage() {
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
    
    private class RowButton extends JButton {

        public RowButton(int xfield, int yfield, int xwidth, int ywidth, final char column) {
            this.setOpaque(SHOWROWBUTTONS);
            this.setContentAreaFilled(SHOWROWBUTTONS);
            this.setBorderPainted(SHOWROWBUTTONS);
            this.setBounds(xfield, yfield, xwidth, ywidth);
            this.addActionListener(new java.awt.event.ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {

//                    VierGewinntAi.mainGameEngine.tryMove(column);
                    JOptionPane.showMessageDialog(null,Character.toString(column));

                }
            });
        }
    }
}
