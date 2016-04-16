package com.robotikazabulgaria;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    int morePoints =0;

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

        final ListView listview = (ListView) findViewById(R.id.listview);

        listview.setAdapter(new ListAdapter(this));

        final Button delete=(Button) findViewById(R.id.reset);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Missions.reset();
                showPoints();

                ListView listView = (ListView) findViewById(R.id.listview);
                listView.invalidateViews();
            }
        });
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
