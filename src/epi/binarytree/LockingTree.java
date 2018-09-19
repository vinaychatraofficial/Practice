package epi.binarytree;

/**
 * @author vcprabha
 * 9.17 Implement locking in a binary tree
 */
public class LockingTree {

	public static void main(String[] args) {


		BinaryTreeNodeLock zero = new BinaryTreeNodeLock(0);
		BinaryTreeNodeLock one = new BinaryTreeNodeLock(1);
		BinaryTreeNodeLock two = new BinaryTreeNodeLock(2);
		BinaryTreeNodeLock three = new BinaryTreeNodeLock(3);
		BinaryTreeNodeLock four = new BinaryTreeNodeLock(4);
		BinaryTreeNodeLock five = new BinaryTreeNodeLock(5);
		BinaryTreeNodeLock six = new BinaryTreeNodeLock(6);
		BinaryTreeNodeLock seven = new BinaryTreeNodeLock(7);
		BinaryTreeNodeLock eight = new BinaryTreeNodeLock(8);
		BinaryTreeNodeLock nine = new BinaryTreeNodeLock(9);
		
		zero.left=one;
		one.parent=zero;
		zero.right=two;
		two.parent=zero;
		one.left=three;
		three.parent=one;
		one.right=four;
		four.parent=one;
		three.left=seven;
		seven.parent=three;
		three.right=eight;
		eight.parent=three;
		two.left=five;
		five.parent=two;
		two.right=six;
		six.parent=two;
		four.right=nine;
		nine.parent=four;
		
		System.out.println(isLocked(four));
		System.out.println(lock(four));
		System.out.println(isLocked(four));
		System.out.println(isLocked(nine));
		System.out.println(lock(one));
		System.out.println(lock(nine));
		System.out.println(unlock(four));
		System.out.println(lock(nine));
	
	}
	
	private static boolean isLocked(BinaryTreeNodeLock node){
		return node.isLocked();
	}
	
	private static boolean lock(BinaryTreeNodeLock node){
		if(node.isLocked||node.numDescLocked>0)
			return false;
		
		BinaryTreeNodeLock cur=node;
		while(cur.parent!=null){
			if(cur.parent.isLocked)
				return false;
			cur=cur.parent;
		}
		
		node.isLocked=true;
		cur=node;
		while(cur.parent!=null){
			cur.parent.numDescLocked++;
			cur=cur.parent;
		}
		
		return true;
			
	}
	
	private static boolean unlock(BinaryTreeNodeLock node){
		if(node.isLocked){
			node.isLocked=false;
			BinaryTreeNodeLock cur=node;
			while(cur.parent!=null){
				cur.parent.numDescLocked--;
				cur=cur.parent;
			}
			return true;
		}
		return false;
	}

}
