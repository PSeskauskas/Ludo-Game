package com.company;

public class Constants {
    protected static final int  NUM_PLAYERS = 4;

    public static final int MAIN_SQUARES = 52;

    public static final int NUM_MID_SQUARES = 6;

    public enum COLOURS {GREEN, YELLOW, RED, BLUE}

    protected static final int PLAYER_PIECES = 4;

    public static int [][] STARTING_POS = new int [][] {{105,160,215,160,105,160,215,160,695,640,590,640,695,640,590,640},{160,215,160,105,640,585,640,695,160,215,160,105,640,585,640,695}};

    public static double [] WHITE_SQUARES_X = new double[] {25, 78.571428, 132.1428566, 185.7142846, 239.2857126, 292.8571406, 346.4285686, 400, 453.571248, 507.142676, 560.714104, 614.285532, 667.85696, 721.428208, 775};

    public static double [] WHITE_SQUARES_Y = new double [] {25, 78.571428, 132.1428566, 185.7142846, 239.2857126, 292.8571406, 346.4285686, 400, 453.571248, 507.142676, 560.714104, 614.285532, 667.85696, 721.428208, 775};

    public static double [][] GREEN_MID_SQUARES = new double[][] {{78.571428, 400}, {132.1428566, 400}, {185.7142846, 400}, {239.2857126, 400}, {292.8571406, 400}, {346.4285686, 400}};

    public static double [][] YELLOW_MID_SQUARES = new double[][] {{400, 721.4282080}, {400, 667.85696}, {400, 614.285532}, {400, 560.714104}, {400, 507.142676}, {400, 453.571248}};

    public static double [][] RED_MID_SQUARES = new double[][] {{400, 78.571428}, {400, 132.1428566}, {400, 185.7142846}, {400, 239.2857126}, {400, 292.8571406}, {400, 346.4285686}};

    public static double [][] BLUE_MID_SQUARES = new double[][] {{721.428208, 400}, {667.85696, 400}, {614.285532, 400}, {560.714104, 400}, {507.142676, 400}, {453.571248, 400}};

    public static int[] startIndexes = {0, 4, 8, 12};

    public static int[] finalIndexes = {3, 7, 11, 15};

    public static int[] startSquares = {1, 40, 14, 27};
}
