/* An exception class for throwing an error 
when an invalid employee number is passed */
public class InvalidEmployeeNumber extends Exception{

	private String errMsg; 

	public InvalidEmployeeNumber(){
		errMsg = "Error! Invalid employee number.";
	}

	public String getMessage(){
		return errMsg; 
	}
}
