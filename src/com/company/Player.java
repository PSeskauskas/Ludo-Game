package com.company;

public class Player {
    public Player() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    private Constants.COLOURS colour;

    public Boolean getInPlay() {
        return inPlay;
    }

    public void setInPlay(Boolean inPlay) {
        this.inPlay = inPlay;
    }

    private Boolean inPlay;

    public Boolean getAvailable() {
        return isAvailable;
    }

    public void setAvailable(Boolean available) {
        isAvailable = available;
    }

    private Boolean isAvailable;

    public void setColor(Constants.COLOURS colours) {
        this.colour = colours;
    }

    public Constants.COLOURS getColor() {
        return colour;
    }

    private int piecesInPlay = 0;

    public int getStartSquare() {
        return startSquare;
    }

    public void setStartSquare(int startSquare) {
        this.startSquare = startSquare;
    }

    private int startSquare;

    public int getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }

    private int startIndex;

    public int getFinalIndex() {
        return finalIndex;
    }

    public void setFinalIndex(int finalIndex) {
        this.finalIndex = finalIndex;
    }

    private int finalIndex;

    public void setPiecesInPlay(int piecesInPlay) {
        this.piecesInPlay = piecesInPlay;
    }

    public int getPiecesInPlay() {
        return piecesInPlay;
    }
}
