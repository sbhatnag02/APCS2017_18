package net.mrpaul.apcs.PB050.ps06;
/**
 * Patron.java
 * Holds attributes of library patron -- what books have been borrowed
 * @author Sarthak Bhatnagar
 * APCS PS06: Cartesian
 * 10/13/17
 *
 */
public class Patron {
	//Instance variables
	Book book1 = null;
	Book book2 = null;
	Book book3 = null;
	/**
	 * No arg constructor
	 */
	public Patron(){
		
	}
	/**
	 * Patron constructor that passes in three book objects
	 * @param book1
	 * @param book2
	 * @param book3
	 */
	public Patron(Book book1, Book book2, Book book3) {
		this.book1 = book1;
		this.book2 = book2;
		this.book3 = book3;
	}
	
	//set book that was passed in to a empty book, otherwise return false
	public boolean borrowBook(Book book){
		if(book1 == null){
			book1 = book;
			return true;
		}else if(book2 == null){
			book2 = book;
			return true;
		}else if(book3 == null){
			book3 = book;
			return true;
		}else{
			return false;
		}
	}
	//set book that matches book that was passed int, if cannot find book that matches
	//return false
	public boolean returnBook(Book book){
		if(book1.title.equals(book.title)){
			book1 = null;
			return true;
		}else if(book2.title.equals(book.title)){
			book2 = null;
			return true;
		}else if(book3.title.equals(book.title)){
			book3 = null;
			return true;
		}else{
			return false;
		}
	}
	/**
	 * Expresses patron object as string, showing what books have been borrowed
	 */
	public String toString(){
		String string = "This person has ";
		if(book1 != null){
			string+=book1.toString();
		}
		if(book2 != null){
			string+=", " + book2.toString();
		}
		if(book3 != null){
			string+=", " + book3.toString();
		}
		return string;
	}
}
