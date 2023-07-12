/** This program can be tested on java 11 **/
/** 
 * This program read the file character by character 
 * and generates a randomized sentences based on the 
 * frequencies of the character.
**/

// import the required classes 
import java.io.BufferedReader; 
import java.io.FileReader;
import java.io.File;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Scanner;
/** for SecureRandom class that provides 
 * a more accurate random values */
import java.security.SecureRandom;

// Main class 
public class RandomWriter {
    
    /** Method takes a list and returns a list k 
     * consecutive characters randomly **/

    public static LinkedList<Character> 
    getRandCharacters(int k, List<Character> list){

        // stores the random consecutive characters 
        LinkedList<Character> str = new LinkedList<>();

        // returns a space if list is empty 
        if(list.isEmpty()){
            str.add(' ');
            return str;
        }
        // create an object
        SecureRandom rand = new SecureRandom();
        // choose random index from the list
        int index = rand.nextInt(list.size());
        // add k consecutive characters from the list to str
        for(int i = index, j = 0; j < k; i++, j++)
            str.add(list.get(i));
        // return the randomly generated list of characters 
        return str;
    }

    // Method that implements the RandomWriter 
    public static String runRandomWriter(ArrayList<Character> characters,
        String sourceFile, int k){

        // Generate a random text upto k characters from the file 
        LinkedList<Character> selectedText = getRandCharacters(k, characters);
        // indicate selectText occurence is found in the file 
        boolean allMatches = true;
        // Stores the character that immediately follows the selectText
        ArrayList<Character>follows = new ArrayList<>();
        // stores the randomized generate output 
        StringBuilder result = new StringBuilder();

        // Perform the algorithm until the result size becomes equal to file size 
        while(result.length() != characters.size()){

            // Add the first character of the select text to the result 
            result.append(selectedText.get(0));

            int i = 0; // for looping

            /** Loop to get all the occurence of selectText in the file 
             * and add the immediate next character to the follows list */ 
            while(i < characters.size()){

                /* Check whether occurence of first character of selectText matches */
                if(characters.get(i) == selectedText.get(0)){

                    /* if so, then check whether the first character is the last character 
                    in the file */
                    if(characters.get(characters.size() - 1) == selectedText.get(0)){

                        /* if so, reset the selectedText */
                        selectedText.clear();
                        /* set a new random text */
                        selectedText = getRandCharacters(k, characters);
                    }
                    
                    /* reset it to true for each iteration */
                    allMatches = true;

                    /* check whether there are not enough characters to match other occurences
                    from the file */
                    if((i + selectedText.size()) < characters.size()){
                    
                    /** run a loop to match all characters of selectText in the file */
                        for(int j = i+1, m = 1; m < selectedText.size(); j++, m++){

                            /* if any character fails to match */
                            if(characters.get(j) != selectedText.get(m)){
                                /* set it false */
                                allMatches = false;
                            }
                           
                        }
                    /* if all occurence of selectText successfully found in the file */
                        if(allMatches){

                            /* set the index of immediate next character */
                            i = i + selectedText.size();
                            /* push the immediate next character to the follows list */
                            follows.add(characters.get(i));                        
                        }
                    }
                }

                /* increment the index to iterate the next character of file */
                i++;
        
            }
            /* Take a random character from the file */
            char c = getRandCharacters(1, follows).get(0);
            /* remove the first character of selectText */
            selectedText.remove(0);
            /* append c to the end of selectText */
            selectedText.add(c);
            /* clear all follows words */
            follows.clear();
        }

        /** return the generate random sentence */
        return result.toString();

    }

/* Method that reads the file character by character and returns the list of 
characters in the order they appeared in the file */
    public static ArrayList<Character> getWordsFromFile(String filePath){

        BufferedReader reader; // read the text from a character-base input stream
        /** stores the list of characters read from the file  */
        ArrayList<Character> words = new ArrayList<Character>();

        try {
            // open the file 
            reader = new BufferedReader(new FileReader(filePath));
            int c = 0;
            // read ASCII code of each character 
            while((c = reader.read()) != -1){
                // add the character to the list
               words.add((char)c);

            }

        } catch (IOException e) {
            System.out.println("File Not found\nProgram will terminate now");
            e.printStackTrace();
        }

        // return the list of characters 
        return words;

    }

// main driver method 
    public static void main(String[] args){

// create an object to read input from the console screen
        Scanner console = new Scanner(System.in);

/** k stores the number of characters that will be read randomly from
 * the file characters.
 * levels stores the number of levels perfomed */
        int k, levels;
        String sourceFile; // name of source file 
/**  prompt the user */
        System.out.println("Welcome to the random writer program.\nThis"+
            " program provides new sentence whose writing style matches to"+
            " the original one.\nThe sentences will be more accurate at higher levels.\n");
        
        System.out.print("Enter non-negative value of k to randomly select "+ 
            "\nk-consecutive characters from file: ");
        k = console.nextInt();
        System.out.print("Enter source file name: ");
        sourceFile = console.next();
        System.out.print("How many levels ? ");
        levels =  console.nextInt();
// read the file and store each characters to the list
        ArrayList<Character> characters = getWordsFromFile(sourceFile);
// validate the value of k
        if(k <= 0){
            System.out.println("K must be positive!");
            System.exit(1);
        }

        PrintWriter out = null; // for writing to the file 

        try{

// open the output file 
            out = new PrintWriter(new File("result.txt"));

            for(int i = 1; i <= levels; i++){

                String result = runRandomWriter(characters, sourceFile, k);
                out.println(result); // write the return result to the file 
            }  

            out.close();    // close the file      
           
        }

        catch(Exception e){};

        System.out.println("Successfully saved to \"result.txt\" ");

    }
 
 }