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
		System.out.println("Inorder traversal of Binary Search Tree: ");
		
		//run inorder traversal algorithm on BST
		inOrderTraversal(binarySearchTree.root);

		
		
		
	}

	//run an inorder traversal on tree
	private static void inOrderTraversal(Node root) {
		
		if(root != null) {
			
			inOrderTraversal(root.left);
			System.out.print(root.data + " ");
			inOrderTraversal(root.right);
			
		}
		
		
	}

}

class Tree {
	
	Node root;
	
	Tree(int value) {
		
		root = new Node(value);
		
	}
	
	private Node getRoot(Tree t) {
		
		return t.root;
		
	}
	
	void add(int value) {
		
		root = recursiveAdd(root, value);
		
	}

	private Node recursiveAdd(Node root, int value) {

		if(root == null) {
			
			Node newNode = new Node(value);
			return newNode;
			
		}
		
		else if(value < root.data) {
			
			root.left = recursiveAdd(root.left, value);
			
		}
		
		else {
			
			root.right = recursiveAdd(root.right, value);
			
		}
		
		return root;

	}
	
	
}

class Node {
	
	int data;
	Node left;
	Node right;
	
	Node(int data) {
		
		this.data = data;
		this.left = null;
		this.right = null;
		
	}
	
}
