/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drawing;

import javax.swing.SwingUtilities;
import maths.Vector2D;

/**
 *
 * @author IPsoft
 */
public class Drawing {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Runnable r = new Runnable() {
            @Override
            public void run() {
                MyWindow me = new MyWindow();
                me.setVisible(true);
            }
        };

        SwingUtilities.invokeLater(r);

        // TODO code application logic here
    }

}
