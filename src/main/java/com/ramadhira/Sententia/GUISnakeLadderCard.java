package com.ramadhira.Sententia;

import javafx.scene.control.Label;

public class GUISnakeLadderCard {
    private Label parent;
    public GUISnakeLadderCard(String icon,String color){
        parent = new Label(icon);
        parent.setPrefHeight(30);
        parent.setPrefWidth(30);
        parent.setStyle("-fx-border-color: black;-fx-border-radius: 7 7 7 7;-fx-background-radius: 7 7 7 7;-fx-background-color: "+color+";");
    }
    public Label getGUI(){return parent;}
}
