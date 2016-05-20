package com.robotikazabulgaria;

import android.util.Log;

import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpResponseHandler;

import cz.msebera.android.httpclient.Header;

public class MatchesAsync extends AsyncHttpResponseHandler {

    volatile boolean ready = false;
    Match[] matches;

    public Match[] getMatches() {
        while (!ready) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return matches;
    }

    @Override
    public void onStart() {
        Log.e("lego_scoring_app", "rest send");
    }

    @Override
    public void onSuccess(int statusCode, Header[] headers, byte[] response) {
        Log.e("lego_scoring_app", "response received");

        String json = new String(response);
        Gson gson = new Gson();
        matches = (Match[]) gson.fromJson(json, Match[].class);
        ready = true;
        Log.e("lego_scoring_app", "response read");

    }

    @Override
    public void onFailure(int statusCode, Header[] headers, byte[] errorResponse, Throwable e) {
        Log.e("lego_scoring_app", "request failed");
        ready = true;
    }

    @Override
    public void onRetry(int retryNo) {
    }
}
