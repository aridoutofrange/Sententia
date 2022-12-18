/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.code;

/**
 *
 * @author Nurhikam
 */
public class Tile {
	
	int value;
	Snake snake;
	Ladder ladder;
	
	public Tile( int value, Snake snake, Ladder ladder )
	{
		this.value = value;
		this.snake = snake;
		this.ladder = ladder;
	}
	
	
}