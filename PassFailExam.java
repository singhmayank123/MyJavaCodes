import java.util.Scanner; // for Using Scanner class to take user input 
import java.io.File; // for File class 
import java.util.Arrays; // for pred-defined Arrays class function 

// Class implementation
public class PersonalityTest{

/** Static method that returns the final code based on the percentage 
 * in each dimension */
	public static String getCode(double percentOfB[]){

		String code = "";
		String first[] = {"E", "S", "T" , "J"}; // for first-type of four dimensions
		String second[] = {"I", "N", "F", "P"}; // for second-type of four dimensions 

		for(int i = 0; i<first.length; i++){
/* Check if percent of B in each dimension is less than 50% */
			if(percentOfB[i] < 50.0)
		/* if so, add the first type to the code */
				code += first[i];
		/* Otherwise,add the second to the code */
			else
				code += second[i];
		
		}
        
        /* return the code */
		return code;
				
	}
	
	// main driver method 

	public static void main(String[] args) {

/* create a 2D array for storing the count of A an B in each dimension */
		int dim[][] = new int[4][4];
/* create a 1D array for storing the percentages of B in each dimension */
		double percentOfB[] = new double[4];

		String name; // for storing the name from the file 
		String responses; // for storing set of responses of 70 questions from file 

		int j = 0; // j is used to increment the index for every next of 7th questions 
		int k = 0; // k is used for indexing of questions from 2 to 7 for each group 
		int count = 0; // count is used to change the k value 

		try{

			File file = new File("pc4.txt"); // open the file and refer to the object file 

			Scanner input = new Scanner(file); // refer the file to the object input 

// run a while loop to iterate each line from the line 
			while(input.hasNextLine()){

/* fill each row of the 2D array with zeros for every iteration */
				for(int []d : dim)
					Arrays.fill(d, 0);
// reset the value of j for every iteration */
				j = 0;

				name = input.nextLine(); // read the first line, which is the name in the file 
	
				responses = input.nextLine(); // read the second line, which is the set of responses in the file 

/* run a for loop to iterate each character */
				for(int i = 0; i < responses.length(); i++){
// for question number 1, 8, 15 and so on
					if((i+1) == (1 + 7*j)){
/* if response is A then increment the count of A 
						if(resArray[i] == 'A')
							dim[0][0]++;
/* otherwise, increment the count of B */
						if(responses.charAt(i) == 'B')
							dim[0][1]++;
					}
/* for question numbers 2, 3, 4, 5,6,7 of 1st group and the subsequent groups  */
					if((i+1) == (2 + 2*k + 7*j) || (i+1) == (3 + 2*k + 7*j)){
// keep the count of traversed question responses 
						count++; 

						if(responses.charAt(i) == 'A')
							dim[k+1][0]++;

						if(responses.charAt(i)] == 'B')
							dim[k+1][1]++;
						
					}
/** if count is 2, which means 2 question of each dimensions has been recorded,
increment the value of k by 1 to record responses for dimensions 3 and 4. Also, 
reset the count to 0 such that question count of each dimensions can be recorded,
whose count is 2 in dimension 2, 3 and 4 in each group. */
					if(count == 2){
						count = 0; 
						k++; 
					}
/* check if first group is traversed, then change the value of j for the next group, 
and reset the value of k for the new group responses */
					if((i+1) % 7 == 0){
						j++;
						k = 0;
					}
				}
/* find the percentage of B's response in each dimension and store them in the percentOfB array */
				for(int i = 0; i < 4; i++){
					percentOfB[i] = ((double) dim[i][1] / (dim[i][0] + dim[i][1])) * 100; 
				}
// print the name 
				System.out.println("\n"+name+": ");
// print the A's and B's in each dimension
				for(int i = 0; i<4; i++)
					System.out.print(dim[i][0]+"A-"+dim[i][1]+"B ");
				System.out.print("\n[");
// print the percentages of B in each dimension 
				for(int i = 0; i<percentOfB.length; i++){
			
					if(i == percentOfB.length - 1)
						System.out.printf("%.0f%%", percentOfB[i]);
					else
						System.out.printf("%.0f%%, ", percentOfB[i]);
				}
// print the code based on the percentage of B in each dimension 
				System.out.println("] = " + getCode());				

			}

		}
// catch block to handle exceptions 		
		catch(Exception e){
			System.out.println("Some error encountered!");
		}
	}
}