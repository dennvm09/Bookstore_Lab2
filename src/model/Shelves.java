package model;
import hash_Linny.HashTableLinny;;

public class Shelves {

	private char shelvesI;
	private HashTableLinny<Book, Integer> books;
	
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

	public HashTableLinny<Book, Integer> getBooks() {
		return books;
	}
	public void setBooks(HashTableLinny<Book, Integer> books) {
		this.books = books;
	}
	
	
	
}
