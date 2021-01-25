package heap;



public class Test {
	public static void main (String[] args) {
		
		int[] array = new int[] {2,15,4,28,17,9,6,11,3};
		System.out.println("This is the input array:");
		for (int i : array) {
			System.out.print(i + " ");
		}
		System.out.println();
		System.out.println();
		
		PriorityQueue m1 = new PriorityQueue(array);		
		System.out.println("This is the minHeap we want:");
		for (int i : m1.array) {
			System.out.print(i + " ");
		}
		System.out.println();
		System.out.println();
		
		m1.offer(10);
		System.out.println("Offer a 10 to this heap:");
		for (int i = 0; i < m1.array.length; i++) {
			System.out.print(m1.array[i] + " ");
		}
		System.out.println();
		System.out.println();
		
		System.out.println("Peek the head:  " + m1.peek());		
		System.out.println();
		
		System.out.println("Poll the head:  " + m1.poll());		
		System.out.println();
		
		System.out.println("Check if the heap is empty?  " + m1.isEmpty());
		System.out.println("What's the size?  " + m1.size());
		System.out.println();
		
		for (int i = 0; i < array.length; i++) {
			m1.poll() ;
		}
		System.out.println("Poll all the elments out, is the heap empty?  " + m1.isEmpty());
		System.out.println("What can we get if we still call the poll():  " +m1.poll());
		System.out.println("What can we get if we still call the peek():  " +m1.peek());
		System.out.println();
		
		System.out.println("Call the second constructor, int cap = 5:");
		PriorityQueue m2 = new PriorityQueue(5);
		for (int i : m2.array) {
			System.out.print(m2.array[i] + " ");
		}
		System.out.println();
		System.out.println("the size of the defaulf m2:  " + m2.size());
		System.out.println();
		
		System.out.println("Call the default constructor:");
		PriorityQueue m3 = new PriorityQueue();
		for (int i : m3.array) {
			System.out.print(m2.array[i] + " ");
		}
		System.out.println();
		System.out.println("the size of the defaulf m3:  " + m3.size());
		System.out.println();
		
	}

}
