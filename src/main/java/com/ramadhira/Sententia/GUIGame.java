package com.ramadhira.Sententia;

import javafx.scene.Parent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.animation.PauseTransition;
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
import javafx.util.Duration;

public class GUIGame {
    private Color[] tileColors = {Color.web("#d7ebf4"),Color.web("#a5bccb")};

    private Label initialSquare = new Label();

    private Label backButton;
    private Label diceButton;

    private HBox pane,boardPane,dicePane;
    private VBox statePane;
    private StackPane board;
    private GameBoard gameBoard;
    private Label p1,p2;
    private Label[] diceLabels = {
        new GUIDice(1).getGUI(),
        new GUIDice(2).getGUI(),
        new GUIDice(3).getGUI(),
        new GUIDice(4).getGUI(),
        new GUIDice(5).getGUI(),
        new GUIDice(6).getGUI(),
    };

    public GUIGame(){

        initialSquare.setPrefHeight(50);
        initialSquare.setPrefWidth(100);
        initialSquare.setBackground(new Background(new BackgroundFill(Color.web("#f2c26d"),CornerRadii.EMPTY,Insets.EMPTY)));
        initialSquare.setTranslateX(-100);
        initialSquare.setTranslateY(0);


        gameBoard = new GameBoard();
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
        diceButton.addEventHandler(MouseEvent.MOUSE_CLICKED, diceAction);

        dicePane = new HBox();
        dicePane.setAlignment(Pos.CENTER);
        dicePane.setPrefHeight(300);
        dicePane.setPrefWidth(250);
        dicePane.getChildren().add(diceLabels[5]);


        statePane = new VBox(backButton,dicePane,diceButton);
        statePane.setPrefWidth(350);
        statePane.setSpacing(50);
        statePane.setAlignment(Pos.CENTER);
        statePane.setBackground(new Background(new BackgroundFill(Color.web("#9dbac4",0.6),CornerRadii.EMPTY,Insets.EMPTY)));
        
        pane = new HBox(boardPane,statePane);
        pane.setBackground(new Background(new BackgroundImage(new Image(getClass().getResourceAsStream("bg.jpg")), null, null, null, new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, true, true, false, true))));
        p1 = new Label();
        p2 = new Label();
        p1 = App.players[0].getGameModel();
        p2 = App.players[1].getGameModel();
        

        p1.setTranslateX(-85);
        p1.setTranslateY(-10);

        p2.setTranslateX(-45);
        p2.setTranslateY(-10);

        board.getChildren().addAll(p1,p2);
        
    }
    public Parent getGUI(){return pane;}


    EventHandler<MouseEvent> diceAction = new EventHandler<MouseEvent>() { 
        @Override 
        public void handle(MouseEvent e) { 
            move();
        }
    };
    public void move(){
        int turn = gameBoard.getTurn();
        // Character tmpCh = App.players.get(turn);
        gameBoard.movePlayer(turn);

        dicePane.getChildren().clear();
        dicePane.getChildren().add(diceLabels[gameBoard.latestDice-1]);
        
        statePane.getChildren().remove(diceButton);

        int pos = App.players[turn].position;
        System.out.println(App.players[turn].name);
        System.out.println(App.players[turn].position);
        if(turn == 0){
            p1.setTranslateX((((pos-1)%10))*50+15);
            p1.setTranslateY(((((pos-1)/10))*50+15)*-1);
        }
        if(turn == 1){
            p2.setTranslateX((((pos-1)%10))*50+15);
            p2.setTranslateY(((((pos-1)/10))*50+15)*-1);
        }
        PauseTransition pause = new PauseTransition(Duration.seconds(1));
        pause.setOnFinished(event -> {
            statePane.getChildren().add(diceButton);
            dicePane.getChildren().clear();;
        });
        pause.play();

        if(App.players[gameBoard.turn%2].playerType != EnumPlayerType.HUMAN){
            statePane.getChildren().remove(diceButton);
            PauseTransition pauseAI = new PauseTransition(Duration.seconds(1));
            pauseAI.setOnFinished(event -> {
                move();
            });
            pauseAI.play();
        }
    }
    
}