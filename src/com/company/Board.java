package com.company;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Circle;

import java.io.FileInputStream;
import java.io.FileNotFoundException;


public class Board extends Parent {
    @FXML public static Circle P1;
    @FXML private Circle P2;
    @FXML private Circle P3;
    @FXML private Circle P4;

    public static ImageView loadImage() throws FileNotFoundException {
        Image image = new Image(new FileInputStream("600px-Ludo_board.svg.png"));
        ImageView imageView = new ImageView(image);
        imageView.setX(0);
        imageView.setY(0);
        imageView.setFitHeight(800);
        imageView.setFitWidth(800);
        imageView.setPreserveRatio(true);
        return imageView;
    }

    public static Circle loadPiece() {
        P1 = new Circle(Constants.STARTING_POS[0][0],Constants.STARTING_POS[0][1],10);
        P1.setFill(javafx.scene.paint.Color.RED);
        return P1;
    }
}
