package com.robotikazabulgaria;

public class GarbageMission extends ExtraSpinnerMission {

    public GarbageMission(String n, int m, int p, int i) {
        this(n, m, p, 0, i);
    }

    public GarbageMission(String n, int m, int p, int l, int i) {
        super(n, m, p, l, i);
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
            if (mission instanceof GarbageMission) {
                garbageCount += mission.lastState;
            }
        }
        return garbageCount <= 18;
    }

}
