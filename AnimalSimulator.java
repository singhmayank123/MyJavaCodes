import java.util.LinkedList;

/** Super class **/
public class Animal{

/** stores the name of the animal **/
	private String animal_name;
/** stores the position of the animal **/
	protected Point p;
/** stores the size of the grid in which these 
 * animals will move **/
	protected final int MAX_X = 20, MAX_Y = 20;

/** string of directions **/
	public String directions[] = {"N", "E", "W", "S"};

/** constructor that initialize the animal name and
 * initial coordinates randomly from the grid **/
	public Animal(String name){

		animal_name = name;

		int x = getRandVal(1, MAX_X);
		int y = getRandVal(1, MAX_Y);

		p = new Point(x, y);
	}
/** method that returns teh animal name **/
	public String toString(){
		return animal_name;
	}
/** method that returns the animal current position **/
	public Point getMove(){
		return p;
	}
/** method that sets the animal position to move **/
	public void setMove(){
		System.out.println("\nMoving "+animal_name+" .....");
	}
/* method that returns a random value **/
	public int getRandVal(int min, int max){

		int rand = (int)(Math.floor(Math.random()*(max-min+1)+min));
		return rand;
	}
}

/** Sub class to represent the Bird **/
public class Bird extends Animal{

/** no-args constructor to set the name of animal **/
	public Bird(){
		super("B");
	}

/** method to set the move of the animal for every call **/
	public void setMove(){

		super.setMove();
/* get any one random direction from four **/
		int randIndex = getRandVal(0, 3);

		String direc = directions[randIndex];
/** validate the direction and move the animal 1 step in that
 * direction **/ 
		if(direc.equalsIgnoreCase("N"))
			if(p.getY() - 1 >= 0)
				p.setLocation(p.getX(), p.getY() - 1);
		else if(direc.equalsIgnoreCase("E"))
			if(p.getX() + 1 <= MAX_X)
				p.setLocation(p.getX() + 1, p.getY());
		else if(direc.equalsIgnoreCase("W"))
			if(p.getX() - 1 >= 0)
				p.setLocation(p.getX() - 1, p.getY());
		else{

			if(p.getY() + 1 <= MAX_Y)
			p.setLocation(p.getX(), p.getY() + 1);
		}
	}
}

/** sub-class of Animal to represent Frog **/
public class Frog extends Animal{

/* no-arg constructor to initialize the name **/
	public Frog(){
// call super class constructor to set the name 
		super("F");
	}

/** method to set the move of the frog **/
	public void setMove(){

		super.setMove();

/** get a random direction **/
		int randIndex = getRandVal(0, 3);

		String direc = directions[randIndex];
/** validate the selected direction and move the frog 3 steps 
 * in that direction **/
		if(direc.equalsIgnoreCase("N"))
			if(p.getY() - 3 >= 0)
				p.setLocation(p.getX(), p.getY() - 3);
		else if(direc.equalsIgnoreCase("E"))
			if(p.getX() + 3 <= MAX_X)
				p.setLocation(p.getX() + 3, p.getY());
		else if(direc.equalsIgnoreCase("W"))
			if(p.getX() - 3 >= 0)
				p.setLocation(p.getX() - 3, p.getY());
		else
			if(p.getY() + 3 <= MAX_Y)
				p.setLocation(p.getX(), p.getY() + 3);
		
	}

}

/** sub-class of Animal to represent the mouse */
public class Mouse extends Animal{

	public Mouse(){

		super("M");
	}

	public void setMove(){

		super.setMove();

		// moves 1 step to north 
		if(p.getY() - 1 >= 0)
			p.setLocation(p.getX(), p.getY() - 1);
	// moves 1 step to west
		if(p.getX() - 1 >= 0) 
		p.setLocation(p.getX() - 1, p.getY());
	
	}

}

/** sub-class of Animal to represent the Rabbit **/
public class Rabbit extends Animal{

	public Rabbit(){

		super("V");
	}

	public void setMove(){

		super.setMove();
		// moves 2 steps to north 
		if(p.getY() - 2 >= 0)
			p.setLocation(p.getX(), p.getY() - 2);
	// moves 2 steps to east 
		if(p.getX() + 2 <= MAX_X)
			p.setLocation(p.getX() + 2, p.getY());
	// moves 2 step to south
		if(p.getY() + 2 <= MAX_Y)
			p.setLocation(p.getX(), p.getY() + 2);
	}

}

/** sub-class of Animal to represent the Snake **/
public class Snake extends Animal{

	public Snake(){

		super("S");
	}

