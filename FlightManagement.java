import java.util.*;

class Flight{

/** member variables **/
	private int flight_number; //stores the flight number 
	private Pilot pilot; // stores the Pilot information 
	private String date_of_flight; // stores a specific date 

	/** other attributes **/
	private String departure_time;  
	private String arrival_time;
	private String origin; 
    private String destination; 

    private int currSize;

    /** maximum 10 passengers can be added in the flight **/
	public static final int MAX_NUM_OF_PASSENGERS = 10;

	/** array for storing info of 10 passenegers ***/
	LinkedList<Passenger> passengers = new LinkedList<>();

	/** constructor for initializing the member variables **/

	public Flight(int flight_number, String fname, String lname,
		String gender, String pilotID, String passportNumber,
		String date_of_flight, String departure_time,
		String arrival_time, String origin, String destination){

		this.flight_number = flight_number;
		this.pilot = new Pilot(passportNumber, fname, lname, gender, pilotID);
		this.date_of_flight = date_of_flight;
		this.departure_time = departure_time;
		this.arrival_time = arrival_time;
		this.origin = origin;
		this.destination = destination;
		currSize = 0;
	}

	/** method for adding a passenger that returns true if 
	 * added successfully **/

	boolean addPassenger(String passportNumber, String fname, 
		String lname, String gender){

		if(currSize < 10){
			passengers.add(new Passenger(passportNumber, fname, lname, gender));
			currSize++;
			return true;
 		}
 		
 		else{
 			System.out.println("Flight is full!!");
 			return false;
 		}
	}

	/** method to remove a passenger with the given ID **/

	boolean removePassenger(String uid){

		for(int i = 0; i < MAX_NUM_OF_PASSENGERS; i++){

			if(passengers.get(i).getID().equalsIgnoreCase(uid)){			
				passengers.remove(i);
			}
		}

		currSize--;

		return true;
	}

	/** method to retrieve the average number of passengers **/

	public int getAvgPassengers(){
		return currSize;
	}

	public String getFlightDate(){
		return date_of_flight;
	}

	public int getFLightNumber(){
		return flight_number;
	}
}

class Passenger{

	private String passportNumber; /** stores the passenger's passport number **/
	private String fname; /** stores the passengers's first name **/
	private String lname; /** stores the passengers's first name **/
	private String gender; /** stores male, female, or other **/

	/** constructor to initialize the variables **/

	public Passenger(String passportNumber, String fname, 
		String lname, String gender){

		this.passportNumber = passportNumber;
		this.fname = fname;
		this.lname = lname;
		this.gender = gender;
	}

	public String getID(){
		return passportNumber;
	}
}

class Pilot extends Passenger{

	private String pilotID;
	/** name is inherited from Passenger class **/

	public Pilot(String passportNumber, String fname, 
		String lname, String gender, String pilotID){
		super(passportNumber, fname, lname, gender);
		this.pilotID = pilotID;
	}
}


class sortByDate implements Comparator<Flight> {
    // Used for sorting in ascending order of
    // date of flight 
    public int compare(Flight a, Flight b)
    {
        return a.getFlightDate().compareTo(b.getFlightDate());
    }
}


public class FlightManagement{

/** method that returns the average number of passengers 
 * available on the given flight on a specific date **/
	public static void getAvailablePassenger(String date, ArrayList<Flight> flight){

		for(int i = 0; i < flight.size(); i++){

			System.out.println("##### Flight "+(i+1)+" ######");
			System.out.println("Available Passengers: "+ 
				flight.get(i).getAvgPassengers());
		}
	}

	private static void sortByDate(ArrayList<Flight> flight){
		Collections.sort(flight, new sortByDate());
	}

	public static void displayAvailFlights(ArrayList<Flight> flight){

		sortByDate(flight);

		System.out.println("### Available flights ###");

		for(Flight fl: flight){

			System.out.println("Date: "+ fl.getFlightDate()+
				", Flight number: "+ fl.getFLightNumber());
		}

	}

	public static void main(String[] args) {
		
		Flight flight1 = new Flight(1234, "Mayank", "Singh", "male", 
			"PIL123","XYZ", "05-11-2021", "6:00", "5:40", "Delhi", "Bangalore");
		Flight flight2 = new Flight(1254, "Suraj", "Chaudhary", "male", 
			"PIL123","XYZ", "08-11-2021", "6:00", "5:40", "Delhi", "Goa");
		Flight flight3 = new Flight(12345, "Aman", "Chandna", "male", 
			"PIL123","XYZ", "08-11-2021", "6:00", "5:40", "Goa", "Bangalore");
		Flight flight4 = new Flight(1236, "Deepak", "Sharma", "male", 
			"PIL123","XYZ", "05-11-2021", "6:00", "5:40", "Pune", "Bangalore");

		ArrayList<Flight> flights = new ArrayList<>();
		flights.add(flight1);
		flights.add(flight2);
		flights.add(flight3);
		flights.add(flight4);
	
		displayAvailFlights(flights);

		flight1.addPassenger("13438", "Mayank", " Singh", "Male");
		getAvailablePassenger("05-11-2021", flights);
	}

}