package com.ramadhira.Sententia;
import java.sql.ResultSet;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.util.Callback;

public class GUILeaderBoard {
    private TableView<ModelLeaderboard> listView = new TableView<ModelLeaderboard>();
    private TableColumn<ModelLeaderboard,String> playerNameColumn = new TableColumn<ModelLeaderboard,String>("Player Name");
    private TableColumn<ModelLeaderboard,Integer> scoreColumn = new TableColumn<ModelLeaderboard,Integer>("Score");

    public GUILeaderBoard() {
        listView.setEditable(true);
        playerNameColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ModelLeaderboard, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<ModelLeaderboard, String> p) {
                return new SimpleStringProperty(p.getValue().playerName);
            }
        });
        scoreColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ModelLeaderboard, Integer>, ObservableValue<Integer>>() {
            @Override
            public ObservableValue<Integer> call(TableColumn.CellDataFeatures<ModelLeaderboard, Integer> p) {
                return new SimpleIntegerProperty(Integer.valueOf(p.getValue().score)).asObject();
            }
        });
        final ObservableList<ModelLeaderboard> items = FXCollections.observableArrayList();
        try{
            ResultSet rs;
            rs = new ModelLeaderboard().search("");
            while(rs.next()) items.add(new ModelLeaderboard(rs.getInt("id")));
        }catch(Exception er){}
        listView.getColumns().addAll(playerNameColumn,scoreColumn);
        listView.setItems(items);
    }
    public TableView<ModelLeaderboard> getGUI(){return listView;}
    
}
