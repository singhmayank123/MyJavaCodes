/* A Java program to read content from one file and write it into another file in secret code. */
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
// Creating class  
class Encryption 
{
  
 
    public static void main(String[] args)
    {
 
  
        // Try block to handle exceptions
        try {
  
            // Creating a FileReader object to read a file and pass the file name to an object of FileReader.
       
            FileReader fr = new FileReader("read.txt");
 
  
            // Creating a FileWriter object to write into a file and pass the file name to be created.
            FileWriter fw = new FileWriter("write.txt");
 
            // Declearing a String object to hold the content of a file.
            String s= "";
            // Declare a variable to hold characters return from a file.
            int ch;
 
            // Reading the file using read() from beginning to end.
            while ((ch = fr.read()) != -1) 
{
     // Adding 10 to the character code of each character returned from the file.            
     int a=ch+10;
  
                // Saving every character in the string.
                s+= (char)a;
            }
  
            // Writing the data contained in the String object to FileWriter object.
            fw.write(s);
  
            // Closing the file using close() method
    
            fr.close();
            fw.close();
  
            // Display message
            System.out.println("File encryption is done.");
        }
  
        // Catch block to catch the exception
        catch (IOException e) 
{
  
            // If there is no file as specified by the parameter passed to FileReader's constructor
  
            // Print the message.
            System.out.println("No such file is found.");
        }
    }
}