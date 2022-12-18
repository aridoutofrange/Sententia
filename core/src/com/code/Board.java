/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.code;

/**
 *
 * @author Nurhikam
 */
public class Board {
	
	private Tile[][] tile = new Tile[10][10];
	Player player1;
	Player player2;
	Dice dice;
	
	public Board()
	{
		int c = 100;
			for( int j = 0; j<=9; j++ )
			{
				tile[0][j] = new Tile( c, null, null );
				c = c-1;
			}
			
			c = 81;
			for( int j = 0; j<=9; j++ )
			{
				tile[1][j] = new Tile( c, null, null );
				c = c+1;
			}
			
			c = 80;
			for( int j = 0; j<=9; j++ )
			{
				tile[2][j] = new Tile( c, null, null );
				c = c-1;
			}
			
			c = 61;
			for( int j = 0; j<=9; j++ )
			{
				tile[3][j] = new Tile( c, null, null );
				c = c+1;
			}
			
			c = 60;
			for( int j = 0; j<=9; j++ )
			{
				tile[4][j] = new Tile( c, null, null );
				c = c-1;
			}
			
			c = 41;
			for( int j = 0; j<=9; j++ )
			{
				tile[5][j] = new Tile( c, null, null );
				c = c+1;
			}
			
			c = 40;
			for( int j = 0; j<=9; j++ )
			{
				tile[6][j] = new Tile( c, null, null );
				c = c-1;
			}
			
			c = 21;
			for( int j = 0; j<=9; j++ )
			{
				tile[7][j] = new Tile( c, null, null );
				c = c+1;
			}
			
			c = 20;
			for( int j = 0; j<=9; j++ )
			{
				tile[8][j] = new Tile( c, null, null );
				c = c-1;
			}
			
			c = 1;
			for( int j = 0; j<=9; j++ )
			{
				tile[9][j] = new Tile( c, null, null );
				c = c+1;
			}
		
		Player player1 = new Player( 1 );
		this.player1 = player1;
		
		Player player2 = new Player( 1 );
		this.player2 = player2;
		
		Snake snake1 = new Snake( 17, 7 );
		tile[8][3].snake = snake1;
		
		Snake snake2 = new Snake( 64, 60 );
		tile[3][3].snake = snake2;
		
		Snake snake3 = new Snake( 89, 26 );
		tile[1][8].snake = snake3;
		
		Snake snake4 = new Snake( 95, 75 );
		tile[0][5].snake = snake4;
		
		Snake snake5 = new Snake( 99, 78 );
		tile[0][1].snake = snake5;
		
		
		Ladder ladder1 = new Ladder( 4, 14 );
		tile[9][3].ladder = ladder1;
		
		Ladder ladder2 = new Ladder( 20, 38 );
		tile[8][0].ladder = ladder2;
		
		Ladder ladder3 = new Ladder( 28, 84 );
		tile[7][7].ladder = ladder3;
		
		Ladder ladder4 = new Ladder( 51, 67 );
		tile[4][9].ladder = ladder4;
		
		Ladder ladder5 = new Ladder( 63, 81 );
		tile[3][2].ladder = ladder5;
		
		
		Dice dice = new Dice();
		this.dice = dice;
	}
	
	public void display()
	{
		System.out.println( "'=' stands for Ladder's foot" );
		System.out.println( "'*' stands for Snake's Mouth" );
		System.out.println( "" );
		
		for( int i = 0; i<10; i++ )
		{
			for( int j = 0; j<10; j++ )
			{
				if( tile[i][j].snake == null && tile[i][j].ladder == null )
				{
					if( tile[i][j].value == 100 )
						System.out.print( tile[i][j].value+" " );
					else if( tile[i][j].value>=11 && tile[i][j].value<=99  )
						System.out.print( tile[i][j].value+"  " );
					else if( tile[i][0].value == 1 )
						System.out.print( tile[i][j].value+"   " );
				}
				else if( tile[i][j].snake == null && tile[i][j].ladder != null )
				{
						System.out.print( "=   " );
				}
				else if( tile[i][j].snake != null && tile[i][j].ladder == null )
				{
						System.out.print( "*   " );
				}
			}
			System.out.println("");
		}
		System.out.println("");
	}
	
