package com.robotikazabulgaria;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ListAdapterTeams extends BaseAdapter {

    private TeamsPageActivity context;
    private Match[] matches;
    private static LayoutInflater inflater = null;

    public ListAdapterTeams(TeamsPageActivity teamsPage, Match[] matches) {
        context = teamsPage;
        this.matches = matches;
        inflater = (LayoutInflater) context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
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
        super.notifyDataSetChanged();//<-- v tozi
       //shto.. tva kakvo e? v toq metod mislq che se prerisuva listview-to ne e li samo tochkite da se prerisuvat
    }

}
