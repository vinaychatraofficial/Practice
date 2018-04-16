package bst;

import trees.Node;

public class ArrayBST {
	static int arr[] = {1,2,3,4,5,6,7};
	static int count=0;
	public static void main(String[] args) {
		
		//Node root = convertToBSTSize(arr.length);
		Node root = convertBST(arr,0,arr.length-1);
		preorder(root);
	}
	
	private static void preorder(Node root){
		if(root==null)
			return;
		
		System.out.println(root.data);
		preorder(root.left);
		preorder(root.right);
	}
	
	private static Node convertToBSTSize(int n){
		if(n<=0)
			return null;
		
		Node left = convertToBSTSize(n/2);
		Node root = new Node(arr[count]);
		count++;
		root.left = left;
		Node right = convertToBSTSize(n-n/2-1);
		root.right = right;
		return root;
	}
	
	private static Node convertBST(int arr[], int left, int right){
		if(left>right)
			return null;
		
		int mid = left+(right-left)/2;
		Node root = new Node(arr[mid]);
		root.left = convertBST(arr, left, mid-1);
		root.right = convertBST(arr, mid+1, right);
		return root;
	}

}
