package trees;

import java.util.ArrayList;
import java.util.List;

public class PrintPathToLeaf {

	public static void main(String[] args) {
		BinaryTree tree = BinaryTree.intialize();
		
		//int height = findHeight(tree.root);
		//int[] path = new int[height];
		//printPath(tree.root, path, 0);
		List<Integer> nodeList = new ArrayList<Integer>();
		printPath(tree.root, nodeList,0);
	}
	
	private static int findHeight(Node root){
		if(root==null)
			return 0;
		
		return 1+Math.max(findHeight(root.left), findHeight(root.right));
	}
	
	private static void printPath(Node root,int path[], int pathLen){
		if(root==null)
			return;
		
		path[pathLen] = root.data;
		pathLen++;
		if(root.left==null && root.right==null)
			print(path,pathLen);
		printPath(root.left,path,pathLen);
		printPath(root.right, path, pathLen);
	}

	private static void print(int[] path, int pathLen) {
		for(int i=0;i<pathLen;i++)
			System.out.print(path[i]+" ");
		System.out.println();
	}
	
	private static void printPath(Node root, List nodeList, int index){
		if(root==null)
			return;
		if(nodeList.size()>index && nodeList.get(index)!=null)
			nodeList.set(index, root.data);
		else
			nodeList.add(root.data);
		index++;
		if(root.left==null && root.right==null)
			print(nodeList, index);
		printPath(root.left, nodeList,index);
		printPath(root.right, nodeList,index);
	}

	private static void print(List<Integer> nodeList,int index) {
		for(int i=0;i<index;i++)
			System.out.print(nodeList.get(i)+" ");
		System.out.println();
	}

}