	public boolean gameOver()
	{
		if( this.player1.position == 100 )
		{
			System.out.println( "Congrats! Player1 won!" );
			return true;
		}
		else if( this.player2.position == 100 )
		{
			System.out.println( "Congrats! Player2 won!" );
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public void throwDice( String plyr )
	{
            int d1text= dice.getDice1();
            int d2text= dice.getDice2();
		int d_value = d1text + d2text;
		System.out.println( "Random Dice Value generated =" + d1text +" + "+ d2text+" = "+d_value);
		System.out.println("");
		
		if( plyr.equals("player1") )
		{
			int temp = this.player1.position;
			if( this.player1.position+d_value>100 )
			{
				temp = this.player1.position;
			}
			else
			{
				temp = this.player1.position+d_value;
			}
				
			int i = iIndexOfTile( temp );
			int j = jIndexOfTile( temp );
			if( ( tile[i][j].ladder == null ) && ( tile[i][j].snake == null ) )
			{
				if( ( this.player1.position+d_value ) <= 100 )
					this.player1.position = this.player1.position+d_value;
				System.out.println( "Player1's Current Position = "+this.player1.position );
				System.out.println( "Player2's Current Position = "+this.player2.position );
			}
			else if( ( tile[i][j].ladder != null ) && ( tile[i][j].snake == null ) )
			{
				System.out.println( "Congrats Player1 You Got Ladder" );
				this.player1.position = tile[i][j].ladder.finalPosition;
				System.out.println( "Player1's Current Position = "+this.player1.position );
				System.out.println( "Player2's Current Position = "+this.player2.position );
			}
			else if( ( tile[i][j].ladder == null ) && ( tile[i][j].snake != null ) )
			{
				System.out.println( "Oops! Player1 You Got Snake Bite!" );
				this.player1.position = tile[i][j].snake.finalPosition;
				System.out.println( "Player1's Current Position = "+this.player1.position );
				System.out.println( "Player2's Current Position = "+this.player2.position );
			}
		}
		else if( plyr.equals("player2") )
		{
			int temp = this.player2.position;
			if( this.player2.position+d_value>100 )
			{
				temp = this.player2.position;
			}
			else
			{
				temp = this.player2.position+d_value;
			}
			
			int i = iIndexOfTile( temp );
			int j = jIndexOfTile( temp );
			if( ( tile[i][j].ladder == null ) && ( tile[i][j].snake == null ) )
			{
				if( ( this.player2.position+d_value ) <= 100 )
					this.player2.position = this.player2.position+d_value;
				System.out.println( "Player1's Current Position = "+this.player1.position );
				System.out.println( "Player2's Current Position = "+this.player2.position );
			}
			else if( ( tile[i][j].ladder != null ) && ( tile[i][j].snake == null ) )
			{
				System.out.println( "Congrats Player2 You Got Ladder" );
				this.player2.position = tile[i][j].ladder.finalPosition;
				System.out.println( "Player1's Current Position = "+this.player1.position );
				System.out.println( "Player2's Current Position = "+this.player2.position );
			}
			else if( ( tile[i][j].ladder == null ) && ( tile[i][j].snake != null ) )
			{
				System.out.println( "Oops! Player2 You Got Snake Bite!" );
				this.player2.position = tile[i][j].snake.finalPosition;
				System.out.println( "Player1's Current Position = "+this.player1.position );
				System.out.println( "Player2's Current Position = "+this.player2.position );
			}
		}
	}
	
	private int iIndexOfTile( int x )
	{
		for( int i = 0; i<10; i++ )
		{
			for( int j = 0; j<10; j++ )
			{
				if( this.tile[i][j].value == x )
				{
					return i;
				}
			}
		}
		return -1;
	}
	
	private int jIndexOfTile( int y )
	{
		for( int i = 0; i<10; i++ )
		{
			for( int j = 0; j<10; j++ )
			{
				if( this.tile[i][j].value == y )
				{
					return j;
				}
			}
		}
		return -1;
	}
	
}