import java.util.Scanner; // for user inputs 
public class TemperatureDemo{
/** main driver method **/	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);

		System.out.print("Enter the fahrenheit temperature: ");
		double temp = input.nextDouble();
		/** create an object of Temperature class and temp to object type **/
		Temperature tempObj = new Temperature(temp);
		/** call getCelcius method to display the temperature in
		 * celcius **/
		System.out.printf("Celcius: %.2f\n", tempObj.getCelcius());
		/** call getKelvin method to display the temperature in
		 * kelvin **/
		System.out.printf("Kelvin: %.2f\n", tempObj.getKelvin());
	}
}

Terminology:
Explanation is just the completed answer.
Revise to briefly include why it's called relational.

Examples:
Hint cues the answer.
Revise the hint.