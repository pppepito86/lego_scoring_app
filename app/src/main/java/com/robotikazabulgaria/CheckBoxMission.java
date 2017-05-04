package com.robotikazabulgaria;

public class CheckBoxMission extends Mission {

    public CheckBoxMission(String id, String n, int p, int i) {
        this(id, n,p,0,i);
    }
    public CheckBoxMission( String n, int p, int i) {
        this("к", n,p,0,i);
    }
    public CheckBoxMission( String n, int p,int l, int i) {
        this("k", n,p,l,i);
    }

    public CheckBoxMission(String id, String n, int p, int l, int i) {
        super(id, n, p, l, i);
        //sq shte ti pokaja neshto

    }

}
