/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package viergewinntai;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import javax.imageio.ImageIO;
import javax.swing.*;

/**
 *
 * @author rusinda
 */
public class GUI {

    private final int FRAMEWIDTH = 1200;
    private final int FRAMEHEIGHT = 700;
    private final int PLAYINGFIELDX = 50;
    private final int PLAYINGFIELDY = 100;
    private final int ROWBUTTONOFFSETX = 30;
    private final int ROWBUTTONWIDTH = 93;
    private final int ROWBUTTONHEIGHT = 525;
    private final boolean SHOWROWBUTTONS = false;
    private final String PLAYERONEPIC = "graphics\\playerone.png";
    private final String PLAYERTWOPIC = "graphics\\playertwo.png";
    private final String PLAYINGFIELDPIC = "graphics\\playingfield.png";
    private final int PIECEOFFSETXLEFT = 6;
    private final int PIECEOFFSETXBETWEEN = 7;
    private final int PIECEOFFSETYUP = 16;
    private final int ANIMATIONYOFFSET = 20;
    private final int ANIMATIONSPEED = 1;
    private JLabel field;
    private JPanel mainPanel = new JPanel();
    private JFrame mainFrame = new JFrame();
    private BufferedImage playerOnePic;
    private BufferedImage playerTwoPic;
    private LinkedList<JLabel> pieces = new LinkedList();

    public void initialize() {

        VierGewinntAi.mainGameEngine.setPlayerOneHuman(true);
        VierGewinntAi.mainGameEngine.setPlayerTwoHuman(false);

        showField();
    }

    /**
     * Builds and displays the playing field
     */
    public void showField() {
        mainFrame.setSize(FRAMEWIDTH, FRAMEHEIGHT);
        BufferedImage myPicture = null;
        try {
            myPicture = ImageIO.read(new File(PLAYINGFIELDPIC));
        } catch (IOException ex) {
        }
        field = new JLabel(new ImageIcon(myPicture));
        mainFrame.setLayout(null);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.add(mainPanel);
        mainPanel.setBounds(0, 0, FRAMEWIDTH, FRAMEHEIGHT);
        mainPanel.setLayout(null);
        mainPanel.add(field);
        field.setBounds(PLAYINGFIELDX, PLAYINGFIELDY, myPicture.getWidth(), myPicture.getHeight());
        field.setVisible(true);
//        System.out.println(field.getLocation());

        RowButton[] buttons = new RowButton[7];

        for (int i = 0; i < 7; i++) {
            buttons[i] = new RowButton(PLAYINGFIELDX + ROWBUTTONOFFSETX + i * ROWBUTTONWIDTH, PLAYINGFIELDY, ROWBUTTONWIDTH, ROWBUTTONHEIGHT, (char) (i + 65));
            mainPanel.add(buttons[i]);
        }

        mainFrame.setVisible(true);
        try {
            playerOnePic = ImageIO.read(new File(PLAYERONEPIC));
            playerTwoPic = ImageIO.read(new File(PLAYERTWOPIC));
        } catch (IOException ex) {
        }
    }

    /**
     * Displays the move taken, will be called from the game engine after
     * checking for a valid move
     *
     * @param column specifies the column
     * @param row specifies the row
     */
    public void showMove(int player, int column, int row) {
        if (player > 1) {
            pieces.add(new JLabel(new ImageIcon(playerTwoPic)));
        } else {
            pieces.add(new JLabel(new ImageIcon(playerOnePic)));
        }

        mainPanel.add(pieces.getLast());
        animate(pieces.getLast(), PLAYINGFIELDX + ROWBUTTONOFFSETX + PIECEOFFSETXLEFT + ((PIECEOFFSETXBETWEEN + playerOnePic.getHeight()) * (column - 1)), PLAYINGFIELDY + PIECEOFFSETYUP + ((6 - row) * playerOnePic.getHeight()), playerOnePic.getHeight(), playerOnePic.getWidth(), column -1, row -1);
        //pieces.getLast().setBounds(PLAYINGFIELDX + ROWBUTTONOFFSETX + PIECEOFFSETXLEFT + ((PIECEOFFSETXBETWEEN + playerOnePic.getHeight()) * (column-1)), PLAYINGFIELDY + PIECEOFFSETYUP + ((6 - row) * playerOnePic.getHeight()), playerOnePic.getHeight(), playerOnePic.getWidth());
    }

    private void animate(final JLabel piece, int x, final int lastY, int width, int height, final int column, final int row) {

        piece.setBounds(x, ANIMATIONYOFFSET, width, height);
        
        javax.swing.Timer t = new javax.swing.Timer(1, new ActionListener() {
            
            int counter = ANIMATIONYOFFSET;

            @Override
            public void actionPerformed(ActionEvent e) {
                
                counter +=ANIMATIONSPEED;
                piece.setBounds(piece.getX(), counter, piece.getWidth(), piece.getHeight());
                mainPanel.repaint();
                if(counter >= lastY + ANIMATIONSPEED){
                    piece.setBounds(piece.getX(), lastY, piece.getWidth(), piece.getHeight());
                    ((Timer)e.getSource()).stop();
                    VierGewinntAi.mainGameEngine.endMove(column, row);
                }
            }
        });
        t.start();

    }

    public void showFullMessage() {
        JOptionPane.showMessageDialog(null, "Gleichstand!", "Gleichstand!", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Shows which players turn it is, called from game engine
     */
    public void showPlayerTurnMessage() {
//        PlayerTurnDisplay.setText("Spieler " + Integer.toString(VierGewinntAi.mainGameEngine.playerTurn) + " ist am Zug");
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

                    if(!GameEngine.lock) {
                        GameEngine.lock = true;
                        VierGewinntAi.mainGameEngine.tryMove(column);
                    }
//                    JOptionPane.showMessageDialog(null, Character.toString(column));

                }
            });
        }
    }
}
