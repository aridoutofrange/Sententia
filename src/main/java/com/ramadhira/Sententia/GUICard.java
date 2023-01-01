package com.ramadhira.Sententia;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundSize;

public class GUICard {
    private VBox pane;
    private Label title, img;
    public GUICard(String title, String img) {
        this.title = new Label(title);
        this.img = new Label();
        this.img.setBackground(new Background(new BackgroundImage(new Image(getClass().getResourceAsStream(img)), null, null, null, new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, true, true, false, true))));
        this.img.setPrefHeight(400);
        this.img.setPrefWidth(300);
        this.pane = new VBox(this.title, this.img);
        this.pane.setSpacing(20);
        this.pane.setPrefHeight(600);
        this.pane.setPrefWidth(300);
        this.pane.setStyle("-fx-border-color: #5a3d28;-fx-border-radius: 7 7 7 7;-fx-background-radius: 7 7 7 7;-fx-background-color: #f2c26d;");

        this.pane.setAlignment(Pos.CENTER);   

    }
    public VBox getGUI(){return pane;}
}
