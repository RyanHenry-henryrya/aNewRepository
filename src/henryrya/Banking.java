/*
    Name:  Ryan Henry
    Assignment:  Assignment 1
    Program: Computer Programmer
    Date:  Jan 21, 2019 12:00 PM

    Description:
    A banking program that can create new bank accounts 
    and store monetary values.
*/

package henryrya;
import java.util.*;

/**
 *Creates a new bank account and asks for the account owner's information.
 * @author Ryan Henry
 */
public class Banking{

    /**
     * Takes new Bank Account information and prints all Bank account details.
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Account newAccount = new Account();
        getStringInput(newAccount);
        getDoubleInput(newAccount);
        System.out.println(newAccount);
    }
    
    /**
     * Gets and validates user input for a new Account, setting the String type 
     * data members, accountNo and customerName.
     * @param newAccount the new bank account to be initialized
     */
    public static void getStringInput(Account newAccount){
        Scanner in = new Scanner(System.in);
        boolean valid;
        //a for loop to input for each method that takes a String
        for (int method = 1; method <= 2; method++){
            valid = true;
            do{
                try{
                    //a switch statement to switch between methods
                    switch (method){
                        case 1:
                            System.out.print("Enter Customer Name: ");
                            newAccount.setCustomerName(in.nextLine());
                            break;
                        case 2:
                            System.out.print("Enter Account Number: ");
                            newAccount.setAccountNo(in.nextLine());
                            break;
                    }
                    valid = false;
                } catch (IllegalArgumentException ex){
                    System.out.println(ex.getMessage());
                }
            } while (valid);
        }
        
    }
    
    /**
     * Gets and validates user input for a new Account, setting the double type 
     * data member balance and also getting a deposit and withdrawal value.
     * @param newAccount the new bank account to be initialized
     */
    public static void getDoubleInput(Account newAccount){
        Scanner in = new Scanner(System.in);
        boolean valid;
        //for loop to enter input for each method that takes a double
        for (int method = 1; method <=3; method++){ 
            valid = true;
            do{
                try{
                    //a switch statement to switch between methods
                    switch (method){
                            case 1:
                                System.out.print("Enter initial balance: ");
                                String input = validateDouble(in.next());
                                newAccount.setBalance(Double.parseDouble(input));
                                break;
                            case 2:
                                System.out.print("Enter deposit amount: ");
                                input = validateDouble(in.next());
                                newAccount.deposit(Double.parseDouble(input));
                                break;
                            case 3:
                                System.out.print("Enter withdraw amount: ");
                                input = validateDouble(in.next());
                                newAccount.withdraw(Double.parseDouble(input));
                                break;
                    }
                    valid = false;
                } catch (InputMismatchException | IllegalArgumentException ex){
                    System.out.println(ex.getMessage());
                }
            } while (valid);
        }
    }
    /**
     * Takes a String input and makes sure it is composed of only digits and up
     * to one decimal place and throws an InputMismatchException otherwise.
     * This is useful to tell if a String can be parsed to a double. 
     * @param input a String intended to be parsed to a double
     * @return only returns the same input String if the exception isn't thrown
     */
    public static String validateDouble(String input){
        if (!((input.replaceFirst("[-.]","").matches("^[0-9]+$")))){
            throw new InputMismatchException("Please enter a number.");
        } else { return input; }
    }

}