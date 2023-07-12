import java.util.Scanner; // for taking user inputs 

/** class that simulates the given task **/
public class VaccineAppointment{
	
	/** method to print the list of available vaccines 
	 * and choose one of the vaccine **/
	public static int printVaccineMenu(Scanner input){

		System.out.println("\nBelow are the available vaccines...");
		System.out.println("1) Pfizer");
		System.out.println("2) Moderna");
		System.out.println("3) AstraZeneca");
		System.out.println("4) Johnson & Johnson");
		System.out.println("5) Sinovac");
		System.out.println("6) Gameliya");
		System.out.println("7) Exit");

		System.out.print("Enter an option: ");

		int choice = input.nextInt();

		return choice;
	}

	/** method to book the appointment for the given time slots **/

	public static boolean bookAppointment(Scanner input){

		System.out.println("\nBelow are the available time slots");
		System.out.println("1) 2.00 - 2.15");
		System.out.println("2) 2.20 - 2.35");
		System.out.println("3) 2.40 - 2.55");
		System.out.println("4) 3.00 - 3.15");
		System.out.println("Choose a time slot to book your appointment? ");

		int timeSlot = input.nextInt();

		/** Ask the user for the 1st shot or 2nd shot **/
		System.out.println("1st shot or 2nd shot?? ");
		String shot = input.next();

/** if user choose a valid time slot, then book the appointment and 
 * return true to tell the caller for the success **/
		if(timeSlot >= 1 && timeSlot <= 4){

			System.out.println("Your have booked the appointment "+
				"for the "+shot+" shot");

			return true;
		}
/** if user choose any invalid time slot then don't book the appointment 
 * and return false such that the program can show the list of available 
 * vaccines again to the user **/
		else{

			System.out.println("Can't book an appointment for you!");
			return false;
		}
	}

// main driver method 
	public static void main(String[] args) {

// for taking user inputs 
		Scanner input = new Scanner(System.in);
/* flag variable that checks whether the appointment is done or not **/
		boolean hasAppointment = false;

		int loc;
/** an infinite loop **/		
		while(true){
/** print the menu **/
			int vaccineChoice = printVaccineMenu(input);
/** if user chooses exits then break the loop to stop further execution **/
			if(vaccineChoice == 7) break;

			if(vaccineChoice == 1){

				System.out.println("\nBelow are the available locations....");
				System.out.println("1) Pharmaprix\n2)Jean Coutu\nChoose one? ");

				loc = input.nextInt();

				if(loc == 1){
					hasAppointment = bookAppointment(input);
				}

				else if(loc == 2){
					hasAppointment = bookAppointment(input);
				}

				else {
					System.out.println("Invalid choice!");
				}

			}

			else if(vaccineChoice == 2){

				System.out.println("Below are the available locations");
				System.out.println("1) Pharmaprix\n2)Uniprix Clinique"+
					"\n3) Health Center\nChoose one? ");

				loc = input.nextInt();

				if(loc == 1){
					hasAppointment = bookAppointment(input);
				}

				else if(loc == 2){
					hasAppointment = bookAppointment(input);
				}

				else if(loc == 3){
					hasAppointment = bookAppointment(input);
				}

				else {
					System.out.println("Invalid choice!");
				}
			}

			else if(vaccineChoice == 3){

				System.out.println("Below are the available locations");
				System.out.println("1) Jean Coutu\n2)Uniprix Clinique"+
					"\nChoose one? ");

				loc = input.nextInt();

				if(loc == 1){
					hasAppointment = bookAppointment(input);
				}

				else if(loc == 2){
					hasAppointment = bookAppointment(input);
				}

				else {
					System.out.println("Invalid choice!");
				}
			}

			else if(vaccineChoice == 4){

				System.out.println("Below are the available locations");
				System.out.println("1) Health Center");
				hasAppointment = bookAppointment(input);

			}
/** for no locations menu do only appointment **/
			else if(vaccineChoice == 5 || vaccineChoice == 6){

				hasAppointment = bookAppointment(input);
			}
/** if appointment is done then break the loop, else keep running the loop **/
			if(hasAppointment)
				break;
		}
	}
}