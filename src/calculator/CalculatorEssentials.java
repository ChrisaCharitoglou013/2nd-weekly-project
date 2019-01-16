/*
 * 
 *
 */
package calculator;

import availableoperations.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author Xrysa
 */
public class CalculatorEssentials {
    
    Addition add = new Addition();
    Substraction substract = new Substraction();
    Multiplication multiply = new Multiplication();
    Division divide = new Division();
    Remainder remainder = new Remainder();
    SquareRoot sqrt = new SquareRoot();
    
    Map<String, MathOperation> operationType = new TreeMap<>();
   
    // Contains as values all the Operations that are available for the user
    // and the symbols that the user can choose from, as their associated keys.
    public Map availableOperations(){
        
        operationType.put("+",add);
        operationType.put("-",substract);
        operationType.put("*",multiply);
        operationType.put("/",divide);
        operationType.put("%",remainder);     
        operationType.put("sqrt",sqrt);
        
        return operationType;
    }
    
    // Calculates and prints the greatest common divisor of 2 numbers
    void greatestCommonDivisor(List<Integer> list) {
        
        LinkedList divisors1 = new LinkedList();
        LinkedList divisors2 = new LinkedList();
        int temp1;
        int temp2;
        
        temp1 = Math.abs(list.get(0));
        temp2 = Math.abs(list.get(1));
        if (temp1 == 0 && temp2 == 0){
            System.out.println("\nThe greatest common divisor of 0 and 0 is undefined!");
        }else if (temp1 == 0){
            System.out.println("\nThe greatest common divisor of 0 and " 
                    + list.get(1) + " is " + temp2);
        }else if (temp2 == 0){
            System.out.println("\nThe greatest common divisor of 0 and " 
                    + list.get(0) + " is " + temp1);
        }else{
            // Calculating the devisors of the 1st result and storing them in ascending order.
            for (int i = 1; i < (temp1 + 1); i++) {
                if ((temp1 % i) == 0) {
                    divisors1.add(i);
                }
            }
            // Calculating the devisors of the 2nd result and storing them in ascending order.
            for (int i = 1; i < (temp2 + 1); i++) {
                if ((temp2 % i) == 0) {
                    divisors2.add(i);
                }
            }
            // Keep only the common divisors stored in ascending order.
            divisors1.retainAll(divisors2);
            // The last divisor in the row is the greatest common divisor.
            System.out.println("\nThe greatest common divisor of " + list.get(1) + 
                " and " + list.get(0) + " is " + divisors1.getLast());
        }
        
    }
    
    // Prints if number is prime or not
    void isPrime(int number) {
        LinkedList divisors = new LinkedList();
        
        if (number <= 0){
            System.out.println(number + " is not a prime number.");
        }else{
            for (int i = 1; i < (number + 1); i++) {
                if ((number % i) == 0) {
                    divisors.add(i);
                }
            }
            // A prime list only has 2 divisors, 1 and itself.
            // So if the total amount of it'temp divisors is 2 then the list is a prime list.
            if (divisors.size() == 2) {
                System.out.println(number + " is a prime number!");
            } else {
                System.out.println(number + " is not a prime number.");
            }
        }
    }
    
    // Returns the corresponding fibonacci number
    public int fibonacci(int n) {
        if (n == 0 || n == 1) {
            return n;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }    
    
    // Returns true if number is perfect square 
    public boolean isPerfectSquare(int number){ 
        int temp = (int) Math.sqrt(number); 
        return (temp*temp == number); 
    } 
    
    // Prints whether number is a fibonacci number or not 
    public void isFibonacci(int number){ 
        // A number is Fibonacci if one of the following expressions 
        //(5*number*number + 4) or (5*number*number - 4) 
        //or both of them are a perfect square.
        if(isPerfectSquare(5*number*number + 4) || 
                isPerfectSquare(5*number*number - 4)){
            System.out.println(number + " is a fibonnacci number!");
        } else{
            System.out.println(number + " is not a fibonnacci number.");
        }
    } 
}
