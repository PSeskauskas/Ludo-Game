package com.company;

public class Constants {
    protected static final int  NUM_PLAYERS = 4;

    public static final int MAIN_SQUARES = 52;

    public static final int NUM_MID_SQUARES =7;

    public enum COLOURS {GREEN, YELLOW, RED, BLUE}

    protected static final int PLAYER_PIECES = 4;

    public static int [][] STARTING_POS = new int [][] {{105,160,215,160,105,160,215,160,695,640,590,640,695,640,590,640},{160,215,160,105,640,585,640,695,160,215,160,105,640,585,640,695}};

    public static double [] WHITE_SQUARES_X = new double[] {25, 78.571428, 132.1428566, 185.7142846, 239.2857126, 292.8571406, 346.4285686, 400, 453.571248, 507.142676, 560.714104, 614.285532, 667.85696, 721.428208, 775};

    public static double [] WHITE_SQUARES_Y = new double [] {25, 78.571428, 132.1428566, 185.7142846, 239.2857126, 292.8571406, 346.4285686, 400, 453.571248, 507.142676, 560.714104, 614.285532, 667.85696, 721.428208, 775};

    public static int[] startIndexes = {0, 4, 8, 12};

    public static int[] finalIndexes = {3, 7, 11, 15};

    public static int[] startSquares = {1, 40, 14, 27};
}
