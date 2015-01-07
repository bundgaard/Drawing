/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drawing;

import java.awt.Graphics;

/**
 *
 * @author IPsoft
 */
public interface IShape {
    
    public void display(Graphics g);
    public void update();
    public void checkEdge();
    
}
