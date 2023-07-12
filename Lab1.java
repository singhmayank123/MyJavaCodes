import java.util.Scanner; 

public class Lab1{
	
	// An instance method for reading inputs 

	private int []arr; // instance variable to store the elements 
	private int nElems; // instance variable for the number of elements 

	// constructor for initializing the object state 
	public Lab1(int nElems){

		this.nElems = nElems;
		this.arr = new int[nElems]; // allocate the memory 
	}

	// A method to read user inputs 
	public void readElements(Scanner input, int numElems){

		System.out.println("Enter "+numElems+ " integer numbers: ");

		for(int i = 0; i < numElems; i++)
			arr[i] = input.nextInt(); // insert numbers in the array

	}

	// A method to displays the array's contents 

	public void display(){

		System.out.println("The set contains: ");
		// for loop for printing the data 
		for(int i = 0; i < nElems; i++)
			System.out.print(arr[i] + " ");

		System.out.println();
	}

	// overloaded method to print the predefined part of the array
	public void display(int numElems){

		System.out.println("The set contains: ");
		// for loop for printing the data 
		for(int i = 0; i < numElems; i++)
			System.out.print(arr[i] + " ");

		System.out.println();
	}

	/* A method that checks whether the given key is present 
	in the array or not. if so returns the index */
	public int search(int searchKey){

		boolean found = false; // helps to check whether the key exists or not 
		int index = -1; // for the index of found element 

		for(int i = 0; i < nElems; i++){

			if(arr[i] == searchKey){
				found = true; // if present
				index = i;
			}
		}

		if(found) // if true 
			System.out.println("found "+searchKey);
		else
			System.out.println("Can't find "+searchKey);

		return index; // return the status 

	}

	/* A method that searches the key and deletes it from the array.
	*/

	public void delete(int searchKey){

		int returnValue = search(searchKey); 

		// if true, means value if present in the list
		if(returnValue != -1){

			System.out.println("Deleting "+searchKey);
	
			// copy the contents of original array to the new array 
			for(int j = returnValue; j < nElems; j++){

				//  doing so, because that procedural program should 
				// generate error. Because nElems is 100 so when j becomes 
				// 99, value of j+1 will be 100 and we can't access the elemnt
				// at 100th position as the size itself is 100 
				if(j == (nElems - 1))
					break;


				arr[j] = arr[j+1];

			}

			nElems--; // decrement the array's size by 1 
		}

		else{
			System.out.println("Can't find "+searchKey);
		}
	}

	// main driver method 

	public static void main(String[] args) {
		
		// create an object of Scanner class for user input 

		Scanner input = new Scanner(System.in);

		// create an object of this class to use the object methods 

		Lab1 lab = new Lab1(100); // pass the allocate size of the array to the object-type

		// call the method to fetch the data
		lab.readElements(input, 10);

		// print the contents 

		lab.display(10); // call to print first 10 numbers 

		int key = 0; 

		System.out.print("Search for key: ");
		key = input.nextInt();

		lab.search(key);

		System.out.print("Delete key: ");
		key = input.nextInt();

		lab.delete(key);

		lab.display(10);

	}
}