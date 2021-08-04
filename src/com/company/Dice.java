package com.company;

import javafx.scene.control.ListView;

public class Dice {
    public static void rollDice(int[] diceRolls, Player[] players, ListView listView) {
        for(int i = 0; i < players.length; i++) {
            diceRolls[i] = (int) (Math.random()*6+1);
            listView.getItems().add(players[i].getName() + " rolled a " + diceRolls[i] + "");
        }
        GameInit.sortStartingPlayer(diceRolls, players, 0, players.length - 1);
    }
}
