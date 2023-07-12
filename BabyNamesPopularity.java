// Filename: NamesPopularity.java
/** This program allows to print the counts of baby name of each year
 * and a bar graph */

import java.io.*; // for file handling classes 
import java.util.Scanner; // for user inputs 
import java.awt.*; // for graphics 

public class BabyNamesPopularity{

    public static String nameFromUser = ""; // to be read from keyboard
    public static String nameFromFile = ""; // to be read from file
    public static int[] popularityCounts = new int[11]; // to store the popularity's count of each name in 11 years

    public static boolean checkPopularityCounts(Scanner readFile){

        boolean found = false; // for telling whether the name is found in the file or not 

        try{
            // create a File class object that references the file in the system          
            File file = new File("babyData.txt");

            // read the data from a file
            readFile = new Scanner(file);

            //A while-loop for reading the data from the from file
            while(readFile.hasNextLine()){
                // read the name from the file
                nameFromFile = readFile.next();

                // check whether the read name from file matches with the name entered by the user
                if(nameFromFile.equalsIgnoreCase(nameFromUser)){
                // if matches, read the baby's popularity of each year and store them into the popularityCounts array
                    for(int i = 0; i < popularityCounts.length; i++)
                        popularityCounts[i] = readFile.nextInt();
                    found = true;
                // After storing the counts terminate the loop as the search is over 
                break; 
                }
            }
            // close the input file
            readFile.close(); 
        }
        // handle the Exception if file not found 
        catch(FileNotFoundException e){
            // print the error message 
            System.out.println(e.getMessage());
        }

        return found; // return the found value 

    } // end of method 

    // main driver method 
    public static void main(String[] args){
        // create an object of Scanner class to read data from the console screen
        Scanner input = new Scanner(System.in);

        // prompt the user to enter baby's name 
        System.out.print("Enter a name to get the popularity count: ");
        // read the name from the console 
        nameFromUser = input.next();

        boolean found = checkPopularityCounts(input);
            // if found is true, then print the data of the array 
        if(found){

            System.out.println("\nStatistics on the name \"" + nameFromUser + "\"\n");
            int year = 1900; // start year

            for(int count : popularityCounts){          
                System.out.println(year + ": " + count);
                year += 10;
            }

        }
        // otherwise, print the not found message to the user 
        else
        // print a message to the user
        System.out.println("\nSorry! file has no record for the name \"" + nameFromUser + "\" ."); 


        plotData();      

    } // end of main method

    public static int getMaxCount(){

        int max = popularityCounts[0];

        for(int i = 1; i< popularityCounts.length; i++){

            if(popularityCounts[i] > max)
                max = popularityCounts[i];
        }

        return max;
    }

    public static void plotData(){

        // Create an object of DrawingPanel class 

        int max = getMaxCount();
        max /= 2;

        DrawingPanel panel = new DrawingPanel(40*11, max + 50);

        panel.setBackground(Color.GRAY);

        Graphics g = panel.getGraphics(); // get the Graphics object

        g.setColor(Color.WHITE);   

        //g.drawString("Popularity", 10, 20);

        g.drawLine(30, 30, 40*10 - 30, 30);
        g.drawLine(30, 30, 30, max + 50 - 30);

        g.setFont(new Font("SansSerif", Font.BOLD, 10));

        for(int i = 0, year = 1900; i<popularityCounts.length; i++, year += 10)
            g.drawString(""+year, 30 + 30*i, 25);
        

        for(int i = 0; i<popularityCounts.length; i++)
            g.fillRect(35 + 30*i, 30, 20, popularityCounts[i]/2);
       

    }

} // end of BabyNamesPopularity class