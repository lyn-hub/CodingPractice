In this project, we are going to implement a minHeap class.
To be a class, we need to define the fileds, constructors, and methods.
Fields: 
int[] array; size; DEFAULT_ARRAY

Constructors: we defined three constructors.
public PriorityQueue(int[] array) {}: heapify the input array to a minHeap.
public PriorityQueue(int cap) {}: creat a minHeap with the capacity is cap.
public PriorityQueue() {}: creat a minHeap with a default array.

Methods(APIs):
int size(): return the number of elements in the heap.
boolean isEmpty(): return true if and only if the heap has 0 element
int peek(): retrieves, but does not remove, the head of this heap, or returns null if this heap is empty.
int poll(): retrieves and removes the head of this heap, or returns null if this heap is empty.
void offer(int): add the given int value into the heap. Note we need to resize the heap (i.e., to increase the capacity of the heap) if it’s full.

How to test:
Run the test.main