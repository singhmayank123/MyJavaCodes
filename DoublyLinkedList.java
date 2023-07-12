public class DoublyLinkedList<E>{
	
	/** node class **/
	private class DLLNode {

		E data;
		DLLNode nextNode;
		DLLNode prevNode;

	}

	private DLLNode header; // points to the first node 
	private DLLNode trailer;// points to the last node 

/** create an empty list at the time of constructor **/
	public DoublyLinkedList(){

		header = new DLLNode();
		trailer = new DLLNode();

		header.nextNode = trailer;
		header.prevNode = null;
		trailer.prevNode = header;
		trailer.nextNode = null;
	}
/** adds an element at the front of the list **/
	public void addFirst(E data){

		/** create a new node **/
		DLLNode newNode = new DLLNode();
		/** add the data to the new node **/
		newNode.data = data;
		/** set previous of newnode null **/
		newNode.prevNode = null;
		/** set next of new node to the header **/
		newNode.nextNode = header;
		/** changer previous of header **/
		header.prevNode = newNode;
		/** make newNode as new head **/
		header = newNode;
	}

/** adds element at the end of the list **/
	
	public void addLast(E data){

		/** create a new node **/
		DLLNode newNode = new DLLNode();
		/** add the data to the new node **/
		newNode.data = data;

		trailer.nextNode = newNode;
		newNode.prevNode = trailer;
		newNode.nextNode = null;
		trailer = newNode;
	}

/** method to remove the last element of the list **/
	
	public void removeLast(){

		DLLNode temp = trailer;
		trailer = trailer.prevNode;
		trailer.nextNode = null;

		temp.prevNode = null;
	}

/** method to print the list in forward direction **/
	
	public void printListForward(){

		DLLNode temp = header;
		System.out.print("[");
		while(temp != null){
			System.out.print(temp.data + " ");
			temp = temp.nextNode;
		}

		System.out.println("]");
	}

	/** method to print the list in backward direction **/
	
	public void printListBackward(){

		DLLNode temp = trailer;
		System.out.print("[");
		while(temp != null){
			System.out.print(temp.data + " ");
			temp = temp.prevNode;
		}

		System.out.println("]");
	}

	/** main method to test the program **/

	public static void main(String[] args) {
		
		/** create a list of integer **/

		DoublyLinkedList<Integer> list = new DoublyLinkedList<Integer>();

		// print the list in forward direction 
		list.printListForward();
		// print the list in backward direction 
		list.printListBackward();

		/** add some integer values to the list **/
		list.addLast(12);
		list.addLast(72);
		list.addLast(90);
		list.addLast(78);
		list.addFirst(45);
		list.addFirst(98);
		list.addFirst(13);

		list.removeLast();
		// print the list in forward direction 
		list.printListForward();
		// print the list in backward direction 
		list.printListBackward();

		// create a list of strings

		DoublyLinkedList<String> strList = new DoublyLinkedList<String>();
		// add some values 

		strList.addFirst("book");
		strList.addFirst("table");
		strList.addLast("fruit");
		strList.addLast("laptop");

		// print the list in forward direction 
		strList.printListForward();
		// print the list in backward direction 
		strList.printListBackward();


	}
}