package detectCycleLinkedList;

public class DetectCycleLinkedList {

	public static void main(String[] args) {

		//initialize head of linked list
		Node head = new Node(1);
		
		//initialize tail of linked list
		Node tail = head;
		
		//initialize count
		int count = 2;
		
		//set current to head of linked list
		Node current = head;
		
		//add to linked list
		for(int i = 0; i < 10; i++) {
			
			//create new node
			Node newNode = new Node(count);
		
			//point current's next to new node
			current.next = newNode;
			
			//move current
			current = current.next;
			
			//point tail to last element
			tail = current;
			
			//increment count
			count++;
			
		}
		
		//point current to head of linked list
		current = head;
		
		//print linked list
		System.out.println(current.printList());
		
		//initialize random integer
		int random = (int)(Math.random() * head.size);
		
		System.out.println("random: " + random);
		
		//index through list
		while(random > 0) {
			
			//move current
			current = current.next;
			
			//decrement random
			random--;
			
		}
		
		//point tail's next to randomly selected index of list
		tail.next = current;
		
		System.out.println("Tail points to: " + tail.next.data);
		
		//point current to head;
		current = head;
		
		System.out.println(current.detectCycle());
		
		
	}

}

class Node {
	
	//initialize size of linked list to zero
	static int size = 0;
	
	//data attribute
	int data;
	
	//next attribute
	Node next;
		
	//constructor
	Node(int data) {
		
		//initialize data attribute
		this.data = data;
		
		//initialize next attribute to null
		this.next = null;
		
		//increment size of list
		size++;
		
	}

	//print linked list
	public String printList() {
		
		//set current to head of linked list
		Node current = this;
		
		String list = "";
		//print linked list
		while(current != null) {
			
			//add current's data to list
			list += current.data + " -> ";
			
			//move current to next index
			current = current.next;
			
		}
		
		//add null to end of list
		list += "null ";
		
		//return list
		return list;
		
	}
	
	//detect cycle in linked list
	public boolean detectCycle() {

		//initialize current to head of the list
		Node current = this;
		
		//initialize runner to two nodes ahead of current
		Node runner = this.next.next;
		
		//boolean to determine if current and runner have collided
		boolean collided = false;

		//iterate through list
		while(!collided && runner != null) {

			//update runner and current
			runner = runner.next.next;
			current = current.next;
			
			//if runner is null break
			if(runner == null) {
				
				break;
				
			}

			//if runner and current have colided
			if(runner == current) {

				collided = true;
				break;
				
			}

		}

		//return whether or not a cycle was detected
		return collided == true ? true : false;
			
	}
	
	
	
	
}
