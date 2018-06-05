/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package source;

import cm3038.search.*;
import java.util.List;

/**
 *
 * @author Mihail Kalchev
 */
public class BreadthfirstSearch extends cm3038.search.SearchProblem {

    public State goalState;

    public BreadthfirstSearch(State start, State goal) {
        super(start);
        this.goalState = goal;
    }

    protected void addChild(List<Node> fringe, Node childNode) {
        fringe.add(childNode);	//***adding a child to the end of the queue give a breadth-first behaviour
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
