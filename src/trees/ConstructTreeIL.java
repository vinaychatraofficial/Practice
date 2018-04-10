package trees;

public class ConstructTreeIL {
	
	static int preindex=0;

	public static void main(String[] args) {
		String preorderStr = "IILLILL";
		ILNode root = null;
		root = constructTree(preorderStr);
		ILNode.inorder(root);
	}
	
	private static ILNode constructTree(String preorderStr){
		
		if(preindex>preorderStr.length()-1)
			return null;
		
		ILNode root = new ILNode(preorderStr.substring(preindex, preindex+1));
		if(root.data.equals("L")){
			return root;
		}else{
			preindex++;
			root.left = constructTree(preorderStr);
			preindex++;
			root.right = constructTree(preorderStr);
		}
			
		return root;
	}
	
private static ILNode constructTree(String preorderStr, int index){
		
		if(index>preorderStr.length()-1)
			return null;
		
		ILNode root = new ILNode(preorderStr.substring(index, index+1));
		if(root.data.equals("L")){
			return root;
		}else{
			index++;
			root.left = constructTree(preorderStr,index);
			index++;
			root.right = constructTree(preorderStr,index);
		}
			
		return root;
	}

}

class ILNode{
	String data;
	ILNode left, right;

	public ILNode(String data){
		this.data = data;
		this.left=this.right=null;
	}
	
	public static void inorder(ILNode root){
		if(root==null)
			return;
		
		inorder(root.left);
		System.out.print(root.data+" ");
		inorder(root.right);
	}
}
