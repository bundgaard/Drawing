/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drawing;

import java.awt.BorderLayout;
import javax.swing.JFrame;

/**
 *
 * @author IPsoft
 */
public class MyWindow extends JFrame {
    
    public MyWindow() {
        super("MyWindow");
        setSize(640,480);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        init();
    }
    
    private void init() {
        setLayout(new BorderLayout());
        add(new DrawPanel(), BorderLayout.CENTER);
    }
    
}
