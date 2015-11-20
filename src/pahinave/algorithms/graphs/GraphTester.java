package pahinave.algorithms.graphs;

import java.util.Random;

public class GraphTester {

	public static void main(String[] args) {
		testAdjacencyGraph();
	}

	private static void testAdjacencyGraph() {
		Graph<Integer, Integer> graph = null;
		graph = testGraph(true);
		graph = testGraph(false);
		

	}

	private static Graph<Integer, Integer> testGraph(boolean directed) {
		System.out.println("======== TESTING GRAPH WITH directed set to " + directed + " =============");
		Graph<Integer, Integer> graph = new AdjacencyGraph<>(directed);

		Random weight = new Random();

		Vertex<Integer> v1 = graph.addVertex("1", weight.nextInt(10));
		Vertex<Integer> v2 = graph.addVertex("2", weight.nextInt(10));
		Vertex<Integer> v3 = graph.addVertex("3", weight.nextInt(10));
		Vertex<Integer> v4 = graph.addVertex("4", weight.nextInt(10));
		Vertex<Integer> v5 = graph.addVertex("5", weight.nextInt(10));

		graph.addEdge(new Edge<>(v1, v2, weight.nextInt(10)));
		graph.addEdge(new Edge<>(v1, v4, weight.nextInt(10)));
		graph.addEdge(new Edge<>(v1, v1, weight.nextInt(10)));
		graph.addEdge(new Edge<>(v1, v1, weight.nextInt(10)));
		graph.addEdge(new Edge<>(v2, v3, weight.nextInt(10)));
		graph.addEdge(new Edge<>(v3, v4, weight.nextInt(10)));
		graph.addEdge(new Edge<>(v4, v1, weight.nextInt(10)));
		graph.addEdge(new Edge<>(v1, v3, weight.nextInt(10)));
		graph.addEdge(new Edge<>(v4, v2, weight.nextInt(10)));
		graph.addEdge(new Edge<>(v4, v5, weight.nextInt(10)));

		graph.showNeighbors();
		
		System.out.println("Edges between vertices v1 and v4");
		for(Edge<Integer, Integer> edge : graph.findAllEdges(v1, v4)) {
			System.out.println(edge);
		}

		System.out.println("Edges between vertices v1 and v1");
		for(Edge<Integer, Integer> edge : graph.findAllEdges(v1, v1)) {
			System.out.println(edge);
		}
		
		return graph;
	}

}
