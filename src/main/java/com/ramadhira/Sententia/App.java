package com.ramadhira.Sententia;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {
    public static Character[] characters;
    public static Character[] players;
    public static int diff;
    public static EnumGameMode gameMode = EnumGameMode.AGAINST_COMPUTER;
    public static int[][] snakeLadderEasy = {
        {15,5},
        {45,35},
        {8,89},
        {19,60},
        {45,99},
    };
    public static int[][] snakeLadderMedium = {
        {15,5},
        {45,25},
        {55,25},
        {92,40},
        {69,71},
        {45,51},
        {88,97},
    };
    public static int[][] snakeLadderHard = {
        {97,5},
        {69,2},
        {50,30},
        {40,20},
        {70,19},
        {8,89},
        {19,60},
        {45,99},
        {89,92},
    };

    public static Scene scene;

    @Override
    public void start(Stage stage) {
        characters = new Character[3];
        players = new Character[2];
        characters[0] = new Character("FA XXIV","charfaxxiv.png","-fx-border-color: black;-fx-border-radius: 10 10 10 10;-fx-background-radius: 10 10 10 10;-fx-background-color: #006bd5;",0);
        characters[1] = new Character("Ralune","charralune.png","-fx-border-color: black;-fx-border-radius: 10 10 10 10;-fx-background-radius: 10 10 10 10;-fx-background-color: #191919;",1);
        characters[2] = new Character("Phase Quanta","charpq.png","-fx-border-color: black;-fx-border-radius: 10 10 10 10;-fx-background-radius: 10 10 10 10;-fx-background-color: #797985;",2);

        scene = new Scene(new GUIMainMenu().getGUI(), 1100, 650);
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        launch();
    }

    static void setRoot(Parent route) throws Exception {
        scene.setRoot(route);
    }

}