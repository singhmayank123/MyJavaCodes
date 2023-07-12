import java.io.FileReader; // imports FileReader class for reading the contents from file 
import java.io.FileWriter; // imports FileWriter class for writing te contents to the file 
import java.io.IOException; // imports IOException class for file exceptions

/** Decryption that represents the method decryption */

public class Decryption{

	/** Static method that takes a FileReader class object. It decrpyts 
	 * the content of write.txt file and restore the decrypted contents 
	 * in the read.txt file and create another file to write the decrypted
	 * text. */
	
	public static void decryptFile(FileReader inputFile) throws IOException{

		StringBuilder s = new StringBuilder();

		int ch = 0; 

		while((ch = inputFile.read()) != -1){
			ch -= 10;
			s.append((char)ch);
		}

		System.out.println("Decryption done! ");

		FileWriter fw1 = new FileWriter("decrypt.txt");
		fw1.write(s.toString());

		FileWriter fw2 = new FileWriter("read.txt");

		fw2.write(s.toString());

		fw1.close(); fw2.close();

	}

	// main driver method 
	public static void main(String[] args) {

		try{

		// Create an instance of FileReader class 
			FileReader fr = new FileReader("write.txt");
		// Call the decrypt method 
			decryptFile(fr);
			fr.close();
		}

		catch(Exception e){}
		
	}
}