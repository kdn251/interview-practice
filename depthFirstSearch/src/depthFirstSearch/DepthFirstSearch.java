package depthFirstSearch;

import java.util.Iterator;
import java.util.LinkedList;

public class DepthFirstSearch {

	public static void main(String[] args) {

		//intialize graph g
		Graph g = new Graph(4);
		
		//add edges to graph g
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
        
        System.out.println("Depth first search traversal of the graph (starting at vertext 2) is ");
        
        //run DFS on graph g
        g.DFS(2);

	}

}

//define graph class
class Graph {
	
	//vertices attribute
	int vertices;
	
	//adjacency list attribute
	LinkedList<Integer> adj[];
	
	Graph(int vertices) {
		
		//initialize number of vertices in graph
		this.vertices = vertices;
		
		//initialize number of adjacency list in graph
		adj = new LinkedList[vertices];
		
		//initialize all adjacency list of graph
		for(int i = 0; i < vertices; i++) {
			
			adj[i] = new LinkedList<Integer>();
			
		}	
		
	}
	
	//add edge in graph
	void addEdge(int u, int v) {
		
		//add edge between vertices u and v
		adj[u].add(v);
		
	}
	
	//recursive helper function for depth first search
	void DFSRecursive(int source, Boolean[] visited) {
		
		//mark source as visited
		visited[source] = true;
		
		//print current vertex
		System.out.print(source + " ");
		
		//initialize iterator to iterate through source's adjacency list
		Iterator<Integer> i = adj[source].listIterator();
		
		while(i.hasNext()) {
			
			//get next vertex in source's adjacency list
			int next = i.next();
			
			//if next has not yet been visited...
			if(!visited[next]) {
				
				//recurse on current vertex
				DFSRecursive(next, visited);
			
			}
			
		}

	}
	
	
	//run depth first search on graph
	void DFS(int source) {
		
		//initialize boolean array visited
		Boolean[] visited = new Boolean[vertices];
		
		//initialize all indices of visited boolean array to false
		for(int i = 0; i < visited.length; i++) {
			
			visited[i] = false;
			
		}
		
		//call recursive helper function
		DFSRecursive(source, visited);
		
		
	}
	
	
}
