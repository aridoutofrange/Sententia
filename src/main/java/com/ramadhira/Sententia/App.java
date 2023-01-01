package com.ramadhira.Sententia;

import java.util.Vector;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {
    public static Vector<Character> characters;
    public static Character player1;
    public static Character player2;
    public static int diff = 0;

    public static Scene scene;

    @Override
    public void start(Stage stage) {
        characters = new Vector<Character>();
        characters.add(new Character("FA XXIV","charfaxxiv.png","-fx-border-color: black;-fx-border-radius: 10 10 10 10;-fx-background-radius: 10 10 10 10;-fx-background-color: #006bd5;"));
        characters.add(new Character("Phase Quanta","charpq.png","-fx-border-color: black;-fx-border-radius: 10 10 10 10;-fx-background-radius: 10 10 10 10;-fx-background-color: #797985;"));
        characters.add(new Character("Ralune","charralune.png","-fx-border-color: black;-fx-border-radius: 10 10 10 10;-fx-background-radius: 10 10 10 10;-fx-background-color: #191919;"));
        
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