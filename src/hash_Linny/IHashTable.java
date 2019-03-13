package hash_Linny;

public interface IHashTable<T> {

	
	public int hashFunction(int key);
	public boolean isEmpty();
	public int size();
	public void insert(T element, int key);
	public void remove(T element, int key);
	public T getElement(int key);
	
}
