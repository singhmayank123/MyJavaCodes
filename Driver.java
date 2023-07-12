import java.util.*;

class Drink {

	// fields 
	protected String name;
	protected String description;
	protected String cookingTime;
	protected double cost;

	// constructor 
	public Drink(String n, String d, String ct, double co){
		name = n;
		description = d;
		cookingTime = ct;
		cost = co;
	}
	// methods 
	public double cost(){
		return cost;
	}

	public String displayDrink(){
		return ("Name: " + name + "\n"+ "Description : "+description);
	}
}

// Child class 

class Coffee extends Drink{

	private int amountOfCaffeine; // in grams
	private boolean hasSugar; // to tell whether has sugar or not 
	private String caffeineType; // powder type
	/** array list to store collection of condiments **/
	private ArrayList<String> condiments = new ArrayList<>();

	/* constructor **/
	public Coffee(int amc, boolean hs, String ctype, String n, String d,
		String ct, double co){
	// call super method to initialize super class fields first 
		super(n, d, ct, co);
		amountOfCaffeine = amc;
		hasSugar = hs;
		caffeineType = ctype;
	}

	@Override
	public String displayDrink(){
	/* call parent class method first to print parent class details **/
		String str = super.displayDrink();

		str += ("\nAmount of caffeine: "+amountOfCaffeine+"\n"+
			"Has sugar : "+hasSugar+"\n"+
			"Caffeine type: "+caffeineType);

		return str;
	}
	@Override
	public double cost(){
		return cost;
	}

}

class Smoothie extends Drink{

	private String typeOfMilk;
	private int numOfBananas;
	private String typeOfBerries;
	private boolean hasAvagadro;
	private String typeOfButter;

	// constructor 
	public Smoothie(String tom, int nob, String tob,
	boolean ha, String tobu, String n, String d,
		String ct, double co){
	// call super method to initialize super class fields first 
		super(n, d, ct, co);
		typeOfMilk = tom;
		numOfBananas = nob;
		typeOfBerries = tob;
		hasAvagadro = ha;
		typeOfButter = tobu;
	}

	@Override
	public String displayDrink(){
	/* call parent class method first to print parent class details **/
		String str = super.displayDrink();

		str += ("\nType of Milk: "+typeOfMilk+"\n"+
			"Number of bananas added : "+numOfBananas+"\n"+
			"Type of berries: "+typeOfBerries+"\n"+
			"Has Avagadro: "+hasAvagadro+"\n"+
			"Type of Butter: "+typeOfButter);

		return str;
	}

	@Override
	public double cost(){
		return cost;
	}
}

class Wine extends Drink{

	private double alcoholPercent;
	private String brandName;

	// constructor 
	public Wine(double ap, String bn,  String n, String d,
		String ct, double co){
	// call super method to initialize super class fields first 
		super(n, d, ct, co);
		alcoholPercent = ap;
		brandName = bn;
	}

	@Override
	public String displayDrink(){
	/* call parent class method first to print parent class details **/
		String str = super.displayDrink();

		str += ("\nAlcohol Percentage: "+alcoholPercent+"\n"+
			"Brand Name: "+brandName);

		return str;
	}

	@Override
	public double cost(){
		return cost;
	}

}

class DrinksMenu{

	public ArrayList<Coffee> coffeeItems;
	public ArrayList<Smoothie> smoothieItems;
	public ArrayList<Wine> wineItems;

	// default constructor 

	public DrinksMenu(){
		coffeeItems = new ArrayList<>();
		smoothieItems = new ArrayList<>();
		wineItems = new ArrayList<>();
	}
/** method to create different types of coffee, smothie, wine items **/
	public void createMenu(){

		coffeeItems.add(new Coffee(100, true, "Nescafe", "Cold Coffee", 
			"Cold coffee with sugar", "5 minutes", 30));
		coffeeItems.add(new Coffee(60, false, "Nescafe", "Hot Coffee", 
			"Cold coffee with no sugar", "6 minutes", 40));

		/* similarly you can add for smothie and wine **/

	}
/** calculates the total cost of the items in the array list **/
	public double calculateTotalCost(){

		double cost = 0;

		for(Coffee c: coffeeItems){
			cost += c.cost();
		}
		for(Wine w: wineItems){
			cost += w.cost();
		}
		for(Smoothie s: smoothieItems){
			cost += s.cost();
		}

		return cost;
	}
/** method to display menus **/
	public void displayMenu(Scanner input){

		System.out.println("1) Show Coffees");
		System.out.println("2) Show Smoothies");
		System.out.println("3) Show Wines");
		System.out.println("4) Show total cost of all Drinks");
		System.out.println("Enter a choice: ");

		int choice = input.nextInt();

		if(choice == 1){

			if(coffeeItems.isEmpty()){
				System.out.println("No coffee items are available!");
			}

			else{

				for(Coffee c: coffeeItems){
					System.out.println(c.displayDrink());
				}
			}
		}

		else if(choice == 3){

			if(wineItems.isEmpty()){
				System.out.println("No wine items are available!");
			}

			else{

				for(Wine w: wineItems){
					System.out.println(w.displayDrink());
				}
			}
		}

		else if(choice == 2){

			if(smoothieItems.isEmpty()){
				System.out.println("No smoothie items are available!");
			}

			else{

				for(Smoothie s: smoothieItems){
					System.out.println(s.displayDrink());
				}
			}
		}

		else if(choice == 4){

			System.out.println("total cost: "+ calculateTotalCost());
		}

		else{
			System.out.println("Invalid selection!!");
		}
	}
}

public class Driver{

	public static void main(String[] args) {

		DrinksMenu menu = new DrinksMenu();

		Scanner input = new Scanner(System.in);
		menu.createMenu();
		menu.displayMenu(input);
	}
}