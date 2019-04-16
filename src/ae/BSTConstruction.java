package ae;

public class BSTConstruction {
	static class BST {
	    public int value;
	    public BST left;
	    public BST right;

	    public BST(int value) {
	      this.value = value;
	    }

	    public BST insert(int value) {
	      // Write your code here.
	      // Do not edit the return statement of this method.
				BST cur = this,prev=null;
				BST newNode = new BST(value);
				while(cur!=null){
					prev=cur;
					if(value<cur.value){
						cur=cur.left;
					}else{
						cur=cur.right;
					}
					
				}
			
				if(value<prev.value){
					//System.out.println("Inserting "+value+" to left of "+prev.value);
					prev.left=newNode;
				}	else {
					//System.out.println("Inserting "+value+" to right of "+prev.value);
					prev.right=newNode;
				}
	      return this;
	    }

	    public boolean contains(int value) {
	      BST cur = this;
				while(cur!=null){
					if(cur.value==value)
						return true;
					else if(value<cur.value){
						cur=cur.left;
					}else{
						cur=cur.right;
					}
				}
				return false;
	    }

	    public BST remove(int value) {
	      // Write your code here.
	      // Do not edit the return statement of this method.
				BST cur = this;
				BST parent=null;
				while(cur!=null){
					if(value<cur.value){
						parent=cur;
						cur=cur.left;
					}	else if(value>cur.value){
						parent=cur;
						cur=cur.right;
					}else {
						//1. Has 2 children
						if(cur.left!=null && cur.right!=null){
							BST child=cur.right;
							while(child.left!=null)
								child = child.left;
							remove(child.value);
							cur.value = child.value;
						}else if(parent==null){ // root node with 1 child
							if(cur.left!=null){
								cur.value = cur.left.value;
								cur.right = cur.left.right;
								cur.left = cur.left.left;
							}else if(cur.right!=null){
								cur.value = cur.right.value;
								cur.left = cur.right.left;
								cur.right = cur.right.right;
							}
						}else{ // non root node with 1 child
							if(parent.left==cur){
								parent.left = cur.left!=null ? cur.left:cur.right;
							}else{
								parent.right = cur.left!=null ? cur.left:cur.right;
							}
						}
						break;
					}
					
				}

	      return this;
	    }
	  }
}
