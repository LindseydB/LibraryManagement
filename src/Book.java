import java.util.ArrayList;

import ecs100.UI;

public class Book {
	
	private String title;
	private int date;
	
	private String checkedOutTo;
	private boolean checkedOut;

	
	//Constructor
	
	public Book(String title, int date) {
		super();
		this.title = title;
		this.date = date;
		this.checkedOut = false;
		this.checkedOutTo = "";
		
	}

	
	
	//Methods
	
	
	public String display() {
		
		
		return "Book: " + title + " " + date;

	
	}

	

	//Getters and Setters

	public String getTitle() {
		return title;
	}




	public void setTitle(String title) {
		this.title = title;
	}




	public int getDate() {
		return date;
	}




	public void setDate(int date) {
		this.date = date;
	}
	
	

// Getters and Setters for checking out a book

	public String getCheckedOutTo() {
		return checkedOutTo;
	}



	public void setCheckedOutTo(String checkedOutTo) {
		this.checkedOutTo = checkedOutTo;
	}



	public boolean isCheckedOut() {
		return checkedOut;
	}



	public void setCheckedOut(boolean checkedOut) {
		this.checkedOut = checkedOut;
	}


}
