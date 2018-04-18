package bst;

import java.util.LinkedList;
import java.util.Queue;

import trees.Node;

public class FindIntersection {
	static int arr1Index, arr2Index;
	static int arr1Count, arr2Count;

	public static void main(String[] args) {
		BinarySearchTree bst1 = BinarySearchTree.initialize();
		BinarySearchTree bst2 = BinarySearchTree.initialize2();
		//System.out.println(countNodes(bst1.root));
		//System.out.println(countNodes(bst2.root));
		int length1=countNodes(bst1.root);
		int length2=countNodes(bst2.root);
		int arr1[] = new int[length1];
		int arr2[] = new int[length2];
		inOrderTraversal(bst1.root, arr1,true);
		for(int elem:arr1){
			System.out.print(elem+" ");
		}
		System.out.println("second tree");
		inOrderTraversal(bst2.root, arr2,false);
		for(int elem:arr2){
			System.out.print(elem+" ");
		}
		
		int intersection = printCommon(arr1,arr2, length1,length2);
		System.out.println("intersection is "+intersection);
		
	}
	


	private static int printCommon(int[] arr1, int[] arr2, int length1, int length2) {
		if(length1>length2){
			for(int i=(length1-length2), j=0;i<length1;i++,j++){
				if(arr1[i]==arr2[j])
					return arr1[i];
			}
		}else{
			for(int i=(length2-length1),j=0;i<length2;i++,j++){
				if(arr1[j]==arr2[i])
					return arr2[i];
			}
		}
		return -1;
	}



	private static void inOrderTraversal(Node root, int arr[],boolean firstTree ) {
		if(root==null)
			return;
		inOrderTraversal(root.left, arr, firstTree);
		if(firstTree)
			arr[arr1Index++]=root.data;
		else
			arr[arr2Index++]=root.data;
		inOrderTraversal(root.right, arr, firstTree);
	}
	
	private static int countNodes(Node root){
		if(root==null)
			return 0;
		
		 Queue<Node> q = new LinkedList<>();
		 q.add(root);
		 int count=0;
		 while(!q.isEmpty()){
			 Node node = q.remove();
			 count++;
			 if(node.left!=null)
				 q.add(node.left);
			 if(node.right!=null)
				 q.add(node.right);
		 }
		 return count;
	}

}
