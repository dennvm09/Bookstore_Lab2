package model;

import stack_Linny.LinnyStack;

public class Customer {

	private LinnyStack<Book> shoppingCart;
	private String userName;
	
	public Customer(String userName) {
		this.userName = userName;
		
	}
}
