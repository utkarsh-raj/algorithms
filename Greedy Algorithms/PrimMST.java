import java.io.*;
import java.lang.Math;
import java.util.*;

class PrimMST {

	int V;

	int minimumKey(int []key, boolean []mstSet) {
		int min = Integer.MAX_VALUE, minIndex = -1, v = 0;

		for (v = 0; v < V; v++) {
			if (mstSet[v] == false && key[v] < min) {
				min = key[v];
				minIndex = v;
			}
		}
		return minIndex;
	}

	void MST(int [][]graph) {
		int []parent = new int[V];
		int []key = new int[V];
		int i = 0;
		int count = 0;
		int v = 0;

		boolean []mstSet = new boolean[V];

		for (i = 0; i < V; i++) {
			key[i] = Integer.MAX_VALUE;
			mstSet[i] = false;
		}

		key[0] = 0;
		parent[0] = -1;

		for (count = 0; count < V - 1; count++) {
			int u = minimumKey(key, mstSet);

			mstSet[u] = true;

			for (v = 0; v < V; v++) {
				if (graph[u][v] != 0 && mstSet[v] == false && graph[u][v] < key[v]) {
					parent[v] = u;
					key[v] = graph[u][v];
				}
			}
		}

		System.out.println("Edge \tWeight"); 
        for (i = 1; i < V; i++) {
            System.out.println(parent[i] + " - "+ i + "\t" + graph[i][parent[i]]);
        }
	}

	public static void main(String []args) {
		PrimMST mst = new PrimMST();

		Scanner scanner = new Scanner(System.in);

		mst.V = scanner.nextInt();

		int graph[][] = new int[][] {{0, 2, 0, 6, 0}, 
                                    {2, 0, 3, 8, 5}, 
                                    {0, 3, 0, 0, 7}, 
                                    {6, 8, 0, 0, 9}, 
                                    {0, 5, 7, 9, 0}};
        mst.MST(graph);
	}
}