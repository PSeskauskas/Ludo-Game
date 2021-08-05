package com.company;

public class Square {

    private int indx;

    public int getX_coord() {
        return x_coord;
    }

    public void setX_coord(int x_coord) {
        this.x_coord = x_coord;
    }

    //coordinates for javafx
    private int x_coord;

    public int getY_cord() {
        return y_cord;
    }

    public void setY_cord(int y_cord) {
        this.y_cord = y_cord;
    }

    private int y_cord;

    public Square(int i,int x, int y){
        indx = i;
        x_coord = x;
        y_cord = y;
    }
}
