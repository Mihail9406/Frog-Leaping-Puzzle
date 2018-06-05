package source;

import cm3038.search.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * This class models the state of the frog leaping puzzle
 *
 * @author Mihail Kalchev
 */
public class FrogState implements cm3038.search.State {

    public String[] frogState;

    //defaut constructor that creates a String array of size 7 with null objecs inside
    public FrogState() {
        this.frogState = new String[7];
    }

    /**
     * Given a String array, create a FrogState to represent this state.
     *
     * @param initialState of the frogs as a String array.
     */
    public FrogState(String[] initialState) {
        this.frogState = new String[initialState.length];
        for (int i = 0; i < frogState.length; i++) {
            frogState[i] = initialState[i].toUpperCase();
        }
    }

    /**
     * Converting a FrogState object into a String.
     */
    public String toString() {
        String result = "";
        for (int i = 0; i < this.frogState.length; i++) {
            result += this.frogState[i];
        }
        return result;
    }

    /**
     * This method tests if the current FrogState equals to another object.
     *
     * @param state The other object to test against.
     * @return true if the current FrogState equals to the other object.
     */
    @Override
    public boolean equals(Object state) {
        if (!(state instanceof FrogState)) {
            return false;
        }

        FrogState frogs = (FrogState) state;
        for (int i = 0; i < this.frogState.length; i++) {
            if (!this.frogState[i].equals(frogs.frogState[i]))//As soon as there is a mismatch, it must be false.
            {
                return false;
            }
        }

        return true;
    }

    @Override
    /**
     * Generate all children nodes of the current state.
     */
    public List<ActionStatePair> successor() {
        List<ActionStatePair> result = new ArrayList<ActionStatePair>();

        int rockIndex = 0;
        int frogIndex = 0;

        for (int i = 0; i < this.frogState.length; i++) {
            if (this.frogState[i].equals("-")) { //find out where the rock is
                rockIndex = i; //assign the rock index
                if (rockIndex + 1 < this.frogState.length) { //check if the rock is at the end of the array so we don't go out of bounds
                    if (this.frogState[i + 1].equals("G")) {
                        frogIndex = i + 1;
                        FrogAction action = new FrogAction(rockIndex, frogIndex);
                        FrogState nextState = this.applyAction(action);
                        ActionStatePair actionStatePair = new ActionStatePair(action, nextState);
                        result.add(actionStatePair);
                    }
                }
                if (rockIndex + 2 < this.frogState.length) {
                    if (this.frogState[i + 2].equals("G")) {
                        if (this.frogState[i + 1].equals("R") || this.frogState[i + 1].equals("G")) { //if statement to make sure the frog does not jump over a vacant rock
                            frogIndex = i + 2;
                            FrogAction action = new FrogAction(rockIndex, frogIndex);
                            FrogState nextState = this.applyAction(action);
                            ActionStatePair actionStatePair = new ActionStatePair(action, nextState);
                            result.add(actionStatePair);
                        }
                    }

                }
                if (rockIndex - 1 > -1) { //check if the rock is at the begining of the array so we don't go out of bounds
                    if (this.frogState[i - 1].equals("R")) {
                        frogIndex = i - 1;
                        FrogAction action = new FrogAction(rockIndex, frogIndex);
                        action.cost = 3.0; //the cost of moving a red frog
                        FrogState nextState = this.applyAction(action);
                        ActionStatePair actionStatePair = new ActionStatePair(action, nextState);
                        result.add(actionStatePair);

                    }
                }
                if (rockIndex - 2 > -1) {
                    if (this.frogState[i - 2].equals("R")) {
                        if (this.frogState[i - 1].equals("R") || this.frogState[i - 1].equals("G")) { //if statement to make sure the frog does not jump over a vacant rock
                            frogIndex = i - 2;
                            FrogAction action = new FrogAction(rockIndex, frogIndex);
                            action.cost = 3.0; //the cost of moving a red frog
                            FrogState nextState = this.applyAction(action);
                            ActionStatePair actionStatePair = new ActionStatePair(action, nextState);
                            result.add(actionStatePair);
                        }
                    }
                }
            }
        }

        return result;
    }

    @Override
    /**
     * The hashCode() method is needed as we use a HashSet to store the history
     * of visited nodes. It returns an int value for a FrogState object. If 2
     * objects are equal, their hash code should be the same.
     *
     * This method has been generated by NetBeans
     */
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Arrays.deepHashCode(this.frogState);
        return hash;
    }

    /**
     * Apply an action to the current state.
     *
     * @param action
     * @return FrogState
     */
    public FrogState applyAction(FrogAction action) {
        FrogState nextState = new FrogState(this.frogState);

        String rock = nextState.frogState[action.rockIndex]; //temp variable to hold the rock for the swap
        nextState.frogState[action.rockIndex] = nextState.frogState[action.frogIndex]; //assign frog value where the rock is
        nextState.frogState[action.frogIndex] = rock; //assign the rock on the place where the frog was

        return nextState;
    }
}
