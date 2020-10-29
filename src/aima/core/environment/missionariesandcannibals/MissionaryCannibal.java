package aima.core.environment.missionariesandcannibals;

import aima.core.agent.Action;
import aima.core.agent.impl.DynamicAction;

import java.util.Arrays;

public class MissionaryCannibal implements Cloneable {

    public static Action crossRiverM = new DynamicAction("cross One Missionary");
    public static Action crossRiverMM = new DynamicAction("cross Two Missionary");
    public static Action crossRiverMC = new DynamicAction("cross One Missionary And One Cannibal");
    public static Action crossRiverC = new DynamicAction("cross One Cannibals");
    public static Action crossRiverCC = new DynamicAction("cross Two Cannials");
    private int[] state;

    public MissionaryCannibal() {state = new int[] {3, 3, 1};}

    public MissionaryCannibal(int[] state) { state.clone();
        this.state = state.clone();
    }

    public int[] getState() {
        return state;
    }

    public void crossingM() {
        state[0] = state[2] == 0 ? state[0] + 1 : state[0] - 1;
        state[2] = state[2] == 0 ? 1 : 0;
    }

    public void crossingMM() {
        state[0] = state[2] == 0 ? state[0] + 2 : state[0] - 2;
        state[2] = state[2] == 0 ? 1 : 0;
    }

    public void crossingMC() {
        state[0] = state[2] == 0 ? state[0] + 1 : state[0] - 1;
        state[1] = state[2] == 0 ? state[1] + 1 : state[1] - 1;
        state[2] = state[2] == 0 ? 1 : 0;
    }

    public void crossingC() {
        state[1] = state[2] == 0 ? state[1] + 1 : state[1] - 1;
        state[2] = state[2] == 0 ? 1 : 0;
    }

    public void crossingCC() {
        state[1] = state[2] == 0 ? state[1] + 2 : state[1] - 2;
        state[2] = state[2] == 0 ? 1 : 0;
    }

    public boolean canCross(Action action) {
        boolean result = true;
        int mLeft = state[0];
        int mRight = 3-state[0];
        int cLeft = state[1];
        int cRight = 3 - state[1];
        if (action.equals(crossRiverM)) {
            if (state[2] == 1) {
                if (mLeft < 1) result = false;
                if (mLeft > 1 && mLeft - 1 < cLeft) result = false;
                if (mRight == 0 && 1 < cRight) result = false;
            }
            if (state[2] == 0) {
                if (mRight < 1) result = false;
                if (mRight > 1 && mRight - 1 < cRight) result = false;
                if (mLeft == 0 && 1 < cLeft) result = false;
            }
        }
        if (action.equals(crossRiverMM)) {
            if (state[2] == 1) {
                if (mLeft < 2) result = false;
                if (mLeft > 2 && mLeft - 2 < cLeft) result = false;
                if (mRight == 0 && 2 < cRight) result = false;
            }
            if (state[2] == 0) {
                if (mRight < 2) result = false;
                if (mRight > 2 && mRight - 2 < cRight) result = false;
                if (mLeft == 0 && 2 < cLeft) result = false;
            }
        }
        if (action.equals(crossRiverMC)) {
            if (state[2] == 1) {
                if (mLeft < 1 || cLeft < 1) result = false;
                if (mRight == 0 && 0 < cRight) result = false;
            }
            if (state[2] == 0) {
                if (mRight < 1 || cRight < 1) result = false;
                if (mLeft == 0 && 0 < cLeft) result = false;
            }
        }
        if (action.equals(crossRiverC)) {
            if (state[2] == 1) {
                if (cLeft < 1) result = false;
                if (mRight > 0 && mRight < cRight + 1) result = false;
            }
            if (state[2] == 0) {
                if (cRight < 1) result = false;
                if (mLeft > 0 && mLeft < cLeft + 1) result = false;
            }
        }
        if (action.equals(crossRiverCC)) {
            if (state[2] == 1) {
                if (cLeft < 2) result = false;
                if (mRight > 0 && mRight < cRight + 2) result = false;
            }
            if (state[2] == 0) {
                if (cRight < 2) result = false;
                if (mLeft > 0 && mLeft < cLeft + 2) result = false;
            }
        }
        return result;
    }

    

    @Override
    public int hashCode() {
        return Arrays.hashCode(state);
    }

    @Override
    public String toString() {
        return state[0] + " " + state[1] + " " + state[2];
    }

	@Override
    public boolean equals(Object o) {
        if (o != null && getClass() == o.getClass()) {
        	MissionaryCannibal situation = (MissionaryCannibal) o;
            return Arrays.equals(state, situation.state);
        }
        return false;
    }

    @Override
    public MissionaryCannibal clone() {
    	MissionaryCannibal result = null;
        try {
            result = (MissionaryCannibal) super.clone();
            result.state = result.state.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace(); // should never happen...
        }
        return result;
    }

    public int getMissionaries() { return state[0];}
    public int getCannibals() { return state[1];}
    public int getBoat() { return state[2];}

}
