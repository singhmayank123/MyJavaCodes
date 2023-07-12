/** main class **/
import java.util.*;

public class Proj9Music{

	/** a class level variable is declared 
	 * with static keywords so we are not using it **/

	/*** declare a constant variable to set the 
	 * size of the array **/
	private final int MAX_SIZE = 5;

	/** Array to store collection of albums **/
	private Album []albums =  new Album[MAX_SIZE];

	public Proj9Music(){

		for(int i = 0; i<MAX_SIZE; i++){
			albums[i] = new Album();
		}
	}

	/** create a variable to know to current size of array **/
	private int size = 0;

	public static void main(String[] args) {

		/** create an object of the class **/
		Proj9Music prog9 = new Proj9Music();

		// create an Scanner obect to read user input 

		Scanner input = new Scanner(System.in);

		while(true){

			/** use the reusable methood for printing
			 * the menu again and again and store the 
			 * user choice in choice variable **/
			int choice = prog9.printMenu(input);
			/** if user selects choice 7 then break the loop 
			**/

			if(choice == 7) break;

			/** use handler method to handle each selected choice **/
			if(choice == 1){
				prog9.addAlbum(input);
			}
			else if(choice == 2){
				prog9.updateAlbum(input);
			}
			else if(choice == 3){
				prog9.removeAlbum(input);
			}
			else if(choice == 4){
				prog9.printAlbums();
			}
			else if(choice == 5){
				prog9.printByArtist();
			}
			else if(choice == 6){
				prog9.printByYear();
			}

		}
	}
	/** method to print the menu **/

	public int printMenu(Scanner input){

		System.out.println("\nPlease make a selection: ");
		System.out.println("1 - Add a new album");
		System.out.println("2 - Update an album ");
		System.out.println("3 - remove an album ");
		System.out.println("4 - print entire collection ");
		System.out.println("5 - print by artist ");
		System.out.println("6 - print by year");
		System.out.println("7 - Quit");
		System.out.println("Your selection: ");
		int choice = input.nextInt();

		return choice;

	}
	/** we are using class level method because 
	 * only class level variables are restricted to 
	 * use in the program **/
/** method to add a album **/
	public void addAlbum(Scanner input){

		if(size < MAX_SIZE){
			input.nextLine();
			System.out.print("Enter the title: ");
			String title = input.nextLine();
			System.out.print("Enter the artist name: ");
			String artist = input.nextLine();
			System.out.print("Enter the release year: ");
			int year = input.nextInt();

			albums[size++] = new Album(title, artist, year);

			System.out.println("Album added successfully!!");
		}

		else{
			System.out.println("No enough space to add a new album!!");
		}
	}

	/** method to search an album that helps to make reusable code **/

	private int search(String title){

		int index = -1;

		/** search the title **/
		for(int i = 0; i < size; i++){

			if(albums[i].getTitle().equalsIgnoreCase(title)){
				index = i;
			}
		}

		return index;
	}
/** method for updating an album **/
	public void updateAlbum(Scanner input){
		input.nextLine();
		System.out.print("Enter the title to update: ");
		String title = input.nextLine();

		int index = search(title);

		if(index != -1){

			System.out.println("Enter the new title: ");
			title = input.nextLine();
			System.out.println("Enter the new artist: ");
			String artist = input.nextLine();
			System.out.println("Enter the new released year: ");
			int year = input.nextInt();

			albums[index].setTitle(title);
			albums[index].setArtist(artist);
			albums[index].setYear(year);

			System.out.println("Records update successfully!!");
		}

		else {
			System.out.println("Cannot update!! Title is not found.");
		}
	}

	/** method for deleting and album **/
	public void removeAlbum(Scanner input){

		System.out.print("Enter the title to remove: ");
		input.nextLine();
		String title = input.nextLine();

		int index = search(title);

		if(index != -1){

			/** create an new array by one less size **/
			Album []newAlbums = new Album[albums.length - 1];

			/** copy all albums to this new array except the deleted one **/

			for(int i = 0, j = 0; i < albums.length; i++){

				if(i == index){
					continue;		
				}
				else{
					newAlbums[j++] = albums[i];
				}
			}

			/** change the reference of albums to the newAlbums **/
			albums = newAlbums;

			System.out.println("Deleted successfully!!");

			size--;
		}

		else {
			System.out.println("Cannot remove!! Title is not found.");
		}
	}
/** method to print collection of albums **/
	public void printAlbums(){
		System.out.println("\n******** Collections **********");
		for(int i = 0; i < albums.length; i++){
			albums[i].print();
			System.out.println();
		}
	}

	public void printByArtist(){
		// 2. sort using comparator: sort by artist 
	    Arrays.sort(albums, new Comparator<Album>() {
	        @Override
	        public int compare(Album o1, Album o2) {
	            return o1.getArtist().compareTo(o2.getArtist());
	        }
	    });

	    printAlbums();
	}

	public void printByYear(){

				// 2. sort using comparator: sort by artist 
	    Arrays.sort(albums, new Comparator<Album>() {
	        @Override
	        public int compare(Album o1, Album o2) {
	        	if(o1.getYear() > o2.getYear())
	        		return 1;
	        	else if(o1.getYear() < o2.getYear())
	        		return -1;
	        	else
	        		return 0;
	            
	        }
	    });

	    printAlbums();
	}

}