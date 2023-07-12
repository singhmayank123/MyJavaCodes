/** Employee class for representing the Employee */
/** This class can be compiled and tested on Eclipse, java 11 */


public class Employee{

	private String name; // for employee name 
	private String empNumber; // for employee number 
	private String hireDate; // for hiring data

	//This method returns true, if passed string is a valid employee number 
    public static boolean isValidEmpNumber(String s){

    	String pattern= "^[0-9]{4}[A-M]$";
    	return s.matches(pattern);
    }

    /* Constructor that initializes the EMployee State */

	public Employee(String name, String empNumber, String hireDate) {

		try{

			if(isValidEmpNumber(empNumber)) 
				this.empNumber = empNumber;
			else
				throw new InvalidEmployeeNumber();
		}
		catch(InvalidEmployeeNumber e){
			System.out.println(e.getMessage());
		}
		
		this.name = name;
		
		this.hireDate = hireDate;
	}

	// Mutators for each instance variable 

	public void setName(String n){
		name = n;
	}

	public void setEmpNumber(String empNumber){

		try{

			if(isValidEmpNumber(empNumber)) 
				this.empNumber = empNumber;
			else
				throw new InvalidEmployeeNumber();
		}
		catch(InvalidEmployeeNumber e){
			System.out.println(e.getMessage());
		}

		
	}

	public void setHireDate(String h)
	{
		hireDate = h;
	}

	// Accessors for each instance variable 

	public String getName()
	{
		return name;
	}

	public String getEmpNumber()
	{
		return empNumber;
	}

	public String getHireDate()
	{
		return hireDate;
	}
}

