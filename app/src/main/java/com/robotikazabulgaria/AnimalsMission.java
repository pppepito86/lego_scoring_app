package com.robotikazabulgaria;

public class AnimalsMission extends ExtraSpinnerMission {

    public AnimalsMission(String n, int m, int p, int i) {
        this("k", n, m, p, 0, i);
    }

    public AnimalsMission(String id, String n, int m, int p, int l, int i) {
        super(id, n, m, p, l, i);
    }

    public boolean setLastState(int state) {
        //proverqvame dali e ok
        if (garbageIsOk(state - lastState)) {
            lastState = state;
            return true;
        }
        return false;
    }

    synchronized static boolean garbageIsOk(int diff) {
        int garbageCount = diff;
        for (Mission mission: Missions.getMissions()) {
            if (mission instanceof AnimalsMission) {
                garbageCount += mission.lastState;
            }
        }
        return garbageCount <= 3;
    }

}
