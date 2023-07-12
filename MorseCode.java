
import java.util.*;
import java.io.*;


public class MorseCodeTree{

	private class MorseNode{
	
		char letter;
		MorseNode left; 
		MorseNode right; 

		MorseNode(){

			letter = ' ';
			left = right = null;
		}

		MorseNode(char letter){
			this.letter = letter;
		}
		
	}

	private MorseNode root;

	public MorseCodeTree(){

		root = new MorseNode();
		readEncodings();
	}

	public void readEncodings(){

		Scanner input = null;

		try {

			input = new Scanner(new File("encodings.txt"));
		}

		catch (FileNotFoundException exception) {

			System.out.println("File not found!");
		}

		while (input.hasNextLine()) {

			String data = input.nextLine().trim();

			if (data.length() > 0) {

				addNode(data.substring(1).trim(), data.charAt(0));
			}
		}

		input.close();
	}

	public void addNode(String morseCode,  char letter){

		MorseNode current = root;
		String substr = "";

		for (int i = 0; i < morseCode.length(); i++) {

			substr = morseCode.substring(i, i + 1);

			if (substr.equals(".")) {

				if (current.left != null)
					current = current.left;

				else{
					current.left = new MorseNode();
					current = current.left;
				}
			}

			else {

				if (current.right != null)
					current = current.right;

				else {
					current.right = new MorseNode();
					current = current.right;
				}
			}
		}
		
		current.letter = letter;

	}

	public String getCode(MorseNode current, char letter, String code){

		if (current.letter == letter)
			return code;
		
		else if (current.left != null)
			return getCode(current.left, letter, (code + "."));
		
		else if (current.right != null)
			return getCode(current.right, letter, (code + "-"));
	   
		return code;
	}

	public String encode(){

		try{

			File decode = new File("encode.txt");

			Scanner input = new Scanner(decode);

			String word = "";

			String morseCode = "";

			String charCode = "";


			MorseNode current = root;

			while(input.hasNext()){

				word = input.next();

				for(int i = 0; i<word.length(); i++){

					morseCode += getCode(current, word.charAt(i), charCode);
				}

			}

			return morseCode;
		}

		catch(FileNotFoundException e){
			System.out.println("file not found exception occurs!");
			e.printStackTrace();
		}

		
	}

	public static void main(String[] args) {
		
		MorseCodeTree morse = new MorseCodeTree();

		morse.encode();	
	}
				
}