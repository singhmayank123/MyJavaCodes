/* Super class Person that represents the person basic details */

public class Person{
	
	private String name; // for name 
	private String address; // for address 
	private String telephone; // for telephone 


/** A constructor to initialize the object state */
	public Person(String name, String address, String telephone){

		this.name = name;
		this.address = address;
		this.telephone = telephone;
	}

/* Accessors for each instance variable */

	public String getName(){
		return name;
	}

	public String getAddress(){
		return address;
	}

	public String getTelephone(){
		return telephone;
	}

/* Mutators for each instance variable */

	public void setName(String name){
		this.name = name;
	}
	public void setAddress(String address){
		this.address = address;
	}

	public void setTelephone(String telephone){
		this.telephone = telephone;
	}
}