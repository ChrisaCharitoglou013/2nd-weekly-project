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
public class Division extends MathOperation{

    @Override
    public boolean isBinary() {
        return true;
    }

    @Override
    public boolean isOperationAllowed(List<Double> list) {
        if (list.get(1) == 0){
            System.out.println("Division by zero is not allowed");
            return false;
        }else return true;
    }

    @Override
    public double doOperation(List<Double> list) {
        
        double temp = list.get(0) / list.get(1);
        
        return temp;
    }
    
}
