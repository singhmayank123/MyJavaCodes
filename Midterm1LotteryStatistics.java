import java.io.*;
import java.util.Scanner;

public class Midterm1LotteryStatistics 
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
        {
        //show introduction
        showIntro();
        
        //repeat program method
        repeatProgram();
    }
    
    //show introduction
    public static void showIntro()
        {
        System.out.println("Lottery Statistics\n");
        System.out.println("The program will use the lottery numbers contained\n"
                + "in a file to generate the following:\n\n"
                + "- 10 least common numbers, ordered by frequency\n"
                + "- 10 most common numbers, ordered by frequency\n"
                + "- 10 most overdue numbers, from most overdue to least\n"
                + "- Frequency of each number\n");
    }
    
    //repeat program
    public static void repeatProgram()
        {
        String again;           //variable for do again
        Scanner keyboard = new Scanner (System.in);        
        
        //loop to do again
        do
        {
            //do this again
            runStatisticsProgram();
            
            //ask the user if they would like to run the program again
            System.out.print("\nWould you like to run "
                        + "the program again? (Enter Y or N):  ");
            again=keyboard.nextLine();

            //verify input        
            while ((!again.equalsIgnoreCase("Y")) 
                    && (!again.equalsIgnoreCase("N")))
                                        {

                System.out.print("\nInvalid Entry\n"
                    + "Would you like to run the program again? "
                    + "(Enter Y or N):  ");
                again=keyboard.nextLine();
            }
        }
 
        while (again.equalsIgnoreCase("Y"));
    }
    
    //statistics demo with menu loop
    public static void runStatisticsProgram()
        {
        //create new lottery numbers object with the file of the numbers
        LotteryNumbers test = new LotteryNumbers(getFileName());
        
        //display menu with do again loop for each kind of numbers
        repeatMenu(test);
    }
    
    /**
     * Get the file name and create a LotteryNumbers Object
     * @return Scanner for input file
     */
    public static Scanner getFileName()
    {
        String fileName;    //filename
        
        //create scanner for user input
        Scanner keyboard = new Scanner(System.in);
        
        //get user input
        System.out.print("Please enter the file name: ");
        fileName = keyboard.nextLine();
        
        //call method to open the filename with try/catch
        Scanner inputFile = openFile(fileName);
        
        //while loop to ask for new user input if object creation fails
        while (inputFile == null)
                {
            System.out.print("File not found.\n"
                    + "Please enter the file name: ");
            fileName = keyboard.nextLine(); 
            
            inputFile = openFile(fileName);
        }
        
        //return Scanner
        return inputFile;
    }
    
    /**
     * Open File 
     * @param file user input for file name
     * @return Scanner
     */
    public static Scanner openFile(String file)
        {
        Scanner scan;   //scanner file
        
        //try/catch for file not found
        try
        {
            File lotteryNumbers = new File(file);
            scan = new Scanner(lotteryNumbers);
            
        }
        catch (FileNotFoundException e)
        {
            scan = null;
        }
        
        //return scanner
        return scan;
    }
    
    /**
     * Menu Repeat
     * @param stats LotteryNumbers object
     */
    public static void repeatMenu(LotteryNumbers stats)
        {
        String again;           //variable for do again
        Scanner keyboard = new Scanner (System.in);        
        
        //loop to do again
        do
        {
            //menu options for kind of number stats to display
            displayMenuOptions(stats);
                        
            //ask the user if they would like to see more stats
            System.out.print("\nWould you like to see the statistics "
                        + "for another set of numbers (Enter Y or N):  ");
            again=keyboard.nextLine();

            //verify input        
            while ((!again.equalsIgnoreCase("Y")) 
                    && (!again.equalsIgnoreCase("N")))
                        {

                System.out.print("\nInvalid Entry\n"
                    + "Would you like to see the statistics "
                        + "for another set of numbers? "
                    + "(Enter Y or N):  ");
                again=keyboard.nextLine();
            }
        }
 
        while (again.equalsIgnoreCase("Y"));
    }
    
    /**
     * Display Menu Options
     * @param stats LotteryNumbers Object
     */
    public static void displayMenuOptions(LotteryNumbers stats)
        {
        String input; //user input
                
        Scanner keyboard = new Scanner(System.in);
        
        System.out.print("\nStatistics Menu:\n"
                + "1. All Number Statistics\n"
                + "2. Regular Number Statistics\n"
                + "3. PowerBall Number Statistics\n\n"
                + "Enter choice: ");
        
        input = keyboard.nextLine();
        
        //user input validation
        while (!input.equals("1") && !input.equals("2") && !input.equals("3"))
        {
            System.out.print("\nInvalid Entry. Please try again.\n"
                    + "1. All Number Statistics\n"
                    + "2. Regular Number Statistics\n"
                    + "3. PowerBall Number Statistics\n\n"
                    + "Enter choice: ");
            
            input = keyboard.nextLine();
        }

        //string to int
        int option = Integer.parseInt(input);
        
        //switch for stats dispaly
        switch (option)
                {
                
                case 1: 
                {
                    //display all stats with the all numbers array
                    allNumbersFrequency(stats.getAllNumbersArray());
                    break;
                }
                
                case 2:
                {
                    //display regular stats with the regular numbers array
                    regularNumberFrequency(stats.getRegNumbersArray());
                    break;
                }
                
                case 3:
                {
                    //display powerball stats with the powerball numbers array
                    powerballNumberFrequency(stats.getPBNumbersArray());
                    break;
                }
            }
    }
    
    /**
     * Display All Numbers Frequency
     * @param allNums array of all numbers
     */
    public static void allNumbersFrequency(int[] allNums )
        {
        final int NUMBER_OF_NUMS = 69;      //Number of numbers to analyze
        int occurences;                     //number of occurences
        int lastDraw;                       //number of last draw
        final int NUMS_PER_DAY = 6;         //numbers per day to analyze
        
        //declare an array to hold the number of occurences per number
        int []occurencesArray = new int[NUMBER_OF_NUMS];
        
        //declare an array for occurences after sort
        int []sortedOccurencesArray = new int[NUMBER_OF_NUMS];
        
        //declare an array to hold the number of the last draw
        int []lastDrawArray = new int[NUMBER_OF_NUMS];
        
        //declare an array hold the number of the last draw after sort
        int []sortedLastDrawArray = new int[NUMBER_OF_NUMS];
        
        //display header
        System.out.println("\nAll Number Frequencies - Powerball and Regular\n");
        
        //display total numbers drawn
        System.out.printf("%-20s %4d\n\n", "Total Numbers Drawn:",
                          allNums.length);
        
        //loop through each number
        for (int index = 0; index < NUMBER_OF_NUMS; index++)
        {
                //create number frequency object for each number
                NumberFrequency number = new NumberFrequency(index+1);
            
                //calculate the occurences for each number
                occurences = calcTimesOccurred(allNums, number.getNumber());
            
                //set the times occurred for the number
                number.setTimesOccurred(occurences);
            
                //store the times occured in an array
                occurencesArray[index] = occurences;
                sortedOccurencesArray[index] = occurences;
            
                //determine the last time drawn out of total numbers drawn
                lastDraw = determineLastDraw(allNums, number.getNumber());
            
                //set last occurances out of all numbers
                number.setLastOccurred(lastDraw);
                 
                //store last occurance in an array
                lastDrawArray[index]= lastDraw;
                sortedLastDrawArray[index]= lastDraw;
                                      
        }
        //display the 10 most common and 10 least common numbers
        displayOccurrences(sortedOccurencesArray, NUMBER_OF_NUMS);
        
        //display the 10 most overdue
        displayMostOverdue(sortedLastDrawArray, NUMBER_OF_NUMS, NUMS_PER_DAY,
                            allNums.length);
        
        //display all number frequencies
        displayAllNumberFrequencies(NUMBER_OF_NUMS, occurencesArray);
        
        
    }
    
    /**
     * Display Regular Numbers Frequency
     * @param regNums array of all numbers
     */
    public static void regularNumberFrequency(int[] regNums )
        {
        final int NUMBER_OF_NUMS = 69;      //Number of numbers to analyze
        int occurences;                     //number of occurences
        int lastDraw;                       //number of last draw
        final int NUMS_PER_DAY = 5;         //numbers per day to analyze
        
        //declare an array to hold the number of occurences per number
        int []occurencesArray = new int[NUMBER_OF_NUMS];
        
        //declare an array for occurences after sort
        int []sortedOccurencesArray = new int[NUMBER_OF_NUMS];
        
        //declare an array to hold the number of the last draw
        int []lastDrawArray = new int[NUMBER_OF_NUMS];
        
        //declare an array hold the number of the last draw after sort
        int []sortedLastDrawArray = new int[NUMBER_OF_NUMS];
                
        //display header
        System.out.println("\nRegular Number Frequencies(Powerball Numbers"
                + " excluded)\n");
        
        //display total numbers drawn
        System.out.printf("%-20s %4d\n\n", "Total Numbers Drawn:",
                          regNums.length);
        
        //loop through each number
        for (int index = 0; index < NUMBER_OF_NUMS; index++)
        {
                //create number frequency object for each number
                NumberFrequency number = new NumberFrequency(index+1);
            
                //calculate the occurences for each number
                occurences = calcTimesOccurred(regNums, number.getNumber());
            
                //set the times occurred for the number
                number.setTimesOccurred(occurences);
            
                //store the times occured in an array
                occurencesArray[index] = occurences;
                sortedOccurencesArray[index] = occurences;
            
                //determine the last time drawn out of total numbers drawn
                lastDraw = determineLastDraw(regNums, number.getNumber());
            
                //set last occurances out of all numbers
                number.setLastOccurred(lastDraw);
                 
                //store last occurance in an array
                lastDrawArray[index]= lastDraw;
                sortedLastDrawArray[index]= lastDraw;
                                   
        }

        //display the 10 most common and 10 least common numbers
        displayOccurrences(sortedOccurencesArray, NUMBER_OF_NUMS);
        
        //display the 10 most overdue
        displayMostOverdue(sortedLastDrawArray, NUMBER_OF_NUMS, NUMS_PER_DAY,
                                                        regNums.length);
        //display all number frequencies
        displayAllNumberFrequencies(NUMBER_OF_NUMS, occurencesArray);
    }
  
    /**
     * Display Powerball Numbers Frequency
     * @param pbNums array of all numbers
     */
    public static void powerballNumberFrequency(int[] pbNums )
        {
        final int NUMBER_OF_NUMS = 35;      //Number of numbers to analyze
        int occurences;                     //number of occurences
        int lastDraw;                       //number of last draw
        final int NUMS_PER_DAY = 1;         //numbers per day to analyze
        
        //declare an array to hold the number of occurences per number
        int []occurencesArray = new int[NUMBER_OF_NUMS];
        
        //declare an array for occurences after sort
        int []sortedOccurencesArray = new int[NUMBER_OF_NUMS];
        
        //declare an array to hold the number of the last draw
        int []lastDrawArray = new int[NUMBER_OF_NUMS];
        
        //declare an array hold the number of the last draw after sort
        int []sortedLastDrawArray = new int[NUMBER_OF_NUMS];
                
        //display header
        System.out.println("\nPowerball Number Frequencies(Regular Numbers "
                + "excluded)\n");
        
        //display total numbers drawn
        System.out.printf("%-20s %4d\n\n", "Total Numbers Drawn:",
                          pbNums.length);
        
        //loop through each number
        for (int index = 0; index < NUMBER_OF_NUMS; index++)
        {
                //create number frequency object for each number
                NumberFrequency number = new NumberFrequency(index+1);
            
                //calculate the occurences for each number
                occurences = calcTimesOccurred(pbNums, number.getNumber());
            
                //set the times occurred for the number
                number.setTimesOccurred(occurences);
            
                //store the times occured in an array
                occurencesArray[index] = occurences;
                sortedOccurencesArray[index] = occurences;
            
                //determine the last time drawn out of total numbers drawn
                lastDraw = determineLastDraw(pbNums, number.getNumber());
            
                //set last occurances out of all numbers
                number.setLastOccurred(lastDraw);
                 
                //store last occurance in an array
                lastDrawArray[index]= lastDraw;
                sortedLastDrawArray[index]= lastDraw;
                                           
        }
                
        //display the 10 most common and 10 least common numbers
        displayOccurrences(sortedOccurencesArray, NUMBER_OF_NUMS);
        
        //display the 10 most overdue
        displayMostOverdue(sortedLastDrawArray, NUMBER_OF_NUMS, NUMS_PER_DAY,
                pbNums.length);
        
        //display all number frequencies
        displayAllNumberFrequencies(NUMBER_OF_NUMS, occurencesArray);

    }    
    
    /**
     * Calculate Times Occurred
     * @param array array of numbers
     * @param num the value of the number
     * @return times occurred
     */
    public static int calcTimesOccurred(int[] array, int num)
    {
            int total = 0;      //accumulator
             
            //loop through numbers adding up occurrences
            for (int index = 0; index < array.length; index++)
            {
                if (array[index] == num)
                {
                     total++;
                }
            }
            
            //return total
            return total;
        }
    
    /**
     * Determine Last Draw
     * @param array array of numbers
     * @param num the value of the number
     * @return last draw
     */
    public static int determineLastDraw(int[] array, int num)
    {
            int last = 0;       // to hold last drawn time
            
            //loop through last draw array to determine the last draw
            for (int index = 0; index < array.length; index++)
            {
                if (array[index] == num)
                {
                    //if true set the last draw to index + 1 to hold number
                     last = index + 1;
                }
            }
            
            //return last
            return last;
        }
    
    /**
     * Determine last set number was drawn in
     * @param lastDraw the last draw
     * @param numDays number of numbers per day
     * @return set of the last draw
     */
    public static int determineLastSet(int lastDraw, int numDays)
    {
        double set;         //double to hold set
        
        //use math.ceil to set the set
        set = (int)Math.ceil((double)lastDraw/numDays);
        
        //return the set as an integer
        return (int)set;
    }
 
    /**
     * Display Frequency for All Numbers
     * @param size The number of numbers in the kind of numbers 
     * @param occurs the array of frequencies
     */
    public static void displayAllNumberFrequencies(int size,
                                                   int []occurs)
    {
        //declare and initialize an array to hole the numbers in the series
        int [] numList = createListOfNumbers(size);
        
        //header
        System.out.println("Frequency For Each Number");
        
        System.out.printf("%-10s%-7s\n", "Number", "Times Drawn");
        
        //loop through number list and frequencies array to display all
        for (int i = 0; i < size; i++)
            {
                System.out.printf("%3d%12d\n", numList[i], occurs[i]);
            }
        
        System.out.println();
    }
    
    /**
     * Display 10 most and least Common
     * @param size Size of the kind of numbers
     * @param numList array of the numbers
     * @param freq array of frequencies 
     */
    public static void displaySortedFrequencies(int size, int []numList,
                                                int []freq)
    {
        
        //header
        System.out.println("10 Least Common Numbers");
        System.out.printf("%-10s%-7s\n", "Number", "Times Drawn");
        
        //display the first 10 elements in the sorted array
        for (int i = 0; i < 10; i++)
            {
                System.out.printf("%3d%12d\n", numList[i], freq[i]);
            }
        
        System.out.println();
        
        //display the last 10 elements in the sorted array
        int lastElement = numList.length -1;    //set last element to the size - 1
        
        
        //header
        System.out.println("10 Most Common Numbers");
        System.out.printf("%-10s%-7s\n", "Number", "Times Drawn");
        
        //for loop to display the last 10 elements
        for (int index = 10; index>0; index--)
        {
            //print the last element in first loop
            System.out.printf("%3d%12d\n", 
                    numList[lastElement], freq[lastElement]);
            
            //decrease last element to show the next last
            lastElement--;
        }
        
        System.out.println();
    }

    /**
     * Create a list of numbers starting at 1 and going to the size
     * @param size number of numbers needed
     * @return an array with the number values
     */
    public static int [] createListOfNumbers(int size)
    {
        //create a list of numbers for the size needed for each type of lottery
        //numbers (regular, all, powerball)
        int []numbersList = new int [size]; 
        
        //initialize array
        for (int i = 0; i < size; i++)
        {
            numbersList[i]= i +1;
        }
        
        //return bumbersList array
        return numbersList;        
    }
    
    /**
     * Sort Parallel arrays
     * @param numList number list
     * @param arrayToSort array that needs sorted
     * @param size size of the kind of number
     */
    public static void sortParallelArrays(int[] numList, int[] arrayToSort,
                                          int size)
    {
        int [] sortedArray = arrayToSort;
        
        //sort the array using a swap for both the number list and the array to sort
        int tempValue;      //temp value for the value in the array to sort
        int tempNumber;     //temp value for the number in the list
      
        int lastPosition;   // last position in the array to use as a loop counter
        int index;          //loop counter for inner loop
        
        for (lastPosition = sortedArray.length-1; lastPosition >=0; 
                                                  lastPosition--)
        {
            for (index = 0; index <= lastPosition - 1; index++)
            {
                if (sortedArray[index] > sortedArray[index+1] )
                {
                    tempValue = sortedArray[index];
                    tempNumber = numList[index];
                    sortedArray[index] = sortedArray[index+1];
                    numList[index] = numList[index + 1];
                    sortedArray[index + 1] = tempValue;
                    numList[index +1] = tempNumber;
                }
            }
        }
    }
    
    /**
     * Display Occurrences After Sorting
     * @param arrayToSort The array that needs to be sorted before display
     * @param size size of the kind of number
     */
     public static void displayOccurrences(int [] arrayToSort, int size)
     {
        //declare and initialize an array to hole the numbers in the series
        int [] numberList = createListOfNumbers(size);
        
        //sort the arrays
        sortParallelArrays(numberList, arrayToSort, size);
        
        //display the sorted frequenciences
        displaySortedFrequencies(size, numberList, arrayToSort);

    }
     
     /**
      * Display most overdue
      * @param arrayToSort array to sort
      * @param size size of the kind of number
      * @param numsPerDay number of numbers per kind for each day
      * @param total the total number of numbers in the kind of number
      */
     public static void displayMostOverdue(int [] arrayToSort,
                                            int size, int numsPerDay, int total)
     {
        //declare and initialize an array to hole the numbers in the series
        int [] list = createListOfNumbers(size);

        //sort the arrays
        sortParallelArrays(list, arrayToSort, size);
                
        //display the sorted frequenciences
        displaySortedOverdue(size, list, arrayToSort, numsPerDay, total);
  
    }
     
     /**
      * display sorted Overdue
      * @param size size of the kind of numbers
      * @param numList sorted numbers listed
      * @param last sorted last drawn array
      * @param numsPerDay numbers per day of the kind of numbers
      * @param total total draws of that kind of numbers
      */
     public static void displaySortedOverdue(int size, int []numList, 
                                              int []last, int numsPerDay,
                                              int total)
    {
        int lastSet;    //last set
        //header
        System.out.println("10 Most Overdue Numbers");
        
        System.out.printf("%-10s%-7s%-12s%d)\n", "Number", "Set", "Drawn For(out of ", total);
        
        //display the first 10 elements in the sorted array
        for (int i = 0; i < 10; i++)
            {
                //set the last set
                lastSet = determineLastSet(last[i], numsPerDay);
                System.out.printf("%4d%9d%10d\n", numList[i], lastSet , last[i]);
            }
        
        System.out.println();
        
    }
}


