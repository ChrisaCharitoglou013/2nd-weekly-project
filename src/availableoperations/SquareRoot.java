/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package availableoperations;

import availableoperations.MathOperation;
import java.util.List;

/**
 *
 * @author Xrysa
 */
public class SquareRoot extends MathOperation{

    @Override
    public boolean isBinary() {
        return false;
    }

    @Override
    public boolean isOperationAllowed(List<Double> list) {
        if (list.get(0) < 0){
            System.out.println("The square root of a negative number can't be defined. \n"+
                    "Please use only positive numbers!");
            return false;
        }else return true;
    }

    @Override
    public double doOperation(List<Double> list) {
        double temp;
        temp = Math.sqrt(list.get(0));
        return temp;
    }
    
}
