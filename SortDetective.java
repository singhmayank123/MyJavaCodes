/** this program simulates the sort detective 
 * challenge. This program uses 2 sorting techniques
 * merge sort and selection sort that is 
 * mentioned in the chapter. These sorting techniques 
 * are anonymous to the user and they need to guess
 * which technique is applied by seeing the 
 * characteristics **/

import java.util.Scanner; // for taking user inputs 

/** Main class that performs the given task **/
public class SortDetective{

/** static method that returns a random value between 
 * min and max **/
	public static int getRandValue(int min, int max){

		int randNum = 
			(int)(Math.floor(Math.random()*(max-min+1)+min));

		return randNum;

	}

/** method for printing the result of the applied sorting **/

	public static void printResult(long startTime, long endTime,
	 int size){

		System.out.println("Random sort characteristics");
		System.out.println("Total Size: "+ size);
		System.out.println("Total time taken: "+
			(endTime - startTime) + " milli seconds");
	}

/** methodd that prints a menu to the user and allow them
 * to choose a option **/
	public static int printMenu(Scanner input){

		System.out.println("Enter 1 for alpha sort");
		System.out.println("Enter 2 for beta sort");
		System.out.println("your response ? ");
		int res = input.nextInt();

		return res;
	}

/** method that process the selected choice and prints the 
 * required result **/	
	public static int processChoice(int selectedSort, int res){

		if(selectedSort == res){
			System.out.println("Good Job!! You Guessed it correctly.");
			return 1;
		}
		else{
			System.out.println("Wrong Guess!! Try again.");
			return -1;
		}
	}

// main driver method 
	public static void main(String[] args) {

// create an object of Scanner class to read user input
		Scanner input = new Scanner(System.in);
/* initialize a random size in b/w 50000 and 60000
for the datasets */
		int size = getRandValue(50000, 60000);
/* create an array of integers to store numeric values **/
		int nums[] = new int[size];
/** fill the array with random values **/
		for(int i = 0; i < size; i++){
			nums[i] = getRandValue(1, size);
		}
// store number of sorting techniques used in the program 
		final int NUM_OF_SORT = 2;
// randomly select a sorting technique 
		int selectedSort = getRandValue(1, NUM_OF_SORT);

		System.out.println("Choosing a random sorting technique....");
/** validate the selected technique **/
		if(selectedSort == 1){
// get the initial time in milliseconds 
			long startTime = System.currentTimeMillis();
// call the sorting function to sort the array 
			Sort.selectionSort(nums);
// get the end time 
			long endTime = System.currentTimeMillis();
// print th result 
			printResult(startTime, endTime, size);

		}
	// for merge sort 	
		else if(selectedSort == 2){

			long startTime = System.currentTimeMillis();
			Sort.mergeSort(nums);
			long endTime = System.currentTimeMillis();
			printResult(startTime, endTime, size);
		}
// number of guesses that user can enter 
		int NUM_OF_GUESSES = 1;
/* keep processing the results until there are more guesses **/
		while(NUM_OF_GUESSES > 0){

			int res = printMenu(input);
			int succ = processChoice(selectedSort, res);
			if(succ == 1) break;

			NUM_OF_GUESSES--;
		}
	}
}