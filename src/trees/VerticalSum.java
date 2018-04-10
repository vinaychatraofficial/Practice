package trees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class VerticalSum {

	public static void main(String[] args) {
		BinaryTree tree = BinaryTree.intialize();
		Map<Integer,Integer> sumMap = new HashMap<>();
		//printVerticalSumInorder(tree.root, sumMap, 0);
		printVerticalSumPreorder(tree.root, sumMap, 0);
		Set keys = sumMap.keySet();
		List<Integer> keyList = new ArrayList(keys);
		System.out.println(keyList);
		Collections.sort(keyList);
		System.out.println(keyList);
		for(Integer key:keyList) {
			System.out.println(sumMap.get(key));
		}
	}
	
	private static void printVerticalSumInorder(Node root, Map<Integer,Integer> sumMap, int column) {
		if(root==null)
			return;
		
		printVerticalSumInorder(root.left, sumMap, column-1);
		int sum = sumMap.get(column)!=null? sumMap.get(column):0;
		System.out.println("Getting "+sum +" from column "+column);
		sum = sum+root.data;
		System.out.println("Putting "+sum+" in column "+column);
		sumMap.put(column, sum);
		printVerticalSumInorder(root.right, sumMap, column+1);
	}
	
	private static void printVerticalSumPreorder(Node root, Map<Integer,Integer> sumMap, int column) {
		if(root==null)
			return;
		
		int sum = sumMap.get(column)!=null? sumMap.get(column):0;
		sum=sum+root.data;
		sumMap.put(column, sum);
		printVerticalSumPreorder(root.left, sumMap, column-1);
		printVerticalSumPreorder(root.right, sumMap, column+1);
	}

}
