package com.robotikazabulgaria;

import android.app.LoaderManager;
import android.content.Intent;
import android.content.Loader;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.loopj.android.http.AsyncHttpClient;

public class TeamsPageActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor> {
   Match[] mMatches;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teams_page);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        AsyncHttpClient client = new AsyncHttpClient();
        final MatchesAsync matches = new MatchesAsync(this);
        client.get("http://www.pesho.org/tables", matches);
        ListView listView= (ListView) findViewById(R.id.teamsListView);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mMatches=matches.getMatches();
                //Toast.makeText(TeamsPageActivity.this, mMatches[position].getTeam().getName(),Toast.LENGTH_SHORT).show();
                startActivity(mMatches[position].getTeam().getName(),mMatches[position].getTeam().getId(),mMatches[position].getId(),mMatches[position].getRound(),mMatches[position].getTable() );

            }
        });
    }

    private void startActivity(String name,String teamId,String id,int round,int table) {
        Intent intent=new Intent(this, MainActivity.class);
        intent.putExtra("name",name);
        intent.putExtra("teamId",teamId);
        intent.putExtra("id",id);
        intent.putExtra("round",round);
        intent.putExtra("table",table);
        startActivity(intent);
    }

    public Loader<Cursor> onCreateLoader(int loaderID, Bundle bundle) {
        return null;
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {

    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {

    }
}
