
// 70 questions 
// A or B choice

// 10 groups of 7 ques in each

/* for each group 

first question ask whether introvert or not 
next two question -- guided by his/her senses / by his/her intuitions
next two questions - focus on thinking / feeling
next two question / prefer two judge or guided by perception


*/

import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Test 
{	
	

	public static void main(String[] args) throws IOException 
	{
		File file = new File("pc4.txt");     //Creation of File Descriptor for input file
		
		Scanner inputFile = new Scanner(file);


		ArrayList<String> names = new ArrayList<>(2);
		ArrayList<String> responses = new ArrayList<>(2);
		ArrayList<Character> dim1 = new ArrayList<>();
		ArrayList<Character> dim2 = new ArrayList<>();
		ArrayList<Character> dim3 = new ArrayList<>();
		ArrayList<Character> dim4 = new ArrayList<>();


		int i = 0;
		String line;

		while(inputFile.hasNextLine())         //Read char by Char
		{

			line = inputFile.nextLine();

			if(line.length() < 70)
				names.add(line);

			responses.add(line);

		}


	}
}