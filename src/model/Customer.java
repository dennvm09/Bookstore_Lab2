package model;

import stack_Linny.LinnyStack;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import list_Linny.*; 

public class Customer {

	private LinnyStack<Book> shoppingCart;
	private LinnyList<Integer> listISBN;
	private LinnyList<Book> listFinal;
	private long timeTotal;
	
	private String userId;
	
	public Customer(String userId) {
		this.userId = userId;
		
	}

	public LinnyStack<Book> getShoppingCart() {
		return shoppingCart;
	}
	public void setShoppingCart(LinnyStack<Book> shoppingCart) {
		this.shoppingCart = shoppingCart;
	}

	public LinnyList<Integer> getListISBN() {
		return listISBN;
	}
	public void setListISBN(LinnyList<Integer> listISBN) {
		this.listISBN = listISBN;
	}
	
	public long getTimeTotal() {
		return timeTotal;
	}

	public void setTimeTotal(long timeTotal) {
		this.timeTotal = timeTotal;
	}

	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public LinnyList<Book> getListFinal() {
		return listFinal;
	}

	public void setListFinal(LinnyList<Book> listFinal) {
		this.listFinal = listFinal;
	}

	public void meterEnElceto () {
		
//		listFinal.linnyAdd(new Book (1985, 4, 234.756, 'A'));
//		listFinal.linnyAdd(new Book (195, 4, 24.756, 'B'));
//		listFinal.linnyAdd(new Book (1986, 4, 234.756, 'A'));
//		listFinal.linnyAdd(new Book (185, 3, 234.756, 'C'));
//		listFinal.linnyAdd(new Book (85, 4, 234.756, 'B'));
		
		LinkedList<Book> listAux = new LinkedList<>();
		listAux.add(new Book (1985, 4, 234.756, 'A'));
		listAux.add(new Book (195, 4, 24.756, 'B'));
		listAux.add(new Book (1986, 4, 234.756, 'A'));
		listAux.add(new Book (185, 3, 234.756, 'C'));
		listAux.add(new Book (85, 4, 234.756, 'B'));
		
//		for (int i = 0; i < listFinal.size(); i++) {
//			if(listFinal.linnyGet(i) != null) {
//				listAux.add(listFinal.linnyGet(i));
//			}
//		}
			
			
			
			
			
			Collections.sort(listAux,new Comparator<Book>() {
				@Override
				public int compare(Book o1, Book o2) {
					return o1.getShelves() - o2.getShelves();
				}
				
			});
			
			for (int i = 0; i < listAux.size(); i++) {
				if(listAux.get(i) != null) {
					System.out.println(listAux.get(i).getShelves());
					System.out.println(listAux.get(i).getIsbn());
				}
				
			}
		
		
		
	}

	public static void main(String[] args) {
		Customer m = new Customer("1238875f");
		m.meterEnElceto();
	}
	
	
	
}
