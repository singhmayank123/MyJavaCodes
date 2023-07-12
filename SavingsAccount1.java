public class SavingsAccount extends BankAccount{

	private boolean status; // either active or inactive

/* A method that tells whether the account is active or not */
	public boolean isActive(){

		/* if balance is greater than or equal to 25,
		 set status to true to state the active account */
		if(getBalance() >= 25)
			status = true;
		// else, set status to false for inactive account
		status = false;

		// return the status 
		return status;
	}

	public void withdraw(double amount){

	/* if the account is inactive, print the message */
		if(!isActive()){
			System.out.println("Account is inactive. No withdrawals can be made.");
		}
	/* Otherwise, call the super class method for withdrawals */
		else{
			super.withdraw(amount);
		}
	}

	public void deposit(double amount){

	/* if account is inactive raise the balance above 25$ and make the 
	account active again */
		if(!isActive()){
			/* set the balance to 25$ */
			setBalance(25);

			/* set the active status */
			status = true;
		}

		/* deposit the amount by calling the super class deposit method */

		super.deposit(amount);
	}

	public void monthlyProcess(){

		if(getWithdrawCounts() > 4){
			/** a service charge of $1 is added to the monthly service charge
			 * for every withdrawal greater than 4. For instance, if withdrawal
			 * is 10 then $6 is added to the service charge. */

			int serviceCharge = getWithdrawCounts() - 4; 

			setServiceCharge((getServiceCharge() + serviceCharge));

			/** check if account balance is still less than 25$, then make the
			 * account inactive again */

			if(getBalance() < 25)
				status = false;

			// now call the monthlyProcess method of super class 

			super.monthlyProcess(); 
		}
	}



	
}