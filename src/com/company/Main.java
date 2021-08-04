package com.company;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

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
            GameInit.initializePieces(root, numPlayers);
            Dice.rollDice(diceRolls, players);
            System.out.println(players[0].getName() + " will go first");
        });

        Button rollDice = new Button("Roll Dice");
        rollDice.setOnAction(event -> {
            GameInit.gameRoll(diceRolls,players);
        });
        VBox vbox = new VBox(10);

        if(numPlayers == 0) {
            vbox.getChildren().add(startGame);
            vbox.getChildren().add(rollDice);
        }
        root.getChildren().add(vbox);

        root.setScaleY(0.88);

        Scene scene = new Scene(root, 800, 800);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}