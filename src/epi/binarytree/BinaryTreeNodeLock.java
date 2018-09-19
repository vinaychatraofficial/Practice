package epi.binarytree;

public class BinaryTreeNodeLock {
	
	int data;
	BinaryTreeNodeLock left, right, parent;
	boolean isLocked;
	int numDescLocked;
	
	public BinaryTreeNodeLock(int data) {
		this.data=data;
	}
	
	public boolean isLocked(){
		return isLocked;
	}

}
