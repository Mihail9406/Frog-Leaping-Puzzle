/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package source;

import cm3038.search.*;

/**
 *Main file for running the frog leaping puzzle
 * @author Mihail Kalchev
 */
public class RunFrogsPuzzle {

    public static void main(String[] arg) {

       String[] initialFrogs = {"r","r","r","-","g","g","g"}; //initial state of the world as an array of strings (basic problem)
       String[] initialFrogs2 = {"r","r","-","-","g","g"}; // initial state of the world (general problem)
       String[] goalFrogs2 = {"-","g","r","g","r","-"}; //goal state (general problem)
        String[] s2 = {"g","g","g","-","r","r","r"};
       String[] goalFrogs = {"g","g","g","-","r","r","r"}; //goal state (basic problem)
       String[] s4 = {"r","r","-","-","g","g"};
       String[] s5 = {"-","g","r","g","r","-"};
        
        FrogState initialState = new FrogState(initialFrogs2);
        FrogState state2 = new FrogState(s2);
        FrogState state3 = new FrogState(goalFrogs);
        FrogState goalState = new FrogState(goalFrogs2);

        System.out.println("Initial state: " + initialState);
        System.out.println("Goal state: " + goalState);
        //testing the equals method
//        System.out.println("State 1: " + initialState);
//        System.out.println("State 2: " + state2);
//        System.out.println("State 3: " + state3);
//        System.out.println("State 1 equals State 2: " + initialState.equals(state2));		
//        System.out.println("State 2 equals State 3: " + state2.equals(state3));

        
       //testing the applyAction and successor methods
//        System.out.println("\n");
//        FrogAction action = new FrogAction(3,2);
//        System.out.println(initialState);
//        System.out.println(action.toString());
//        FrogState next = initialState.applyAction(action);
//        System.out.println(next);
//        System.out.println(initialState.successor().toString());
//        System.out.println(state2.successor().toString());


//        SearchProblem problem = new BreadthfirstSearch(initialState, goalState);	//breadth-frist search
        SearchProblem problem = new FrogProblem(initialState, goalState); //A* search
        System.out.println("Searching...");		//print some message
        Path path = problem.search();				//perform search, get result
        System.out.println("Done!");			//print some message
        if (path == null) //if it is null, no solution
        {
            System.out.println("No solution");
        } else {
            path.print();							//otherwise print path
            System.out.println("Nodes visited: " + problem.nodeVisited);
            System.out.println("Cost: " + path.cost + "\n");
        }

    }
}
