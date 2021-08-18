package com.company;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
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
    static int choice;

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

        Button rollDice = new Button("Roll Dice");
        rollDice.setAlignment(Pos.CENTER);
        rollDice.setDisable(true);

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
            rollDice.setDisable(false);
        });

        count = 0;
        rollDice.setOnAction(event -> {
            int res = GameInit.gameRoll();
            if(res == 6) {
                listView.getItems().add(players[count].getName() + " has rolled a " + res + ".");
                if(!players[count].getInPlay()) {
                    if(players[count].getColor() == Constants.COLOURS.GREEN) {
                        indexes[0] = Constants.GREEN_START_SQUARE;
                        circles[0].setCenterX(board[indexes[0]].getX_coord());
                        circles[0].setCenterY(board[indexes[0]].getY_cord());
                        inPlay[0] = true;
                        players[count].setInPlay(true);
                    }
                    if(players[count].getColor() == Constants.COLOURS.RED) {
                        indexes[8] = Constants.RED_START_SQUARE;
                        circles[8].setCenterX(board[indexes[8]].getX_coord());
                        circles[8].setCenterY(board[indexes[8]].getY_cord());
                        inPlay[8] = true;
                        players[count].setInPlay(true);
                    }
                    if(players[count].getColor() == Constants.COLOURS.BLUE) {
                        indexes[12] = Constants.BLUE_START_SQUARE;
                        circles[12].setCenterX(board[indexes[12]].getX_coord());
                        circles[12].setCenterY(board[indexes[12]].getY_cord());
                        inPlay[12] = true;
                        players[count].setInPlay(true);
                    }
                    if(players[count].getColor() == Constants.COLOURS.YELLOW) {
                        indexes[4] = Constants.YELLOW_START_SQUARE;
                        circles[4].setCenterX(board[indexes[4]].getX_coord());
                        circles[4].setCenterY(board[indexes[4]].getY_cord());
                        inPlay[4] = true;
                        players[count].setInPlay(true);
                    }
                } else if(players[count].getAvailable()) {
                    rollDice.setDisable(true);
                    choice = GameInit.selectMove();
                    if(choice == 1) {
                        listView.getItems().add(players[count].getName() + " has rolled a " + res + ".");
                        if (players[count].getColor() == Constants.COLOURS.GREEN) {
                            for (int i = 0; i < Constants.PLAYER_PIECES; i++) {
                                if(!inPlay[i]) {
                                    indexes[i] = Constants.GREEN_START_SQUARE;
                                    circles[i].setCenterX(board[indexes[i]].getX_coord());
                                    circles[i].setCenterY(board[indexes[i]].getY_cord());
                                    inPlay[i] = true;
                                    players[count].setInPlay(true);
                                    if(i == 3) {
                                        players[count].setAvailable(false);
                                    }
                                    break;
                                }
                            }
                        }
                        if (players[count].getColor() == Constants.COLOURS.RED) {
                            for (int i = 8; i < Constants.PLAYER_PIECES * 3; i++) {
                                if(!inPlay[i]) {
                                    indexes[i] = Constants.RED_START_SQUARE;
                                    circles[i].setCenterX(board[indexes[i]].getX_coord());
                                    circles[i].setCenterY(board[indexes[i]].getY_cord());
                                    inPlay[i] = true;
                                    players[count].setInPlay(true);
                                    if(i == 11) {
                                        players[count].setAvailable(false);
                                    }
                                    break;
                                }
                            }
                        }
                        if (players[count].getColor() == Constants.COLOURS.BLUE) {
                            for (int i = 12; i < Constants.PLAYER_PIECES * 4; i++) {
                                if(!inPlay[i]) {
                                    indexes[i] = Constants.BLUE_START_SQUARE;
                                    circles[i].setCenterX(board[indexes[i]].getX_coord());
                                    circles[i].setCenterY(board[indexes[i]].getY_cord());
                                    inPlay[i] = true;
                                    players[count].setInPlay(true);
                                    if(i == 15) {
                                        players[count].setAvailable(false);
                                    }
                                    break;
                                }
                            }
                        }
                        if (players[count].getColor() == Constants.COLOURS.YELLOW) {
                            for (int i = 4; i < Constants.PLAYER_PIECES * 2; i++) {
                                if(!inPlay[i]) {
                                    indexes[i] = Constants.YELLOW_START_SQUARE;
                                    circles[i].setCenterX(board[indexes[i]].getX_coord());
                                    circles[i].setCenterY(board[indexes[i]].getY_cord());
                                    inPlay[i] = true;
                                    players[count].setInPlay(true);
                                    if(i == 7) {
                                        players[count].setAvailable(false);
                                    }
                                    break;
                                }
                            }
                        }
                        rollDice.setDisable(false);
                    }
                    if(choice == 2) {
                        listView.getItems().add(players[count].getName() + " has rolled a " + res + ".");
                        if (players[count].getColor() == Constants.COLOURS.GREEN) {
                            for (int i = 0; i < Constants.PLAYER_PIECES; i++) {
                                if (inPlay[i]) {
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
                            }
                        }
                        if (players[count].getColor() == Constants.COLOURS.RED) {
                            for (int i = 8; i < Constants.PLAYER_PIECES * 3; i++) {
                                if (inPlay[i]) {
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
                            }
                        }
                        if (players[count].getColor() == Constants.COLOURS.BLUE) {
                            for (int i = 12; i < Constants.PLAYER_PIECES * 4; i++) {
                                if (inPlay[i]) {
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
                            }
                        }
                        if (players[count].getColor() == Constants.COLOURS.YELLOW) {
                            for (int i = 4; i < Constants.PLAYER_PIECES * 2; i++) {
                                if (inPlay[i]) {
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
                            }
                        }
                        rollDice.setDisable(false);
                    }
                }
            } else {
                listView.getItems().add(players[count].getName() + " has rolled a " + res + ".");
                if (players[count].getColor() == Constants.COLOURS.GREEN) {
                    for (int i = 0; i < Constants.PLAYER_PIECES; i++) {
                        if (inPlay[i]) {
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
                    }
                }
                if (players[count].getColor() == Constants.COLOURS.RED) {
                    for (int i = 8; i < Constants.PLAYER_PIECES * 3; i++) {
                        if (inPlay[i]) {
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
                    }
                }
                if (players[count].getColor() == Constants.COLOURS.BLUE) {
                    for (int i = 12; i < Constants.PLAYER_PIECES * 4; i++) {
                        if (inPlay[i]) {
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
                    }
                }
                if (players[count].getColor() == Constants.COLOURS.YELLOW) {
                    for (int i = 4; i < Constants.PLAYER_PIECES * 2; i++) {
                        if (inPlay[i]) {
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
                    }
                }
                if (count < numPlayers && res != 6) {
                    count++;
                }
                if (count == numPlayers) {
                    count = 0;
                }
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
        root.getChildren().add(vbox);

        root.setScaleY(0.88);

        Scene scene = new Scene(root, 1200, 800);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}