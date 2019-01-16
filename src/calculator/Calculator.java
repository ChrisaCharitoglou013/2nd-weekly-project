/*
 * This calculator application performs the following operations:
 * 
 * Asks the user to enter a number and a symbol. 
 * Choices are (+, -, *, /, %, square root).
 * If the chosen operation requires 2 numbers it asks for the second number and  
 * based on user's choice and input it calculates and prints the result.

 * After using the calculator 2 times and finding a second result, 
 * it finds the Greatest Common Divisor (Largest Positive Integer that
 * divides each of the integers) from the 2 results.
 * Based on the second result it performs the following operations:
 * Checks if the 2nd result is a prime number (a prime number is a positive 
 * integer that can be divided only by 1 and itself.) and finds the
 * 2nd result 's corresponding Fibonacci Number.
 */
package calculator;

import availableoperations.MathOperation;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author Xrysa
 */
public class Calculator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        UserInteraction useCalculator = new UserInteraction();
        LinkedList<Double> numbersGivenByUser = new LinkedList();
        LinkedList<Integer> resultsToUse = new LinkedList();
        CalculatorEssentials calculate= new CalculatorEssentials();
        Map<String, MathOperation> operationType = calculate.availableOperations();

        
        useCalculator.welcomeUser();
        do{
            System.out.println("\n--> Starting a new operation:");
            numbersGivenByUser.clear();
            double x = useCalculator.enterNumber();
            numbersGivenByUser.add(x);
            String symbolChoice = useCalculator.chooseOperation(); // The operator chosen by the user
            MathOperation selectedOperation = operationType.get(symbolChoice); // The operation that has as a key the symbol (operator) chosen by the user
            if(selectedOperation.isBinary()){  // Check if the chosen operation needs two numbers
               x = useCalculator.enterNumber();
               numbersGivenByUser.add(x);
            }
            if(selectedOperation.isOperationAllowed(numbersGivenByUser)){ // Check if the chosen operation is allowed
                double y = selectedOperation.doOperation(numbersGivenByUser); // Do operation
                if(Math.ceil(y) == Math.floor(y)){ // Check if the result can be converted to integer
                    resultsToUse.addFirst((int)y);  
                    System.out.println("The result is: " + resultsToUse.getFirst());
                }else if (useCalculator.decideIfKeepResult(y)){ // Ask the user whether to round the result and keep it
                    useCalculator.roundNumber(y);
                    resultsToUse.addFirst((int)y);
                    System.out.println("The result is: " + resultsToUse.getFirst());
                }
            }
        }while(resultsToUse.size() < 2); // Keep looping until reach 2 integer results
        
        calculate.greatestCommonDivisor(resultsToUse); // find and print greatest common divisor
        int secondResult = (int)resultsToUse.getFirst();
        char cases; // Various possible cases according to the value of 2nd result
        // If 2nd result is negative ask whether to use absolute value of the number
        if (secondResult < 0 && !(useCalculator.decideIfUseABS(secondResult))){
            cases = 'A'; // Negative number & user says not to use absolute value
        }else if (secondResult < 0 && useCalculator.decideIfUseABS(secondResult)){
            cases = 'B'; // Negative number & user decides to use absolute value
        }else{
            cases = 'C'; // Positive number
        }
        
        switch(cases){
            case('A'): // Number remains negative. Exiting the application!
                System.out.println("Unable to proceed with calculations.\n"+
                        "Exiting the application.");
                break;
            case('B'): //  Use absolute value of the number
                secondResult = Math.abs(secondResult); 
            case('C'): // Proceed with calculations
                calculate.isPrime(secondResult);
                int fibResult = calculate.fibonacci(secondResult);
                System.out.println("The fibonacci number in position " + 
                        secondResult + " is " + fibResult);
                calculate.isFibonacci(secondResult);
        }
     
    }
}
