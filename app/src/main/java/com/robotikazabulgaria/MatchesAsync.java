package com.robotikazabulgaria;

import android.util.Log;
import android.widget.ListView;

import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpResponseHandler;

import cz.msebera.android.httpclient.Header;

public class MatchesAsync extends AsyncHttpResponseHandler {

    private TeamsPageActivity activity;

    public MatchesAsync(TeamsPageActivity activity) {
        this.activity = activity;
    }

    @Override
    public void onStart() {
    }

    @Override
    public void onSuccess(int statusCode, Header[] headers, byte[] response) {
        String json = new String(response);
        Gson gson = new Gson();
        Match[] matches = (Match[]) gson.fromJson(json, Match[].class);
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
