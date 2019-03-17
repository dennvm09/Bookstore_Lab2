package model;

import stack_Linny.LinnyStack;
import heap_linny.*;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import list_Linny.*; 

public class Customer {

	private LinnyStack<Book> shoppingCart;
	private LinnyList<Integer> listISBN;
	private LinnyList<Book> listFinal;
	private int timeTotal;
	
	private String userId;
	
	public Customer(String userId) {
		this.userId = userId;
		listFinal = new LinnyList<>();
		listISBN = new LinnyList<>();
		shoppingCart = new LinnyStack<>();
		
		
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
	
	public int getTimeTotal() {
		return timeTotal;
	}

	public void setTimeTotal(int timeTotal) {
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

	public void bestTour () {
		
		listFinal.linnyAdd(new Book (1985, 2, 234.756, 'A'));
		listFinal.linnyAdd(new Book (195, 4, 24.756, 'B'));
		listFinal.linnyAdd(new Book (1986, 4, 234.756, 'B'));
		listFinal.linnyAdd(new Book (185, 3, 234.756, 'C'));
		listFinal.linnyAdd(new Book (85, 4, 234.756, 'A'));
		System.out.println(listFinal.getTamanio());
		
		HeapLinny<Integer, Book> aux = new HeapLinny<>(listFinal.getTamanio());
		
		for (int i = 0; i < listFinal.getTamanio(); i++) {
			aux.insertMin((int) listFinal.linnyGet(i).getShelves(), listFinal.linnyGet(i));
			
		}
				
		LinnyList<Book> auxL = new LinnyList<>();
		
		for (int i = 0; i < listFinal.getTamanio(); i++) {
			auxL.linnyAdd(aux.max());
			aux.removeMax();
			System.out.println(auxL.linnyGet(i).getShelves());
		}
		
		listFinal = auxL;
		setTimeTotal(timeTotal+listFinal.getTamanio());
		

	}
	
	public void collectBooks() {
		
		for (int i = 0; i < listFinal.getTamanio(); i++) {
			shoppingCart.linnyPush(listFinal.linnyGet(i));
			System.out.println(listFinal.linnyGet(i).getShelves());
		}
		
	}

	public static void main(String[] args) {
		Customer m = new Customer("1238875f");
		
		m.bestTour();
		System.out.println("collection");
		m.collectBooks();
		System.out.println("hola");
		System.out.println((int)'a');
	}
	
	
	
}
