import java.util.Scanner;

public class SavingsAccount{
	
	private double annualIRate = 12.5; // stores annual interest rate 
	private double balance; // stores account balance 
	private double earnedIntBal;

/** Constructor that accepts the starting balance **/
	public SavingsAccount(double startBalance, double ir){
		balance = startBalance;
		annualIRate = ir;
	}

/** Withdrawal method **/

	public void withdraw(double balance){

/** check the validity of requested balance **/
		if(balance > 0 && balance <= this.balance){
/** if valid, subtract the request amount **/
			this.balance -= balance;
			System.out.println(balance + " is debited from the account.");
		}

		else{
			System.out.println("Invalid balance is requested!");
		}
	}
/*** method for adding the balance to the account **/
	public void deposit(double balance){

		if(balance > 0){
			this.balance += balance;
			System.out.println(balance + " is credited to the account.");
		}

		else {
			System.out.println("Invalid balance!");
		}
	}
/** method for adding  the monthly interest **/
	public void addMonthlyInterest(){

		double mi = (double)annualIRate / 12;

		mi = (double) mi / 100;

		earnedIntBal += this.balance * mi;

		this.balance = this.balance + this.balance*mi;
	}
/** method to get the total balance **/
	public double getBalance(){
		return balance;
	}
/** method to get the total earned interest **/
	
	public double getEarnedAmount(){
		return earnedIntBal;
	}

/** main driver method to test the program **/

	public static void main(String[] args) {
		
		Scanner keyboard = new Scanner(System.in);

		System.out.print("Enter Annual Interest Rate: ");
		double ir = keyboard.nextDouble();

		System.out.print("Enter starting balance: ");
		double sb = keyboard.nextDouble();

		// initialize the object 
		SavingsAccount acc = new SavingsAccount(sb, ir);

		System.out.print("Enter the number of months passed: ");
		int numMonths = keyboard.nextInt();

		double amount = 0;
		double totalWithdrawal = 0;
		double totalDeposit = 0;

		/** iterate a loop for each month **/
		for(int i = 1; i <= numMonths; i++){

			/** ask the user to deposit **/

			System.out.print("Enter deposit amount: ");
			amount = keyboard.nextDouble();
			totalDeposit += amount;
			acc.deposit(amount);

			/** Ask the user to withdraw the amount **/
			System.out.print("Enter withdraw amount: ");
			amount = keyboard.nextDouble();
			totalWithdrawal += amount;
			acc.withdraw(amount);

			/** Add monthy interest **/
			acc.addMonthlyInterest();
		}

		/** print the ending balance, withdrawal, deposit,
		 * and total earned interest amount **/

		System.out.printf("Total ending balance: %.2f\n",acc.getBalance());
		System.out.printf("Total withdraw balance: %.2f\n", totalWithdrawal);
		System.out.printf("Total deposit balance: %.2f\n", totalDeposit);
		System.out.printf("Total earned interest balance: %.2f\n",acc.getEarnedAmount());


	}
}