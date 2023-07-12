import java.util.Scanner;
import java.io.File;

public class DNASequence{

/** method that takes two parameters and returns +1 to tell 
 * success status if the given dna string contains the sequence 
 * string **/
	public static int searchProtein(String sequence, String dna){

/** search for the sequence in the dna string **/
		if(dna.contains(sequence)){
			System.out.println("Protein is found in the DNA sequence.");
			return 1; // success status 
		}

		else{
			System.out.println("Protein is not found in the DNA sequence.");
			return -1; // failure status 
		}
	
	}
// main driver method 
	public static void main(String[] args) {
	
		try{

			/** Scanner class object for reading dna sequence 
			 * from the file **/
			Scanner fileReader = new Scanner(new File("dna.txt"));
			/** Scanner object to read a value from the console 
			 * screen to search within the dna sequence **/

			Scanner console = new Scanner(System.in);

			// stores sequences of letters A, C, G, and T
			String dna = "";

			/** read the file contents **/
			while(fileReader.hasNextLine()){
				dna += fileReader.nextLine();
			}

			/** read the protein sequence that needs to be searched within
			 * the dna sequence **/
			System.out.println("Enter a protein sequence to search: ");
			String sequence = console.next();

			/* length of sequence must be 3, so validate before searching it
			within the dna sequence **/
			if(sequence.length() != 3){
				System.out.println("Invalid length value is entered!");
				System.exit(1);

			}

			/** call the method to search the sequence within the dna 
			 * string **/
			searchProtein(sequence, dna);

		}

		catch(Exception e){
			System.out.println("Error: "+e.getMessage());
		}
	}
	
}