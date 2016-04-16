package com.robotikazabulgaria;

public class Mission {

    String name;
    String[] values;
    int points;
    int imageId;//ok smqtai tekushtite tochki na baza points i laststate mislq che tr da promenish 3 mesta ok davai ako si razbral da be razbrah
    int lastState;

    public Mission(String n, String[] v, int p, int i) {
        this(n,v,p,0,i);
    }

    public Mission(String n, String[] v, int p, int l, int i) {
        name = n;
        values = v;
        points = p;
        imageId = i;
        lastState=l;
        //sq shte ti pokaja neshto

    }
}
