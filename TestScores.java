// The program can be tested in Eclipse IDE, JAVA 11.
/** This program takes the five TestScores objects and
 * serializes them and then deserialized them */
import java.util.Scanner;
import java.io.*;
public class TestScores implements Serializable
{
	private double[] arrayOfScores;
    // Parameterized constructor
	public TestScores(double[] demo) throws IllegalArgumentException 
	{
		arrayOfScores = new double[demo.length];
		for (int i = 0; i < demo.length; i++) 
		{
			if (demo[i] < 0 || demo[i] > 100)
				throw new IllegalArgumentException("Test scores should be in the range of 0 to 100.");
			else
				arrayOfScores[i] = demo[i];
		}
	}
	// Function to find the average of scores
	public double AvgScore()
	{
		double totScore = 0.0;
		for (int i = 0; i < arrayOfScores.length; i++)
			totScore += arrayOfScores[i];
		return (totScore / arrayOfScores.length);
	}

	public String toString(){

		String scores = "";

		for(int i = 0; i<arrayOfScores.length; i++){
			scores += (arrayOfScores[i]+" ");
		}

		return scores;
	}
	
    // Main function
	public static void main(String[] args) throws Exception
	{
		
		int num_scores = 0;
		Scanner io = new Scanner(System.in);
		System.out.print("Enter number of test scores: ");
		num_scores = io.nextInt();
		double[] array1 = new double[num_scores];
		

		final int TEST_SCORES_OBJECTS = 5; // create an array of five objects 

		// An array of five TestScores objects 
		TestScores[] testScores = new TestScores[TEST_SCORES_OBJECTS];

		// initialize the five objects

		for(int i = 0; i<TEST_SCORES_OBJECTS; i++){

			System.out.println("Enter 5 test scores for object"+(i+1)+": ");
			for(int j = 0; j<num_scores; j++){
				array1[j] = io.nextDouble();
			}

			testScores[i] = new TestScores(array1);
		}


		// Create the stream object file
	
		FileOutputStream outStream = new FileOutputStream("TestScores.dat");

		// Create the object stream 
		ObjectOutputStream outObject = new ObjectOutputStream(outStream);

		// Serializing the objects 
		for(int i = 0; i<TEST_SCORES_OBJECTS; i++){
			outObject.writeObject(testScores[i]);
		}

		// close the file 
		outObject.close();

		System.out.println("Serialization is done for objects");

		//for Deserializing the objects 
		FileInputStream inFile = new FileInputStream("TestScores.dat");

		ObjectInputStream inObject = new ObjectInputStream(inFile);

		TestScores testObject = null; 

		System.out.println("\nPrcoessing the deserialization...\n");
		System.out.println("\nBelow are the deserialized objects data\n");
		for(int i = 0; i<TEST_SCORES_OBJECTS; i++){
			// downcast the object 
			testObject = (TestScores) inObject.readObject();
			System.out.println(testObject.toString());
		}

		inObject.close();
				
	}
}