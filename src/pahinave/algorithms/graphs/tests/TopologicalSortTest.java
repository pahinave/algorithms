package pahinave.algorithms.graphs.tests;

import java.util.List;

import org.junit.Test;

import pahinave.algorithms.graphs.AdjacencyGraph;
import pahinave.algorithms.graphs.Edge;
import pahinave.algorithms.graphs.Graph;
import pahinave.algorithms.graphs.Vertex;

public class TopologicalSortTest {
	@Test
	public void test() {
		// topological sort not appliable for undirected graph
		Graph<Integer, Integer> graph = new AdjacencyGraph<>(true);

		Vertex<Integer> v1 = graph.addVertex("1");
		Vertex<Integer> v2 = graph.addVertex("2");
		Vertex<Integer> v3 = graph.addVertex("3");
		Vertex<Integer> v4 = graph.addVertex("4");
		Vertex<Integer> v5 = graph.addVertex("5");

		graph.addEdge(new Edge<>(v1, v2));
		graph.addEdge(new Edge<>(v2, v4));
		graph.addEdge(new Edge<>(v4, v5));
		graph.addEdge(new Edge<>(v1, v3));
		graph.addEdge(new Edge<>(v3, v5));
		graph.addEdge(new Edge<>(v3, v4));

		graph.showVertexEdgesView();

		List<Vertex<Integer>> sorted = graph.topologicalSort();
		System.out.print("Topological sort: ");
		sorted.forEach(System.out::print);

	}
}
