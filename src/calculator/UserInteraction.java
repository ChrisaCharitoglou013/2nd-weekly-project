/*
 * UserInteraction class
 * contains all the required method for the application 's 
 * interaction with the user.
 */
package calculator;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author Xrysa
 */
public class UserInteraction {
    
    Scanner input = new Scanner(System.in);
    LinkedList numbersGivenByUser = new LinkedList();
    CalculatorEssentials avOps= new CalculatorEssentials();

    public void welcomeUser(){
        System.out.println("  Welcome to calculator application!\n"+
                           "--------------------------------------");
    }
    
    public double enterNumber(){
        
        System.out.println("Enter a number: ");
        double temp;
            while (!input.hasNextDouble()){
                System.out.println("That's not a number!");
                input.next();
            }
            temp = input.nextDouble() ;
        return temp;
    }
    
    public String chooseOperation(){
        System.out.println("Choose a math operation by pressing the corresponding symbol:");
        String choices;
        choices = String.format(" %-5s %-20s %-5s %-20s %-5s %-20s %n" + 
                                " %-5s %-20s %-5s %-20s %-5s %-20s %n" ,
                "+","Addition","*","Multiplication","  %","Division remainder",
                "-","Substraction","/","Division","sqrt","Square root");
        System.out.println(choices);
        System.out.println("Enter your choice: ");
        
        String operatorChoice = input.next().trim().toLowerCase();
            while (!(avOps.availableOperations().containsKey(operatorChoice))){
                System.out.println("That's not a valid choice! Please choose one from the list.");
                System.out.println("Enter your choice: ");
                operatorChoice = input.next();
            }
        return operatorChoice;
    }
    
    public boolean decideIfKeepResult(double result){
        System.out.printf("\nThe result is %.2f %n" , result);
        System.out.println("\nThis result is not an integer! \n" + 
                "You can round it to an integer and continue, \n"+
                "or you can reject it and start over. \n" + 
                "Do you want to round it and continue? \n"+
                "Please type 'Yes' or 'No' :");
        return chooseYesOrNo();  
    }
    
    public int roundNumber(double number){
        int roundedNumber;
        roundedNumber = Math.toIntExact(Math.round(number));
        return roundedNumber;
    }
    
    public boolean decideIfUseABS(int number){
        System.out.println("For the following operations we need a positive"+
                " number but the result we got is a negative one.\n" + 
                "Do you want to use the absolute value of the result" + 
                " in order to continue?\n" + 
                "Please answer 'Yes' or 'No' :");
        return chooseYesOrNo();    
    }
    
    private boolean chooseYesOrNo(){
        String choice = input.next().trim().toUpperCase();
        while (!(choice.equals("YES") || choice.equals("NO"))){
                System.out.println("That's not a valid choice!\n" + 
                        "Please write 'Yes' or 'No' : ");
                choice = input.next().trim().toUpperCase();
            }
        return (choice.equals("YES"));
    }
}
