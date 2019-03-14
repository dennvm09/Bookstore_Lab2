package hash_Linny;

public interface IHashTable<T,M> {

	public void insert(T element, M key);
	public void remove(T element, M key);
	public boolean isEmpty();
	public int size();
	public ItemLinny<T,M> search(M key);
	public int getSlot(M key);
	public boolean contains(M key);
	
}
