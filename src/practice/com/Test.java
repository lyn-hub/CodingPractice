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
        
//		String s1 = "1";
//		String s2 = "2";
//		String s3 = s1 + s2;
//		StringBuilder  sb1 = new StringBuilder(s3);
//	
			
		//string convert to int
//		int r = Integer.parseInt("200");
//		//string concatenation operator
//		String s = "200" + 100;    //s = "200100"
//		//int convert to string
//		String st = String.valueOf(200);
//		
//		List<String> list = Arrays.asList("hot","dot","dog","lot","log","cog");	
//		
//		TreeNode n1 = new TreeNode(5);
//		TreeNode n2 = new TreeNode(3);
//		TreeNode n3 = new TreeNode(8);
//		TreeNode n4 = new TreeNode(1);
//		TreeNode n5 = new TreeNode(4);
//		TreeNode n6 = new TreeNode(11);
////		TreeNode n7 = new TreeNode(7);
//		n1.left =  n2;
//		n1.right = n3;
//		n2.left = n4;
//		n2.right = n5;
//	//	n3.left = n6;
//		n3.right = n6;
		
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
		
		
//		PriorityQueue<TreeNode> minHeap = new PriorityQueue<>(new Comparator<TreeNode>() {
//			public int compare (TreeNode e1, TreeNode e2) {
//				return e2.key - e1.key;
//			}
//		});
//		minHeap.offer(n1);
//		minHeap.offer(n2);
//		minHeap.offer(n3);
//		minHeap.offer(n4);
//		
//		
//	//	String[] input = new String[] {"wrt","wrf","er","ett","rftt"};
//		char[][] gym = { { ' ', 'E', ' ' },
//
//				  {  ' ', ' ',  ' ' },
//
//				  {  ' ',  ' ', ' ' } };
		double[] a = new double[] {4,-2,-3,-2,3,-1,-2,6}; 
		int[] b = new int[] {4,1,3,2};
	//	int k = 4;
    //  int[][] matrix = new int[][] {{0,0},{0,1},{1,2},{2,1}};
        
		
		
//	//	int[][] pre = {{3,1},{2,0},{1,2},{0,3}};
//	//	String sh = "x2y0i0z3";
//	//	String lo = "code";
//	//	String target = "o ffer";
//	//	double[][] matrix = new double[][] { {2,-1,0.5,1,-3},{0,-2,-1,2,0.1},{3,0.2,1,-3,-2}};
		
		Test solution = new Test();
		int result = solution.minCost(b);
		System.out.println(result);
//	//	}
		
 }

	
	
	public int minCost(int[] stones) {
		// Write your solution here
		int[][] M = new int[stones.length][stones.length];
    for (int j = 0; j < M.length; j++) {
      for (int i = j; i >= 0; i--) {
        if (i == j) {
          M[i][j] = 0;
        } else if (i + 1 == j) {
          M[i][j] = stones[i] + stones[j];
        } else {
          M[i][j] = Integer.MAX_VALUE;
          for (int k = i + 1; k <= j; k++) {
            int cost1 = M[i][k - 1] + M[k][j];
            int temp1 = M[i][k - 1] == 0? stones[i] : M[i][k - 1];
            int temp2 = M[k][j] == 0 ? stones[j] : M[k][j];
            int cost2 = temp1 + temp2;
            M[i][j] = Math.min(M[i][j], cost1 + cost2);
          }
        }
      }
    }  
		return M[0][M.length - 1];
	}
}

	
 

		  
		 



