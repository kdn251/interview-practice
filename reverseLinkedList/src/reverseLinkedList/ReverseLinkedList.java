package reverseLinkedList;

public class ReverseLinkedList {

	public static void main(String[] args) {

		//initialize count to zero
		int count = 0;
		
		//initialize head of list
		Node head = new Node(count);
		
		//point current to head of list
		Node current = head;
		
		//intialize linked list
		initializeList(head, count);
		
		//print list
		printList(head);
		
		//print line break
		System.out.println();
		
		//reverse the linked list
		Node reversedList = reverseList(head);
		
		//print the new reversed list
		printList(reversedList);
		
		
	}

	private static Node reverseList(Node head) {
		
		//print header
		System.out.println("Reversed, the link listed is: ");
		
		//if list is null or consists of one element return
		if(head == null || head.next == null) return head;
		
		//initialize pointers
		Node previous = null;
		Node current = head;
		Node next = current.next;

		//reverse list
		while(next != null) {
			
			current.next = previous;
			previous = current;
			current = next;
			next = next.next;
	
		}
		
		//set current's next to previous
		current.next = previous;
		
		//return current
		return current;
		
		
	}

	private static void printList(Node head) {

		//point current to head of list
		Node current = head;
		
		//iterate through list
		while(current != null) {
			
			System.out.print(current.data + " -> ");
			
			current = current.next;
			
			
		}
		
		System.out.println("null");
			
		
	}

	private static void initializeList(Node head, int count) {
		
		//print header
		System.out.println("Linked list is currently: ");
		
		//point current to head of list
		Node current = head;
		
		//increment count
		count++;
		
		//initialize a random number
		int random = (int)(Math.random() * 100);
		
		//populate list with of size "random"
		for(int i = 0; i < random; i++) {
			
			Node newNode = new Node(count);
			
			current.next = newNode;
			
			current = newNode;
			
			count++;
			
		}
		
		//do i need this?
		//current.next = null;
		
		
		
		
	}

}

//definition of node class
class Node {
	
	//initialize size of list to zero
	static int size = 0;
	
	//data attribute
	int data;
	
	//next attribute
	Node next;
	
	//constructor for node
	Node(int data) {
		
		this.data = data;
		this.next = null;
		size++;
		
	}
	
}
