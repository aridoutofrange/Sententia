package com.ramadhira.Sententia;

import java.sql.ResultSet;

public class ModelLeaderboard extends Model {
    public String tableName="leaderboard";

    public int id;
    public String playerName;
    public int score;

    public ModelLeaderboard() {}
    public ModelLeaderboard(int id){
        ResultSet res;
        try{
            res = this.search("id = "+id);
            res.next();
            this.id = res.getInt("id");
            this.playerName = res.getString("PlayerName");
            this.score = res.getInt("Score");
        }catch(Exception err){
            System.out.println(err);
        }
    }
}
