/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.code;

import java.util.Random;
/**
 *
 * @author HP
 */
public class Dice {

        Random dadu1 = new Random();
        Random dadu2 = new Random();

    public Dice ( ) {

    }

    public int getDice1(){
        int d1 = (dadu1.nextInt(6)+1)  ;
        return d1;
    }

    public int getDice2(){
        int d2 = (dadu2.nextInt(6)+1);
        return d2;
    }
}