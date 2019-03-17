package hash_Linny;

public interface IHashTable<M, T> {

	public void insert(M key, T element);
	public void remove(M key, T element);
	public boolean isEmpty();
	public int size();
	public ItemLinny<M, T> search(M key);
	public int getSlot(M key);
	public boolean contains(M key);
	
}
