package model;

import java.util.Comparator;

public class Book {
	
	private int isbn;
	private int quantity;
	private double price;
	private char shelves;
	
	public Book(int isbn, int quantity,double price, char shelves) {
		
		this.isbn = isbn;
		this.quantity = quantity;
		this.price = price;
		this.shelves = shelves;
		
	}

	
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}

	public int getIsbn() {
		return isbn;
	}
	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}

	public char getShelves() {
		return shelves;
	}
	public void setShelves(char shelves) {
		this.shelves = shelves;
	}

	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	

}
