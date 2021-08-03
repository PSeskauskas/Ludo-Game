package com.company;

public class Dice {
    public static void rollDice(int[] diceRolls, Player[] players) {
        for(int i = 0; i < players.length; i++) {
            diceRolls[i] = (int) (Math.random()*6+1);
            System.out.println(players[i].getName() + " rolled a " + diceRolls[i] + "");
        }
        GameInit.sortStartingPlayer(diceRolls, players, 0, players.length - 1);
    }
}
