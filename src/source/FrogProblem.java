/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package source;

import cm3038.search.*;
import cm3038.search.informed.*;

/**
 * An informed search problem needed for the A* search requirement of the frog
 * leaping puzzle
 *
 * @author Mihail Kalchev
 */
public class FrogProblem extends cm3038.search.informed.BestFirstSearchProblem {

    /**
     * Constructing the FrogProblem object from the initial and goal state.
     *
     * @param initialState	The initial state.
     * @param goalState The goal state.
     */
    public FrogProblem(State initialState, State goalState) {
        super(initialState, goalState);
    }

    /**
     * A heuristic function that estimate how far is a current state from a goal
     * state.
     *
     * @param currentState
     * @return The remaining distance of the current state to a goal.
     */
    public double heuristic(State currentState) {

        double result = 0.0;
        String[] frogs = ((FrogState) currentState).frogState;
        String[] goal = ((FrogState) this.goalState).frogState;

        for (int i = 0; i < frogs.length; i++) {
            if (!frogs[i].equals("-") && !frogs[i].equals(goal[i])) { //if the frog at this position does not equal the one in the goal state on the same position
                result++; //counting the number of misplaced frogs
            }
        }
        return result;
    }

    @Override
    /**
     * The evaluation function required by an informed search.
     *
     * @param node	The node to be evaluated.
     * @return The score of the node.
     */
    public double evaluation(Node node) {
        return heuristic(node.state) + node.getCost();
    }

    @Override
    /**
     * This method tests if the current FrogState is a goal state.
     *
     * @return Return true if the current state is a goal. false otherwise.
     */
    public boolean isGoal(State state) {
        return state.equals(this.goalState);
    }

}
