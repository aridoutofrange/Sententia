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
    private Button closeButton = new Button("Close");
    private Button backCharButton = new Button("Back");
    private Button backCreditButton = new Button("Back");
    
    private Label nama1Label = new Label("RAMADHIRA AZZAHRA PUTRI");
    private Label nama2Label = new Label("MOCHAMAD KELVIN FADHILAH");
    private Label nama3Label = new Label("DEBRIYANTI SAFITRI SANTOSO");
    private Label nama4Label = new Label("NURHIKAM");
    private Label nama5Label = new Label("MELISA GALUH PARWATI");
    private Label nama6Label = new Label("VLADIO SADA ARIHTA SEMBIRING");
    
    private VBox pane,formPane, chooseCharacterPane, chooseDiffPane,creditPane;
    private Label chooseCharacterLabel = new Label("Choose Character");

    public GUIMainMenu(){
        formPane = new VBox(titleLabel,startButton,creditButton,closeButton);
        formPane.setSpacing(20);
        formPane.setAlignment(Pos.CENTER);
        formPane.setBackground(new Background(new BackgroundFill(Color.AQUAMARINE,CornerRadii.EMPTY,Insets.EMPTY)));
        formPane.setPrefHeight(250);
        formPane.setPrefWidth(50);

        pane = new VBox(formPane);

        
        chooseCharacterLabel.setStyle("-fx-border-color: #5a3d28;-fx-border-radius: 7 7 7 7;-fx-background-radius: 7 7 7 7;-fx-background-color: #f2c26d;");
        chooseCharacterPane = new VBox(chooseCharacterLabel,backCharButton);

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
        creditButton.addEventHandler(MouseEvent.MOUSE_CLICKED, credit);
        closeButton.addEventHandler(MouseEvent.MOUSE_CLICKED, close);
        backCreditButton.addEventHandler(MouseEvent.MOUSE_CLICKED, backCredit);
        backCharButton.addEventHandler(MouseEvent.MOUSE_CLICKED, backChar);
        
        pane.setBackground(new Background(new BackgroundImage(new Image(getClass().getResourceAsStream("bg.jpg")), null, null, null, new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, true, true, false, true))));
        pane.setPadding(new Insets(150, 200, 150, 200));
        
        creditPane = new VBox(nama1Label,nama2Label,nama3Label,nama4Label,nama5Label,nama6Label,backCreditButton);
        creditPane.setSpacing(20);
        creditPane.setAlignment(Pos.CENTER);
        creditPane.setBackground(new Background(new BackgroundFill(Color.AQUAMARINE,CornerRadii.EMPTY,Insets.EMPTY)));
        creditPane.setPrefHeight(250);
        creditPane.setPrefWidth(220);
        
        nama1Label.setPrefSize(300, 50);;
        nama2Label.setPrefSize(300, 50);
        nama3Label.setPrefSize(300, 50);
        nama4Label.setPrefSize(300, 50);
        nama5Label.setPrefSize(300, 50);
        nama6Label.setPrefSize(300, 50);
        
        
    }
    public Parent getGUI(){return pane;}

    EventHandler<MouseEvent> credit = new EventHandler<MouseEvent>() { 
        @Override 
        public void handle(MouseEvent e) { 
            pane.getChildren().remove(formPane);
            pane.getChildren().add(creditPane);
        }
    };
    
    EventHandler<MouseEvent> backChar = new EventHandler<MouseEvent>() { 
        @Override 
        public void handle(MouseEvent e) { 
            pane.getChildren().remove(chooseCharacterPane);
            pane.getChildren().add(formPane);
        }
    };
    
    EventHandler<MouseEvent> backCredit = new EventHandler<MouseEvent>() { 
        @Override 
        public void handle(MouseEvent e) { 
            pane.getChildren().remove(creditPane);
            pane.getChildren().add(formPane);
        }
    };

    
    EventHandler<MouseEvent> close = new EventHandler<MouseEvent>() { 
        @Override 
        public void handle(MouseEvent e) { 
            pane.getChildren().remove(formPane);
            System.exit(0);
        }
    };
    
    EventHandler<MouseEvent> start = new EventHandler<MouseEvent>() { 
        @Override 
        public void handle(MouseEvent e) { 
            pane.getChildren().remove(formPane);
            pane.getChildren().add(chooseCharacterPane);
        }
    };

}
