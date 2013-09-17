/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package viergewinntai;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JComponent;
import javax.swing.JOptionPane;

/**
 *
 * @author Stefan
 */
public class Panel extends JComponent {

    @Override
    protected void paintComponent(Graphics g) {



        g.setColor(Color.blue);
        g.fillRect(0, 0, 420, 360);
        g.setColor(Color.black);
        g.fillRect(0, 0, 3, 360);
        for (int i = 0; i < 8; i++) {
            g.fillRect(i * 60, 0, 3, 360);
        }
        for (int i = 0; i < 6; i++) {
            g.fillRect(0, 60 + i * 60, 423, 3);
        }




        for (int i = 0; i < 7; i++) {
            for (int y = 0; y < 6; y++) {
                if (VierGewinntAi.mainGameEngine.playingField[i][5 - y] == 0) {
                    g.setColor(Color.black);

                } else if (VierGewinntAi.mainGameEngine.playingField[i][5 - y] == 1) {
                    g.setColor(Color.yellow);

                } else if (VierGewinntAi.mainGameEngine.playingField[i][5 - y] == 2) {
                    g.setColor(Color.red);
                }
                g.fillOval(i * 60 + 4, y * 60 + 4, 55, 55);

            }


        }



    }
}
