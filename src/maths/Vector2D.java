/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maths;

import java.io.Serializable;
import java.util.Random;

/**
 *
 * @author IPsoft
 */
public class Vector2D implements Serializable{
    
    private double x;
    private double y;
    private double array[];
    
    public Vector2D() {
        this(0.0, 0.0);
    }
    
    public Vector2D(double x, double y){
        this.x = x;
        this.y = y;
    }
    
    public void addition(Vector2D v) {
        this.x += v.getX();
        this.y += v.getY();
    }
    
    public void subtract(Vector2D v) {
        this.x -= v.getX();
        this.y -= v.getY();
    }
    
    public void multiply(double scale) {
        this.x *= scale;
        this.y *= scale;
    }
    
    public void divide(double scale) {
        this.x /= scale;
        this.y /= scale;    
    }
    
    public double magnitude() {
        return Math.sqrt(this.x * this.x + this.y * this.y);
    }
    
    public void normalize() {
        double m = this.magnitude();
        if ( m != 0 && m != 1) {
            divide(m);
        }
    }
    
    public void limit(double newLimit) {
        double m = this.magnitude();
        if ( m > newLimit) {
            this.normalize();
            this.multiply(newLimit);
        }
    }
    
    public double heading() {
        return -1 * Math.atan2(-y, x);
    }
    
    public static Vector2D Add(Vector2D v1, Vector2D v2) {
        return new Vector2D(v1.getX() + v2.getX(), v1.getY() + v2.getY());
    }
    
    public static Vector2D Sub(Vector2D v1, Vector2D v2) {
        return new Vector2D(v1.getX() - v2.getX(), v1.getY() - v2.getY());
    }
    
    public static Vector2D Multiply(Vector2D v1, double scale) {
        return new Vector2D(v1.getX() * scale, v1.getY() * scale);
    }
    public static Vector2D Divide(Vector2D v1, double scale) {
        return new Vector2D(v1.getX() / scale, v1.getY() / scale);
    }
    
    public static Vector2D Random2D() {
        Vector2D result = fromAngle(Math.random() * 2 * Math.PI);
        return result;
    }
    
    public static Vector2D fromAngle(double angle) {
        Vector2D result = new Vector2D(Math.cos(angle), Math.sin(angle));
        return result;
    }
    // static public final float lerp(float start, float stop, float amt) {
    //return start + (stop-start) * amt;
    //}
    
    public final double lerp(double start, double stop, double amount) {
        return start + (stop-start) * amount;
    }
    public void lerp(Vector2D v, double amount) {
        this.x = lerp(x, v.getX(), amount);
        this.y = lerp(y, v.getY(), amount);
    }
    
    
    @Override
    public String toString() {
        return String.format("(%.2f,%.2f)\n", getX(), getY());
    }
    
    public double[] toArray() {
        if ( array == null ) {
            array = new double[2];
        }
        array[0] = this.x;
        array[1] = this.y;
        return array;
    }
        
    public void setX(double newX) {
        this.x = newX;
    }
    
    public void setY(double newY){
        this.y = newY;
    }
    
    public double getX() {
        return this.x;
    }
    
    public double getY() {
        return this.y;
    }
    
    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + (int) Double.doubleToLongBits(x);
        result = 31 * result + (int) Double.doubleToLongBits(y);
        return result;
    }
    
    @Override
    public boolean equals(Object obj) {
        if( ! (obj instanceof Vector2D)) {
            return false;
        }
        
        Vector2D v = (Vector2D) obj;
        return (x == v.getX() && y == v.getY());        
    }
}
