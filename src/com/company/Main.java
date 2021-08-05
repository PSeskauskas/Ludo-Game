package com.company;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {

    static int numPlayers;
    static int[] diceRolls;
    static Player[] players;
    static int count;


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

        ListView listView = new ListView();

        Button startGame = new Button("Start Game");
        startGame.setAlignment(Pos.CENTER);
        startGame.setOnAction(event -> {
            numPlayers = GameInit.selectPlayers();
            players = new Player[numPlayers];
            diceRolls = new int[numPlayers];
            GameInit.setNames(players);
            startGame.setVisible(false);
            GameInit.initializePieces(root, numPlayers);
            Dice.rollDice(diceRolls, players, listView);
            listView.getItems().add(players[0].getName() + " will go first");
        });

        count = 0;
        Button rollDice = new Button("Roll Dice");
        rollDice.setAlignment(Pos.CENTER);
        rollDice.setOnAction(event -> {
            GameInit.gameRoll(diceRolls, players[count], listView);
            if(count < numPlayers) {
                count++;
            }
            if(count == numPlayers) {
                count = 0;
            }
        });
        VBox vbox = new VBox(20);
        BackgroundFill backgroundFill = new BackgroundFill(Color.GREY, CornerRadii.EMPTY, Insets.EMPTY);
        Background background = new Background(backgroundFill);
        vbox.setBackground(background);
        vbox.setAlignment(Pos.CENTER);
        vbox.setMinWidth(400);
        vbox.setMinHeight(800);
        vbox.setMaxHeight(800);
        vbox.setMaxWidth(400);
        vbox.setLayoutX(800);
        listView.setMinWidth(400);
        listView.setMinHeight(400);

        HBox hbox = new HBox(10);
        hbox.setAlignment(Pos.CENTER);
        TextField inputBox = new TextField();
        Button submitButton = new Button("Submit");
        submitButton.setOnAction(event -> {
            listView.getItems().add(inputBox.getText());
            inputBox.setText("");
        });
        hbox.getChildren().addAll(inputBox, submitButton);

        vbox.getChildren().add(startGame);
        vbox.getChildren().add(rollDice);
        vbox.getChildren().add(listView);
        vbox.getChildren().add(hbox);
        root.getChildren().add(vbox);

        root.setScaleY(0.88);

        Scene scene = new Scene(root, 1200, 800);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}