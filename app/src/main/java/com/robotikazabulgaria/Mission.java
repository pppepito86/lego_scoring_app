package com.robotikazabulgaria;

public class Mission {

    String id;
    String name;
    int points;
    int imageId;//ok smqtai tekushtite tochki na baza points i laststate mislq che tr da promenish 3 mesta ok davai ako si razbral da be razbrah
    int lastState;

    public Mission(String id, String n, int p, int i) {
        this(id, n,p,0,i);
    }

    public Mission(String id, String n, int p, int l, int i) {
        this.id = id;
        name = n;
        points = p;
        imageId = i;
        lastState=l;
        //sq shte ti pokaja neshto

    }

    public boolean setLastState(int state) {
        lastState = state;
        return true;
    }
}
