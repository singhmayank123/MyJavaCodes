import java.util.ArrayList;
import java.util.Scanner;

public class LotteryNumbers 
{
    private final ArrayList <Integer> winningNumbers;   //arrayList of all nums
    private ArrayList <Integer> regularNumbers;         //arrayList of regular
    private ArrayList <Integer> pbNumbers;              //arrayList of powerball
    
    //no args constructor
    LotteryNumbers()
        {
        this.winningNumbers = null;
        this.regularNumbers = null;
        this.pbNumbers = null;
    }
    
    /**
     * Constructor
     * @param inFile Scanner Object
     */
    LotteryNumbers(Scanner inFile)
        {
        this.winningNumbers = setWinningNumbersArrayList(inFile);
        
        //to set regular numbers and pb numbers array;
        setRegularAndPBNumbers();
    }
    

    //setters
    /**
     * set the winning number array list
     * @param inputFile Scanner input
     * @return arrayList of all numbers
     */
    private ArrayList setWinningNumbersArrayList(Scanner inputFile)
        {
        //declare an array list to hold Integer
        ArrayList <Integer> arrayList = new ArrayList<>();
         
        //try catch for inputting file to the array list
        try
        {
            while (inputFile.hasNext())
            {
                //get the Integer
                Integer number = inputFile.nextInt();
                
                //add the Integer to the ArrayList
                arrayList.add(number);
            }
        }
        
        catch (Exception e)
        {
            //message if file could not be processed
            System.out.println("The file could not be processed.");
        }
        
        finally
        {
            //close the input file
            inputFile.close();
        }
        return arrayList;
    }
    
    //set regular and powerball arrays   
    private void setRegularAndPBNumbers()
        {
       //Integer ArrayList for regular and powerball
       ArrayList <Integer> regNums = new ArrayList<>();
       
       ArrayList <Integer> pbNums = new ArrayList<>();
       
       //add(copy) all winning numbers to a new array list
       for (int index = 0; index < this.winningNumbers.size(); index++)
        {
            regNums.add(this.winningNumbers.get(index));
            
        }

       //add the powerball to the remove the powerball numbers
        for (int index = 0; index < regNums.size(); index+=5)
        {
            if (index!= 0)
            {
                //add the powerball to the pb arrayList
                pbNums.add(regNums.get(index));
                
                //remove the powerball from the regular numbers ArrayList
                regNums.remove(index);
            }
        }

        //set the regular and powerball arrayLists
        this.regularNumbers =regNums;
        this.pbNumbers = pbNums;
    }
    
    //getters (returns int arrays)
    /**
     * Get All Numbers Array
     * @return int array of all numbers
     */
    public int[] getAllNumbersArray()
        {
        int[]allNumbers = new int[this.winningNumbers.size()];
        
        for (int index = 0; index < this.winningNumbers.size(); index++)
        {
            allNumbers[index]=this.winningNumbers.get(index);
        }
               
        return allNumbers;
        
    }
         
    /**
     * Get Powerball Numbers
     * @return int array of powerball numbers
     */
    public int[] getPBNumbersArray()
        {
        int[]powerballNumbers = new int[this.pbNumbers.size()];
        

        for (int index = 0; index < this.pbNumbers.size(); index++)
        {
            powerballNumbers[index]=this.pbNumbers.get(index);
        }
        
        return powerballNumbers;
        
    }
    
    /**
     * Get Regular Numbers
     * @return int array of Regular Numbers
     */
    public int[] getRegNumbersArray()
        {
        int[]regNumbers = new int[this.regularNumbers.size()];
        

        for (int index = 0; index < this.regularNumbers.size(); index++)
        {
            regNumbers[index]=this.regularNumbers.get(index);
        }
        
        return regNumbers;
    }
    
}
