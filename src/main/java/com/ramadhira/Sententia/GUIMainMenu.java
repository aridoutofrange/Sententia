package com.ramadhira.Sententia;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class GUIMainMenu {
    private Label titleLabel = new Label("Sententia");
    private Button startButton = new Button("Start"); 
    private Button creditButton = new Button("Credit");
    private VBox pane,formPane;
    public GUIMainMenu(){
        formPane = new VBox(titleLabel,startButton,creditButton);
        formPane.setSpacing(20);
        formPane.setAlignment(Pos.CENTER);
        formPane.setBackground(new Background(new BackgroundFill(Color.AQUAMARINE,CornerRadii.EMPTY,Insets.EMPTY)));
        formPane.setPrefHeight(350);
        formPane.setPrefWidth(500);
        
        pane = new VBox(formPane);
        pane.setPadding(new Insets(150, 300, 150, 300));
    }
    public Parent getGUI(){return pane;}
}
