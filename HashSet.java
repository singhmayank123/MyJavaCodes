/** This class implements the hashing technique
 * using linear probing method **/

import java.util.Arrays;

public class HashSet{
	
	/** stores the hashset values **/
	private int hashValues[];
	private int size;
	
	/** Collision flags that sets as true if there is 
	 * collision at the given index **/
	private boolean flags[];

	public HashSet(){
		this(10);
	}

	public HashSet(int size){

		hashValues = new int[size];
		flags = new boolean[size];

		this.size = 0;
	}
/** helper method for hashing **/
	private int hash(int key){
	    return key % hashValues.length;
	}
/** method that handles the collisions **/
	private int linearProbe(int key){

	    int index = hash(key);

	    int i = 0;

	    while (hashValues[(index + i) % hashValues.length] != 0){    	
	        i++;
	    }
/** set flag as true for the collided element **/
	    flags[(index + i) % hashValues.length] = true;

	    return (index + i) % hashValues.length;
	}
/** method that adds an element in the hash set **/

	public void add(int key){

		try{

			if(size >= hashValues.length){
				throw new IndexOutOfBoundsException("No more elements can be inserted!");
			}

			int index = hash(key);
	
		    if (hashValues[index] != 0)
		        index = linearProbe(key);
		    
		    hashValues[index] = key;
		    size++;
		}

		catch(Exception e){
			System.out.println("Insert Error: "+ e.getMessage());
		}
	}
/** method that tells whether the key is in the hash set or not **/
	public boolean contains(int key){

		int flag = search(key);
		return (flag != -1);
	}
/** method that searches a key within the hashset and returns 
 * the key index **/
	private int search(int key){

	    int index = hash(key);

	    int i = 0;

	    while (hashValues[(index + i) % hashValues.length] != key &&
	    	i < hashValues.length){
	        i++;
	        if (hashValues[(index + i) % hashValues.length] == 0){
	            return -1;
	        }
	    }

	    if(i == hashValues.length)
	    	return -1;

	    return (index + i) % hashValues.length;		
	}

/** method that removes a key from the array **/
	public void remove(int key){	

		try{

/** throw an error if size is less than 0 **/
			if(size < 0)
				throw new Exception("No element exists!!");
/** get the index of key element in the hash set **/
			int keyIndex = search(key);
/** throw an error if keyIndex is -1 **/
			if(keyIndex == -1)
				throw new Exception("Key " + key+ " is not found!");
/** keep shifting the elements of flags and hashValues array
 *  in the cyclic order till the flag value is true **/
			while(flags[(keyIndex + 1) % hashValues.length]){

				flags[keyIndex] = flags[(keyIndex+1) % hashValues.length];
				hashValues[keyIndex] = hashValues[(keyIndex+1) % hashValues.length]; 
				keyIndex = (keyIndex + 1) % hashValues.length;
			}
/** set 0 and false at the correct vacant place **/
			hashValues[keyIndex] = 0;
			flags[keyIndex] = false;
/** reduce the size by 1 **/
			size--;

		}
/** handle the exceptions **/
		catch(Exception e){
			System.out.println("Remove Error: "+e.getMessage());
		}
	}
/** Method to print the contents of the hash set **/
	public String toString(){
		return Arrays.toString(hashValues);
	}

}