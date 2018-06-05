/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package source;

import cm3038.search.*;

/**
 *
 * @author Mihail Kalchev
 */
public class FrogAction extends cm3038.search.Action {

    public int rockIndex; // index of the rock
    public int frogIndex; // index of the frog

    /**
     * FrogAction constructor
     *
     * @param rockIndex
     * @param frogIndex
     */
    public FrogAction(int rockIndex, int frogIndex) {
        this.rockIndex = rockIndex;
        this.frogIndex = frogIndex;
    }

    @Override
    //toString method displaying the frog movement and the cost associated with it
    public String toString() {
        return "Move frog from position " + frogIndex + " to position " + rockIndex + " (Cost: " + this.cost + ")";
    }

}
