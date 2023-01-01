package com.ramadhira.Sententia;

import java.util.Vector;

import javafx.scene.Parent;
import javafx.scene.control.Label;

// 1. Ralune (teknisi): 
// Kelebihan = Ketika dadu “6” “6” bisa naik keatas 1 tingkat.

// Kekurangan = Hanya bisa dipake 1 kali pasifnya.

// 2. FA XXIV (pengajar nomad): 
// Kelebihan = Bisa nurunin 1 tingkat ke bawah buat lawan yang injek ditempat dia diem. 

// Kekurangan = gabisa naik tangga kalo lagi di urutan 1

// 3. Phase Quanta (robot): 
// Kelebihan = setiap di angka kelipatan 2 bisa maju 2 kali

// Kekurangan = di angka kelipatan 5 player di skip giliran mainnya
public class Character {
    public String name;
    public String image;
    public EnumPlayerType playerType;
    public String pasiveInformation;
    public int position;
    public boolean isCanUseSnake = true;
    public boolean isCanUseLadder = true;
    public boolean isCanUseCard = true;
    public boolean isCanUsePassiveCharacter = true;
    public int skipTurn;
    public Vector<Boolean> streak;
    public void move(int dice){
        streak.add(dice == 6);
        position = position + dice;
    }

    public Parent getGameModel(){
        Label p = new Label();
        p.setPrefHeight(20);
        p.setPrefWidth(20);
        p.setTranslateX(15);
        p.setTranslateY(-15);
        p.setStyle("-fx-border-color: black;-fx-border-radius: 10 10 10 10;-fx-background-radius: 10 10 10 10;-fx-background-color: black;");
        return p;
    }
}
