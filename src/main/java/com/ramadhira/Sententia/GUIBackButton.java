package com.ramadhira.Sententia;

import javafx.geometry.Pos;
import javafx.scene.control.Label;

public class GUIBackButton {
    public Label parent;
    public GUIBackButton(){
        parent = new Label("BACK");
        parent.setPrefHeight(40);
        parent.setPrefWidth(150);
        parent.setAlignment(Pos.CENTER);
        parent.setStyle("-fx-border-color: #5a3d28;-fx-border-radius: 7 7 7 7;-fx-background-radius: 7 7 7 7;-fx-background-color: #f2c26d;");
        // parent.setStyle("fx-background-color:#f2c26d;fx-border-color:#5a3d28;");
    }
    public Label getGUI(){return parent;}
    
}
