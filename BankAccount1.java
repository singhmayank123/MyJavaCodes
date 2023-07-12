public class BankAccount1{

	private String clientID; // for storing customer ID number 
	private String clientName; // for the client's name
	private double balInJD; // for balance in JD
	private double balInNIS; // for balance in NIS
	public static double exchangeRate; 
	private String branchCity; // for city name of the branch


	/* A constructor for initializing the fields  */

	public BankAccount1(String clientID, String clientName, double balInJD, double balInNIS,
		double exchangeRate, String branchCity){

		this.clientID = clientID; 
		this.clientName = clientName;
		this.balInJD = balInJD;
		this.balInNIS = balInNIS;
		this.exchangeRate = (double)exchangeRate/100; // for converting rate in decimal 
		this.branchCity = branchCity;
	}

	/** required getters methods */

	public String getClientID(){return clientID;}
	public String getCLientName(){return clientName;}
	public double getBalInJD(){return balInJD;}
	public double getBalInNIS(){return balInNIS; }
	public String getBranchCity(){return branchCity;}

	/** required setter methods */

	public void setClientID(String clienID){this.clientID = clientID;}
	public void setCLientName(String clientName){this.clientName = clientName;}
	public void setBalInJD(double balInJD){this.balInJD += balInJD;}
	public void setBalInNIS(double balInNIS){this.balInNIS += balInNIS;}
	public void setBranchCity(String amount){this.branchCity = branchCity;}

	/* A method that adds the amount to the balanceJD if it positive */

	public void depositJD(double amount){

		if(amount > 0){
			balInJD += amount; 
			System.out.println("$"+amount+" has been credited to the bank account."); 
		}
	}

	/* A method that adds the amount to the balanceNIS if it positive */
	public void depositNIS(double amount){

		if(amount > 0){
			balInNIS += amount; 
			System.out.println("$"+amount+" has been credited to the bank account."); 
		}
	}

	/* A method that subtracts the amount from the balanceJD, if the 
	amount is positive and less than the account balance */

	public void withdrawJD(double amount){

		if(amount > 0 && amount < balInJD){
			balInJD -= amount;  
			System.out.println("$"+amount+" has been debited from the JD account.");
		}
		else{
			System.out.println("Invalid balance is requested!");
		}
	}

	/* A method that subtracts the amount from the balanceNISs, if the 
	amount is positive and less than the account balance */

	public void withdrawNIS(double amount){

		if(amount > 0 && amount < balInNIS){
			balInNIS -= amount;  
			System.out.println("$"+amount+" has been debited from the NIS account.");
		}
		else{
			System.out.println("Invalid balance is requested!");
		}
	}
	/* A method that transfer balances on the same account */
	public void transferIN(double amount, String transToCurr){

		// for transfer from JD to NIS

		if(transToCurr.equalsIgnoreCase("NIS") && amount <= balInJD){

			// 1 JD = 4.54 NIS, from google results 
			double amountINNIS = 4.54 * amount;
			// add the entered balance to NIS 
			balInNIS += amountINNIS;
			// subtract the requested balance from JD that has been added to NIS
			balInJD -= amount;
			System.out.println("Transaction successful from JD to NIS in same account");
		}
		else{

			System.out.println("Sorry transfer can't be done to NIS because of low balance in JD");
		}

		// For NIS to JD
		if(transToCurr.equalsIgnoreCase("JD") && amount <= balInNIS){

			// 1 NIS = 1 / 4.54 JD 
			double amountINJD =  (double) amount / 4.54;
			// add the entered balance to JD
			balInJD += amountINJD;
			// subtract the requested balance from JD that has been added to NIS
			balInNIS -= amount;
			System.out.println("Transaction successful from NIS to JD in same account");

		}

		else{

			System.out.println("Sorry transfer can't be done to JD because of low balance in  NIS");
		}
	}

	/* A method for transfering between different accounts */

	public void transferOut(BankAccount1 transToAcc, String transToCurr, double amount){

		// for transfer from JD to NIS

		if(transToCurr.equalsIgnoreCase("NIS") && amount <= this.balInJD){

			// 1 JD = 4.54 NIS, from google results 
			double amountINNIS = 4.54 * amount * exchangeRate;
			// add the entered balance to NIS 
			transToAcc.setBalInNIS(amountINNIS);
			// subtract the requested balance from JD that has been added to NIS
			this.balInJD -= amount;
			System.out.println("Transaction successful from JD to NIS in different account");
		}
		else{
			System.out.println("Sorry transfer can't be done through client A because of low balance in JD");
		}

		// For NIS to JD
		if(transToCurr.equalsIgnoreCase("JD") && amount <= balInNIS){

			// 1 NIS = 1 / 4.54 JD 
			// convert the balance and add the exchange rate 
			double amountINJD =  (double) (amount / 4.54) * exchangeRate;
			// add the entered balance to JD
			transToAcc.setBalInJD(amountINJD);
			// subtract the requested balance from JD that has been added to NIS
			this.balInNIS -= amount;
			System.out.println("Transaction successful from NIS to JD in different account");

		}

		else{
			System.out.println("Sorry transfer can't be done through client B to JD because of low balance in  NIS");
		}
	}

	// overridden toString method of Object class 
	@Override
	public String toString(){

		String output = "\nClient ID: "+ clientID +"\n" +
						"Client Name: "+ clientName + "\n" +
						"Balance In JD currency: "+balInJD + "\n" +
						"Balance in NIS currency: "+balInNIS + "\n" +
						"Bank Account Branch City: "+ branchCity + "\n";

		return output;
	}

	// main driver method 
	public static void main(String[] args) {
		
		BankAccount1 bankAccount1 = new BankAccount1("Priya@1234", "Priya", 1000.00, 500.00, 15, "Gurgaon");
		bankAccount1.depositJD(100);
		bankAccount1.withdrawJD(800);
		bankAccount1.withdrawJD(200);
		System.out.println("\nDisplaying information....\n"+bankAccount1.toString());
		bankAccount1.transferIN(2000, "NIS");
		bankAccount1.transferIN(2000, "JD");
		System.out.println("\nDisplaying information....\n"+bankAccount1.toString());
		BankAccount1 bankAccount2 = new BankAccount1("Priya@456", "Priya Bhatt", 500.00, 500.00, 12, "Delhi");
		bankAccount1.transferOut(bankAccount2, "JD", 200);
		System.out.println("\nDisplaying information....\n"+bankAccount2.toString());
	}


}