package com.robotikazabulgaria;

/**
 * Created by Bobi Mitov on 16.4.2016 г..
 */
public class SpinnerMission extends Mission {

    String[] values;

    public SpinnerMission(String n, String[] v, int p, int i) {
        this(n,v,p,0,i);
    }

    public SpinnerMission(String n, String[] v, int p, int l, int i) {
        super(n, p, l, i);
        values = v;
        //sq shte ti pokaja neshto

    }
}
