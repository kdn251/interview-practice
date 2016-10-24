package deleteKthToLastLinkedList;

public class DeleteKthToLastLinkedList {

	public static void main(String[] args) {

		//initialize count to zero
		int count = 0;
		
		//initialize head of linked list
		Node head = new Node(count);
		
		//initialize random number
		int random = (int)(Math.random() * 100);
		
		//initialize linked list with size "random"
		initializeList(head, random, count);
		
		
		//print header
		System.out.println("Original list: ");
		
		//print list
		printList(head);
		
		//randomly choose a kth element
		int kth = (int)(Math.random() * head.size);
		
		//account for off by one
		kth--;
		
		//remove the randomly chosen kth element
		removeKthElement(head, kth);
		
		System.out.println("List with " + kth + "th to last element removed: ");
		
		//print list with kth to last element removed
		printList(head);
		
		
		
		
	}

	private static void printList(Node head) {
		
		//point current to head
		Node current = head;
		
		
		//traverse the list printing each node's data
		while(current != null) {
			
			System.out.print(current.data + " -> ");
			
			current = current.next;
			
		}
		
		System.out.println("null");
		
	}

	private static void removeKthElement(Node head, int kth) {

		//if kth is greater than the list size return
		if(kth > head.size || head == null) return;
		
		//point runner and current to head
		Node runner = head;
		Node current = head;
		
		//move runner to kth element of the list
		while(kth > 0) {
			
			runner = runner.next;
			kth--;
			
		}
		
		//traverse the list while runner has not reached the end
		while(runner.next != null) {
			
			runner = runner.next;
			current = current.next;
			
		}
		
		//remove kth element by passing over it
		current.next = current.next.next;
		
	}

	private static void initializeList(Node head, int random, int count) {
		
		//increment count
		count++;

		//point current to head of list
		Node current = head;
		
		//initialize linked list with size "random"
		for(int i = 0; i < random; i++) {
			
			Node newNode = new Node(count);
			
			current.next = newNode;
			
			current = newNode;
			
			count++;
				
		}
		
	}

}

class Node {
	
	//size of list
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
