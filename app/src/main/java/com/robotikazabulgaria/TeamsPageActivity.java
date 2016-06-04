package com.robotikazabulgaria;

import android.app.LoaderManager;
import android.content.Intent;
import android.content.Loader;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.loopj.android.http.AsyncHttpClient;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TeamsPageActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor> {
    Match[] mMatches;
    String data="";
    int size;
    private String fileName = "textFile.txt";
    ListView listView;
    MatchesAsync matches;
    String k;
    public char[] o;
    Button reset;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teams_page);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        reset= (Button) findViewById(R.id.reset);
        File file=new File(this.getFilesDir(),"/"+fileName);
     /*   if(file.exists()) {

        }else{
            file=new File(this.getFilesDir(),"/"+fileName);
        }*/
        AsyncHttpClient client = new AsyncHttpClient();
        matches= new MatchesAsync(this);
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i=0;i<80;i++){
                    data+="0";
                    try {
                        FileOutputStream fou = openFileOutput(fileName,MODE_WORLD_READABLE);
                        fou.write(data.getBytes());
                        fou.close();
                    } catch (FileNotFoundException e2) {

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                o=new char[k.length()];
                for(int i=0;i<k.length();i++){
                    o[i]='0';
                }
                if ( ((ListAdapterTeams)((ListView) findViewById(R.id.teamsListView)).getAdapter())!=null) {
                    ((ListAdapterTeams) ((ListView) findViewById(R.id.teamsListView)).getAdapter()).notifyDataSetChanged();
                }
            }
        });

        k="";
        try {
            //FileInputStream fio=openFileInput(file);
            InputStream instream = openFileInput(fileName);
            InputStreamReader inp = new InputStreamReader(instream);;
            BufferedReader buffreader = new BufferedReader(inp);
            try {

                k= buffreader.readLine();

            } catch (IOException e) {

            }
        } catch (FileNotFoundException e2) {
            for(int i=0;i<80;i++){
                data+="0";
                try {
                    FileOutputStream fou = openFileOutput(fileName,MODE_WORLD_READABLE);
                    fou.write(data.getBytes());
                    fou.close();
                } catch (FileNotFoundException e3) {

                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
            o=new char[k.length()];
            for(int i=0;i<k.length();i++){
                o[i]='0';
            }
        }
        client.get("http://www.pesho.org/tables", matches);
        listView= (ListView) findViewById(R.id.teamsListView);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mMatches = matches.getMatches();
                startActivity(position, mMatches[position].getTeam().getName(), mMatches[position].getTeam().getId(), mMatches[position].getId(), mMatches[position].getRound(), mMatches[position].getTable());
            }
        });
    }
//k?? neshtata v faila readable code :D
    //edin red li ima toq fail emi taka go pravih che malko imah proble s zniqta :D
    @Override
    protected void onResume() {
        super.onResume();
        String k = "";
        try {
            //FileInputStream fio=openFileInput(file);
            InputStream instream = openFileInput(fileName);
            InputStreamReader inp = new InputStreamReader(instream);
            BufferedReader buffreader = new BufferedReader(inp);
            try {
                k = buffreader.readLine();
                Log.e("lego_scoring_app", "line is: " + k);
            } catch (IOException e) {
            }
        } catch (FileNotFoundException e2) {

        }
        o=new char[k.length()];
       for(int i =0;i<k.length();i++) {
           o[i] = k.charAt(i);
       }
        if ( ((ListAdapterTeams)((ListView) findViewById(R.id.teamsListView)).getAdapter())!=null) {
            ((ListAdapterTeams) ((ListView) findViewById(R.id.teamsListView)).getAdapter()).notifyDataSetChanged();
        }
    }

    private void startActivity(int position,String name,String teamId,String id,int round,int table) {
        Intent intent=new Intent(this, MainActivity.class);
        intent.putExtra("position",position);
        intent.putExtra("size",mMatches.length);
        intent.putExtra("name", name);
        intent.putExtra("teamId", teamId);
        intent.putExtra("id", id);
        intent.putExtra("round",round);
        intent.putExtra("table", table);
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
