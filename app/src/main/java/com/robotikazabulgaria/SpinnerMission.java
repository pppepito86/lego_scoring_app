package com.robotikazabulgaria;

/**
 * Created by Bobi Mitov on 16.4.2016 г..
 */
public class SpinnerMission extends Mission {

    String[] values;

    public SpinnerMission(String id, String n, String[] v, int p, int i) {
        this(id, n,v,p,0,i);
    }
    public SpinnerMission(String n, String[] v, int p, int i) {
        this("к", n,v,p,0,i);
    }
    public SpinnerMission( String n, String[] v, int p,int l ,int i) {
        this("к", n,v,p,l,i);
    }

    public SpinnerMission(String id, String n, String[] v, int p, int l, int i) {
        super(id, n, p, l, i);
        values = v;
        //sq shte ti pokaja neshto

    }
}
