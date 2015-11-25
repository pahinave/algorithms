package pahinave.algorithms.graphs.tests;

import java.util.HashMap;
import java.util.Map.Entry;

import org.junit.Test;

import pahinave.algorithms.graphs.AdjacencyGraph;
import pahinave.algorithms.graphs.Dijkstra;
import pahinave.algorithms.graphs.Edge;
import pahinave.algorithms.graphs.Graph;
import pahinave.algorithms.graphs.PathInfo;
import pahinave.algorithms.graphs.Vertex;

public class DijkstraTest {
	@Test
	public void testSingleSourceShortedPath() throws Exception {
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

		Dijkstra<Integer, Integer> dijkstra = new Dijkstra<>();
		HashMap<Vertex<Integer>, PathInfo<Integer, Integer>> shortestPaths = dijkstra.singleSourceShortedPath(graph, v1,
				Integer.valueOf(0), Integer::sum);
		for (Entry<Vertex<Integer>, PathInfo<Integer, Integer>> entry : shortestPaths.entrySet()) {
			System.out.println(entry.getValue());
		}
	}
}