	public void setMove(){

		super.setMove();
		// moves 1 step to south
		if(p.getY() + 1 <= MAX_Y)
			p.setLocation(p.getX(), p.getY() + 1);
		// moves 1 step to east 
		if(p.getX() + 1 <= MAX_X)
			p.setLocation(p.getX() + 1, p.getY());
		// moves 1 step to south
		if(p.getY() + 1 <= MAX_Y)
			p.setLocation(p.getX(), p.getY() + 1);
		// moves 2 steps to west
		if(p.getX() - 2 >= 0) 
			p.setLocation(p.getX() - 2, p.getY());
		// moves 1 step to south
		if(p.getY() + 1 <= MAX_Y)
			p.setLocation(p.getX(), p.getY() + 1);
		// moves 3 steps to east 
		if(p.getX() + 3 <= MAX_X)
			p.setLocation(p.getX() + 3, p.getY());
		// moves 1 step to south
		if(p.getY() + 1 <= MAX_Y)
			p.setLocation(p.getX(), p.getY() + 1);
	// moves 4 steps to west 
		if(p.getX() - 4 >= 0) 
			p.setLocation(p.getX() - 4, p.getY());
	
	}

}
// Turtle.java
/** sub-class to represent the Turtle move **/
public class Turtle extends Animal{

	public Turtle(){
		super("T");
	}

	public void setMove(){

		super.setMove();
		// moves 5 steps to south
		if(p.getY() + 5 <= MAX_Y)
			p.setLocation(p.getX(), p.getY() + 5);
		// moves 5 steps to west
		if(p.getX() - 5 >= 0) 
			p.setLocation(p.getX() - 5, p.getY());
		// moves 5 steps to north 
		if(p.getY() - 5 >= 0)
			p.setLocation(p.getX(), p.getY() - 5);
		// moves 5 steps to east 
		if(p.getX() + 5 <= MAX_X)
			p.setLocation(p.getX() + 5, p.getY());
		
	}

}

public class Wolf extends Animal{

	public Wolf(){

		super("W");
	}
/** set the user-selected move for this animal **/
	public void setMove(int step, String direc){

		super.setMove();
		if(direc.equalsIgnoreCase("N")){
			
			if(p.getY() - step >= 0)
				p.setLocation(p.getX(), p.getY() - step);
		}

		else if(direc.equalsIgnoreCase("E"))
			if(p.getX() + step <= MAX_X)
				p.setLocation(p.getX() + step, p.getY());

		else if(direc.equalsIgnoreCase("W")){

			if(p.getX() - step >= 0)
				p.setLocation(p.getX() - step, p.getY());
		}
		else if(direc.equalsIgnoreCase("S"))
			if(p.getY() + step <= MAX_Y)
				p.setLocation(p.getX(), p.getY() + step);
		else
			System.out.println("Invalid direction! Choose only N, E, W, S");
	
	}
}


public class AnimalSimulator{

	public static void printInitialMoves(LinkedList<Animal> animals){

		System.out.println("Initial Moves of Animals.......\n");

		for(int i = 0; i < animals.size(); i++){

			System.out.printf("%s is at (%d, %d)\n", 
				animals.get(i).toString(),
				animals.get(i).getMove().getX(), 
				animals.get(i).getMove().getY());
		}
	}

	public static boolean checkAllCollides(LinkedList<Animal> animals){

		boolean isAll = true;

		for(int i = 0; i<animals.size(); i++){

			for(int j = i+1; j<animals.size(); j++){

				if(animals.get(i).getMove().equals(animals.get(j).getMove())){

					System.out.println("\nAnimal "+animals.get(i).toString()+
						" and animal " + animals.get(j).toString()+
						" collides.");

					System.out.println("\nEliminating "+ animals.get(i).toString()
						+ " and " +animals.get(j).toString());

					animals.remove(animals.get(i));
					if(j == animals.size())
						animals.remove(animals.get(j-1));
					else
						animals.remove(animals.get(j));
				}

				else{

					isAll = false;
				}
			}
		}

		return isAll;
	}

	public static void printMove(Animal animal){

		System.out.printf("%s is at (%d, %d)\n", 
				animal.toString(),
				animal.getMove().getX(), 
				animal.getMove().getY());
	}

	public static void main(String[] args) {
	
		LinkedList<Animal> animals = new LinkedList<>();

		animals.add(new Bird());
		animals.add(new Frog());
		animals.add(new Mouse());
		animals.add(new Rabbit());
		animals.add(new Snake());
		animals.add(new Turtle());
		animals.add(new Wolf());

		printInitialMoves(animals);

		while(!checkAllCollides(animals)){

			for(int i = 0; i < animals.size(); i++){
				animals.get(i).setMove();
				printMove(animals.get(i));
			}
		}
	}
} 