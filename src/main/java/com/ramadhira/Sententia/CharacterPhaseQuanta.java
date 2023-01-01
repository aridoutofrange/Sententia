package com.ramadhira.Sententia;

import javafx.scene.Parent;

public class CharacterPhaseQuanta extends Character {
    public String name = "Phase Quanta";
    @Override
    public Parent getGameModel(){
        Parent p = super.getGameModel();
        p.setStyle("-fx-border-color: black;-fx-border-radius: 10 10 10 10;-fx-background-radius: 10 10 10 10;-fx-background-color: #797985;");
        return p;
    }
}
