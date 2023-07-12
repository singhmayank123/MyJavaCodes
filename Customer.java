/* Customer class that inherits the Person class */

public class Customer extends Person{

/* instance variables */
	private int cusNo;  // for customer number 
	private boolean hasMailList;  // indicates whether customer is on mailing list or not 

/* A no-arg constructor that sets the default values of the instance variables */
	public Customer(){

// call super method to set the super class variables 
		super("null", "null", "null");

		this.cusNo = 0;
		this.hasMailList = false;

	}

/* Constructor that initializes the variables by user-defined values */
	public Customer(String name, String address, String telephone, 
		int cusNo, boolean hasMailList){

		super(name, address, telephone);

		this.cusNo = cusNo;
		this.hasMailList = hasMailList;
	}

/* Accessor methods  */
	public int getCusNo(){
		return cusNo;
	}

	public boolean isOnMailingList(){
		return hasMailList;
	}

/* Mutator methods */
	public void setCusNo(int cusNo){
		this.cusNo = cusNo;
	}

	public void setMailingList(boolean hasMailList){
		this.hasMailList = hasMailList;
	}

}