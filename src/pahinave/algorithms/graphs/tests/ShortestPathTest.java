package pahinave.algorithms.graphs.tests;

import java.util.Map;
import java.util.Map.Entry;

import org.junit.Test;

import pahinave.algorithms.graphs.AdjacencyGraph;
import pahinave.algorithms.graphs.Edge;
import pahinave.algorithms.graphs.Graph;
import pahinave.algorithms.graphs.Vertex;

public class ShortestPathTest {

	@Test
	public void testFullyConnected() {
		Graph<Integer, Integer> graph = new AdjacencyGraph<>(false);

		Vertex<Integer> v1 = graph.addVertex("1", 1);
		Vertex<Integer> v2 = graph.addVertex("2", 2);
		Vertex<Integer> v3 = graph.addVertex("3", 3);
		Vertex<Integer> v4 = graph.addVertex("4", 4);
		Vertex<Integer> v5 = graph.addVertex("5", 5);

		graph.addEdge(new Edge<>(v1, v2, 5));
		graph.addEdge(new Edge<>(v2, v3, 6));
		graph.addEdge(new Edge<>(v3, v4, 7));
		graph.addEdge(new Edge<>(v4, v5, 7));


		 
		 Vertex<Integer> v6 = graph.addVertex("6", 6);
		 Vertex<Integer> v7 = graph.addVertex("7", 7);
		 Vertex<Integer> v8 = graph.addVertex("8", 8);
		 Vertex<Integer> v9 = graph.addVertex("9", 9);
		
		 graph.addEdge(new Edge<>(v1, v6, 14));
		 graph.addEdge(new Edge<>(v6, v7, 14));
		 graph.addEdge(new Edge<>(v8, v7, 14)); // NOTE THIS EDGE ****
		 graph.addEdge(new Edge<>(v8, v9, 14));

		
		graph.showVertexEdgesView();
		
		Map<Vertex<Integer>, Integer> shortestPaths = graph.shortestPaths(v1);
		for(Entry<Vertex<Integer>, Integer> entry : shortestPaths.entrySet()) {
			System.out.println(entry.getKey() + "     -> " + entry.getValue());
		}

	}
}
