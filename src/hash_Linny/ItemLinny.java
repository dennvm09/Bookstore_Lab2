package hash_Linny;

public class ItemLinny<T,M> {

	private M key;
	private T value;
	private ItemLinny<T,M> next;
	private ItemLinny<T,M> previous;
	
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
	public ItemLinny<T, M> getNext() {
		return next;
	}
	public void setNext(ItemLinny<T, M> next) {
		this.next = next;
	}
	public ItemLinny<T, M> getPrevious() {
		return previous;
	}
	public void setPrevious(ItemLinny<T, M> previous) {
		this.previous = previous;
	}
	
	
	
}
