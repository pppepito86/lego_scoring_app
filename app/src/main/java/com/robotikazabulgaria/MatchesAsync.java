package com.robotikazabulgaria;

import android.widget.ListView;

import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpResponseHandler;

import cz.msebera.android.httpclient.Header;

public class MatchesAsync extends AsyncHttpResponseHandler {

    private TeamsPageActivity activity;

    public MatchesAsync(TeamsPageActivity activity) {
        this.activity = activity;
    }
    Match[] mMatches;

    public Match[] getMatches() {
        return mMatches;
    }

    @Override
    public void onStart() {
    }

    @Override
    public void onSuccess(int statusCode, Header[] headers, byte[] response) {
        String json = new String(response);
        Gson gson = new Gson();
        Match[] matches = (Match[]) gson.fromJson(json, Match[].class);
        mMatches=matches;
        for(int i=0;i<mMatches.length;i++){
            int n=mMatches[i].getTeam().getId().length();
            for(int j =6;j-n>0;j--){
                mMatches[i].getTeam().setId(mMatches[i].getTeam().getId()+"  ");
            }
        }
        final ListView listview = (ListView) activity.findViewById(R.id.teamsListView);
        listview.setAdapter(new ListAdapterTeams(activity, matches));
    }

    @Override
    public void onFailure(int statusCode, Header[] headers, byte[] errorResponse, Throwable e) {
    }

    @Override
    public void onRetry(int retryNo) {
    }
}
