package com.ramadhira.Sententia;

import javafx.scene.Parent;

public class CharacterRalune extends Character {
    public String name = "Ralune";
    @Override
    public void move(int dice){
        super.move(dice);
        if(streak.size() == 2 && streak.get(streak.size()-1)==true){
            position = position + 1;
            isCanUsePassiveCharacter = false;
        }
    }
    @Override
    public Parent getGameModel(){
        Parent p = super.getGameModel();
        p.setStyle("-fx-border-color: black;-fx-border-radius: 10 10 10 10;-fx-background-radius: 10 10 10 10;-fx-background-color: #191919;");
        return p;
    }
}
