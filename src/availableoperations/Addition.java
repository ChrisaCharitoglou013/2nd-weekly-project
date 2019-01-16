/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package availableoperations;

import java.util.List;

/**
 *
 * @author Xrysa
 */
public class Addition extends MathOperation{
    
    @Override
    public boolean isBinary() {
        return true;
    }

    @Override
    public boolean isOperationAllowed(List<Double> list) {
        return true;
    }

    @Override
    public double doOperation(List<Double> list) {
        double temp = 0;
        for (Double x:list){
            temp = temp + x;
        }
        return temp;
    }
    
}
