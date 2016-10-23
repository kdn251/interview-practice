package breadthFirstSearch;

import java.util.Iterator;
import java.util.LinkedList;

//define graph class
class Graph {
	
	//vertices attribute
	private int vertices;
	
	//adjacency list attribute
	private LinkedList<Integer> adj[];
	
	
	//graph constructor
	Graph(int vertices) {
		
		//initialize number of vertices
		this.vertices = vertices;
		
		//initialize number of adjacency list to the number of vertices
		adj = new LinkedList[vertices];
		
		//initialize each adjacency list
		for(int i = 0; i < vertices; i++) {
			
			adj[i] = new LinkedList<Integer>();
			
		}
		
	}
	
	//add an edge to graph
	void addEdge(int u, int v) {
		
		//add edge between u and v
		this.adj[u].add(v);
		
	}
	
	//run BFS on graph
	void BFS(int source) {
		
		//initialize visited boolean array
		Boolean[] visited = new Boolean[vertices];
		
		//initialize array to false
		for(int i = 0; i < visited.length; i++) {

			visited[i] = false;
			
		}
		
		//initialize queue
		LinkedList<Integer> queue = new LinkedList<Integer>();
		
		//mark source as visited
		visited[source] = true;
		
		//add source to queue
		queue.add(source);
		
		//while the queue is not empty...
		while(!queue.isEmpty()) {
			
			//remove next item in queue
			source = queue.remove();
			
			//print current vertex
			System.out.print(source + " ");
			
			//initialize iterator to iterate through adjacency list
			Iterator<Integer> i = adj[source].listIterator();
			
			//while the current adjacency list has another vertex
			while(i.hasNext()) {
				
				//get the next vertex
				int next = i.next();
				
				//if next vertex has not been visited...
				if(!visited[next]) {
					
					//mark next as visited
					visited[next] = true;
					
					//add next to queue
					queue.add(next);
					

					
				}
				
			}
			
			
		}
		
		
	}
	
	
}

public class BreadthFirstSearch {

	public static void main(String[] args) {
		
		Graph g = new Graph(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
        
        System.out.println("Breath first search traversal of the graph (starting at vertex 2) is ");
        
    	g.BFS(2);
		
	}

}


