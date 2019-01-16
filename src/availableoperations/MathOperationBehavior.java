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
public interface MathOperationBehavior {
    
    // Check if the operation needs two numbers
    boolean isBinary();
    
    // Check if the operation is allowed
    boolean isOperationAllowed(List<Double> list);
    
    // Do operation 
    double doOperation(List<Double> list);
}
