package com.company;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Popup;
import javafx.stage.Stage;

public class Main extends Application {

    static int numPlayers;


    public static void main(String[] args) {
        //makes a board of 52 squares
        Square[] board = new Square[52];
        for(int i = 0; i < 52;i++){
            Square s = new Square(i);
            board[i] = s;

        }
        launch(args);

    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Ludo Game");
        primaryStage.setResizable(false);

        Button startGame = new Button("Start Game");
        startGame.setOnAction(event -> {
            numPlayers = GameInit.selectPlayers();
            startGame.setVisible(false);
        });

        Group root = new Group(Board.loadImage());
        for(int i = 0; i < Constants.PLAYER_PIECES * Constants.NUM_PLAYERS; i++) {
            if(i < 4) {
                root.getChildren().add(Piece.loadPiece(Constants.STARTING_POS[0][i], Constants.STARTING_POS[1][i], 10, i, Constants.COLOURS.GREEN));
            } else if(i < 8) {
                root.getChildren().add(Piece.loadPiece(Constants.STARTING_POS[0][i], Constants.STARTING_POS[1][i], 10, i, Constants.COLOURS.YELLOW));
            } else if(i < 12) {
                root.getChildren().add(Piece.loadPiece(Constants.STARTING_POS[0][i], Constants.STARTING_POS[1][i], 10, i, Constants.COLOURS.RED));
            } else {
                root.getChildren().add(Piece.loadPiece(Constants.STARTING_POS[0][i], Constants.STARTING_POS[1][i], 10, i, Constants.COLOURS.BLUE));
            }
        }
        if(numPlayers == 0) {
            root.getChildren().add(startGame);
        }
        root.setScaleY(0.88);

        Scene scene = new Scene(root, 800, 800);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}