package aima.core.environment.missionariesandcannibals;

import aima.core.search.framework.problem.BidirectionalProblem;
import aima.core.search.framework.problem.GeneralProblem;
import aima.core.search.framework.problem.Problem;
import aima.core.agent.Action;

import java.util.function.Predicate;

public class MissionaryCannibalProblem extends GeneralProblem <MissionaryCannibal, Action> implements BidirectionalProblem <MissionaryCannibal, Action> {
    private final Problem<MissionaryCannibal, Action> reverseProblem;

    public MissionaryCannibalProblem(MissionaryCannibal initialState) {
        super(initialState, MissionaryCannibalFunctions::getActions, MissionaryCannibalFunctions::getResult,
                Predicate.isEqual(MissionaryCannibalFunctions.GOAL_STATE));

        reverseProblem = new GeneralProblem<>(MissionaryCannibalFunctions.GOAL_STATE,
        		MissionaryCannibalFunctions::getActions, MissionaryCannibalFunctions::getResult,
                Predicate.isEqual(initialState));
    }

    public Problem<MissionaryCannibal, Action> getOriginalProblem() {
        return this;
    }

    public Problem<MissionaryCannibal, Action> getReverseProblem() {
        return reverseProblem;
    }
}
