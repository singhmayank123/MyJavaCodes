abstract public class BankAccount{

	private double balance; // to hold the bank balance 
	private int depositCounts; // to hold count of deposits in a month
	private int withdrawCounts; // to hold the count of withdrawals 
	// to hold annual interest rate, assuming it 7.5 
	private final double ANN_INT_RATE = 7.5;  
	private double monthlyServiceCharge; // to hold monthly service charge

	public BankAccount(){}

	/* A constructor to accept balance and annual interest rate */

	public BankAccount(double balance, double interestRate){

		this.balance = balance; 
		depositCounts = 0;
		withdrawCounts = 0;

	}

	/** required accessor methods */

	public double getBalance(){ return balance; }
	public int getWithdrawCounts(){ return withdrawCounts; }
	public double getServiceCharge(){return monthlyServiceCharge; }

	/** required mutator methods */

	public void setBalance(double balance){this.balance = balance; }
	public void setServiceCharge(double amount){monthlyServiceCharge = amount;}

	/* A method that adds the amount to the balance if it positive
	and increments the deposit count by 1 for every deposit */

	public void deposit(double amount){

		if(amount > 0){

			balance += amount; 
			depositCounts++;
			System.out.println("$"+amount+" has been credited to the account."); 
		}
	}

	/* A method that subtracts the amount from the balance, if the 
	amount is positive and less than the account balance */

	public void withdraw(double amount){

		if(amount > 0 && amount < balance){
			balance -= amount; 
			withdrawCounts++; 
			System.out.println("$"+amount+" has been debited from the account.");
		}
		else{
			System.out.println("Invalid balance is requested!");
		}
	}

	/* A method to that updates the balance based on the calculated interest */

	public void calcInterest(){

		double monthIntRate = (double) ANN_INT_RATE / 12; 
		double monthlyInterest = balance * monthIntRate; 
		balance += monthlyInterest;
	}

	/* A method that runs all basic method based on months */

	public void monthlyProcess(){

		// Subtract the montly service charge from the balance 
		balance -= monthlyServiceCharge;

		// call the calcInterest method to add the monthly interest in balance */

		calcInterest();

		// set the withdrawal, deposits and montly service charge to zero 

		withdrawCounts = 0; 
		depositCounts = 0; 
		monthlyServiceCharge = 0; 

	}
}