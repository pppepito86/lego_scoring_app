package com.robotikazabulgaria;

import com.google.gson.annotations.SerializedName;

public class Match {

    @SerializedName("_id")
    private String id;
    private Team team;
    private int round;
    private int table;
    private String color;

    public Match(String id, Team team, int round, int table,String color ) {
        this.id = id;
        this.team = team;
        this.round = round;
        this.table = table;
        this.color=color;
    }

    public int getTable() {
        return table;
    }

    public String getColor() {return color;}

    public void setColor(String color) {this.color = color;}

    public Team getTeam() {
        return team;
    }

    public String getId() {
        return id;
    }

    public int getRound() {
        return round;
    }
}
