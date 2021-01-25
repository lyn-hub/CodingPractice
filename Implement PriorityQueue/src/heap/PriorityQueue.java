package heap;

import java.util.Arrays;


public class PriorityQueue {
	//Fields
	//For easy to test, I set the fields are public.
	public int[] array;
	public int size;	
	private static final int[] DEFAULT_ARRAY = new int[16];	
	
	// Constructors	
	public PriorityQueue(int[] array) {
		if (array == null || array.length == 0) {
			throw new IllegalArgumentException("input array can not be null or empty");
		}
		this.array = array;
		size = array.length;
		heapify();
	}
	public PriorityQueue (int cap) {
		if (cap <= 0) {
			throw new IllegalArgumentException("capacity can not be <= 0");
		}
		array = new int[cap];
		size = 0;
	}
	public PriorityQueue() {
		this.array = DEFAULT_ARRAY;
		this.size = 0;
	}
	
	//Methods
	private void heapify() {
		for (int i = size / 2 - 1; i >= 0; i--) {
			percolateDown(i);
		}
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	
	private void percolateUp(int index) {
		while(index > 0) {
			int parentIndex = (index - 1) /2;
			if (array[parentIndex] > array[index]) {
				swap(array, parentIndex, index); 
			} else {
				break;
			}
			index = parentIndex;
		}
	}
	
	private void percolateDown(int index) {
		// check if index is legal?(The last legal one is the last leaf node's parent)
		while(index <= size / 2 - 1) {
			int leftChildIndex = index * 2 + 1;
			int rightChildIndex = index * 2 + 2;
			//find the smaller one between leftChild and rightChild, if the rightChild exists
			int swapCandidate = leftChildIndex;
			if (rightChildIndex <= size - 1 && array[leftChildIndex] >= array[rightChildIndex]) {
				swapCandidate = rightChildIndex;
			}
			//swap if necessary
			if (array[index] > array[swapCandidate]) {
				swap(array, index, swapCandidate);
			} else {
				break;
			}
			index = swapCandidate;
		}
		
	}
	
	private void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	
	public Integer peek() {
		if (size == 0) {
			return null;
		}
		return array[0];
	}
	
	public Integer poll() {
		if (size == 0) {
			return null;
		}
		int result = array[0];
		array[0] = array[size - 1];
		size--;
		percolateDown(0);
		return result;
	}
	
	public void offer (int element) {
		if (size == array.length) {
			array = Arrays.copyOf(array, (int)(1.5 * array.length));
		}
		array[size] = element;
		size++;
		percolateUp(size - 1);
	}	
	

}
