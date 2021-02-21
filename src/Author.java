import java.util.ArrayList;

public class Author {
	

	private String name;
	private int dob;
	private int dod;
	
	//Storing books against author name
	private ArrayList<Book> books = new ArrayList<>();
	
	
	//Constructor	
	public Author(String name, int dob, int dod) {
		super();
		this.name = name;
		this.dob = dob;
		this.dod = dod;
		
	}
		
	
	//Methods
	
	
	//Creating a method to add the object 'book' to the class Author and to the array within this class 'books'
	public void addBook(Book book) {
				
		books.add(book);
		
	}
	
	
	
	public String display() {
		
		return "Author: " + name + " " + dob + " - " + dod + " Number of books:" + books.size();
	
	}
	
	
	public String displayShort() {
		
		return "Author: " + name + " " + dob + " - " + dod;
	
	}
	
	
	
	public ArrayList<Book> getBooks(){
		
		
		return this.books;

		
		
	}

	
	


	//Getters and Setters
	
	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public int getDob() {
		return dob;
	}



	public void setDob(int dob) {
		this.dob = dob;
	}



	public int getDod() {
		return dod;
	}



	public void setDod(int dod) {
		this.dod = dod;
	}
		

}
