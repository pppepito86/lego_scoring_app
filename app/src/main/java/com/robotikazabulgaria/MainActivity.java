package com.robotikazabulgaria;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    int morePoints =0;
    String teamName;
    String teamId;
    String id;
    int matchRound;
    int table;
    AlertDialog backAlert1 ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);//...mani mani ok moze da go nabutam v dqsno sreshtu texta
        //dai az shte si poigraq s tova po nqkoe vreme/i da vidim kakvo dr ima da se pravi
        //vijdash li kak cifrite na spinnera ne sa podredeni edna pod druga
        // moje li spinnera da e dqsno centered i cifrite da sa podredeni
        //to tva e zaradi imeto ne predishnoto ama tr da go izmislim tva e gadno da moze da napravim tekta da e do malko predi spinnera
        //abe tva ne e li poneje spinnera na nqkoi e s cifri <9 a na drugi ima 10,11 i gi centrira mau da
        //dai togava tiq deto imat po 2 cifri da gi centrirame  ama nie ako go centrirame shte mrydnem i strelkichkite togava neshto takova
        //abe poigrai si sys score lentata, s spinner alignmenta i s designa kato cqlo
        //napravi go kakto ti haresva, ok
        //primerno kartinkata ne e centered vyv view-to ami e bottom syshto moje da se poigrae i s neq
        //i mislq 4e za sega tova e ok, razcykai malko, ako imash vyprosi pitai, ili ako imash neshto prashtai
        // az shte razgledam title bara predimno i taka emi ok ako neshto ne si ok kaji stava samo deto moze prez sedmicata da ne mu obryshtam mn vnimanie
        //emi kogato imash vreme ;) ok iii abe aide shte vidq neshto gitrepo da napravq 4e da go imame koda nqkyde ama po-natatyk
        //za sega sme si ok  (y) smi super aide leka za sega leka
        //list view da se namalqt elementite
        //zavisimost mezdu spinnerite za boklucite

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        Intent intent=getIntent();
        teamName=intent.getStringExtra("name");
        teamId=intent.getStringExtra("teamId");
        id=intent.getStringExtra("id");
        matchRound=intent.getIntExtra("round", 1);
        table=intent.getIntExtra("table", 1);
        TextView textViewName= (TextView) findViewById(R.id.ttt);
        textViewName.setText(teamName);
        TextView round= (TextView) findViewById(R.id.roundNumber);
        round.setText(matchRound + "");
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

        final Button delete=(Button) findViewById(R.id.reset);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setMessage("Сигурни ли сте че искате да качите данните и да загубите прогреса си до сега?");
                builder.setCancelable(true);

                builder.setPositiveButton("Да", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                Missions.reset();
                                finish();
                            }
                        });

                builder.setNegativeButton("Не", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });

                AlertDialog alert = builder.create();
                alert.show();
            }
        });
        ImageView back= (ImageView) findViewById(R.id.backButton);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backAlert.show();
            }
        });
    }

    static AlertDialog alertDialog;
    static void showGarbageAlert(Context context) {
        if (alertDialog!=null) {
            if (alertDialog.isShowing()) {
                return;
            } else {
                alertDialog = null;
            }
        }
        alertDialog = new AlertDialog.Builder(context).create();
        alertDialog.setTitle("Предупреждение");
        alertDialog.setMessage("Превишавате максималния брой боклуци на полето");
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
            showGarbageAlert(this);
        }
    }
    @Override
    public void onBackPressed() {
        backAlert1.show();
    }

    public void showPoints() {
        int points = 0;
        for (Mission mission: Missions.getMissions()) {
            points += mission.lastState*mission.points;
            points +=morePoints;
        }
        TextView score=(TextView) findViewById(R.id.scoreId);
        score.setText(points+"/501");
    }
}
