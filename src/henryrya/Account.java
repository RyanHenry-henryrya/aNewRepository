/*Java 2
Name: Ryan Henry
Date: Jan 21, 2019 12:00 PM

Description
A Bank account with basic functionality deposit and withdrawal functionality as
well as a balance, customer name and account number associated with the account.

this is my first git update
    */
package henryrya;

/**
 *Bank Account, contains an account number, customer name and balance. 
 * @author Ryan Henry
 */
public class Account {
    private String accountNo;
    private String customerName;
    private double balance;
    
    /**
     * Instantiates a new Account Object.
     * Sets the Account Number and Customer Name to the default values.
     */
    public Account() {
        this.accountNo = "0000000";
        this.customerName = "Unknown";
    }

    /**
     * Instantiates a new Account Object.
     * Sets the Account Number as long as it's a seven digit number.
     * Sets the Customer Name as long as it is not null or of length zero.
     * @param accountNo The Account number.
     * @param customerName The customer name.
     */
    public Account(String accountNo, String customerName) {
        if (accountNo.matches("^[0-9]{7}")){
            this.accountNo = accountNo;
        } else {
            throw new IllegalArgumentException("Error: Account number must " +
                    "be a 7 digit number.");
        }
        if (customerName == null || customerName.length() == 0){
            throw new IllegalArgumentException("Error: You must enter the" + 
                    " customer name.");
        } else {
            this.customerName = customerName;
        }        
    }
    
    /**
     * Returns the account number.
     * @return Returns the account number.
     */
    public String getAccountNo() {
        return accountNo;
    }
    
    /**
     * Sets the Account Number as long as it is a seven digit number.
     * @param accountNo The Account number.
     */
    public void setAccountNo(String accountNo) {
        if (accountNo.matches("^[0-9]{7}$")){
            this.accountNo = accountNo;
        } else {
            throw new IllegalArgumentException("Error: Account number must " +
                    "be a 7 digit number.");
        }
    }

    /**
     * Returns the Customer Name.
     * @return the Customer Name
     */
    public String getCustomerName() {
        return customerName;
    }

    /**
     * Sets the Account Customer name, as long as it's not null or 
     * of zero length.
     * @param customerName the Customer Name
     */
    public void setCustomerName(String customerName) {
        if (customerName == null || customerName.length() == 0){
            throw new IllegalArgumentException("Error: You must enter the" + 
                    " customer name.");
        } else {
            this.customerName = customerName;
        }  
    }

    /**
     * Returns the Account balance.
     * @return the account balance
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Sets the Account balance to a non-negative amount.
     * @param balance the account balance
     */
    public void setBalance(double balance) {
        if (balance < 0){
            throw new IllegalArgumentException("Error: Account balance cannot" +
                    " be a negative value.");
        }else{
            this.balance = balance;
        }
    }
    
    /**
     * Withdraws a non-negative amount less than or equal to the balance;
     * @param amount the amount to withdraw
     */
    public void withdraw(double amount){
        if (amount > balance){
            throw new IllegalArgumentException("Error: Account balance will" + 
                    " be negative. Transaction is cancelled.");
        }else if (amount < 0){
            throw new IllegalArgumentException("Error: Withdraw amount cannot" +
                    " be a negative number.");
        } else {
            balance -= amount;
        }
    }
    
    /**
     * Deposits a non-negative amount to the Bank Account.
     * @param amount the amount to deposit
     */
    public void deposit(double amount){
        if (amount < 0){
            throw new IllegalArgumentException("Error: Deposit amount cannot" +
                    " be a negative number.");
        } else {
            balance += amount;
        }
    }

    /**
     * Prints all Bank Account details.
     * @return returns a properly formatted String to be printed.
     */
    @Override
    public String toString() {
        return String.format("%n   Account no: %s%nCustomer name: %s%n      " + 
                "Balance: $%.2f",accountNo,customerName,balance);
    }
    
}
