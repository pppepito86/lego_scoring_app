package com.robotikazabulgaria;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ListAdapterTeams extends BaseAdapter {
    TeamsPageActivity context;
    private static LayoutInflater inflater = null;

    public ListAdapterTeams(TeamsPageActivity teamsPage) {
        context = teamsPage;
        inflater = (LayoutInflater) context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return Matches.getMatches().length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, final View convertView, ViewGroup parent) {
        final Match match = Matches.getMatches()[position];
        View rowView = inflater.inflate(R.layout.team, null);
        final TextView id=(TextView) rowView.findViewById(R.id.teamId);
        id.setText(match.getTeam().getId());
        final TextView name=(TextView) rowView.findViewById(R.id.teamName);
        name.setText(match.getTeam().getName());
        final TextView round=(TextView) rowView.findViewById(R.id.round);
        round.setText(match.getRound()+"");

        return rowView;
    }


    @Override
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();//<-- v tozi
       //shto.. tva kakvo e? v toq metod mislq che se prerisuva listview-to ne e li samo tochkite da se prerisuvat
    }

}
