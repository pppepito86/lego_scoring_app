package com.robotikazabulgaria;

public class ExtraSpinnerMission extends SpinnerMission {

    public ExtraSpinnerMission(String n, int m, int p, int i , String inf) {
        this(n, m, p, 0, i, inf);
    }

    public ExtraSpinnerMission(String n, int m, int p, int l, int i, String inf) {
        super(n, null, p, l, i, inf);
        values=new String[m+1];
        for(int j=0;j<=m;j++){
            values[j]=""+j;
        }
        values[0]="  0";
    }

}
