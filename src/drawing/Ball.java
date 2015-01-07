/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drawing;

import java.awt.Color;
import java.awt.Graphics;
import maths.Vector2D;

/**
 *
 * @author IPsoft
 */
public class Ball implements IShape{
    
    private Vector2D location;
    private Vector2D velocity;
    private Vector2D acceleration;
    private Vector2D box;
    public Ball() {
        this(new Vector2D(0.0, 0.0));
    }
    
    public Ball(Vector2D location) {
        this.location = location;
        velocity = new Vector2D(0,0);
        
        box = new Vector2D(640,480);
    }

    @Override
    public void display(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillOval( (int) location.getX(), (int) location.getY(), 16,16);
    }

    @Override
    public void update() {
        acceleration = Vector2D.Random2D();
        System.out.println(acceleration.heading());
        velocity.addition(acceleration);
        velocity.limit(10);
        location.addition(velocity);
        
        
    }
    
    /*
    if ( location.getX() > box.getX()) {
            location.setX(0);
        } else if ( location.getX() < 0) {
            location.setX(box.getX());
        }
        
        if ( location.getY () > box.getY()) {
            location.setY(0);
        } else if ( location.getY() < 0 ) {
            location.setY(box.getY());
        }
    */
    
    /*
    if (( location.getX() > box.getX()) ||(location.getX() < 0)) {
            velocity.setX(velocity.getX() * -1);
        }
        if ( (location.getY() > box.getY()) || (location.getY() < 0 )) {
            velocity.setY(velocity.getY() * -1);
        }
    */

    @Override
    public void checkEdge() {
        if ( location.getX() > box.getX()) {
            location.setX(0);
        } else if ( location.getX() < 0) {
            location.setX(box.getX());
        }
        
        if ( location.getY () > box.getY()) {
            location.setY(0);
        } else if ( location.getY() < 0 ) {
            location.setY(box.getY());
        }
        
        
    }
    
    
    
}
