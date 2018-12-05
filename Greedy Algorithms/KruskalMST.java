import java.io.*;
import java.lang.Math;
import java.util.*;

class KruskalMST {

	class Edge implements Comparable<Edge> {
		int source, destination, cost;

		public int compareTo(Edge edge) {
			return this.cost - edge.cost;
		}
	}

	class Subset {
		 int parent, rank;
	}

	int V, E;
	Edge []edge;

	void Graph(int edges, int vertices) {
		V = vertices;
		E = edges;
		edge = new Edge[E];

		int i = 0;

		for (i = 0; i < edges; i++) {
		edge[i] = new Edge();
		}
	}

	int find(Subset []subsets, int vertex) {
		if (subsets[vertex].parent != vertex) {
			subsets[vertex].parent = find(subsets, subsets[vertex].parent);
		}

		return subsets[vertex].parent;
	}

	void union(Subset []subsets, int setA, int setB) {
		int aRoot = find(subsets, setA);
		int bRoot = find(subsets, setB);

		if (subsets[aRoot].rank < subsets[bRoot].rank) {
			subsets[aRoot].parent = bRoot;
		}

		else if (subsets[aRoot].rank > subsets[bRoot].rank) {
			subsets[bRoot].parent = aRoot;
		}

		else {
			subsets[bRoot].parent = aRoot;
			subsets[aRoot].rank += 1;
		}
	}

	void MST() {
		// To store the result
		Edge []result = new Edge[V];
		int e = 0, i = 0; //Index variables

		for (i = 0; i < V; i++) {
			result[i] = new Edge();
		}

		Arrays.sort(edge);

		Subset []subsets = new Subset[V];
		for (i = 0; i < V; i++) {
			subsets[i] = new Subset();
			subsets[i].parent = i;
			subsets[i].rank = 0;
		}

		i = 0;

		while (e < V - 1) {

			Edge nextEdge = new Edge();
			nextEdge = edge[i];
			i += 1;

			int x = find(subsets, nextEdge.source);
			int y = find(subsets, nextEdge.destination);

			if (x != y) {
				result[e] = nextEdge;
				e += 1;
				union(subsets, x, y);
			}
		}

		System.out.println("The constructed MST");

		for (i = 0; i < e; i++) {
			System.out.println(result[i].source + "-" + result[i].destination + "    Cost = " + result[i].cost);
		}
	}

	public static void main(String []args) {
		int V = 4;
		int E = 5;

		KruskalMST mst = new KruskalMST();

		mst.Graph(E, V);

		// add edge 0-1 
        mst.edge[0].source = 0; 
        mst.edge[0].destination = 1; 
        mst.edge[0].cost = 10; 
  
        // add edge 0-2 
        mst.edge[1].source = 0; 
        mst.edge[1].destination = 2; 
        mst.edge[1].cost = 6; 
  
        // add edge 0-3 
        mst.edge[2].source = 0; 
        mst.edge[2].destination = 3; 
        mst.edge[2].cost = 5; 
  
        // add edge 1-3 
        mst.edge[3].source = 1; 
        mst.edge[3].destination = 3; 
        mst.edge[3].cost = 15; 
  
        // add edge 2-3 
        mst.edge[4].source = 2; 
        mst.edge[4].destination = 3; 
        mst.edge[4].cost = 4;

        mst.MST();
    }
}