package com.company;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Popup;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Ludo Game");
        primaryStage.setResizable(false);

        final Popup popup = new Popup();
        popup.setX(300);
        popup.setY(200);
        popup.getContent().addAll(new Circle(25, 25, 50, Color.AQUAMARINE));

        Button show = new Button("Show");
        show.setOnAction(event -> popup.show(primaryStage));

        Button hide = new Button("Hide");
        hide.setOnAction(event -> popup.hide());

        Group root = new Group(Board.loadImage());
        for(int i = 0; i < Constants.PLAYER_PIECES * Constants.NUM_PLAYERS; i++) {
            if(i < 4) {
                root.getChildren().add(Piece.loadPiece(Constants.STARTING_POS[0][i], Constants.STARTING_POS[1][i], 10, Constants.COLOURS.GREEN));
            } else if(i < 8) {
                root.getChildren().add(Piece.loadPiece(Constants.STARTING_POS[0][i], Constants.STARTING_POS[1][i], 10, Constants.COLOURS.YELLOW));
            } else if(i < 12) {
                root.getChildren().add(Piece.loadPiece(Constants.STARTING_POS[0][i], Constants.STARTING_POS[1][i], 10, Constants.COLOURS.RED));
            } else {
                root.getChildren().add(Piece.loadPiece(Constants.STARTING_POS[0][i], Constants.STARTING_POS[1][i], 10, Constants.COLOURS.BLUE));
            }
        }
        VBox vbox = new VBox(5);
        vbox.getChildren().addAll(show, hide);

        root.getChildren().add(vbox);
        root.setScaleY(0.88);

        Scene scene = new Scene(root, 800, 800);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}