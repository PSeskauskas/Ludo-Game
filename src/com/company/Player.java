package com.company;

import javafx.scene.paint.Color;

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
}
