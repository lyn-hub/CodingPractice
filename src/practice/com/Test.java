package practice.com;

import java.util.*;

public class Test {
	
	public static final class TreeNode{
		int key;
		TreeNode left;
		TreeNode right;
		public TreeNode(int key) {
			this.key = key;
		}
	}
	static final class ListNode {
		int value;
		ListNode next;
		public ListNode(int value) {
			this.value = value;
		}
	}
	public static void main(String[] args) {
        
		
		//string convert to int
//		int r = Integer.parseInt("200");
//		//string concatenation operator
//		String s = "200" + 100;    //s = "200100"
//		//int convert to string
//		String st = String.valueOf(200);
//		
//		List<String> list = Arrays.asList("hot","dot","dog","lot","log","cog");	
//		
		TreeNode n1 = new TreeNode(5);
		TreeNode n2 = new TreeNode(3);
		TreeNode n3 = new TreeNode(8);
		TreeNode n4 = new TreeNode(1);
		TreeNode n5 = new TreeNode(4);
		TreeNode n6 = new TreeNode(11);
//		TreeNode n7 = new TreeNode(7);
		n1.left =  n2;
		n1.right = n3;
		n2.left = n4;
		n2.right = n5;
	//	n3.left = n6;
		n3.right = n6;
		
//		List<String> list1 = new ArrayList<>();
//		list1.add("a");
//		list1.add("b");
//		String[] r1= list1.toArray(new String[0]);
//		System.out.print(r1);
		
		/*
		ListNode n1 = new ListNode(5);
		ListNode n2 = new ListNode(3);
		ListNode n3 = new ListNode(2);
		ListNode n4 = new ListNode(6);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		ListNode head = n1;
		*/
		
		/*
		PriorityQueue<TreeNode> minHeap = new PriorityQueue<>(new Comparator<TreeNode>() {
			public int compare (TreeNode e1, TreeNode e2) {
				return e2.key - e1.key;
			}
		});
		minHeap.offer(n1);
		minHeap.offer(n2);
		minHeap.offer(n3);
		minHeap.offer(n4);
		
		
	//	String[] input = new String[] {"wrt","wrf","er","ett","rftt"};
		char[][] gym = { { ' ', 'E', ' ' },

				  {  ' ', ' ',  ' ' },

				  {  ' ',  ' ', ' ' } };
	//	int[] a = new int[] {4,3,3,1,5}; 
	//	int[] b = new int[] {3,4,2};
	//	int k = 4;
        int[][] matrix = new int[][] {{0,0},{0,1},{1,2},{2,1}};
        */
		
		
//	//	int[][] pre = {{3,1},{2,0},{1,2},{0,3}};
//	//	String sh = "x2y0i0z3";
//	//	String lo = "code";
//	//	String target = "o ffer";
//	//	double[][] matrix = new double[][] { {2,-1,0.5,1,-3},{0,-2,-1,2,0.1},{3,0.2,1,-3,-2}};
		
		Test solution = new Test();
		List<Integer> result = solution.zigZag(n1);
		System.out.println(result);
//	//	}
		
 }

	
	public List<Integer> zigZag(TreeNode root) {
	    // Write your solution here
	    List<Integer> result = new ArrayList<>();
	    if (root == null) {
	      return result;
	    }
	    Deque<TreeNode> deque = new ArrayDeque<>();
	    deque.offerFirst(root);
	    int count = 0;
	    while (!deque.isEmpty()) {
	      int size = deque.size();
	      for (int i = 0; i < size; i++) {
	        if (count / 2 == 0) {
	          //poll out
	          TreeNode cur = deque.pollLast();
	          result.add(cur.key);
	          //offer
	         if (cur.right != null) {
	            deque.offerFirst(cur.right);
	         }
	          if (cur.left != null) {
	           deque.offerFirst(cur.left);
	         }        
	       } else {
	         //poll out 
	          TreeNode cur = deque.pollFirst();
	          result.add(cur.key);
	          //offer
	          if (cur.left != null) {
	            deque.offerLast(cur.left);
	          }
	          if (cur.right != null) {
	            deque.offerLast(cur.right);
	         }
	        }
	      }
	       count++;
	    }
	    return result;
	  }
}

	
 

		  
		 



