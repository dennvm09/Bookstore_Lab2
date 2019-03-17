package hash_Linny;
import list_Linny.LinnyList;

public class HashTableLinny<M, T> implements IHashTable<M, T> {

	public final static int SIZE = 3000;
	public int busy;
	public ItemLinny<M,T>[] table;
	public M[] keys;
	
	public HashTableLinny() {
		keys = (M[]) new Object[SIZE];
		table = new ItemLinny[SIZE];
		busy = 1;
		
	}
	
	@Override
	public void insert(M key, T element) {
		// TODO Auto-generated method stub
		
		int k = getSlot(key);
		
		ItemLinny<M, T> newItem = new ItemLinny<M, T>(key, element);
		int i = k;
		int h = 0;
		do {
			
			if(keys[i] == null) {
				keys[i] = key;
				table[i] = newItem;
				busy++;
			}
			
			if(keys[i] == key) {
				table[i] = newItem;
			}
			i = (i+h*h++)%SIZE;
		}while(i != k);
	}

	@Override
	public void remove(M key, T element) {
		// TODO Auto-generated method stub
		if(!contains(key)) {
			return;
		}
		
		int i = getSlot(key);
		int h = 1;
		
		while(key != keys[i]) {
			i = (i+h*h++)%SIZE;
		}
		
		keys[i] = null;
		table[i] = null;
		
		for ( i = (i+h*h++)%SIZE; keys[i] != null; i = (i+h*h++)%SIZE) {
			
			M tmp = keys[i];
			ItemLinny<M, T> temp = table[i];
			keys[i] = null;
			table[i] = null;
			busy--;
			insert(tmp, element);
		}
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return busy == 0;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return SIZE;
	}

	@Override
	public ItemLinny<M, T> search(M key) {
		// TODO Auto-generated method stub
		int i = getSlot(key);
		int h = 1;
		ItemLinny<M, T> actual = null;
		
		while(keys[i] != null) {
			if(keys[i] == key) {
				actual = table[i];
				
			i = (i + h * h++) % SIZE;
			}
		}
		return actual;
	}

	@Override
	public int getSlot(M key) {
		// TODO Auto-generated method stub
		int val = key.hashCode() % SIZE;
		if(val < 0) {
			val = val * -1;
		}
		return val;
	}

	@Override
	public boolean contains(M key) {
		// TODO Auto-generated method stub
		return search(key) != null;
	}

//	public static void main(String[] args) {
//		
//		HashTableLinny<Integer, Number> m = new HashTableLinny<>();
//		
//		m.insert(980, 76);
//		m.insert(987, 86);
//		m.insert(98, 99);
//		m.insert(980, 99);
//		m.insert(9, 8);
//		System.out.println(m.isEmpty());
//		System.out.println(m.contains(86));
//		System.out.println(m.search(86));
//		System.out.println(m.contains(89));
//		System.out.println(m.search(89));
//		System.out.println(m.contains(76));
//		System.out.println(m.search(86));
//		m.remove(980, 76);
//		System.out.println(m.contains(76));
//		System.out.println(m.contains(99));
//		System.out.println(m.contains(99));
//		System.out.println(m.size());
//		
//	
//	}

}
