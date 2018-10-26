package epi.bst;

import epi.binarytree.BinaryTreeNode;

/**
 * @author vcpaks
 * 14.9 Test if three BST nodes are totally ordered
 */
public class TestThreeNodesOrdering {

	public static void main(String[] args) {
		BinaryTreeNode 	five = new BinaryTreeNode(5);
		BinaryTreeNode three = new BinaryTreeNode(3);
		BinaryTreeNode two = new BinaryTreeNode(2);
		BinaryTreeNode seven = new BinaryTreeNode(7);
		BinaryTreeNode seventeen = new BinaryTreeNode(17);
		BinaryTreeNode thirteen = new BinaryTreeNode(13);
		BinaryTreeNode eleven = new BinaryTreeNode(11);
		BinaryTreeNode fortythree = new BinaryTreeNode(43);
		BinaryTreeNode twentythree = new BinaryTreeNode(23);
		BinaryTreeNode thirtyseven = new BinaryTreeNode(37);
		BinaryTreeNode twentynine = new BinaryTreeNode(29);
		BinaryTreeNode thirtyone = new BinaryTreeNode(31);
		BinaryTreeNode fortyone = new BinaryTreeNode(41);
		BinaryTreeNode fortyseven = new BinaryTreeNode(47);
		BinaryTreeNode fiftythree = new BinaryTreeNode(53);
		BinaryTreeNode nineteen = new BinaryTreeNode(19);
		
		nineteen.left=seven;
		nineteen.right=fortythree;
		seven.left=three;
		seven.right=eleven;
		three.left=two;
		three.right=five;
		eleven.right=seventeen;
		seventeen.left=thirteen;
		fortythree.left=twentythree;
		fortythree.right=fortyseven;
		fortyseven.right=fiftythree;
		twentythree.right=thirtyseven;
		thirtyseven.left=twentynine;
		thirtyseven.right=fortyone;
		twentynine.right=thirtyone;
		
		System.out.println(checkOrdering(twentythree, thirtyone, fortythree));
	}
	
	private static boolean checkOrdering(BinaryTreeNode middle, BinaryTreeNode firstNode, BinaryTreeNode secondNode) {
		BinaryTreeNode first = firstNode, second = secondNode;
		if(first==middle||second==middle||first==second) 
			return false;
		
		while(first!=secondNode && second!=firstNode && first!=middle && second!=middle && (first!=null || second!=null)) {
			if(first!=null)
				first = first.data>middle.data?first.left:first.right;
			if(second!=null)
				second = second.data>middle.data?second.left:second.right;
		}
		
		if(first!=middle && second!=middle)
			return false;
		
		if(first==middle)
			return searchDesc(middle,secondNode);
		else if(second==middle)
			return searchDesc(middle,firstNode);
		
		return false;
	}

	private static boolean searchDesc(BinaryTreeNode middle, BinaryTreeNode node) {
		while(middle!=null && middle!=node) {
			middle = middle.data>node.data?middle.left:middle.right;
		}
		return middle==node;
	}

}
