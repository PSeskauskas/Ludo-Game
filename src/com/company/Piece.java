package com.company;

import com.sun.corba.se.impl.orbutil.closure.Constant;
import com.sun.org.apache.bcel.internal.Const;
import javafx.fxml.FXML;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Piece {
    public Constants.COLOURS colour;

    int startingIndx;
    int currentIndx;

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
