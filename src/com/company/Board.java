package com.company;

import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;


public class Board extends Parent {
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
}
