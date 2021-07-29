package com.company;

import javafx.fxml.FXML;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Piece {
    @FXML public static Circle P1;
    @FXML private Circle P2;
    @FXML private Circle P3;
    @FXML private Circle P4;

    public static Circle loadPiece(int x, int y, int radius, Constants.COLOURS color) {
        P1 = new Circle(x, y, radius);
        if(color == Constants.COLOURS.GREEN) {
            P1.setFill(Color.GREEN);
        } else if(color == Constants.COLOURS.BLUE) {
            P1.setFill(Color.CYAN);
        } else if(color == Constants.COLOURS.RED) {
            P1.setFill(Color.DARKRED);
        } else if(color == Constants.COLOURS.YELLOW) {
            P1.setFill(Color.ORANGE);
        }
        return P1;
    }
}
