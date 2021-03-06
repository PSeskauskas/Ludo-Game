package com.company;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
    static Boolean[] lapComplete = new Boolean[16];
    static Boolean[] centerPiece = new Boolean[16];
    static int[] squaresPassed = new int[circles.length];
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
            lapComplete[i] = false;
            squaresPassed[i] = 0;
            centerPiece[i] = false;
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
            GameInit.initializeMiddleSquares(players, numPlayers);
            Dice.rollDice(diceRolls, players, listView);
            listView.getItems().add(players[0].getName() + " will go first");
            rollDice.setDisable(false);
        });

        count = 0;

        rollDice.setOnAction(event -> {
            int res = GameInit.gameRoll();
            listView.getItems().add(players[count].getName() + " has rolled a " + res + ".");
            if(players[count].getInPlay() || res == 6) {
                rollDice.setDisable(true);
                choice = GameInit.selectMove(players[count], centerPiece, res);
                if (choice == 1) {
                    for (int i = players[count].getStartIndex(); i <= players[count].getFinalIndex(); i++) {
                        if (!inPlay[i] && !centerPiece[i]) {
                            indexes[i] = players[count].getStartSquare();
                            circles[i].setCenterX(board[indexes[i]].getX_coord());
                            circles[i].setCenterY(board[indexes[i]].getY_cord());
                            inPlay[i] = true;
                            squaresPassed[i] = 0;
                            players[count].setInPlay(true);
                            if (i == players[count].getFinalIndex()) {
                                players[count].setAvailable(false);
                            }
                            break;
                        }
                    }
                    players[count].setPiecesInPlay(players[count].getPiecesInPlay() + 1);
                    rollDice.setDisable(false);
                } else {
                    for (int i = players[count].getStartIndex(); i <= players[count].getFinalIndex(); i++) {
                        if (inPlay[i + (choice - 2)]) {
                            if(lapComplete[i + (choice - 2)] && !centerPiece[i + (choice - 2)]) {
                                if(indexes[i + (choice - 2)] + res < 6) {
                                    indexes[i + (choice - 2)] += res;
                                } else {
                                    int temp = indexes[i + (choice - 2)] + res;
                                    indexes[i + (choice - 2)] = 5 - (temp - 5);
                                }
                                if(indexes[i + (choice - 2)] == 5) {
                                    centerPiece[i + (choice - 2)] = true;
                                    players[count].setCenterPieces(players[count].getCenterPieces() + 1);
                                    inPlay[i + (choice - 2)] = false;
                                }
                                circles[i + (choice - 2)].setCenterX(players[count].getMiddleSquares()[indexes[i + (choice - 2)]].getX_coord());
                                circles[i + (choice - 2)].setCenterY(players[count].getMiddleSquares()[indexes[i + (choice - 2)]].getY_cord());
                            } else {
                                if (squaresPassed[i + (choice - 2)] + res >= 51) {
                                    indexes[i + (choice - 2)] = (squaresPassed[i + (choice - 2)] + res) - 51;
                                    squaresPassed[i + (choice - 2)] += res;
                                    lapComplete[i + (choice - 2)] = true;
                                    if(squaresPassed[i + (choice - 2)] == 56) {
                                        centerPiece[i + (choice - 2)] = true;
                                    }
                                    circles[i + (choice - 2)].setCenterX(players[count].getMiddleSquares()[indexes[i + (choice - 2)]].getX_coord());
                                    circles[i + (choice - 2)].setCenterY(players[count].getMiddleSquares()[indexes[i + (choice - 2)]].getY_cord());
                                } else if (indexes[i + (choice - 2)] + res < 52 && !lapComplete[i + (choice - 2)]) {
                                    indexes[i + (choice - 2)] += res;
                                    squaresPassed[i + (choice - 2)] += res;
                                    circles[i + (choice - 2)].setCenterX(board[indexes[i + (choice - 2)]].getX_coord());
                                    circles[i + (choice - 2)].setCenterY(board[indexes[i + (choice - 2)]].getY_cord());
                                } else if (indexes[i + (choice - 2)] + res >= 52 && !lapComplete[i + (choice - 2)]) {
                                    while (indexes[i + (choice - 2)] < 52) {
                                        indexes[i + (choice - 2)]++;
                                        squaresPassed[i + (choice - 2)]++;
                                        res--;
                                    }
                                    indexes[i + (choice - 2)] = 0;
                                    indexes[i + (choice - 2)] += res;
                                    squaresPassed[i + (choice - 2)] += res;
                                    circles[i + (choice - 2)].setCenterX(board[indexes[i + (choice - 2)]].getX_coord());
                                    circles[i + (choice - 2)].setCenterY(board[indexes[i + (choice - 2)]].getY_cord());
                                }
                            }
                            break;
                        }
                    }
                    rollDice.setDisable(false);
                    boolean piece = false;
                    for(int i = players[count].getStartIndex(); i <= players[count].getFinalIndex(); i++) {
                        if (inPlay[i]) {
                            piece = true;
                            break;
                        }
                    }
                    if(!piece) {
                        players[count].setInPlay(false);
                    }
                }
                if(players[count].getInPlay()) {
                    for (int i = players[count].getStartIndex(); i <= players[count].getFinalIndex(); i++) {
                        for (int j = 0; j < indexes.length; j++) {
                            if (j < players[count].getStartSquare() || j > players[count].getFinalIndex()) {
                                if (indexes[i] == -1 || indexes[j] == -1 || indexes[i] == 1 || indexes[j] == 1 || indexes[i] == 14 || indexes[j] == 14 || indexes[i] == 27 || indexes[j] == 27 || indexes[i] == 40 || indexes[j] == 40) {
                                    break;
                                } else if (i != j && (indexes[i] == indexes[j]) && (!lapComplete[i] && !lapComplete[j])) {
                                    if(circles[j].getFill() == Color.DARKRED) {
                                        indexes[j] = 14;
                                    } else if(circles[j].getFill() == Color.CYAN) {
                                        indexes[j] = 27;
                                    } else if(circles[j].getFill() == Color.GREEN) {
                                        indexes[j] = 1;
                                    } else if(circles[j].getFill() == Color.ORANGE) {
                                        indexes[j] = 40;
                                    }
                                    squaresPassed[j] = 0;
                                    circles[j].setCenterX(board[indexes[j]].getX_coord());
                                    circles[j].setCenterY(board[indexes[j]].getY_cord());
                                }
                            }
                        }
                    }
                }
                if(players[count].getCenterPieces() == 4) {
                    rollDice.setDisable(true);
                    Stage winnerWindow = new Stage();
                    winnerWindow.setResizable(false);
                    winnerWindow.setTitle("WE HAVE A WINNER!!!!");
                    winnerWindow.setWidth(700);
                    winnerWindow.setHeight(700);
                    Label label = new Label(players[count].getName() + " has won the game!!!");
                    VBox layout = new VBox();
                    layout.getChildren().addAll(label);
                    layout.setAlignment(Pos.CENTER);
                    Scene scene = new Scene(layout);
                    winnerWindow.setScene(scene);
                    winnerWindow.show();
                }
            }
            if (count < numPlayers && res != 6) {
                count++;
            }
            if (count == numPlayers) {
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
        root.getChildren().add(vbox);

        root.setScaleY(0.88);

        Scene scene = new Scene(root, 1200, 800);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}