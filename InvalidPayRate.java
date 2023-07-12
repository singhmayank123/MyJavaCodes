/** An exception class for throwing an error when an negative
 *  invalid pay rate is passed */

public class InvalidPayRate extends Exception{

	private String errMsg; 

	public InvalidPayRate(){
		errMsg = "Error! Negative pay rate.";
	}

	public String getMessage(){
		return errMsg; 
	}
}
