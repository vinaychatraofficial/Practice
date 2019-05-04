package ae;

import java.util.HashMap;

public class LRUCache {
	static class LRUCache1 {
		int maxSize;
		HashMap<String,Node> map = new HashMap<>();
		int currentSize=0;
		Node head=null, tail=null;

		public LRUCache1(int maxSize) {
			this.maxSize = maxSize > 1 ? maxSize : 1;
		}

		public void insertKeyValuePair(String key, int value) {
			if(map.containsKey(key)){
				Node node = map.get(key);
				node.value=value;
				setHead(node);
			}else{
				Node node = new Node(key,value);
				if(currentSize==maxSize){
					removeLRU();
				}else{
					currentSize++;
				}
				map.put(key,node);
				setHead(node);
			}
		}

		public LRUResult getValueFromKey(String key) {
			if(map.containsKey(key)){
				Node node = map.get(key);
				setHead(node);
				System.out.println("getValueFromKey(key):"+node.value);
				return new LRUResult(true,node.value);
			}
			System.out.println("getValueFromKey(key):false");
			return new LRUResult(false,-1);
		}

		public String getMostRecentKey() {
			if(head!=null){
				System.out.println("getMostRecentKey():"+head.key);
				return head.key;
			}
			System.out.println("getMostRecentKey():no head");
			return null;
		}

		private void removeLRU(){
			String key = tail.key;
			if(head==tail){
				head=null;
				tail=null;
			}else	if(tail.prev!=null){
				tail.prev.next=null;
				tail = tail.prev;
			}

			map.remove(key);
		}

		private void setHead(Node node){
			if(head==null){
				head=node;
				tail=node;
			}else{
				if(node.prev!=null)
					node.prev.next=node.next;
				if(node.next!=null)
					node.next.prev=node.prev;
				node.next = head;
				head.prev = node;
				head = node;
			}

		}
	}

	static class Node{
		private String key;
		private int value;
		Node prev;
		Node next;

		public Node(String key, int value){
			this.key = key;
			this.value = value;
		}
	}

	static class LRUResult{
		boolean found;
		int value;

		public LRUResult(boolean found, int value){
			this.found = found;
			this.value = value;
		}
	}

}
