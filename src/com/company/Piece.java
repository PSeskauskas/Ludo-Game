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


    @FXML public static Circle[] pieces = new Circle[Constants.NUM_PLAYERS * Constants.PLAYER_PIECES];

    public static Circle loadPiece(int x, int y, int radius, int circleNumber, Constants.COLOURS color) {
        pieces[circleNumber] = new Circle(x, y, radius);
        if(color == Constants.COLOURS.GREEN) {
            pieces[circleNumber].setFill(Color.GREEN);
        } else if(color == Constants.COLOURS.BLUE) {
            pieces[circleNumber].setFill(Color.CYAN);
        } else if(color == Constants.COLOURS.RED) {
            pieces[circleNumber].setFill(Color.DARKRED);
        } else if(color == Constants.COLOURS.YELLOW) {
            pieces[circleNumber].setFill(Color.ORANGE);
        }
        return pieces[circleNumber];
    }
}
