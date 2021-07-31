package com.company;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GameInit {

    static int choice;



    public static int selectPlayers() {
        Stage newWindow = new Stage();
        newWindow.setWidth(300);
        newWindow.setHeight(300);
        newWindow.setTitle("Please select how many players are playing");
        newWindow.setResizable(false);
        Label label = new Label("Select here");

        ComboBox select = new ComboBox();
        select.getItems().add(2);
        select.getItems().add(3);
        select.getItems().add(4);

        Button submit = new Button("Submit");
        submit.setOnAction(e -> {
            choice = (int) select.getValue();
            newWindow.close();
        });

        VBox layout = new VBox(10);
        layout.getChildren().addAll(label, select, submit);
        layout.setAlignment(Pos.CENTER);
        Scene scene = new Scene(layout);
        newWindow.setScene(scene);
        newWindow.showAndWait();
        return choice;
    }
}
