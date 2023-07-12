
public class Author{

	private String name;
	private String email;
	private String gender;

	// getters

	public String getName(){
		return name;
	}

	public String getEmail(){
		return email;
	}

	public getGender(){
		return gender;
	}

	// setters 

	public void setName(String name){
		this.name = name;
	}

	public void setEmail(String email){
		this.email = email;
	}

	public String toString(){
		return (this.name + " at "+ this.email);
	}

}