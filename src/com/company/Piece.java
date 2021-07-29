package com.company;

import javafx.fxml.FXML;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Piece {
    @FXML public static Circle P1;
    @FXML private Circle P2;
    @FXML private Circle P3;
    @FXML private Circle P4;

    public static Circle loadPiece(int x, int y, int radius) {
        P1 = new Circle(x, y, radius);
        P1.setFill(Color.GREEN);
        return P1;
    }
}
