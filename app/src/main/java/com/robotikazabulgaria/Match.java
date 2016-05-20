package com.robotikazabulgaria;

import com.google.gson.annotations.SerializedName;

public class Match {

    @SerializedName("_id")
    private String id;
    private Team team;
    private int round;
    private int table;

    public Match(String id, Team team, int round, int table) {
        this.id = id;
        this.team = team;
        this.round = round;
        this.table = table;
    }

    public int getTable() {
        return table;
    }

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
