import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import ecs100.UI;

public class UserInterface {


	//Storing books against author name
	private ArrayList<Author> authors = new ArrayList<>();	

	public UserInterface() {
		UI.initialise();
		UI.addButton("List authors", this::listAuthors);
		UI.addButton("List all books", this::listBooks);
		UI.addButton("List books of author", this::listAuthorBooks);
		UI.addButton("Look up book by title", this::lookUpBook);
		UI.addButton("Issue book", this::issueBook);

		try {
			//This line opens the file book.txt and has read it into memory, and data is stored in the 'scan' variable
			Scanner scan = new Scanner(new File("books.txt"));

			// Write code here to load books.txt into objects
			// and lists you design. You will need to make
			// classes, write loops to load the file,
			// and store objects made from your classes into
			// lists.

			//Loop through book.txt
			while (scan.hasNext()) {

				//Set variables - to read data from file and assign to relevant variables

				String authorName = scan.nextLine();
				int dob = scan.nextInt();

				//initialising dod to a value of 0 (author is still alive)
				int dod = 0;

				//if there is a dod value in the text document
				if(scan.hasNextInt()) {

					//assign that value to dod, otherwise default to the zero that it is initialised as
					dod = scan.nextInt();
				}

				//new object created from the Author class				
				Author author = new Author(authorName, dob, dod);
				//adding new object 'author' to the 'authors' array
				authors.add(author);

				scan.nextLine();


				while(!scan.hasNext("---")){

					//start collecting book data				
					String bookTitle = scan.nextLine();
					int bookDate = scan.nextInt();

					//new object created from the Book class				
					Book book  = new Book(bookTitle, bookDate);

					//calling the method addBook set in the Author class which adds the new object 'book' to the 'books' array within the class 'Author'
					//new object 'author' adding the object 'book' to it
					author.addBook(book);

					scan.nextLine();

				}

				scan.nextLine();

			}
		} catch (IOException e) {
			UI.println("File error: " + e);
			e.printStackTrace();
		}
	}

	public void listAuthors() {
		// List names, lifetimes, and number of books
		// in the library for all authors


		for(int i =0; i<authors.size(); i++) {

			UI.println(authors.get(i).display()); //display the authors and the num of books

		}

	}

	public void listBooks() {
		// List titles of all books

		//loop through the authors
		for(int i =0; i<authors.size(); i++) {


			//*----The method displayBooksByAuthor (created below) is being called, and is a 
			//*----Seperate method to avoid duplicating the loop code across other methods
			this.displayBooksByAuthor(authors.get(i));


		}

	}

	public void listAuthorBooks() {
		// List titles of all books by a chosen author

		String authorName = UI.askString("Enter an author's name: ");


		//loop through all of the authors
		for(int i = 0; i<authors.size(); i++) {
			//check if the name matches the supplied string
			if(authors.get(i).getName().equalsIgnoreCase(authorName)) {


				//*----The method displayBooksByAuthor (created below) is being called, and is a 
				//*----Seperate method to avoid duplicating the loop code across other methods
				this.displayBooksByAuthor(authors.get(i));

			}
		}

	}	



	public void displayBooksByAuthor(Author a){

		//*---- This code gets duplicated across other methods, so have made it its own method
		//Every author has their own list of books, so we need to call this array so that we can loop through each author's books
		ArrayList<Book> book = a.getBooks();


		// loop through the books each author has
		for(int j =0; j<book.size(); j++) {

			//display the book details
			UI.println(book.get(j).display());

			//*----	

		}


	}

	//Looking up book using a for each loop which is much tidier
	public void lookUpBook() {
		// Show book, publication date, and author information

		String bookTitle = UI.askString("Enter book name");

		//loop through all of the authors
		for(Author a : authors) {

			for(Book b : a.getBooks()) {

				if(b.getTitle().equalsIgnoreCase(bookTitle)) {

					//display the book details
					UI.println("--------------------------------");
					UI.println(b.display());	
					UI.println(a.displayShort());
					UI.println("--------------------------------");

				}												
			}						
		}	
	}


	//Alternative way for looking up book using a for loop:	
	public void lookUpBook2() {
		// Show book, publication date, and author information

		String bookTitle = UI.askString("Enter book name");

		//loop through all of the authors
		for(int i =0; i<authors.size(); i++) {

			ArrayList<Book> book = authors.get(i).getBooks();


			for(int j =0; j<book.size(); j++) {

				if(book.get(j).getTitle().equalsIgnoreCase(bookTitle)) {

					//display the book details
					UI.println("--------------------------------");
					UI.println(book.get(j).display());	
					UI.println(authors.get(i).displayShort());
					UI.println("--------------------------------");

				}												
			}						
		}	
	}	




	public void issueBook() {
		// Issue a book to a patron.


		String user = UI.askString("Enter user name: ");
		String title = UI.askString("Enter book name: ");

		// space, enter - for the user to break the loop of adding books
		while(title != " ") {


			//loop through all of the authors
			for(Author a : authors) {

				for(Book b : a.getBooks()) {

					if(b.getTitle().equalsIgnoreCase(title)) {


						if(b.isCheckedOut()) {

							UI.println("This book is checked out by: " + b.getCheckedOutTo());

						}else{

							b.setCheckedOutTo(user);
							b.setCheckedOut(true);

						}

						title = UI.askString("Enter book name: ");

					}	
				}						
			}	
		}
	}

	public static void main(String[] args) {
		new UserInterface();
	}
}
