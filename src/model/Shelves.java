package model;
import hash_Linny.HashTableLinny;;

public class Shelves {

	private char shelvesI;
	private HashTableLinny<Integer, Book> books;
	
	public Shelves(char shelvesI) {
	  this.shelvesI = shelvesI;
	  books = new HashTableLinny<>();
	}

	public char getShelvesI() {
		return shelvesI;
	}
	public void setShelvesI(char shelvesI) {
		this.shelvesI = shelvesI;
	}

	public HashTableLinny<Integer, Book> getBooks() {
		return books;
	}
	public void setBooks(HashTableLinny<Integer, Book> books) {
		this.books = books;
	}
	
	
	
}
