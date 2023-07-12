/** This program work on basic inputs and outputs 
 * with variables **/
 
/** Import the Scanner class that helps to take user input **/
  
import java.util.Scanner;

/** Public class that represents the structure of the given
 *  task. Please do save the java file same as the class name.
 * For instance, if class name is ZyLab then file name should be
 * ZyLab.java **/

public class ZyLab{

	/* main driver method that invokes automatically when the program runs */

	public static void main(String[] args) {
		
		/** Create an object of Scanner class to read user input **/
		Scanner keyboard = new Scanner(System.in);
		int userNum = 0; // Integer variable that holds the user value 
		/** Prompt a message to the user **/
		System.out.println("Enter integer: ");
		/** read the next integer value from the console screen
		 * and store to userNum **/
		userNum = keyboard.nextInt();
		/** prompt the message for displaying the entered value **/
		System.out.println("You entered: "+userNum);		
		/** store the square of userNum value **/
		int squared = userNum*userNum; 
		/** prompt the square of entered number */
		System.out.println(userNum + " squared is "+squared);
		/** store the cube of userNum value **/
		int cubed = userNum*userNum*userNum;
		/** prompt the cube of userNum **/
		System.out.println(userNum + " cubed is "+cubed);
		/** prompt the sum of square and cube **/
		System.out.println(userNum + " squared "+" + "+ userNum + 
			" cubed is "+ (squared + cubed));
		/** prompt the user to enter another number **/
		System.out.println("Enter another number: ");
		/** store the number into separate variable **/
		int userNum2 = keyboard.nextInt();
		/** prompt the sum of userNum and userNum2 **/
		System.out.println(userNum + " + "+ userNum2 + " is "+ (userNum + userNum2));
		/** prompt the product of userNum and userNum2 **/
		System.out.println(userNum + " * "+ userNum2 + " is "+ (userNum * userNum2));
		/** prompt the subtraction of userNum and userNum2 **/
		System.out.println(userNum + " - "+ userNum2 + " is "+ (userNum - userNum2));
	} 
 }
