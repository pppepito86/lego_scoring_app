package com.robotikazabulgaria;

public class GarbageMission extends ExtraSpinnerMission {

    public GarbageMission(String n, int m, int p, int i, String inf) {
        this(n, m, p, 0, i, inf);
    }

    public GarbageMission(String n, int m, int p, int l, int i, String inf) {
        super(n, m, p, l, i,inf);
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
