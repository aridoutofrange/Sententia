package com.ramadhira.Sententia;

import java.util.Random;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class GameBoard {
	public static final int ROWS = 10;
	public static final int COLS = 10;
	public static final int WIN_POINT = 100;
	public static final int DICE_ROLL_DELAY = 1;
	public static final int COMPUTER_MOVE_DELAY = 2;
	public static final int PLAYER_STARTING_POSITION = 0;

	public Tile[] tiles;
    public int turn = 0;
    public int latestDice;
	
	public GameBoard() {

        // set computer
        if(App.gameMode == EnumGameMode.AGAINST_COMPUTER){

            Random rn = new Random();
            int ic = 0;
            int cmp = rn.nextInt(2);
            for(Character c : App.characters){
                if(!c.equals(App.players[0]) && ic == cmp){
                    App.players[1] = c;
                    break;
                }
                if(!c.equals(App.players[0]))ic++;
            }
        }

        // set tiles and its snakeladder
        tiles = new Tile[ROWS*COLS];
        int[][] snakeLadder = App.diff == 0 ? App.snakeLadderEasy : App.diff == 1 ? App.snakeLadderMedium : App.snakeLadderHard;
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
        Random rn = new Random();
        Character ple = App.players[player];
        int dice = rn.nextInt(6)+1;
        latestDice = dice;

        boolean move = true;
        while(App.players[player].position != 100 && move){

            App.players[player].move(dice);
    
            // register each skill of characters
            if(ple.streak.size() == 2 && ple.streak.get(ple.streak.size()-1) && ple.name.equals("Ralune") && ple.isCanUsePassiveCharacter){
                App.players[player].position = ple.position + 10;
                App.players[player].isCanUsePassiveCharacter = false;
            }
    
            //tile rules
            Tile tile=tiles[ple.position-1];
            if(tile.snakeLadder!=null){
                int[] sl = tile.snakeLadder;
                if((sl[0]>sl[1]&&ple.isCanUseSnake) || (sl[0]<sl[1]&&ple.isCanUseLadder)){
                    App.players[player].position = sl[1];
                }
            }
            move = false;
        }
        if(App.players[player].position == 100 ){
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setContentText(App.players[player].name + " win the game");
            alert.show();
            try{
                App.setRoot(new GUIMainMenu().getGUI());
            }catch(Exception e){System.out.println(e);}
        }
    }

    public int getTurn(){
        turn++;
        if(App.players[turn%2].skipTurn>0){ 
            App.players[turn%2].skipTurn = App.players[turn%2].skipTurn -1;
            turn++;
        }
        return turn%2;
    }
}
