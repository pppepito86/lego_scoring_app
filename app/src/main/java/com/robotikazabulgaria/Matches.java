package com.robotikazabulgaria;

public class Matches {
    private static Match[] matches;

    public static Match[] getMatches() {
        if (matches == null) {
            loadMatches();
        }
        return matches;
    }

    private static void loadMatches(){
        //matches = new Match[0];
        matches = RestClient.getMatches();
    }

}
