package net.mrpaul.apcs.PB050.ps06;
/**
 * Book.java
 * Holds attributes of book -- title, author, etc
 * @author Sarthak Bhatnagar
 * APCS PS06: Cartesian
 * 10/13/17
 *
 */
public class Book {
	String title = null;
	String author = null;
	/**
	 * Constructor for book object
	 * @param title Name of book (string)
	 * @param author Author of book (string)
	 */
	public Book(String title, String author){
		this.title=title;
		this.author = author;
	}
	/**
	 * No arg constructor. Sets instance variables to ""
	 */
	public Book() {
		this.title = "";
		this.author = "";
	}
	/**
	 * Constructor for book object
	 * @param title name of book (string)
	 */
	public Book(String title){
		this.title= title;
		this.author = "";
	}
	/**
	 * Gets title
	 * @return title as string
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * Sets name of the book
	 * @param title (string)
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * Returns the name of the author
	 * @return author as string
	 */
	public String getAuthor() {
		return author;
	}
	/**
	 * Set the author of the book
	 * @param author (string)
	 */
	public void setAuthor(String author) {
		this.author = author;
	}
	/**
	 * Expresses contents of book object into a string
	 */
	public String toString(){
		return title + " by " + author;
	}
}
