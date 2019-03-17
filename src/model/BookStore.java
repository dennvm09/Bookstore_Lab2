package model;
import queue_Linny.LinnyQueue;

import com.sun.org.apache.bcel.internal.generic.NEW;

import list_Linny.*;

public class BookStore {
	
	private String name;
	private LinnyQueue<Customer> queueInitial;
	private LinnyList<Cashier> cashier;
	private LinnyList<Shelves> shelves;
	
	public BookStore(String name) {
		this.name = name;
		queueInitial = new LinnyQueue<>();
		shelves = new LinnyList<>();
		cashier = new LinnyList<>();
	}
	
	public String getName() {
		
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LinnyQueue<Customer> getQueueInitial() {
		return queueInitial;
	}

	public void setQueueInitial(LinnyQueue<Customer> queueInitial) {
		this.queueInitial = queueInitial;
	}

	public LinnyList<Cashier> getCashier() {
		return cashier;
	}

	public void setCashier(LinnyList<Cashier> cashier) {
		this.cashier = cashier;
	}

	public LinnyList<Shelves> getShelves() {
		return shelves;
	}

	public void setShelves(LinnyList<Shelves> shelves) {
		this.shelves = shelves;
	}

	public void organizedIsbn() {
		
		LinnyQueue<Customer> queue = queueInitial;
//		Shelves g = new Shelves('A');
//		Shelves f = new Shelves('B');
//		
//		shelves.linnyAdd(g);
//		shelves.linnyAdd(f);
//		
//		
//		Customer x = new Customer("84784");
//		Customer a = new Customer("847994");
//		Customer w = new Customer("847674");
//		Customer k = new Customer("847564");
//		Customer o = new Customer("84734");
//		x.getListISBN().linnyAdd(19);
//		a.getListISBN().linnyAdd(19);
//		a.getListISBN().linnyAdd(15);
//		w.getListISBN().linnyAdd(15);
//		w.getListISBN().linnyAdd(19);
//		w.getListISBN().linnyAdd(68);
//		k.getListISBN().linnyAdd(19);
//		o.getListISBN().linnyAdd(75);
//		
//		
//		queue.linnyOffer(x);
//		queue.linnyOffer(a);
//		queue.linnyOffer(w);
//		queue.linnyOffer(k);
//		queue.linnyOffer(o);
//		
//		
//		Book n = new Book (19, 2, 234.756, 'A');
//		Book p = new Book (17, 1, 234.756, 'B');
//		Book r = new Book (68, 4, 234.756, 'A');
//		
//		Book t = new Book (85, 2, 234.756, 'B');
//		Book y = new Book (15, 1, 234.756, 'B');
//		Book u = new Book (75, 4, 234.75, 'A');
//		
//		//System.out.println(shelves.linnyGet(0).getBooks().isEmpty());
//		shelves.linnyGet(0).getBooks().insert(n.getIsbn(), n);
//		
//		shelves.linnyGet(1).getBooks().insert(p.getIsbn(), p);
//		shelves.linnyGet(0).getBooks().insert(r.getIsbn(), r);
//		
//		shelves.linnyGet(1).getBooks().insert(t.getIsbn(), t);
//		shelves.linnyGet(1).getBooks().insert(y.getIsbn(), y);
//		shelves.linnyGet(0).getBooks().insert(u.getIsbn(), u);
		
		
		while(queue.isEmpty() == false) {
			Customer user = queue.linnyPoll();
			int listIsbnSize = user.getListISBN().getTamanio();
			int shelvesSize = shelves.getTamanio();
			
			int i = 0;
			while(i < shelvesSize) {
				int j = 0;
				while ( j < listIsbnSize ) {
					
					if(shelves.linnyGet(i).getBooks().contains(user.getListISBN().linnyGet(j))) {
						System.out.println("Hola");
						 
						Book find = shelves.linnyGet(i).getBooks().search(user.getListISBN().linnyGet(j)).getValue();
						System.out.println(find.getShelves());
						
						if(find.getQuantity() > 0) {
							user.getListFinal().linnyAdd(find);
							System.out.println(user.getListFinal().linnyGet(0).getIsbn());
							System.out.println(find.getQuantity());
							find.setQuantity(find.getQuantity() - 1 );
							user.setTimeTotal(user.getTimeTotal() + user.getListFinal().getTamanio());
						}
					}
					j++;
				}
				i++;
			}			
		}	
	}
	
	public static void main(String[] args) {
		
		BookStore s = new BookStore("Tienda");
		s.organizedIsbn();
		
		
	}

}
