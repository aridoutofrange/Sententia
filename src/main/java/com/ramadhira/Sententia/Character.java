package com.ramadhira.Sententia;

import java.util.Vector;

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
    Label p = new Label();

    public Character(String name,String image,String gameModel){
        p.setPrefHeight(20);
        p.setPrefWidth(20);
        p.setTranslateX(15);
        p.setTranslateY(-15);
        p.setStyle(gameModel);
        this.name = name;
        this.image = image;
        this.pasiveInformation = "";
        this.position = 0;
        this.streak = new Vector<>();
    }

    public void move(int dice){
        streak.add(dice == 6);
        position = position + dice;
    }

    public Label getGameModel(){

        return p;
    }

    public boolean equals(Character c){
        return this.name.equals(c.name);
    }
}
