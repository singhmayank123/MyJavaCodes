public class Album{
	
	// stores the title of the album 
	private String title;
	// stores the artist name of the album
	private String artist;
	// stores the launched year of album 
	private int year;

	/** constructor to initialize member variables **/

	public Album(){
		title = "None";
		artist = "None";
		year = 0;
	}
	public Album(String title, String artist, int year){
		this.title = title;
		this.artist = artist;
		this.year = year;
	}

	/** accessor methods for each field **/

	public String getTitle(){
		return title;
	}

	public String getArtist(){
		return artist;
	}

	public int getYear(){
		return year;
	}

	/** modifier methods for each field **/

	public void setTitle(String title){
		this.title = title;
	}

	public void setArtist(String artist){
		this.artist = artist;
	}

	public void setYear(int year){
		this.year = year;
	}

	/** print method to display the value of each class field **/

	public void print(){

		System.out.println("Title: "+ title);
		System.out.println("Artist: "+ artist);
		System.out.println("Release Year: "+ year);
	}
}
