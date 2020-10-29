package aima.core.environment.missionariesandcannibals;

import aima.core.agent.Action;
import aima.core.search.framework.Node;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MissionaryCannibalFunctions {

    public static final MissionaryCannibal GOAL_STATE = new MissionaryCannibal(new int[] {0, 0, 0});

    public static List<Action> getActions(MissionaryCannibal state) {
        return Stream.of(MissionaryCannibal.crossRiverM, MissionaryCannibal.crossRiverMM, MissionaryCannibal.crossRiverMC, MissionaryCannibal.crossRiverC, MissionaryCannibal.crossRiverCC).
                filter(state::canCross).collect(Collectors.toList());
    }

    public static MissionaryCannibal getResult(MissionaryCannibal state, aima.core.agent.Action action) {
        MissionaryCannibal result = state.clone();

        if (result.canCross(action)) {
            if (action == MissionaryCannibal.crossRiverM)
                result.crossingM();
            else if (action == MissionaryCannibal.crossRiverMM)
                result.crossingMM();
            else if (action == MissionaryCannibal.crossRiverMC)
                result.crossingMC();
            else if (action == MissionaryCannibal.crossRiverC)
                result.crossingC();
            else if (action == MissionaryCannibal.crossRiverCC)
                result.crossingCC();
        }
        return result;
    }

    public static double getH(Node<MissionaryCannibal, Action> node) {
        MissionaryCannibal currState = node.getState();
        return currState.getMissionaries() + currState.getCannibals();
    }
}
