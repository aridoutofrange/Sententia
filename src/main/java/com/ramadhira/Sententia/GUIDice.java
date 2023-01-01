package com.ramadhira.Sententia;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundSize;

public class GUIDice {
    private Label parent;
    public GUIDice(int dice){
        parent = new Label();
        parent.setPrefHeight(70);
        parent.setPrefWidth(70);
        parent.setBackground(new Background(new BackgroundImage(new Image(getClass().getResourceAsStream("dice"+dice+".jpg")), null, null, null, new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, true, true, false, true))));
    }
    public Label getGUI(){return parent;}
}
