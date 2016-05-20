package com.robotikazabulgaria;

import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import cz.msebera.android.httpclient.Header;

public class RestClient {

    public static void sendRequest(final MainActivity context) {
        AsyncHttpClient client = new AsyncHttpClient();
        client.get("https://www.google.com", new AsyncHttpResponseHandler() {

            @Override
            public void onStart() {
                // called before request is started
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] response) {
                // called when response HTTP status is "200 OK"
                Toast.makeText(context, new String(response), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] errorResponse, Throwable e) {
                // called when response HTTP status is "4XX" (eg. 401, 403, 404)
                Toast.makeText(context, "fail", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onRetry(int retryNo) {
                // called when request is retried
                //pomnish li kak se importva jar jar li?kskvo e tva
            }
        });
    }

    public static Match[] getMatches() {
        return new Match[]{
                new Match("12342dfasdf3423", new Team("1000", "kasapin40"), 1, 1),
                new Match("12342dfasdf5555", new Team("1999", "balo"), 1, 2),
                new Match("12342dfasdf5556", new Team("2000", "cyber"), 1, 3)

        };
        /*
        AsyncHttpClient client = new AsyncHttpClient();
        MatchesAsync matches = new MatchesAsync();
        client.get("http://www.pesho.org/tables", matches);
        try {
            Thread.sleep(10000);
        } catch (Exception e){}
        matches.ready = true;
        return matches.getMatches();
        */
    }
}
