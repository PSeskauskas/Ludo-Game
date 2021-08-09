package com.company;

import com.sun.org.apache.bcel.internal.Const;
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
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Main extends Application {

    static int numPlayers;
    static int[] diceRolls;
    static Player[] players;
    static int count;
    static Square[] board = new Square[52];
    static Circle[] circles = new Circle[16];
    static Boolean[] inPlay = new Boolean[16];

    public static void main(String[] args) {
        int i = 0;
        double x, y;
        Square s;
        for(int j = 0; j < 6; j++) {
            x = Constants.WHITE_SQUARES_X[j];
            y = Constants.WHITE_SQUARES_Y[6];
            s = new Square(i, x, y);
            board[i] = s;
            i++;
        }
        for(int j = 5; j >= 0; j--) {
            x = Constants.WHITE_SQUARES_X[6];
            y = Constants.WHITE_SQUARES_Y[j];
            s = new Square(i, x, y);
            board[i] = s;
            i++;
        }
        x = Constants.WHITE_SQUARES_X[7];
        y = Constants.WHITE_SQUARES_Y[0];
        s = new Square(i, x, y);
        board[i] = s;
        i++;
        for(int j = 0; j < 6; j++) {
            x = Constants.WHITE_SQUARES_X[8];
            y = Constants.WHITE_SQUARES_Y[j];
            s = new Square(i, x, y);
            board[i] = s;
            i++;
        }
        for(int j = 9; j < 15; j++) {
            x = Constants.WHITE_SQUARES_X[j];
            y = Constants.WHITE_SQUARES_Y[6];
            s = new Square(i, x, y);
            board[i] = s;
            i++;
        }
        x = Constants.WHITE_SQUARES_X[14];
        y = Constants.WHITE_SQUARES_Y[7];
        s = new Square(i, x, y);
        board[i] = s;
        i++;
        for(int j = 14; j >= 9; j--) {
            x = Constants.WHITE_SQUARES_X[j];
            y = Constants.WHITE_SQUARES_Y[8];
            s = new Square(i, x, y);
            board[i] = s;
            i++;
        }
        for(int j = 9; j < 15; j++) {
            x = Constants.WHITE_SQUARES_X[8];
            y = Constants.WHITE_SQUARES_Y[j];
            s = new Square(i, x, y);
            board[i] = s;
            i++;
        }
        x = Constants.WHITE_SQUARES_X[7];
        y = Constants.WHITE_SQUARES_Y[14];
        s = new Square(i, x, y);
        board[i] = s;
        i++;
        for(int j = 14; j >= 9; j--) {
            x = Constants.WHITE_SQUARES_X[6];
            y = Constants.WHITE_SQUARES_Y[j];
            s = new Square(i, x, y);
            board[i] = s;
            i++;
        }
        for(int j = 5; j >= 0; j--) {
            x = Constants.WHITE_SQUARES_X[j];
            y = Constants.WHITE_SQUARES_Y[8];
            s = new Square(i, x, y);
            board[i] = s;
            i++;
        }
        x = Constants.WHITE_SQUARES_X[0];
        y = Constants.WHITE_SQUARES_Y[7];
        s = new Square(i, x, y);
        board[i] = s;
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Ludo Game");
        primaryStage.setResizable(false);

        Group root = new Group(Board.loadImage());
        /*for(int i = 0; i < 52;i++) {
            root.getChildren().add(Piece.loadPiece(board[i].getX_coord(), board[i].getY_cord(), 10, 2, Constants.COLOURS.BLUE));
        }*/
        for(int i = 0; i < 16; i++) {
            inPlay[i] = false;
        }

        ListView listView = new ListView();

        Button startGame = new Button("Start Game");
        startGame.setAlignment(Pos.CENTER);
        startGame.setOnAction(event -> {
            numPlayers = GameInit.selectPlayers();
            players = new Player[numPlayers];
            diceRolls = new int[numPlayers];
            GameInit.setNames(players);
            startGame.setVisible(false);
            GameInit.initializePieces(root, numPlayers, circles);
            Dice.rollDice(diceRolls, players, listView);
            listView.getItems().add(players[0].getName() + " will go first");
        });

        count = 0;
        Button rollDice = new Button("Roll Dice");
        rollDice.setAlignment(Pos.CENTER);
        rollDice.setOnAction(event -> {
            int res = GameInit.gameRoll(diceRolls, players[count], listView);
            if(res == 6) {
                listView.getItems().add(players[count].getName() + " has rolled a " + res + ". A piece has been brought out");
                if(players[count].getColor() == Color.GREEN) {
                    for(int i = 0; i < Constants.PLAYER_PIECES; i++) {
                        if(!inPlay[i]) {
                            circles[i].setCenterX(board[1].getX_coord());
                            circles[i].setCenterY(board[1].getY_cord());
                            inPlay[i] = true;
                            break;
                        }
                    }
                }
                if(players[count].getColor() == Color.RED) {
                    for(int i = 8; i < Constants.PLAYER_PIECES * 3; i++) {
                        if(!inPlay[i]) {
                            circles[i].setCenterX(board[14].getX_coord());
                            circles[i].setCenterY(board[14].getY_cord());
                            inPlay[i] = true;
                            break;
                        }
                    }
                }
                if(players[count].getColor() == Color.BLUE) {
                    for(int i = 12; i < Constants.PLAYER_PIECES * 4; i++) {
                        if(!inPlay[i]) {
                            circles[i].setCenterX(board[27].getX_coord());
                            circles[i].setCenterY(board[27].getY_cord());
                            inPlay[i] = true;
                            break;
                        }
                    }
                }
                if(players[count].getColor() == Color.YELLOW) {
                    for(int i = 4; i < Constants.PLAYER_PIECES * 2; i++) {
                        if(!inPlay[i]) {
                            circles[i].setCenterX(board[40].getX_coord());
                            circles[i].setCenterY(board[40].getY_cord());
                            inPlay[i] = true;
                            break;
                        }
                    }
                }
            } else if(res != 6) {
                listView.getItems().add(players[count].getName() + " has rolled a " + res + ".");
            }
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