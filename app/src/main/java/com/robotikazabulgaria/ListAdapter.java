package com.robotikazabulgaria;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Arrays;

public class ListAdapter extends BaseAdapter {

    MainActivity context;
    private static LayoutInflater inflater = null;

    public ListAdapter(MainActivity mainActivity) {
        context = mainActivity;
        inflater = (LayoutInflater) context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return Missions.getMissions().length;
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
        context.showPoints();

        final Mission mission = Missions.getMissions()[position];
        View rowView;



        if (mission.values[0].equals("не")) {
            rowView = inflater.inflate(R.layout.list_view, null);
            final CheckBox check = (CheckBox) rowView.findViewById(R.id.checkBox2);
            if (mission.lastState == 1) check.setChecked(true);//sega ? of pak tva s memoryt
            check.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                    if (isChecked) {
                        mission.lastState = 1;
                    } else {
                        mission.lastState = 0;
                    }
                    context.showPoints();
                }
            });
        } else {
            Log.e("lego", position + " " + Arrays.toString(mission.values) + " " + mission.lastState);
            rowView = inflater.inflate(R.layout.list_view2, null);
            final Spinner spinner = (Spinner) rowView.findViewById(R.id.spinner);
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(context, R.layout.spinner_textview, mission.values);
            adapter.setDropDownViewResource(R.layout.spinner_textview);
            spinner.setAdapter(adapter);
            spinner.setSelection(mission.lastState);
            spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    mission.lastState = position;
                    context.showPoints();
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {
                }
            });
        }



        TextView text = (TextView) rowView.findViewById(R.id.text);
        ImageView image = (ImageView) rowView.findViewById(R.id.image);
        text.setText(mission.name);


//ok de shte go vidq posle tova
        // gore deto pishe lego mi e interesno moje li vdqsno da slojim edno log na sap mai moze dai da go vidim tva

        image.setImageBitmap(ImageUtil.decodeSampledBitmapFromResource(context.getResources(), mission.imageId, 100, 60));
        // teksta iskam da e left centered kato sybirane na plastmasovi otpadyci, drugite da sa syshto tolkova blizo do kartinkata vsichki da pochvat ot kartinkata li?
        // da s malko otstoqnie

        return rowView;
    }

    @Override
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();//<-- v tozi
        context.showPoints();//nishto.. tva kakvo e? v toq metod mislq che se prerisuva listview-to ne e li samo tochkite da se prerisuvat
    }


}




/*ImageButton button1 = (ImageButton) rowView.findViewById(R.id.plus);
            ImageButton button2 = (ImageButton) rowView.findViewById(R.id.minus);
            button1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mission.values.length - 1 != mission.lastState) {
                        mission.lastState++;
                        spinner.setSelection(mission.lastState);
                        context.showPoints();
                    }
                }
            });
            button2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mission.lastState != 0) {
                        mission.lastState--;
                        spinner.setSelection(mission.lastState);
                        context.showPoints()
                    }
                }
            });*/
