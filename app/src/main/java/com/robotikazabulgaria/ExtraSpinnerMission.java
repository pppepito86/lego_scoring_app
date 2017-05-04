package com.robotikazabulgaria;

public class ExtraSpinnerMission extends SpinnerMission {

    public ExtraSpinnerMission( String n, int m, int p, int i) {
        this("k", n, m, p, 0, i);
    }

    public ExtraSpinnerMission(String id, String n, int m, int p, int l, int i) {
        super(id, n, null, p, l, i);
        values=new String[m+1];
        for(int j=0;j<=m;j++){
            values[j]=""+j;
        }
        values[0]="  0";
    }

}
