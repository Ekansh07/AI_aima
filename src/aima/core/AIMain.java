package aima.core;

import aima.core.agent.Action;
import aima.core.agent.Agent;
import aima.core.agent.EnvironmentListener;
import aima.core.agent.impl.DynamicPercept;
import aima.core.agent.impl.SimpleEnvironmentView;
import aima.core.environment.map.*;
import aima.core.environment.missionariesandcannibals.MissionaryCannibal;
import aima.core.environment.missionariesandcannibals.MissionaryCannibalFunctions;
import aima.core.environment.missionariesandcannibals.MissionaryCannibalProblem;
import aima.core.search.agent.SearchAgent;
import aima.core.search.framework.SearchForActions;
import aima.core.search.framework.problem.Problem;
import aima.core.search.framework.qsearch.GraphSearch;
import aima.core.search.informed.AStarSearch;
import aima.core.search.informed.GreedyBestFirstSearch;
import aima.core.search.informed.RecursiveBestFirstSearch;
import aima.core.search.uninformed.IterativeDeepeningSearch;
import aima.core.search.uninformed.UniformCostSearch;

import java.util.List;
import java.util.Properties;

public class AIMain {

	private static MissionaryCannibal puzzle = new MissionaryCannibal();

	public static void main(String[] args) {

		System.out.println("Name: Ekansh Goyal");
		System.out.println("NetID: EXG180024");
		System.out.println("Programming Assignment for Problem 2: ");
		System.out.println("Missionary and Cannibal,The initial state is : " + puzzle);

		MissionaryCannibalUCS();
		MissionaryCannibalIDS();
		MissionaryCannibalGBFS();
		MissionaryCannibalAStar();
		MissionaryCannibalRBFS();

		System.out.println("End of Missionary Cannibal code");
		System.out.println(" \nPROBLEM 3:");

		System.out.println("Route from Seattle to Dallas: \n");
		ExtendableMap map = new ExtendableMap();
		USRoadMap.initMap(map);
		MapEnvironment env = new MapEnvironment(map);
		EnvironmentListener<Object, Object> envView = new SimpleEnvironmentView();
		env.addEnvironmentListener(envView);

		String source = USRoadMap.SEATTLE;
		String destination = USRoadMap.DALLAS;
		System.out.println("Problem 3.1");
		System.out.println("Recursive Best-First Search is: \n");
		SearchForActions<String, MoveToAction> search;
		Agent<DynamicPercept, MoveToAction> agent;
		search = new RecursiveBestFirstSearch<>(
				AStarSearch.createEvalFn(MapFunctions.createSLDHeuristicFunction(destination, map)));
		agent = new SimpleMapAgent(map, search, destination);
		env.addAgent(agent, source);
		env.stepUntilDone();
		envView.notify(search.getMetrics().toString());

		System.out.println("\nProblem 3.3");

		System.out.println("A* Search output: is \n");

		search = new AStarSearch<>(new GraphSearch<>(), MapFunctions.createSLDHeuristicFunction(destination, map));

		agent = new SimpleMapAgent(map, search, destination);

		env.addAgent(agent, source);
		env.stepUntilDone();
		envView.notify(search.getMetrics().toString());

	}

	private static void MissionaryCannibalUCS() {
		System.out.println("\nThe Uniform-Cost Search result is :");
		try {
			Problem<MissionaryCannibal, Action> problem = new MissionaryCannibalProblem(puzzle);
			SearchForActions<MissionaryCannibal, Action> search = new UniformCostSearch<>();
			SearchAgent<Object, MissionaryCannibal, Action> agent = new SearchAgent<>(problem, search);
			printActions(agent.getActions());
			printInstrumentation(agent.getInstrumentation());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void MissionaryCannibalIDS() {
		System.out.println("\nIterative Deepening Search is:");
		try {
			Problem<MissionaryCannibal, Action> problem = new MissionaryCannibalProblem(puzzle);
			SearchForActions<MissionaryCannibal, Action> search = new IterativeDeepeningSearch<>();
			SearchAgent<Object, MissionaryCannibal, Action> agent = new SearchAgent<>(problem, search);
			printActions(agent.getActions());
			printInstrumentation(agent.getInstrumentation());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void MissionaryCannibalGBFS() {
		System.out.println("\nGreedy Best-First Search is:");
		try {
			Problem<MissionaryCannibal, Action> problem = new MissionaryCannibalProblem(puzzle);
			SearchForActions<MissionaryCannibal, Action> search = new GreedyBestFirstSearch<>(new GraphSearch<>(),
					MissionaryCannibalFunctions::getH);
			SearchAgent<Object, MissionaryCannibal, Action> agent = new SearchAgent<>(problem, search);
			printActions(agent.getActions());
			printInstrumentation(agent.getInstrumentation());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void MissionaryCannibalAStar() {
		System.out.println("\nA* Search is:");
		try {
			Problem<MissionaryCannibal, Action> problem = new MissionaryCannibalProblem(puzzle);
			SearchForActions<MissionaryCannibal, Action> search = new AStarSearch<>(new GraphSearch<>(),
					MissionaryCannibalFunctions::getH);
			SearchAgent<Object, MissionaryCannibal, Action> agent = new SearchAgent<>(problem, search);
			printActions(agent.getActions());
			printInstrumentation(agent.getInstrumentation());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void MissionaryCannibalRBFS() {
		System.out.println("\nRecursive Best-First Search is:");
		try {
			Problem<MissionaryCannibal, Action> problem = new MissionaryCannibalProblem(puzzle);
			SearchForActions<MissionaryCannibal, Action> search = new RecursiveBestFirstSearch<>(
					AStarSearch.createEvalFn(MissionaryCannibalFunctions::getH));
			SearchAgent<Object, MissionaryCannibal, Action> agent = new SearchAgent<>(problem, search);
			printActions(agent.getActions());
			printInstrumentation(agent.getInstrumentation());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void printInstrumentation(Properties properties) {
		properties.keySet().stream().map(key -> key + " = " + properties.get(key)).forEach(System.out::println);
	}

	private static void printActions(List<Action> actions) {
		actions.forEach(System.out::println);
	}

}
