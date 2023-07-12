// derived class 
public class C2 extends C1{
	
	private int a; // data member 

	public C2(){}
	/** A Constructor **/

	public C2(int a, int x, double y, char z){
	 /** call the base class constructor using super() to initialize 
	the base state */
		super(x, y, z);
		this.a = a;
	}

	public int getA(){ return a; }
	public void setA(int a){ this.a = a; }

	@Override
	public void print(){
		super.print(); // print super class states
		System.out.println("A = "+ a);
	}
}