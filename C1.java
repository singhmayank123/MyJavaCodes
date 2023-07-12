// Base class
public class C1{

	private int x; // private member
	protected double y; // protected member 
	public char z; // public member 

	// class Contructor 

	public C1(){}
	
	public C1(int x, double y, char z){

		this.x = x;
		this.y = y;
		this.z = z;
	}
	// getter and setter for x 
	public int getX() { return x; }
	public void setX(int x) { this.x = x; }
	// getter and setter for y
	public double getY(){ return y; }
	public void setY(double y){ this.y = y; }
	// print method to print out the data member's value 
	public void print(){
		System.out.println("X = "+x);
		System.out.println("Y = "+y);
		System.out.println("Z = "+z);
	}
}

