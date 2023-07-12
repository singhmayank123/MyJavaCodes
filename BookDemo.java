public class BookDemo{

	public static void main(String[] args) {
		
		Book book1 = new Book("Java programming", 100, 2, 
			new Author("James Gosling", "abc@example.com", "male"));

		System.out.println(book1.toString());
	}
}