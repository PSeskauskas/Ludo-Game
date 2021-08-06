package com.company;

public class Square {

    private int indx;

    public double getX_coord() {
        return x_coord;
    }

    public void setX_coord(double x_coord) {
        this.x_coord = x_coord;
    }

    //coordinates for javafx
    private double x_coord;

    public double getY_cord() {
        return y_cord;
    }

    public void setY_cord(double y_cord) {
        this.y_cord = y_cord;
    }

    private double y_cord;

    public Square(int i,double x, double y){
        indx = i;
        x_coord = x;
        y_cord = y;
    }
}
