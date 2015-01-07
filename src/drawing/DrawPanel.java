/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drawing;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author IPsoft
 */
class DrawPanel extends JPanel implements Runnable {
    
    private final ArrayList<IShape> objects = new ArrayList<>(); 

    public DrawPanel() {
        
        init();
    }
    
    private void init() {
        Ball b = new Ball();
        objects.add(b);
        
        Thread t = new Thread(this);
        t.start();
    }

    @Override
    public void run() {
        while(true) {
            try{
                for(IShape s : objects) {
                    s.update();
                    s.checkEdge();
                    repaint();
                    Thread.sleep(25);
                }
            }catch(InterruptedException ie){
                System.err.println(ie.getMessage());
            }
        }

    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.clearRect(0, 0, 640, 480);
        for ( IShape shape : objects){
            shape.display(g);
        }

        //drawCircle(g2, 320, 240, 500);
        drawCantor(g2, 20,20,500);
    }

    private void cantorLine(Graphics2D g2, int x, int y, int length) {
        if (length >= 1) {
            g2.drawLine(x, y, x + length, y);

            y += 20;

            cantorLine(g2, x, y, length / 3);
            cantorLine(g2, x + length * 2 / 3, y, length / 3);
        }
    }
    
    private void drawCantor(Graphics2D g2, int x, int y, double radius) {
        cantorLine(g2, x, y, (int) radius);
        if (radius > 8) {
            drawCantor(g2, x * 2, y * 2, radius * 2/3);
            
        }

    }

    private void drawCircle(Graphics2D g2, int x, int y, double radius) {
        g2.drawOval((x - (int) radius) / 2, (y - (int) radius) / 2, (int) radius, (int) radius);
        if (radius > 8) {
            drawCircle(g2, x + (int) radius / 2, y, radius / 2.0);
            drawCircle(g2, x - (int) radius / 2, y, radius / 2.0);
            drawCircle(g2, x, y + (int) radius / 2, radius / 2.0);
            drawCircle(g2, x, y - (int) radius / 2, radius / 2.0);
        }

    }
}
