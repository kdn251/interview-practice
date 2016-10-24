package binarySearchTree;

public class BinarySearchTree {

	public static void main(String[] args) {

		//initialize tree
		Tree binarySearchTree = new Tree(4);
		
		//add nodes to tree
		binarySearchTree.add(2);
		binarySearchTree.add(1);
		binarySearchTree.add(3);
		binarySearchTree.add(6);
		binarySearchTree.add(5);
		binarySearchTree.add(7);
		
		//print header
		System.out.print("Preorder traversal of Binary Search Tree: ");
		
		//run preorder traversal algorithm on BST
		preOrderTraversal(binarySearchTree.root);
		
		System.out.println();
		
		//print header
		System.out.print("Inorder traversal of Binary Search Tree: ");
		
		//run inorder traversal algorithm on BST
		inOrderTraversal(binarySearchTree.root);
		
		System.out.println();
		
		//print header
		System.out.print("Postorder traversal of Binary Search Tree: ");
		
		//run postorder traversal algorithm on BST
		postOrderTraversal(binarySearchTree.root);
		

		
		
		
	}

	private static void postOrderTraversal(Node root) {

		if(root != null) {
			
			//process left
			postOrderTraversal(root.left);
			
			//proces right
			postOrderTraversal(root.right);
			
			//print node's data
			System.out.print(root.data + " ");
			
			
		}
		
		
	}

	private static void preOrderTraversal(Node root) {

		if(root != null) {
			
			//print node's data
			System.out.print(root.data + " ");
			
			//process left
			preOrderTraversal(root.left);
			
			//process right
			preOrderTraversal(root.right);
			
			
		}
		
		
		
	}

	//run an inorder traversal on tree
	private static void inOrderTraversal(Node root) {
		
		if(root != null) {
			
			//process left
			inOrderTraversal(root.left);
			
			//print node's data
			System.out.print(root.data + " ");
			
			//process right
			inOrderTraversal(root.right);
			
		}
		
		
	}

}

//tree class definition
class Tree {
	
	//root of tree
	Node root;
	
	
	//tree constructor
	Tree(int value) {
		
		root = new Node(value);
		
	}
	
	//getter for root of tree
	private Node getRoot(Tree t) {
		
		return t.root;
		
	}
	
	//add function
	void add(int value) {
		
		root = recursiveAdd(root, value);
		
	}

	//recursive helper function for add method
	private Node recursiveAdd(Node root, int value) {
		
		//if we have reached the bottom of the tree insert the node
		if(root == null) {
			
			Node newNode = new Node(value);
			return newNode;
			
		}
		
		//go into left subtree
		else if(value < root.data) {
			
			root.left = recursiveAdd(root.left, value);
			
		}
		
		//go into right subtree
		else {
			
			root.right = recursiveAdd(root.right, value);
			
		}
		
		//return root of tree
		return root;

	}
	
	
}

//node class definition
class Node {
	
	//data attribute
	int data;
	
	//left child
	Node left;
	
	//right child
	Node right;
	
	//node constructor
	Node(int data) {
		
		this.data = data;
		this.left = null;
		this.right = null;
		
	}
	
}
