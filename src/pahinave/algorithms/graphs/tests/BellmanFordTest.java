package pahinave.algorithms.graphs.tests;

import java.util.Map;
import java.util.Map.Entry;

import org.junit.Test;

import pahinave.algorithms.graphs.AdjacencyGraph;
import pahinave.algorithms.graphs.BellmanFord;
import pahinave.algorithms.graphs.Edge;
import pahinave.algorithms.graphs.Graph;
import pahinave.algorithms.graphs.PathInfo;
import pahinave.algorithms.graphs.Vertex;

public class BellmanFordTest {
	@Test
	public void testNonNegative() throws Exception {
		// topological sort not applicable for undirected graph
		Graph<Integer, Integer> graph = new AdjacencyGraph<>(true);

		Vertex<Integer> v1 = graph.addVertex("1");
		Vertex<Integer> v2 = graph.addVertex("2");
		Vertex<Integer> v3 = graph.addVertex("3");
		Vertex<Integer> v4 = graph.addVertex("4");
		Vertex<Integer> v5 = graph.addVertex("5");

		graph.addEdge(new Edge<>(v1, v2, 1));
		graph.addEdge(new Edge<>(v2, v3, 2));
		graph.addEdge(new Edge<>(v3, v4, 3));
		graph.addEdge(new Edge<>(v2, v4, 6));
		graph.addEdge(new Edge<>(v1, v3, 4));
		graph.addEdge(new Edge<>(v4, v5, 2));

		graph.showVertexEdgesView();

		BellmanFord bf = new BellmanFord();
		Map<Vertex<Integer>, PathInfo<Integer, Integer>> pathInfo = bf.singleSourceShortestPath(graph, v1,
				Integer.valueOf(0), Integer.valueOf(Integer.MAX_VALUE), Integer::sum);

		for (Entry<Vertex<Integer>, PathInfo<Integer, Integer>> entry : pathInfo.entrySet()) {
			System.out.println(entry.getKey() + " -> " + entry.getValue());
		}
	}
	
	@Test
	public void testNegativeCycle() throws Exception {
		// topological sort not applicable for undirected graph
		Graph<Integer, Integer> graph = new AdjacencyGraph<>(true);

		Vertex<Integer> v1 = graph.addVertex("1");
		Vertex<Integer> v2 = graph.addVertex("2");
		Vertex<Integer> v3 = graph.addVertex("3");
		Vertex<Integer> v4 = graph.addVertex("4");
		Vertex<Integer> v5 = graph.addVertex("5");

		graph.addEdge(new Edge<>(v1, v2, 1));
		graph.addEdge(new Edge<>(v2, v3, 2));
		graph.addEdge(new Edge<>(v3, v4, 3));
		graph.addEdge(new Edge<>(v5, v2, -30)); // negative weight cycle edge
		graph.addEdge(new Edge<>(v2, v4, 6));
		graph.addEdge(new Edge<>(v1, v3, 4));
		graph.addEdge(new Edge<>(v4, v5, 2));

		graph.showVertexEdgesView();

		BellmanFord bf = new BellmanFord();
		
		System.out.println("Running bellman ford");
		Map<Vertex<Integer>, PathInfo<Integer, Integer>> pathInfo = bf.singleSourceShortestPath(graph, v1,
				Integer.valueOf(0), Integer.valueOf(Integer.MAX_VALUE), Integer::sum);

		for (Entry<Vertex<Integer>, PathInfo<Integer, Integer>> entry : pathInfo.entrySet()) {
			System.out.println(entry.getKey() + " -> " + entry.getValue());
		}
	}
}
