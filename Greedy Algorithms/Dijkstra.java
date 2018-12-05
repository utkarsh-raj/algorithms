import java.io.*;
import java.lang.Math;
import java.util.*;

class Dijkstra {

	int V;

	int minimumDistance(int []distance, boolean []sptSet) {
		int min = Integer.MAX_VALUE, minIndex = -1, v = 0;

		for (v = 0; v < V; v++) {
			if (sptSet[v] == false && distance[v] < min) {
				min = distance[v];
				minIndex = v;
			}
		}
		return minIndex;
	}

	void shortestPath(int [][]graph, int source) {
		int []distance = new int[V];
		int i = 0;
		int count = 0;
		int v = 0;

		boolean []sptSet = new boolean[V];

		for (i = 0; i < V; i++) {
			distance[i] = Integer.MAX_VALUE;
			sptSet[i] = false;
		}

		distance[source] = 0;

		for (count = 0; count < V - 1; count++) {
			int u = minimumDistance(distance, sptSet);

			sptSet[u] = true;

			for (v = 0; v < V; v++) {
				if (graph[u][v] != 0 && sptSet[v] == false && distance[u] + graph[u][v] < distance[v] && distance[u] != Integer.MAX_VALUE) {
					distance[v] = distance[u] + graph[u][v];
				}
			}
		}

		System.out.println("Vertex \tDistance from Source"); 
        for (i = 1; i < V; i++) {
            System.out.println(i + "\t" + distance[i]);
        }
	}

	public static void main(String []args) {
		Dijkstra spt = new Dijkstra();

		Scanner scanner = new Scanner(System.in);

		spt.V = scanner.nextInt();

		int graph[][] = new int[][] {{0, 4, 0, 0, 0, 0, 0, 8, 0}, 
                                  {4, 0, 8, 0, 0, 0, 0, 11, 0}, 
                                  {0, 8, 0, 7, 0, 4, 0, 0, 2}, 
                                  {0, 0, 7, 0, 9, 14, 0, 0, 0}, 
                                  {0, 0, 0, 9, 0, 10, 0, 0, 0}, 
                                  {0, 0, 4, 14, 10, 0, 2, 0, 0}, 
                                  {0, 0, 0, 0, 0, 2, 0, 1, 6}, 
                                  {8, 11, 0, 0, 0, 0, 1, 0, 7}, 
                                  {0, 0, 2, 0, 0, 0, 6, 7, 0} 
                                 };
        spt.shortestPath(graph, 0);
	}
}