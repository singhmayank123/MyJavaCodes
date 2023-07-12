/*** 

This program reads a set of words from a file that contains all 
those words where the edit distance is one between any two words
from the source word to the target word. For instance, the source 
word is a dog, and the target word is a cat. The first intermediate
word between dog cat with an edit distance of 1 will be a cog, by 
changing d with c, the second will be a cag by replacing o with a, 
and so on. 

***/

import java.util.List; // for List class
import java.util.LinkedList; // for LinkedList class 
import java.util.Map; // for Map class
import java.util.HashMap; // for Hashmap class
import java.util.Set; // for Set class 
import java.util.HashSet; // for HashSet class 
import java.io.File; // for File class 

public class EditDistance{

/* A static method that calculates the edit distance between the source 
and target word using the set of words defined in the text file */
	public static int findEditDistance(String start, String target, Set<String> dictionary){

		/** check whether start and target strings are same **/
		if(start.equals(target)){
			/** if so return edit distance 0 */
			return 0;
		}

		/** Map to store each word and a list to store the words whose edit
		 *  distance is 1 to the word **/
		Map<String, List<String>> umap = new HashMap<>();

		/** iterate the start word **/
		for(int i = 0; i < start.length(); i++){
			/** replace each character of start string with * for each iteration **/
			String str = start.substring(0,i) + "*" + start.substring(i+1);
			// *og -> dog 
			// d*g -> dog
			// do* -> dog
			/** check if the replaced string is not present in the map */
            if(!umap.containsKey(str)){
            	/** if so, then create a list of String **/
                List<String> s = new LinkedList<String>();
                /** push the start word to the list **/
                s.add(start);
                /** Make the replace string as key and list as value and push them into map **/
                umap.put(str, s);
            }
			else
				/* if replaced string already present, then get the value of key str,
				which will be a list and add the start string to that list **/
                umap.get(str).add(start);
		}

		/** convert the dictionary set to the array of Strings to fetch each element by index **/
		String[] d = dictionary.toArray(new String[dictionary.size()]);
		
		/** iterate each word of the dictinary d */
		for(int i = 0; i < d.length; i++)
		{
			String word = d[i];// store word at index i in array d

			/** iterate over each character of the word **/
			for(int j = 0; j < word.length(); j++)
			{	
				/* replace each word with * for every iteration */
				String str = word.substring(0,j) + "*" + word.substring(j+1);
				/* check if the replaced word does not contain in the map */
				if(!umap.containsKey(str)){
					/* if so, create a list */
					List<String> s = new LinkedList<String>();
					/* push the word in the list */
					s.add(word);
					/** push the replace word as key and the list containing the word whose edit distance is 1 */
					umap.put(str, s);
				}
				/** if the Map the already present in the list, get the list reference and add the word to that list **/
				else umap.get(str).add(word);
			}
		}

		/** The Map set will hold data like below after the termination of outer loop, which represents a adjaceny list **/
		// *ag > dag -> cag
		// d*g > dog -> dag
		// da* > dag -> dat
		// *at > dat -> cat
		// d*t > dat -> dot
		// c*t > cat -> cot
		// ca* > cat -> cag
		// *ot > cot -> dot
		// co* > cot -> cog
		// do* > dog -> dot
		// *og > dog -> cog
		// c*g > cog -> cag 

		// Perform BFS and push (word, distance)
		Queue<String> qKey = new LinkedList<String>();
        Queue<Integer>qValue = new LinkedList<Integer>();
        // create a map to mark each string visited 
		Map<String, Integer> visited = new HashMap<>();
		
		// add the start in the queue 
		qKey.add(start);
		// add the value in the queue 
        qValue.add(1);

		// put the start word in the map and value as 1 to mark it visited 
		visited.put(start, 1);

		// Traverse until queue is empty
		while(!qKey.isEmpty())
		{		
			String word = qKey.peek(); // get the front value of the qKey 
			System.out.println(word);
			int dist = qValue.peek(); // get the front value of the qValue 
			qKey.remove(); // remove the front value 
            qValue.remove(); // remove the front value 

			// If target word is found
			if(word.equals(target)) return dist-1;
		
			// Finding intermediate words for
			// the word in the front of queue
			for(int i = 0; i < word.length(); i++)
			{
					/* replace each character with * and find the str in the umap **/
				String str = word.substring(0,i) + "*" +
									word.substring(i+1);
			
	            if(umap.containsKey(str)){

	            	/** store all the words in vect whose edit distance is 1 with str */
					List<String> vect = umap.get(str);

					/** iterate over each word of the vect **/
					for(int j = 0; j < vect.size(); j++)
					{
						// If the word is not visited
						if(!visited.containsKey(vect.get(j)))
						{	
							/* mark the work visited */
							visited.put(vect.get(j), 1);
							/** add the word in the qKey **/
							qKey.add(vect.get(j));
							/** add the edit distance to qValue with an increment to the current one **/
							qValue.add(dist+1);
						}
					}
				}
        	}
		}
		return 0;
	}

	// main driver method 
	public static void main(String[] args) throws Exception{
		
		// Create a set to store the words from the file 	
		Set<String> dictionary = new HashSet<>();
		// Get the text file 
		File file = new File("dictionary.txt");
		// to read contents from the file 
		Scanner input = new Scanner(file);
		// to store each word of the file 
		String word; 
		// Loop to read each line that contains a word 
		while(input.hasNext()){
			// read the word 
			word = input.next();
			// add the read word in the dictionary 	
			dictionary.add(word.trim());
		}

		// close the file 
		input.close();
		// source string to find edit distance 
		String start = "dog";
		// target string 
		String target = "cat";

		// call the method to get the edit distance b/w source and target strings 
		int ed = findEditDistance(start, target, dictionary);
		// print the edit distance 
		System.out.printf("Edit distance b/w %s and %s : %d" , start, target, ed); 
			
	}
}