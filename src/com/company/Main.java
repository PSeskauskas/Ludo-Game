package com.company;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.util.Arrays;

public class Main extends Application {

    static int numPlayers;
    static int[] diceRolls;
    static Player[] players;


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

        Group root = new Group(Board.loadImage());

        Button startGame = new Button("Start Game");
        startGame.setOnAction(event -> {
            numPlayers = GameInit.selectPlayers();
            players = new Player[numPlayers];
            diceRolls = new int[numPlayers];
            GameInit.setNames(players);
            startGame.setVisible(false);
            for(int i = 0; i < Constants.PLAYER_PIECES * Constants.NUM_PLAYERS; i++) {
                if(i < 4) {
                    root.getChildren().add(Piece.loadPiece(Constants.STARTING_POS[0][i], Constants.STARTING_POS[1][i], 10, i, Constants.COLOURS.GREEN));
                } else if(i < 8 && numPlayers > 1) {
                    root.getChildren().add(Piece.loadPiece(Constants.STARTING_POS[0][i], Constants.STARTING_POS[1][i], 10, i, Constants.COLOURS.YELLOW));
                } else if(i < 12 && numPlayers > 2) {
                    root.getChildren().add(Piece.loadPiece(Constants.STARTING_POS[0][i], Constants.STARTING_POS[1][i], 10, i, Constants.COLOURS.RED));
                } else if(numPlayers > 3){
                    root.getChildren().add(Piece.loadPiece(Constants.STARTING_POS[0][i], Constants.STARTING_POS[1][i], 10, i, Constants.COLOURS.BLUE));
                }
            }
            for(int i = 0; i < numPlayers; i++) {
                diceRolls[i] = (int) (Math.random()*6+1);
                System.out.println(players[i].getName() + " rolled a " + diceRolls[i] + "");
            }
            GameInit.sortStartingPlayer(diceRolls, players, 0, players.length - 1);
            System.out.println(players[0].getName() + " will go first");
        });


        if(numPlayers == 0) {
            root.getChildren().add(startGame);
        }


        root.setScaleY(0.88);

        Scene scene = new Scene(root, 800, 800);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}