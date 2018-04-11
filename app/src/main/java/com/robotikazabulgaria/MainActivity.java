package com.robotikazabulgaria;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


public class MainActivity extends AppCompatActivity {

    int morePoints =0;
    String teamName;
    String teamId;
    String id;
    int matchRound;
    int table;
    int size;
    int position;
    AlertDialog backAlert1 ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);//...mani mani ok moze da go nabutam v dqsno sreshtu texta


        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
      /*  try {
            FileOutputStream fou = openFileOutput(file, MODE_WORLD_READABLE);
            fou = null;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }*/
        getData();
        final ListView listview = (ListView) findViewById(R.id.listview);
        listview.setAdapter(new ListAdapter(this));

        AlertDialog.Builder backBuilder = new AlertDialog.Builder(MainActivity.this);
        backBuilder.setMessage("Сигурни ли сте че искате да излезнете и да загубите прогреса си до сега?");
        backBuilder.setCancelable(true);

        backBuilder.setPositiveButton("Да", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Missions.reset();
                        finish();
                    }
                });

        backBuilder.setNegativeButton("Не", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

        final AlertDialog backAlert = backBuilder.create();
        backAlert1=backAlert;

        ImageView back= (ImageView) findViewById(R.id.backButton);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backAlert.show();
            }
        });
    }

    static AlertDialog alertDialog;
    static void showObjectsAlert(Context context,String type) {
        if (alertDialog!=null) {
            if (alertDialog.isShowing()) {
                return;
            } else {
                alertDialog = null;
            }
        }
        alertDialog = new AlertDialog.Builder(context).create();
        alertDialog.setTitle("Предупреждение");
        if(type=="animals"){
            alertDialog.setMessage("Превишавате максималния брой чиста вода на полето");
        }else{
            alertDialog.setMessage("Превишавате максималния брой чиста вода на полето");
        }

        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        alertDialog = null;
                        dialog.dismiss();
                    }
                });
        alertDialog.show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (alertDialog != null) {
            alertDialog = null;
            showObjectsAlert(this, "animals");
        }
    }
    @Override
    public void onBackPressed() {
        backAlert1.show();
    }

    public void showPoints() {
        int points = 0;
        for (Mission mission: Missions.getMissions()) {
            if(mission instanceof DifSpinnerMission){
                points += mission.difPoints[mission.lastState];
            }else {
                points += mission.lastState * mission.points;

            }
            points += morePoints;
        }
        TextView score=(TextView) findViewById(R.id.scoreId);
        score.setText(points+"/730");
    }
    String k1="0";
    String k="";
    int i=0;
    private String file = "textFile.txt";
    private String data = "";
    private String[] all;
    String test="";
    public void manageFile(int n) {
        try {
            //FileInputStream fio=openFileInput(file);
            InputStream instream = openFileInput(file);
            InputStreamReader inp = new InputStreamReader(instream);;
            BufferedReader buffreader = new BufferedReader(inp);
            try {

                k1= buffreader.readLine();

                //

            } catch (IOException e) {}
        } catch (FileNotFoundException e2) {

        }
        k="";
        for(int i=0;i<size;i++) {
            if(i==n){
                k+="1";
            }else {
                k += k1.charAt(i) + "";
            }

        }
        for(int i=0;i<size;i++){
            data+=k.charAt(i) + "";
        }

        try {
            FileOutputStream fou = openFileOutput(file,MODE_WORLD_READABLE);
            fou.write(data.getBytes());
            fou.close();
        } catch (FileNotFoundException e2) {

        } catch (IOException e) {
            e.printStackTrace();
        }



    }

    public void saveData(){
        try {
            FileOutputStream fou = openFileOutput("match_"+id,MODE_WORLD_READABLE);
            StringBuilder sb = new StringBuilder();
            for (Mission mission: Missions.getMissions()) {
                sb.append(mission.points * mission.lastState);
                sb.append(",");
            }
            sb.deleteCharAt(sb.length()-1);
            fou.write(sb.toString().getBytes());
            fou.close();
        } catch (FileNotFoundException e3) {

        } catch (IOException e1) {
            e1.printStackTrace();
        }

    }

    public void getData(){
        String data=null;
        try {
            //FileInputStream fio=openFileInput(file);
            InputStream instream = openFileInput("match_"+id);
            InputStreamReader inp = new InputStreamReader(instream);;
            BufferedReader buffreader = new BufferedReader(inp);
            try {

                data= buffreader.readLine();

            } catch (IOException e) {

            }
        } catch (FileNotFoundException e2) {

        }
        if(data!=null){
            String[] points= data.split(",");
            Mission[] missions=Missions.getMissions();
            for(int i =0;i<points.length;i++){
                missions[i].lastState=Integer.parseInt(points[i])/missions[i].points;
            }
        }
    }


}
