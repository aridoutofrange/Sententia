package com.ramadhira.Sententia;

import java.util.Vector;


public class GameBoard {
	public static final int ROWS = 10;
	public static final int COLS = 10;
	public static final int WIN_POINT = 100;
	public static final int DICE_ROLL_DELAY = 1;
	public static final int COMPUTER_MOVE_DELAY = 2;
	public static final int PLAYER_STARTING_POSITION = 0;

    public Vector<Character> players;
	public Tile[] tiles;
    public int currentPlayer;
	
	public GameBoard(Vector<Character> players,int[][] snakeLadder) {
        this.players = players;
        tiles = new Tile[ROWS*COLS];
        for (int i = 0; i < (ROWS*COLS); i++) {
            boolean isHasSL = false;
            for(int[] sl : snakeLadder){
                if(sl[0] == i + 1){
                    isHasSL = true;
                    tiles[i] = new Tile(i+1, sl);
                    break;
                }
            }
            if(!isHasSL) tiles[i] = new Tile(i+1,null);
        }
	}
    public void movePlayer(int player) {

    }

    // public void buffPlayer(Character player,int changes, int type, String buffName){
    //     if(buffName.equals("position"))
    // }
}
