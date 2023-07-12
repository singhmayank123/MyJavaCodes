/* Main class to demonstrate the Essay class */

import javax.swing.JOptionPane; // for GUI input/outputs

public class EssayMain{

// main driver method 
	public static void main(String[] args) {

	// Helps in running the loop until all the parameters are read 
		boolean allRead = false; 

	// Essay score parameters 
		double grammar = 0, spelling = 0, cor_length = 0, content = 0;
	
	// loop until allRead set to true 	
		while(!allRead){

		// Read grammar score
			grammar = Float.parseFloat(JOptionPane.showInputDialog("Enter grammar points: "));
		// validate the score 
			if(grammar > 30){
				JOptionPane.showMessageDialog(null, "Maximum points is 30. Enter again");
				continue;
			}
		// read spelling score 
			spelling = Float.parseFloat(JOptionPane.showInputDialog("Enter spelling points: "));
		// validate the score 
			if(spelling > 20){
				JOptionPane.showMessageDialog(null, "Maximum points is 20. Enter again");
				continue;
			}
		// read correct length score 
			cor_length = Float.parseFloat(JOptionPane.showInputDialog("Enter correct length points: "));
		// validate the score 
			if(cor_length > 20){
				JOptionPane.showMessageDialog(null, "Maximum points is 20. Enter again");
				continue;
			}
		// read content score 
			content = Float.parseFloat(JOptionPane.showInputDialog("Enter content points: "));
		// validate the score 
			if(content > 30){
				JOptionPane.showMessageDialog(null, "Maximum points is 30. Enter again");
				continue;
			}
		// set allRead to true for terminating the loop
			allRead = true;

		}

		// Create the instance of Essay class and pass each field to the Object type

		Essay e = new Essay(grammar, spelling, cor_length, content);

		// print the grade achieved by the total scores 
		JOptionPane.showMessageDialog(null, String.format("Achieved grade is: %c", e.getGrade()));
	}
}