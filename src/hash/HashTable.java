package hash;

class ListNode{
	int key;
	int data;
	ListNode next;
	
	public ListNode(int key, int data) {
		this.key = key;
		this.data = data;
		this.next = null;
	}
}

public class HashTable {

	int count;
	final static int LOAD_FACTOR = 20;
	ListNode[] table;
	int tableSize;
	
	public HashTable(int size) {
		this.tableSize = size/LOAD_FACTOR;
		table = new ListNode[tableSize];
	}
	
	public int hash(int data,int size) {
		return data%size;
	}
	
	public void hashInsert(int data) {
		int index = hash(data,this.tableSize);
		ListNode startNode = this.table[index];
		ListNode node = new ListNode(index,data);
		if(startNode==null) {
			this.table[index]=node;
		}else {
			node.next = startNode;
			this.table[index] = node;
		}
		this.count++;
		if(this.count/tableSize >  LOAD_FACTOR)
			rehash();
	}
	
	public int hashSearch(int data) {
		int index = hash(data,this.tableSize);
		ListNode startNode = this.table[index];
		ListNode temp = startNode;
		while(temp!=null) {
			if(temp.data==data) {
				return 1;
			}
			temp=temp.next;
		}
		return 0;
	}
	
	public void hashDelete(int data) {
		int index = hash(data, this.tableSize);
		ListNode startNode = this.table[index];
		ListNode temp = startNode;
		ListNode prev = null;
		while(temp!=null) {
			if(temp.data==data) {
				if(prev!=null) {
					prev.next=temp.next;
				}else {
					this.table[index]=temp.next;
				}
				temp = null;
				this.count--;
				break;
			}
			temp=temp.next;
		}
	}
	
	public void rehash() {
		int oldSize = this.tableSize;
		ListNode[] oldTable = this.table;
		int newSize = 2*oldSize;
		this.table = new ListNode[newSize];
		this.count=0;
		for(int i=0;i<oldSize;i++) {
			ListNode startNode = oldTable[i];
			if(startNode!=null) {
				ListNode temp = startNode;
				while(temp!=null) {
					hashInsert(temp.data);
					temp = temp.next;
				}
			}
		}
	}
}
