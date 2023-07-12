import java.io.File; // for File class 
import java.io.FileNotFoundException; // for exception 
import java.util.*; // for collection frameworks 

public class WordCountings {

    public static void main(String args[]) throws FileNotFoundException { 

        File file = new File("word.txt"); // make reference to the text file 
        // Arraylist to store words from the file 
        ArrayList<String> words = new ArrayList<>();
        // ArrayList to store the count of word parallelly to words list 
        ArrayList<Integer> wordCount = new ArrayList<>();
        // stores the read word from file 
        String word = "";
        // to read file contents 
        Scanner in = new Scanner(file);
        
        // keep iterating to read each word from file 
        while(in.hasNext())
        {   
            // read the word 
            word = in.next();
            // make the cases same for same word 
            word = word.toLowerCase();

            // remove the punctuations from the containing word 
            if(word.charAt(word.length()-1) < 'a' 
                || word.charAt(word.length()-1) >'z'){          
                word = word.substring(0, word.length()-1);
            }

            int i = words.indexOf(word);

            if(i == -1){
                words.add(word);
                wordCount.add(1);
            }

            else{          
                wordCount.add(i, (wordCount.get(i) + 1));
            }
        }
        
        for(int i = 0; i < words.size(); i++){

            System.out.println("Word : "+words.get(i)+ 
                " | Count: "+ wordCount.get(i));
        }
    }
}