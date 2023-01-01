package com.ramadhira.Sententia;
// 1. Ralune (teknisi): 
// Kelebihan = Ketika dadu “6” “6” bisa naik keatas 1 tingkat.

import java.util.Vector;

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
    public String pasiveInformation;
    public int position;
    public boolean isCanUseSnake;
    public boolean isCanUseLadder;
    public boolean isCanUseCard;
    public int skipTurn;
    public Vector<Boolean> streak;
    public void move(int dice){
        streak.add(dice == 6);
        position = position + dice;
    }
}
