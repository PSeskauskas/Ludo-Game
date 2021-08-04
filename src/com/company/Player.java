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

    private Color color;

    public void setColor(Constants.COLOURS colours) {
        if(colours == Constants.COLOURS.RED) {
            this.color = Color.RED;
        } else if(colours == Constants.COLOURS.BLUE) {
            this.color = Color.BLUE;
        } else if(colours == Constants.COLOURS.GREEN) {
            this.color = Color.GREEN;
        } else if(colours == Constants.COLOURS.YELLOW) {
            this.color = Color.YELLOW;
        }
    }

    public Color getColor() {
        return color;
    }
}
