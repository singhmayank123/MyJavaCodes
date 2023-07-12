import java.io.FileWriter;
import java.io.IOException;

public class Book {

// class fields 
	private String name;
	private String isbn;
	private double price;
	private String publisher;
	
// constructor for initializing the fields 
	public Book(String name, String isbn, double price, String publisher) {
		super();
		this.name = name;
		this.isbn = isbn;
		this.price = price;
		this.publisher = publisher;
	}

// getters and setters method 
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	
	/* static method that accepts an array of books and
		 and adds the data into the file **/
	
	public static void writeToFile(Book books[]) {
		
		try {
			FileWriter fw = new FileWriter("cheapBooks.txt");
			
			for(int i = 0; i < books.length; i++) {
				if(books[i].getPrice() < 5){
					String str = books[i].getIsbn() + "\t" + books[i].getName() + "\n";
					fw.write(str);
				}	
			}

			fw.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// main method for testing
	public static void main(String[] args) {
		
		// Create an array of book 
		Book[] books = { 
			new Book("Java illuminated", "456-8774-474-3456", 1, "ABC"),
			new Book("Cplus plus", "346-8894-564-3466", 2, "ABC"),
			new Book("Data structures", "346-9009-454-3459", 4, "XYZ"),
			new Book("Java programming", "566-1456-900-3455", 5, "ABC"),
			new Book("Python programming", "456-8774-474-1235", 1, "ABC")		
		};

		writeToFile(books);
	}
}
