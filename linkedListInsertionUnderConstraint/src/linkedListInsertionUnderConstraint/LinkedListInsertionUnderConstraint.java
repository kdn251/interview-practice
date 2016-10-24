package linkedListInsertionUnderConstraint;

public class LinkedListInsertionUnderConstraint {

	public static void main(String[] args) {

		//initialize count
		int count = 0;
		
		//initialize head of list
		Node head = new Node(0);
		
		//choose size of list randomly
		int random = (int)(Math.random() * 100);
		
		//initialize remainder of list
		initializeList(head, random, count);
		
		//print header
		System.out.println("Original List: ");
		
		//print list
		printList(head);
		
		//initialize random value to insert into list
		int randomValue = (int)(Math.random() * head.size);
		
		//insert random value into list at correct position
		insertInOrder(head, randomValue);
		
		//print header
		System.out.println("List with random value " + randomValue + " inserted: ");
		
		//print list
		printList(head);
		
		
	}

	private static void printList(Node head) {

		//point current to head
		Node current = head;
		
		//iterate through list
		while(current != null) {
			
			System.out.print(current.data + " -> ");
			
			current = current.next;
			
		}
		
		System.out.println("null");
		
	}

	private static void insertInOrder(Node head, int randomValue) {

		//if head of list is null insert value and return
		if(head == null) {
			
			Node newNode = new Node(randomValue);
			
			head = newNode;
			
			return;
			
		}
		
		//if the list only contains one element
		if(head != null && head.next == null) {
			
			if(head.data <= randomValue) {
				
				Node newNode = new Node(randomValue);
				
				head.next = newNode;
				
				return;
				
			}
			
			else {
				
				Node newNode = new Node(randomValue);
				
				newNode.next = head;
				
				head = newNode;
				
				return;
				
			}
			
		}
		
		//point current to head
		Node current = head;
		
		//point next to current's next
		Node next = current.next;
		
		//iterate through list while we are not at the correct insertion point
		while(next.data < randomValue) {
			
			next = next.next;
			current = current.next;
			
		}
		
		//create node with value
		Node newNode = new Node(randomValue);
		
		//point current to the new node
		current.next = newNode;
		
		//point new node's next to next
		newNode.next = next;
		
	}

	private static void initializeList(Node head, int random, int count) {

		//point current to head
		Node current = head;
		
		//increment count
		count++;
		
		//initialize list to size of "random"
		for(int i = 0; i < random; i++) {
			
			Node newNode = new Node(count);
			
			current.next = newNode;
			
			current = newNode;
			
			count++;
			
		}
		
	}

}

class Node {
	
	//initialize size of list to zero
	static int size = 0;
	
	//data attribute
	int data;
	
	//next attribute
	Node next;
	
	//node constructor
	Node(int data) {
		
		this.data = data;
		this.next = null;
		size++;
		
	}
	
	
}
