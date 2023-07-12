//-----------------------------------------------------------------------------------------------------------------

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class RandomWriter {

    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);
        System.out.println("Enter the text file you want to analyze");
        String filePath = console.nextLine();
        System.out.println("Enter the length of phrase you want to track");
        int phraseLength = console.nextInt();

        ArrayList<String> words = getWordsFromFile(filePath);
        for(String word:words){
            System.out.println(word);
        }
        // create a hashmap that will store the phrase as a key, the values will be the list of words following that phrase
        HashMap<String,ArrayList<String>> phrases = new HashMap<String,ArrayList<String>>(100);

        for(int wordCount=0; wordCount<words.size()-phraseLength;wordCount++){

            String phrase = "";
            // build the phrase of length as given by the user
            for(int length=0;length<phraseLength;length++){
                phrase=phrase+ words.get(wordCount+length)+" ";
            }
            phrase=phrase.trim();
            // below is the word that is followed by the phrase
            String wordFollowingPhrase = words.get(wordCount+phraseLength);
            System.out.println(phrase+"->"+wordFollowingPhrase);
            // if the phrase is already repeated earlier we simply add the word to the list
            if(phrases.containsKey(phrase)){
                ArrayList<String> wordList = phrases.get(phrase);
                wordList.add(wordFollowingPhrase);

            }else{
                ArrayList<String> wordList = new ArrayList<String>(1);
                wordList.add(wordFollowingPhrase);
                phrases.put(phrase,wordList);
            }
        }

        printMap(phrases);


    }
    // reads word from a file and returns are list of words in the order they appeared in the file
    public static ArrayList<String> getWordsFromFile(String filePath){

        BufferedReader reader;
        ArrayList<String> words = new ArrayList<String>(50);

        try {
            reader = new BufferedReader(new FileReader(filePath));
            String readLine = reader.readLine();
            while(readLine!=null){

                String[] wordArray = readLine.replaceAll("[^a-zA-Z ]", "").toLowerCase().split("\\s+");
    
                for(String word:wordArray){
                   if(word.length()>0) {
                        words.add(word);
                    }
                }
            }

        } catch (IOException e) {
            System.out.println("File Not found\nProgram will terminate now");
            e.printStackTrace();
        }

        return words;

    }
    // prints the hashmap 
    public static void printMap(HashMap<String,ArrayList<String>> wordMap){

        for (String key : wordMap.keySet()){

            System.out.print("Phrase: "+key);
            System.out.print(" Words followed: [");
            for (String word: wordMap.get(key)){
                System.out.print(word+" ");
            }
            System.out.println("]\n");
        }
    }