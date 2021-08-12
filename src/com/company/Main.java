package com.company;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
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
    static Square[] board;
    static Circle[] circles = new Circle[16];
    static Boolean[] inPlay = new Boolean[16];
    static int[] indexes = new int[circles.length];

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Ludo Game");
        primaryStage.setResizable(false);

        board = GameInit.initializeSquares();

        Group root = new Group(Board.loadImage());
        for(int i = 0; i < 16; i++) {
            inPlay[i] = false;
            indexes[i] = -1;
        }

        ListView listView = new ListView();
        HBox hbox = new HBox(10);
        hbox.setAlignment(Pos.CENTER);
        TextField inputBox = new TextField();
        Button submitButton = new Button("Submit");
        submitButton.setOnAction(event -> {
            listView.getItems().add(inputBox.getText());
            inputBox.setText("");
        });
        hbox.getChildren().addAll(inputBox, submitButton);

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
            int res = GameInit.gameRoll();
            if(res == 6) {
                listView.getItems().add(players[count].getName() + " has rolled a " + res + ".");
                listView.getItems().add("Enter 1 to bring a piece out or 2 to move a current piece");
                String choice = inputBox.getText();
                //rollDice.setDisable(true);
                if(choice == "1") {
                    //
                    rollDice.setDisable(false);
                }
                if(choice == "2") {
                    //
                    rollDice.setDisable(false);
                }
                else {
                    listView.getItems().add("Please enter 1 or 2");
                }
            } else {
                listView.getItems().add(players[count].getName() + " has rolled a " + res + ".");
            }
            if(players[count].getColor() == Color.GREEN) {
                for(int i = 0; i < Constants.PLAYER_PIECES; i++) {
                    if(inPlay[i]) {
                        if (indexes[i] + res < 52) {
                            indexes[i] += res;
                        } else {
                            while (indexes[i] < 52) {
                                indexes[i]++;
                                res--;
                            }
                            indexes[i] = 0;
                            indexes[i] += res;
                        }
                        circles[i].setCenterX(board[indexes[i]].getX_coord());
                        circles[i].setCenterY(board[indexes[i]].getY_cord());
                        break;
                    }
                    if(!inPlay[i]) {
                        if(res == 6) {
                            indexes[i] = Constants.GREEN_START_SQUARE;
                            circles[i].setCenterX(board[indexes[i]].getX_coord());
                            circles[i].setCenterY(board[indexes[i]].getY_cord());
                            inPlay[i] = true;
                            break;
                        }
                    }
                }
            }
            if(players[count].getColor() == Color.RED) {
                for(int i = 8; i < Constants.PLAYER_PIECES * 3; i++) {
                    if(inPlay[i]) {
                        if (indexes[i] + res < 52) {
                            indexes[i] += res;
                        } else {
                            while (indexes[i] < 52) {
                                indexes[i]++;
                                res--;
                            }
                            indexes[i] = 0;
                            indexes[i] += res;
                        }
                        circles[i].setCenterX(board[indexes[i]].getX_coord());
                        circles[i].setCenterY(board[indexes[i]].getY_cord());
                        break;
                    }
                    if(!inPlay[i]) {
                        if(res == 6) {
                            indexes[i] = Constants.RED_START_SQUARE;
                            circles[i].setCenterX(board[indexes[i]].getX_coord());
                            circles[i].setCenterY(board[indexes[i]].getY_cord());
                            inPlay[i] = true;
                            break;
                        }
                    }
                }
            }
            if(players[count].getColor() == Color.BLUE) {
                for(int i = 12; i < Constants.PLAYER_PIECES * 4; i++) {
                    if(inPlay[i]) {
                        if (indexes[i] + res < 52) {
                            indexes[i] += res;
                        } else {
                            while (indexes[i] < 52) {
                                indexes[i]++;
                                res--;
                            }
                            indexes[i] = 0;
                            indexes[i] += res;
                        }
                        circles[i].setCenterX(board[indexes[i]].getX_coord());
                        circles[i].setCenterY(board[indexes[i]].getY_cord());
                        break;
                    }
                    if(!inPlay[i]) {
                        if(res == 6) {
                            indexes[i] = Constants.BLUE_START_SQUARE;
                            circles[i].setCenterX(board[indexes[i]].getX_coord());
                            circles[i].setCenterY(board[indexes[i]].getY_cord());
                            inPlay[i] = true;
                            break;
                        }
                    }
                }
            }
            if(players[count].getColor() == Color.YELLOW) {
                for(int i = 4; i < Constants.PLAYER_PIECES * 2; i++) {
                    if(inPlay[i]) {
                        if (indexes[i] + res < 52) {
                            indexes[i] += res;
                        } else {
                            while (indexes[i] < 52) {
                                indexes[i]++;
                                res--;
                            }
                            indexes[i] = 0;
                            indexes[i] += res;
                        }
                        circles[i].setCenterX(board[indexes[i]].getX_coord());
                        circles[i].setCenterY(board[indexes[i]].getY_cord());
                        break;
                    }
                    if(!inPlay[i]) {
                        if(res == 6) {
                            indexes[i] = Constants.YELLOW_START_SQUARE;
                            circles[i].setCenterX(board[indexes[i]].getX_coord());
                            circles[i].setCenterY(board[indexes[i]].getY_cord());
                            inPlay[i] = true;
                            break;
                        }
                    }
                }
            }
            if(count < numPlayers && res != 6) {
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