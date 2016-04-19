package com.robotikazabulgaria;

/**
 * Created by Bobi Mitov on 16.4.2016 г..
 */
public class SpinnerMission extends Mission {

    String[] values;

    public SpinnerMission(String n, String[] v, int p, int i, String inf) {
        this(n,v,p,0,i,inf);
    }

    public SpinnerMission(String n, String[] v, int p, int l, int i, String inf) {
        super(n, p, l, i, inf);
        values = v;
        //sq shte ti pokaja neshto

    }
}
