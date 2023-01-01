package com.ramadhira.Sententia;

import javafx.scene.Parent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

import java.util.Vector;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;

public class GUIGame {
    private Color[] tileColors = {Color.web("#d7ebf4"),Color.web("#a5bccb")};

    private Label initialSquare = new Label();

    private Label backButton;
    private Label diceButton, dice;

    private HBox pane,boardPane,dicePane;
    private VBox statePane;
    private StackPane board;
    private GameBoard gameBoard;

    public GUIGame(){
        Vector<Character> characters = new Vector<Character>();
        // characters.add(new Character());
        // characters.add(new CharacterFAXXIV());
        int[][] snakeLadder = {
            {11,1}
        };

        initialSquare.setPrefHeight(50);
        initialSquare.setPrefWidth(100);
        initialSquare.setBackground(new Background(new BackgroundFill(Color.web("#f2c26d"),CornerRadii.EMPTY,Insets.EMPTY)));
        initialSquare.setTranslateX(-100);
        initialSquare.setTranslateY(0);


        gameBoard = new GameBoard(characters,snakeLadder);
        Parent[] squares = new Parent[gameBoard.tiles.length];
        for(Tile tile : gameBoard.tiles){
            int position = tile.position;
            Label square = new Label(String.valueOf(position));
            square.setBackground(new Background(new BackgroundFill((position+((position-1)/10))%2 == 0 ? tileColors[1]:tileColors[0],CornerRadii.EMPTY,Insets.EMPTY)));
            square.setTextFill(Color.BLACK);
            square.setPrefHeight(49);
            square.setPrefWidth(49);
            square.setTranslateX((50*((position-1)%10))+1);
            square.setTranslateY((50*((position-1)/10)*-1)+-1);
            squares[position - 1] = square;
            square.setAlignment(Pos.TOP_LEFT);
        }
        
        board = new StackPane();
        board.setPrefWidth(500);
        board.setMaxHeight(500);
        board.setAlignment(Pos.BOTTOM_LEFT);
        board.setBackground(new Background(new BackgroundFill(Color.BLACK,CornerRadii.EMPTY,Insets.EMPTY)));
        board.getChildren().addAll(squares);
        board.getChildren().add(initialSquare);

        boardPane = new HBox(board);
        boardPane.setPrefWidth(750);
        boardPane.setAlignment(Pos.CENTER);
        boardPane.setPadding(new Insets(75, 0, 75, 0));

        backButton = new GUIBackButton().getGUI();
        backButton.setOnMouseClicked(new EventHandler<MouseEvent>() { 
            @Override 
            public void handle(MouseEvent e) { 
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setContentText("Back");
                alert.show();
            }
        });
        diceButton = new GUIDiceButton().getGUI();
        dice = new GUIDice(6).getGUI();

        dicePane = new HBox(dice);
        dicePane.setAlignment(Pos.CENTER);
        dicePane.setPrefHeight(300);
        dicePane.setPrefWidth(250);

        statePane = new VBox(backButton,dicePane,diceButton);
        statePane.setPrefWidth(350);
        statePane.setSpacing(50);
        statePane.setAlignment(Pos.CENTER);
        statePane.setBackground(new Background(new BackgroundFill(Color.web("#9dbac4",0.6),CornerRadii.EMPTY,Insets.EMPTY)));
        
        pane = new HBox(boardPane,statePane);
        pane.setBackground(new Background(new BackgroundImage(new Image(getClass().getResourceAsStream("bg.jpg")), null, null, null, new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, true, true, false, true))));

        
        
    }
    public Parent getGUI(){return pane;}
}
