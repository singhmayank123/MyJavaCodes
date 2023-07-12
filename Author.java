
public class Author{

	private String name;
	private String email;
	private String gender;

	public Author(String name, String email, String gender){
		this.name = name;	
		this.email = email;
		this.gender = gender;
	}
	// getters

	public String getName(){
		return name;
	}

	public String getEmail(){
		return email;
	}

	public String getGender(){
		return gender;
	}

	// setters 

	public void setName(String name){
		this.name = name;
	}

	public void setEmail(String email){
		this.email = email;
	}

	public void setGender(String gender){
		this.gender = gender;
	}
	public String toString(){
		return (this.name + " at "+ this.email);
	}

}