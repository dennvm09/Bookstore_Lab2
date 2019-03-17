package model;
import stack_Linny.LinnyStack;;


public class Cashier {

	private double cost;
	LinnyStack<Book> bagBooks;
	
	public Cashier() {
		cost = 0;
		bagBooks = new LinnyStack<>();
	}
	
	public LinnyStack<Book> getBagBooks() {
		return bagBooks;
	}

	public void setBagBooks(LinnyStack<Book> bagBooks) {
		this.bagBooks = bagBooks;
	}

	public double calculeCost(Customer user, LinnyStack<Book> userBook) {
		double cost = 0;
		
		for (int i = 0; i < userBook.linnySize(); i++) {
			cost += userBook.linnyPeek().getPrice();
			bagBooks.linnyPush(userBook.linnyPop());
		}
		
		return cost;
	}
	
	
}
