package heap_linny;


import hash_Linny.ItemLinny;

public class HeapLinny< M,T> implements IHeap<M,T> {
	
	public static final int FRONT = 1;
	private ItemLinny<M, T>[] heap;	
	private int sizeM;
	private int maxSize;
	
	public HeapLinny(int maxSize) {
	
		this.maxSize =  maxSize;
		this.sizeM = 0;
		heap = new ItemLinny[(maxSize+1)];
		
	}

	@Override
	public int parent(int pos) {
		
		return pos/2;
	}

	@Override
	public int leftChild(int pos) {
		
		return 2*pos;
	}

	@Override
	public int rigthChild(int pos) {
		
		return (2*pos)+1;
	}

	@Override
	public boolean isLeaf(int pos) {
		
		if(pos >= (sizeM/2)&& pos<= sizeM) {
			return true;
		}
		return false;
	}

	@Override
	public void swap(int fpos, int spos) {
		ItemLinny<M,T> temp = heap[fpos];
		heap[fpos] = heap[spos];
		heap[spos] = temp;
		
	}

	@Override
	public void minHeapify(int index) {
		
		while(hasLeftChild(index)) {
			
			int largest = leftChild(index);
			
			if(hasRigthChild(index) && heap[leftChild(index)].getPriority() < heap[rigthChild(index)].getPriority() ) {
				largest = rigthChild(index);
			}
			if(heap[index].getPriority() < heap[largest].getPriority()) {
				swap(index, largest);
				minHeapify(largest);
			}
			else break;
		}
		
	}

	@Override
	public void maxHeapify(int index) {
		while(hasLeftChild(index)) {
			
			int smallest = leftChild(index);
			
			if(hasRigthChild(index)&& heap[leftChild(index)].getPriority() > heap[rigthChild(index)].getPriority()) {
				smallest = rigthChild(index);
			}
			if(heap[index].getPriority() > heap[smallest].getPriority()) {
				swap(index, smallest);
				maxHeapify(smallest);
			}
			else break;
			
		}
		
	}

	@Override
	public void insertMax(M priory, T element) {		
		ItemLinny<M, T> add = new ItemLinny<M, T>(priory, element);
		setSizeM(sizeM+1);
		
		heap[sizeM] = add;
		
		maxHeap();
	}

	@Override
	public void maxHeap() {
		
		int index = sizeM;
		
		while(parent(index) != 0 && (heap[parent(index)].getPriority() < heap[index].getPriority()))  {
			
			swap(index, parent(index));
			index = parent(index);
			
		}
	}

	@Override
	public T removeMax() {
		
		ItemLinny<M, T> remove = heap[FRONT];
		heap[FRONT] = heap[sizeM];
		heap[sizeM] = null;
		setSizeM(sizeM-1);
		//minHeapify(FRONT);
		maxHeapify(FRONT);
		return remove.getValue();
	}

	@Override
	public T max() {
		return heap[FRONT].getValue();
	}

	@Override
	public int size() {
		return sizeM;
	}
	
	public void setSizeM(int sizeM) {
		this.sizeM = sizeM;
	}
	
	public int getSizeM() {
		return sizeM;
	}

	@Override
	public void minHeap() {
		
		int index = sizeM;
		
		while(parent(index) != 0 && (heap[parent(index)].getPriority() > heap[index].getPriority()))  {
			
			swap(index, parent(index));
			index = parent(index);
			
		}
	}

	@Override
	public void insertMin(M priory, T element) {
		ItemLinny<M, T> add = new ItemLinny<M, T>(priory, element);
		setSizeM(sizeM+1);
		
		heap[sizeM] = add;
		minHeap();
		
	}

	@Override
	public T removeMin() {
		
		ItemLinny<M, T> remove = heap[FRONT];
		heap[FRONT] = heap[sizeM];
		heap[sizeM] = null;
		setSizeM(sizeM-1);
		//maxHeapify(FRONT);
		minHeapify(FRONT);
		return remove.getValue();
	}
	
	private boolean hasLeftChild(int i) {
		return leftChild(i) <= sizeM;
	}
	
	private boolean hasRigthChild(int i) {
		return rigthChild(i) <= sizeM;
	}


	
	

}
