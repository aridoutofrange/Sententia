package com.ramadhira.Sententia;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundSize;

public class GUIDiceButton {
    private Label parent;
    public GUIDiceButton(){
        parent = new Label();
        parent.setPrefHeight(40);
        parent.setPrefWidth(40);
        parent.setBackground(new Background(new BackgroundImage(new Image(getClass().getResourceAsStream("dice1.jpg")), null, null, null, new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, true, true, false, true))));
    }
    public Label getGUI(){return parent;}

    
}
