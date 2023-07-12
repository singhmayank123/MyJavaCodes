/* main class to demonstrate the working of Person and Customer class */
/* This file can be tested on Eclipse, java 11 */
public class PersonDemo {

	/* A static method that takes an object of Customer class and 
	print the details using accessor method */

	public static void printDetails(Customer p){

		System.out.println("Name: "+ p.getName());
		System.out.println("Address: "+ p.getAddress());
		System.out.println("Telephone number: "+ p.getTelephone());
		System.out.println("ID number: "+ p.getCusNo());
		System.out.println("Available on mailing list: "+ p.isOnMailingList());
	}

	/* main driver method */

	public static void main(String[] args) {
		
		// Create an instance of customer class using the no-arg constructor 
		Customer customer = new Customer();

		System.out.println("Printing Customer's details when Object is just created. ");
		// print the default details of the customer that is set by no-arg constructor 
		printDetails(customer);	

		// Setting the proper fields using mutator methods 

		System.out.println("\nSetting the values using mutators..");

		customer.setName("Person A");
		customer.setAddress("Country C");
		customer.setTelephone("91-28728-18");
		customer.setCusNo(12334);
		customer.setMailingList(true);

		// print the updated details 
		System.out.println("\nPrinting the updated details...\n");	
		printDetails(customer);
	}
	
}