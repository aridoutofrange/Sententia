package com.ramadhira.Sententia;

import java.util.Vector;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.image.Image;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundSize;

public class GUIMainMenu {
    private Label titleLabel = new Label("Sententia");
    private Button startButton = new Button("Start"); 
    private Button creditButton = new Button("Credit");
    private VBox pane,formPane, chooseCharacterPane, chooseDiffPane;
    private Label chooseCharacterLabel = new Label("Choose Character");

    public GUIMainMenu(){
        formPane = new VBox(titleLabel,startButton,creditButton);
        formPane.setSpacing(20);
        formPane.setAlignment(Pos.CENTER);
        formPane.setBackground(new Background(new BackgroundFill(Color.AQUAMARINE,CornerRadii.EMPTY,Insets.EMPTY)));
        formPane.setPrefHeight(350);
        formPane.setPrefWidth(500);

        pane = new VBox(formPane);

        
        chooseCharacterLabel.setStyle("-fx-border-color: #5a3d28;-fx-border-radius: 7 7 7 7;-fx-background-radius: 7 7 7 7;-fx-background-color: #f2c26d;");
        chooseCharacterPane = new VBox(chooseCharacterLabel);

        Vector<VBox> characterCards = new Vector<VBox>();
        for(var c : App.characters){
            VBox card = new GUICard(c.name, c.image).getGUI();
            card.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() { 
                @Override 
                public void handle(MouseEvent e) {
                    App.players[0] = c;
                    App.players[0].playerType = EnumPlayerType.HUMAN;
                    pane.getChildren().remove(chooseCharacterPane);
                    try{
                        App.setRoot(new GUIGame().getGUI());                
                    }catch(Exception er){System.out.println(er);}
                }
            });
            characterCards.add(card);
        }
        HBox cardList = new HBox();
        cardList.setSpacing(20);
        cardList.getChildren().addAll(characterCards);
        
        chooseCharacterPane.getChildren().add(cardList);
        chooseCharacterPane.setAlignment(Pos.CENTER);
        chooseCharacterPane.setSpacing(20);
        chooseCharacterPane.setPrefWidth(1000);


        startButton.addEventHandler(MouseEvent.MOUSE_CLICKED, start);
        
        pane.setBackground(new Background(new BackgroundImage(new Image(getClass().getResourceAsStream("bg.jpg")), null, null, null, new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, true, true, false, true))));
        pane.setPadding(new Insets(150, 300, 150, 300));
    }
    public Parent getGUI(){return pane;}

    EventHandler<MouseEvent> start = new EventHandler<MouseEvent>() { 
        @Override 
        public void handle(MouseEvent e) { 
            pane.getChildren().remove(formPane);
            pane.getChildren().add(chooseCharacterPane);
        }
    };

}
