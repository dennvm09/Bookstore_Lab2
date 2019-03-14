package model;
import queue_Linny.LinnyQueue;
import list_Linny.*;

public class BookStore {
	
	private String name;
	private LinnyQueue<Customer> queueInitial;
	private LinnyList<Shelves> shelves;
	
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

	public BookStore(String name) {
		this.name = name;
	}
	
	public void organizedIsbn() {
		
		LinnyQueue<Customer> queue = queueInitial;
		
		while(queue.isEmpty() == false) {
			Customer user = queue.linnyPeek();
			int z = user.getListISBN().getTamanio();
			int v = shelves.getTamanio();
			
			for (int i = 0; i < v; i++) {
				if(shelves.linnyGet(i) != null) {
					
					for (int j = 0; j < z; j++) {
						if(shelves.linnyGet(i).getBooks().contains(user.getListISBN().linnyGet(i))) {
							//shelves.linnyGet(i).getBooks().search(user.getListISBN().linnyGet(i));
							//retorna el book
							user.getListFinal().linnyAdd(shelves.linnyGet(i).getBooks().search(user.getListISBN().linnyGet(i)).getValue());
						}
					}
				}
			}
			
		}
		
		
	}

}
