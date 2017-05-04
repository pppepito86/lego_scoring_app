package com.robotikazabulgaria;

public class DifSpinnerMission extends Mission {

    String[] values;

    public DifSpinnerMission(String id, String n, String[] v, Integer[] p, int i) {
        this(id, n,v,p,0,i);
    }
    public DifSpinnerMission(String n, String[] v, Integer[] p, int i) {
        this("к", n,v,p,0,i);
    }
    public DifSpinnerMission( String n, String[] v, Integer[] p,int l ,int i) {
        this("к", n,v,p,l,i);
    }

    public DifSpinnerMission(String id, String n, String[] v, Integer[] p, int l, int i) {
        super(id, n, p, l, i);
        values = v;
        //sq shte ti pokaja neshto

    }
}
