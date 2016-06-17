package com.robotikazabulgaria;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ListAdapterTeams extends BaseAdapter {

    private TeamsPageActivity context;
    private Match[] matches;
    private Match[] origMatches;

    private static LayoutInflater inflater = null;
    String table="table.txt";

    public ListAdapterTeams(TeamsPageActivity teamsPage, Match[] matches) {
        context = teamsPage;
        this.origMatches = matches;
        this.matches = matches;
        inflater = (LayoutInflater) context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        readTable();
    }

    public  void readTable(){
        String data="";
        try {
            //FileInputStream fio=openFileInput(file);
            InputStream instream = context.openFileInput(table);
            InputStreamReader inp = new InputStreamReader(instream);;
            BufferedReader buffreader = new BufferedReader(inp);
            try {

                data= buffreader.readLine();

            } catch (IOException e) {

            }
        } catch (FileNotFoundException e2) {

        }
        setTable(data);
    }

    public void setTable(String n){
        int tableId = 0;
        try {
            tableId = Integer.parseInt(n);
        }catch (NumberFormatException e) {

        }
        List<Match> list = new ArrayList<>();
        for (Match match:origMatches) {
            if(match.getTable() == tableId) list.add(match);
        }
        matches=list.toArray(new Match[list.size()]);
        context.mMatches = matches;
    }

    @Override
    public int getCount() {
        return matches.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
    TextView name;
    @Override
    public View getView(final int position, final View convertView, ViewGroup parent) {
        Match match = matches[position];
        View rowView = inflater.inflate(R.layout.team, null);
        TextView id=(TextView) rowView.findViewById(R.id.teamId);
        id.setText(match.getTeam().getId());
        name=(TextView) rowView.findViewById(R.id.teamName);
        name.setText(match.getTeam().getName());

        if (context.o[position] == '0') {
            name.setTextColor(0xffff0000);
        }else{
            name.setTextColor(0xff00ff00);
        }
        TextView round=(TextView) rowView.findViewById(R.id.round);
        round.setText(match.getRound()+"");
        return rowView;
    }


    @Override
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
    }

}
