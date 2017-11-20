package net.mrpaul.apcs.PB050.ps06;
/**
 * BookAndPatronTest.java
 * Tests methods and data from both the book and patron classes
 * @author Sarthak Bhatnagar
 * APCS PS06: Cartesian
 * 10/13/17
 *
 */
public class BookAndPatronTest {
	public static void main(String[] args){
		//Declare book objects
		Book book1 = new Book("Harry Potter");
		Book book2 = new Book("The Hobbit");
		Book book3 = new Book("Ender's Game");

		boolean borrowed, returned;
		
		//Declare patron object
		Patron patron1 = new Patron(null, null, null);
		
		//Set authors of books
		book1.setAuthor("J.K. Rowling");
		book2.setAuthor("J.R.R. Tolkien");
		book3.setAuthor("Orson Scott Card");
		
		//Borrow three books
		borrowed = patron1.borrowBook(book1);
		if(borrowed) {
			System.out.println("Patron has borrowed " + book1.toString());
		}
		borrowed = patron1.borrowBook(book2);
		if(borrowed) {
			System.out.println("Patron has borrowed " + book2.toString());
		}
		borrowed = patron1.borrowBook(book3);
		if(borrowed) {
			System.out.println("Patron has borrowed " + book3.toString());
		}
		
		//Return a book
		returned = patron1.returnBook(book2);
		if(returned) {
			System.out.println("\nPatron has returned " + book2.toString());
		}
		
		//Show what books patron has
		System.out.println("\n" + patron1.toString());

	}
}
