/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.code;

/**
 *
 * @author Nurhikam
 */

import java.util.*;

public class Main {
	public static void main( String args[] )
	{
		Scanner sc = new Scanner(System.in);
		Board B = new Board();
		int n;
		
		boolean Player1Turn = true;
		B.display();
		System.out.println( "Player1's Current Position = "+B.player1.position );
		System.out.println( "Player2's Current Position = "+B.player2.position );
		while( !B.gameOver() )
		{
			if( Player1Turn )
			{
				Player1Turn = false;
				System.out.println( "Player1's Turn" );
				System.out.println( "To throw dice Enter 1\nTo quit game Enter 0\n" );
				n = sc.nextInt();
				if( n == 1 )
				{
					B.display();
					B.throwDice( "player1" );
				}
				else if( n == 0 )
				{
					System.exit(0);
				}
				else
				{
					System.out.println( "Invalid Response!\n" );
					Player1Turn = true;
				}
			}
			else
			{
				Player1Turn = true;
				System.out.println( "Player2's Turn" );
				System.out.println( "To throw dice Enter 1\nTo quit game Enter 0\n" );
				n = sc.nextInt();
				if( n == 1 )
				{
					B.display();
					B.throwDice( "player2" );
				}
				else if( n == 0 )
				{
					System.exit(0);
				}
				else
				{
					System.out.println( "Invalid Response!" );
					Player1Turn = false;
				}
			}
		}
	}
}