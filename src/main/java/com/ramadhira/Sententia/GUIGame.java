package com.ramadhira.Sententia;

import javafx.scene.Parent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

import java.util.Vector;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;

public class GUIGame {
    private Color[] tileColors = {Color.web("#d7ebf4"),Color.web("#a5bccb")};

    private Label initialSquare = new Label();

    private HBox pane,boardPane;
    private VBox statePane;
    private StackPane board;
    private GameBoard gameBoard;

    public GUIGame(){
        Vector<Character> characters = new Vector<Character>();
        characters.add(new CharacterRalune());
        characters.add(new CharacterFAXXIV());
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

        
        statePane = new VBox();
        statePane.setPrefWidth(350);
        statePane.setBackground(new Background(new BackgroundFill(Color.GRAY,CornerRadii.EMPTY,Insets.EMPTY)));
        pane = new HBox(boardPane,statePane);
        pane.setBackground(new Background(new BackgroundImage(new Image(getClass().getResourceAsStream("bg.jpg")), null, null, null, new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, true, true, false, true))));
        
    }
    public Parent getGUI(){return pane;}
}
