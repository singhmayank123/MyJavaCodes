/** An exception class for throwing an error when an invalid
 * shift is passed */

public class InvalidShift extends Exception{

	private String errMsg; 

	public InvalidShift(){
		errMsg = "Error! Invalid shift.";
	}

	public String getMessage(){
		return errMsg; 
	}
}
