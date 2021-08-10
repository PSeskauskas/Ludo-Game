package com.company;

import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import static com.company.Main.board;

public class GameInit {

    static int choice;

    public static void initializePieces(Group root, int numPlayers, Circle[] circles) {
        for(int i = 0; i < Constants.PLAYER_PIECES * Constants.NUM_PLAYERS; i++) {
            if(i < 4) {
                circles[i] = Piece.loadPiece(Constants.STARTING_POS[0][i], Constants.STARTING_POS[1][i], 10, Constants.COLOURS.GREEN);
                root.getChildren().add(circles[i]);
            } else if(i < 8 && numPlayers > 1) {
                circles[i] = Piece.loadPiece(Constants.STARTING_POS[0][i], Constants.STARTING_POS[1][i], 10, Constants.COLOURS.YELLOW);
                root.getChildren().add(circles[i]);
            } else if(i < 12 && numPlayers > 2) {
                circles[i] = Piece.loadPiece(Constants.STARTING_POS[0][i], Constants.STARTING_POS[1][i], 10, Constants.COLOURS.RED);
                root.getChildren().add(circles[i]);
            } else if(numPlayers > 3){
                circles[i] = Piece.loadPiece(Constants.STARTING_POS[0][i], Constants.STARTING_POS[1][i], 10, Constants.COLOURS.BLUE);
                root.getChildren().add(circles[i]);
            }
        }
    }

    public static int selectPlayers() {
        Stage newWindow = new Stage();
        newWindow.setWidth(300);
        newWindow.setHeight(300);
        newWindow.setTitle("Please select how many players are playing");
        newWindow.setResizable(false);
        Label label = new Label("Select here");

        ComboBox select = new ComboBox();
        select.getItems().add(2);
        select.getItems().add(3);
        select.getItems().add(4);

        Button submit = new Button("Submit");
        submit.setOnAction(e -> {
            choice = (int) select.getValue();
            newWindow.close();
        });

        VBox layout = new VBox(10);
        layout.getChildren().addAll(label, select, submit);
        layout.setAlignment(Pos.CENTER);
        Scene scene = new Scene(layout);
        newWindow.setScene(scene);
        newWindow.showAndWait();
        return choice;
    }

    public static void setNames(Player[] players) {
        Stage newWindow = new Stage();
        newWindow.setWidth(500);
        newWindow.setHeight(500);
        newWindow.setTitle("Please enter player names here");
        newWindow.setResizable(false);

        VBox layout = new VBox();
        TextField[] textFields = new TextField[players.length];
        for (int i = 0; i < textFields.length; i++) {
            Label label = new Label("Player " + (i + 1) + " Name");
            players[i] = new Player();
            textFields[i] = new TextField();
            layout.getChildren().addAll(label, textFields[i]);
        }
        int j = 0;
        for(Constants.COLOURS colours : Constants.COLOURS.values()) {
            if(j < players.length) {
                players[j].setColor(colours);
                j++;
            } else {
                break;
            }
        }

        Button submit = new Button("Submit");
        submit.setOnAction(e -> {
            for(int i = 0; i < players.length; i++) {
                players[i].setName(textFields[i].getText());
            }
            newWindow.close();
        });

        layout.getChildren().add(submit);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);
        newWindow.setScene(scene);
        newWindow.showAndWait();
    }

    public static void sortStartingPlayer(int[] diceRolls, Player[] players, int lo, int hi) {
        for(int i = 0; i <= hi; i++) {
            for(int j = i; j > lo; j--) {
                if(diceRolls[j] > diceRolls[j - 1]) {
                    Player temp = players[j];
                    players[j] = players[j - 1];
                    players[j - 1] = temp;
                } else {
                    break;
                }
            }
        }
    }

    public static int gameRoll() {
            return (int) (Math.random()*6+1);
        }
    }


