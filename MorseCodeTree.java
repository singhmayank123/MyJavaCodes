
import java.util.*;
import java.io.*;


public class MorseCodeTree{

/** Node class that represents the each node of the tree */
	private class MorseNode{
	
		char letter; // for storing the characters like numbers and alphabets 
		String morseCode; // for storing morseCode of each letter  
		MorseNode left;  // points to the left node  
		MorseNode right; // points to the right node 

// Constructor for initialization 
		MorseNode(){

			letter = ' ';
			left = right = null;
		}
// constructor for setting the letter 
		MorseNode(char letter){
			this.letter = letter;
		}
	
	}

	public MorseNode root; // for the root of the binary tree 

// constructor for initialization 
	public MorseCodeTree(){

		root = new MorseNode(); // initializ the root 
		readEncodings(); // to read the characters encoding from the file 
	}

/** method that reads each character and their morse code and
 * stores them to the binary tree */ 
	public void readEncodings(){

		Scanner input = null;

		try {

			input = new Scanner(new File("encodings.txt"));
		}

		catch (FileNotFoundException exception) {

			System.out.println("File not found!");
		}
// keep iterating while there is new line in the line 
		while (input.hasNextLine()) {
			// get the data 
			String data = input.nextLine().trim();

			if (data.length() > 0) {

				// call the addNode method to store each character and the morse code 
				addNode(data.substring(1).trim(), data.charAt(0));
			}
		}

		input.close(); // close the file 
	}

/** Method that adds each letter at appropriate position in the tree **/

	public void addNode(String morseCode,  char letter){

		MorseNode current = root; // start from root 
		String substr = "";

//iterate each character of morse code 
		for (int i = 0; i < morseCode.length(); i++) {

			// get the character 
			substr = morseCode.substring(i, i + 1);

			if (substr.equals(".")) {

				// keep going to the left if character is "." until left is null 
				if (current.left != null)
					current = current.left;

				// if left is null, assign a new node to it and go to the left 
				else{
					current.left = new MorseNode();
					current = current.left;
				}
			}

			// when the read character is "-""
			else {

				if (current.right != null)
					current = current.right;

				else {
					current.right = new MorseNode();
					current = current.right;
				}
			}
		}
		
		/** current will point at the correct position where the 
		 * letter should store */
		current.letter = letter; // store the letter 
		current.morseCode = morseCode; // store the morseCode 

	}

	// method that returns the stored morse code of the node 
	public String getCode(MorseNode current, char letter){

		if(current != null){
	        if(current.letter == Character.toLowerCase(letter)){
	           return current.morseCode;
	        } 

	        else {

	            String foundNode = getCode(current.left, letter);
	            if(foundNode == "") {
	                foundNode = getCode(current.right, letter);
	            }
	            return foundNode;
	         }
	    }
	    else 
        	return "";	
	}

// method that encodes the text contents of a file to the morse code  
	public void encode(){

		String word = ""; // stores the word from the file 
		String morseCode = "";	// stores the encode morse code 			
		MorseNode current = root; // start from root 

		try{

			System.out.println("Encrypting the text to morse code........");
			// open the text file for encoding the characters 
			File encode = new File("encode.txt");

			Scanner input = new Scanner(encode);

			// keep reading until there are more words 
			while(input.hasNext()){

				word = input.next(); // store the read word 
		
				for(int i = 0; i<word.length(); i++){
					
					// get the morseCode of each character and append it to morseCode 
					morseCode += (getCode(current, word.charAt(i)) + " ");
				}
			}

			input.close(); //close the file 

			File decode = new File("decode.txt");

			// for printing to the file 
			PrintWriter out = new PrintWriter(decode);

			// print to the file 
			out.append(morseCode+"\n");

			out.close(); // close the file
			
			System.out.println("Encryption done and saved to the file \"decode.txt\".");

		}
// handle the exceptions 
		catch(Exception e){
			System.out.println("file not found exception occurs!");
			e.printStackTrace();
		}
	}

	/** method that returns the stored character of the particular morse code */

	public char getChar(MorseNode current, String code){
		
		if(current != null){
			for(int i = 0; i<code.length(); i++){

				if(code.charAt(i) == '.')
					current = current.left;

				if(code.charAt(i) == '-')
					current = current.right;
			}
		}

		return current.letter;
	}

/** method that decodes the morse code file to the sequence of 
 * characters **/
	public void decode(){

		String code = ""; // stores the read code 
		StringBuilder word = new StringBuilder(); // stores the decodes characters 

		MorseNode current = root; // start from root 

		try{

			// open the file 
			File decode = new File("decode.txt");

			Scanner input = new Scanner(decode);

			// read each morse code 
			while(input.hasNext()){
				// store the morse code 
				code = input.next();
				// append the character represent the morse code to the word 
				word.append(getChar(current, code));
			}

			decode = new File("encode.txt");
			// for writing to the file 
			PrintWriter out = new PrintWriter(decode);

			// write the decoded word to the file 
			out.println(word);

			out.close(); // close the file 

			System.out.print("Decryption done and saved to file \"encode.txt\" ");
		}

		// handle the exceptions 
		catch(FileNotFoundException e){
			System.out.println("file not found exception occurs!");
			e.printStackTrace();
		}

	}

// main driver method 
	public static void main(String[] args) {
		
		MorseCodeTree morse = new MorseCodeTree();

		morse.encode(); // for encoding the file contents 

		morse.decode(); // for decoding the file contents 
	}
				
}