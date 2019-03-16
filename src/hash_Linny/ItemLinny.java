package hash_Linny;

public class ItemLinny<M, T> {

	private M key;
	private T value;
	private ItemLinny<M, T> next;
	private ItemLinny<M, T> previous;
	private int priority;
	
	public ItemLinny(M key, T value) {
		this.key = key;
		this.value = value;
		next = null;
		previous = null;
	}
	
	public M getKey() {
		return key;
	}
	public void setKey(M key) {
		this.key = key;
	}
	public T getValue() {
		return value;
	}
	public void setValue(T value) {
		this.value = value;
	}
	public ItemLinny<M, T> getNext() {
		return next;
	}
	public void setNext(ItemLinny<M, T> next) {
		this.next = next;
	}
	public ItemLinny<M, T> getPrevious() {
		return previous;
	}
	public void setPrevious(ItemLinny<M,T> previous) {
		this.previous = previous;
	}
	
	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}
	
}
