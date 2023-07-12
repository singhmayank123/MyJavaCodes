/* ProductionWorker class that inherits the Employee clas */


public class ProductionWorker extends Employee
{
	private int shift;
	private double payRate;

	public ProductionWorker(String name, String empNumber,
	 String hireDate, int shift, double payRate){

	// invoke the super method to initialize the superclass state
		super(name, empNumber, hireDate);

		try{

			if(shift == 1 || shift == 2)
			    this.shift = shift;
			else
				throw new InvalidShift();
		}

		catch(InvalidShift e){

			System.out.println(e.getMessage());
			
		}


		try{
			if(payRate < 0)
				throw new InvalidPayRate();
			this.payRate = payRate;
		}

		catch(InvalidPayRate e){
			System.out.println(e.getMessage());
		}
	
		
	}

	// Accessors for instance variables 
	public int getShift()
	{
		return shift;
	}

	public double getPayRate()
	{
		return payRate;
	}
	// Mutators for instance variables 

	public void setShift(int shift){

		
		try{

			if(shift == 1 || shift == 2)
			    this.shift = shift;
			else
				throw new InvalidShift();
			
		}

		catch(InvalidShift e){

			System.out.println(e.getMessage());
			
		}

	}

	public void setPayRate(double payRate){
		try{
			if(payRate < 0)
				throw new InvalidPayRate();
			this.payRate = payRate;
		}

		catch(InvalidPayRate e){
			System.out.println(e.getMessage());
		}
	}
}
