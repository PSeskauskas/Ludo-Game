package com.company;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Piece {

    int startingIndx;
    int currentIndx;

    Constants.COLOURS playerColour;

    public Piece (int start,Constants.COLOURS c){
        startingIndx = start;
        playerColour = c;
        currentIndx = startingIndx;
    }

    private void  movePiece(int roll) {
        if (currentIndx + roll < 52) {
            currentIndx += roll;
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
        Circle circle = new Circle(x, y, radius);
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