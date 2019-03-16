package heap_linny;

public interface IHeap<M, T> {

	public int parent(int pos);
	public int leftChild(int pos);
	public int rigthChild(int pos);
	public boolean isLeaf(int pos);
	public void swap(int fpos, int spos);
	public void minHeapify(int index);
	public void maxHeapify(int index);
	public void insertMax(M priory, T element);
	public void maxHeap();
	public T removeMax();
	public T max();
	public int size();
	public void minHeap();
	public void insertMin(M priory, T element);
	public T removeMin();
	
}
