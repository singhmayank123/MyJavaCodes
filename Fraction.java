
/** class to represent a fraction **/
public class Fraction{

	public int numerator; // for storing numerator of a fraction 
	public int denominator; // for storing numerator of a fraction 
/** default fraction **/
	public Fraction(){
		numerator = 0;
		denominator = 1;
	}

	/** parameterized constructor **/

	public Fraction(int numerator, int denominator){
		this.numerator = numerator;
		this.denominator = denominator;
	}

	/** return a string of fraction **/

	public String toString(){

		if(numerator == 0 && denominator != 0)
			return "0";

		if(denominator == 1)
			return (""+numerator);

		return (numerator + "/"+denominator);
	}
/** method to find the highest common factor of two numbers **/
	private int greatestCommonDivisor(int num1, int num2){

        if (num1 == 0)
            return num2;
        else if (num2 == 0)
            return num1;
        while (num1 != num2) {
            if (num1 > num2)
                num1 = num1 - num2;
            else
                num2 = num2 - num1;
        }

        return num1;
	}
/** method that simplies the fraction **/
	public void simplify(){

		if(denominator < 0){
			numerator *= -1;
			denominator *= -1;
		}

		int cf = greatestCommonDivisor(numerator, denominator);

		while(cf != 1){

			numerator /= cf;
			denominator /= cf;
			cf = greatestCommonDivisor(numerator, denominator);
		}
	}
	/** method to multiply two fractions **/
	public static Fraction multiply(Fraction a, Fraction b){

		/** create a new fraction object to store the result 
		 * of multiplication **/
		Fraction mulResult = new Fraction();
		mulResult.numerator = a.numerator * b.numerator;
		mulResult.denominator = a.denominator * b.denominator;
		mulResult.simplify();
		return mulResult;
	}
	/** method to divide two fractions **/
	public static Fraction divide(Fraction a, Fraction b){
		/** create a new fraction object to store the result of
		 * division **/
		Fraction divResult = new Fraction();
		divResult.numerator = a.numerator * b.denominator;
		divResult.denominator = a.denominator * b.numerator;
		divResult.simplify();
		return divResult;
	}
	/** method to add two fractions **/
	public static Fraction add(Fraction a, Fraction b){
		
		Fraction addResult = new Fraction();
		addResult.denominator = a.denominator * b.denominator;
		addResult.numerator = (b.denominator * a.numerator +
		 a.denominator * b.numerator);
		addResult.simplify();
		return addResult;
	}
	/** method to subtract two fractions **/
	public static Fraction subtract(Fraction a, Fraction b){
		
		Fraction subResult = new Fraction();
		subResult.denominator = a.denominator * b.denominator;
		subResult.numerator = (b.denominator * a.numerator -
		 a.denominator * b.numerator);
		subResult.simplify();
		return subResult;
	}
}