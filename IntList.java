

public class IntList{

	class Node{

		public int data;
		public Node nextNode;

		Node(int i){
			data = i;
		}
	}

	private Node head; // points to the first node 
	private Node tail; // points to the last node 

	// EMPTY is equal to the maxinum value of integer
	private final int EMPTY = Integer.MAX_VALUE;
	private int size; // for the list size  

	// constructor that creates an empty list 
	public IntList(){
		head = tail = null;
		size = 0;
	}

	public int getHead(){
// returns empty if head is null 
		if(head == null)
			return EMPTY;
// otherwise returns the value of head node

		return head.data;
	}

	public int removeHead(){

		if(head == null)
			return EMPTY;

		Node oldHead = head;
		// otherwise, move head to next node 
		// previous head will be deleted by the garbage collector
		head = head.nextNode;
		oldHead = null;
		// decrease the list size by 1
		size--;

		return head.data; // return new head data
	}

	public void append(int i){

		Node newnode = new Node(i);
		newnode.nextNode = null;


		// for the very first node
		if(head == null){
			head = newnode;		
			tail = head;
			size++;
			return;
		}

		// for rest of node 

		tail.nextNode = newnode;
		tail = tail.nextNode;
		size++;
		
	}

	public int size(){
		return size; 
	}


	public void printList(){

		Node temp = head;

		while(temp != null){

			System.out.print(temp.data+" ");
			temp = temp.nextNode;
		}

		System.out.println();

	}


public void addAll(int index, IntList list) {

	if(index >= 0 && index <= this.size){

		Node prev = null;
		Node temp = head;

		while(index > 0){

			prev = temp;
			temp = temp.nextNode;
			index--;
		}

		// for index value 0
		if(prev == null){
			list.tail.nextNode = head;
			head = list.head;
			return;
		}

		// for rest of the indices 
		prev.nextNode = list.head;
		list.tail.nextNode = temp;

		size = size + list.size();

	}

	else
		System.out.println("Invalid index is passed!");
}


	public static void main(String[] args) {
		
		IntList list = new IntList();

		IntList list2 = new IntList();

		for(int i = 1; i<20; i+=2)
			list.append(i);

		System.out.println("List1:");
		list.printList();
		System.out.println("List1 size:" + list.size());
		list2.append(12);
		list2.append(56);
		list2.append(100);
		list2.append(103);
		System.out.println("List2:");
		list2.printList();
		System.out.println("Adding list2 in list1 at index 5..");
		list.addAll(13 , list2);
		System.out.println("Updated list1: ");
		list.printList();
		System.out.println("Updated list1 size: "+list.size());
		

		
	}


}