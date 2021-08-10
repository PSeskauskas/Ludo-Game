package com.company;

import com.sun.corba.se.impl.orbutil.closure.Constant;
import com.sun.org.apache.bcel.internal.Const;
import javafx.fxml.FXML;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Piece {
    private static Circle circle;
    public Constants.COLOURS colour;

    int startingIndx;
    int currentIndx;

    Constants.COLOURS playerColour;

    public Piece (int start,Constants.COLOURS c){
        startingIndx = start;
        playerColour = c;
        currentIndx = startingIndx;
    }

    public void movePiece(int roll) {
        if (currentIndx + roll < 52) {
            currentIndx = roll;
            circle.setCenterX(Main.board[currentIndx].getX_coord());
            circle.setCenterY(Main.board[currentIndx].getY_cord());
        } else {
            while (currentIndx < 52) {
                currentIndx++;
                roll--;
            }
            currentIndx = 0;
            currentIndx += roll;

        }
    }

    Boolean lapComplete;

    public static Circle loadPiece(double x, double y, int radius, Constants.COLOURS color) {
        circle = new Circle(x, y, radius);
        if(color == Constants.COLOURS.GREEN) {
            circle.setFill(Color.GREEN);
        } else if(color == Constants.COLOURS.BLUE) {
            circle.setFill(Color.CYAN);
        } else if(color == Constants.COLOURS.RED) {
            circle.setFill(Color.DARKRED);
        } else if(color == Constants.COLOURS.YELLOW) {
            circle.setFill(Color.ORANGE);
        }
        return circle;
    }
}
