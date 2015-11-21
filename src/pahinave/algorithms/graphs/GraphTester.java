package pahinave.algorithms.graphs;

import java.util.Random;

public class GraphTester {

	public static void main(String[] args) {
		testAdjacencyGraph();
	}

	private static void testAdjacencyGraph() {
		// testGraph(true);
		 testGraph(false);
		//testGraphContraction(false);
		testGraphContraction(true);
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
		graph.addEdge(new Edge<>(v1, v3, weight.nextInt(10)));
		graph.addEdge(new Edge<>(v1, v4, weight.nextInt(10)));
		graph.addEdge(new Edge<>(v2, v3, weight.nextInt(10)));
		graph.addEdge(new Edge<>(v3, v4, weight.nextInt(10)));
		graph.addEdge(new Edge<>(v3, v4, weight.nextInt(10)));
		graph.addEdge(new Edge<>(v4, v3, weight.nextInt(10)));
		graph.addEdge(new Edge<>(v4, v1, weight.nextInt(10)));
		graph.addEdge(new Edge<>(v4, v2, weight.nextInt(10)));
		graph.addEdge(new Edge<>(v4, v5, weight.nextInt(10)));

		graph.showVertexEdgesView();

		// remove edges between v1 and v4
		graph.removeEdge(graph.getAllEdges().get(0));
		graph.showVertexEdgesView();

		graph.removeEdges(v1, v1);
		graph.showVertexEdgesView();

		graph.removeEdges(v3, v4);
		graph.showVertexEdgesView();

		graph.removeVertex(v2);
		graph.showVertexEdgesView();

		return graph;
	}

	private static Graph<Integer, Integer> testGraphContraction(boolean directed) {
		System.out.println("======== TESTING GRAPH CONTRACTION WITH directed set to " + directed + " =============");
		Graph<Integer, Integer> graph = new AdjacencyGraph<>(directed);

		Vertex<Integer> v1 = graph.addVertex("1", 1);
		Vertex<Integer> v2 = graph.addVertex("2", 2);
		Vertex<Integer> v3 = graph.addVertex("3", 3);
		Vertex<Integer> v4 = graph.addVertex("4", 4);

		graph.addEdge(new Edge<>(v1, v2, 5));
		graph.addEdge(new Edge<>(v2, v3, 6));
		graph.addEdge(new Edge<>(v4, v3, 7));
		graph.addEdge(new Edge<>(v4, v1, 8));
		graph.addEdge(new Edge<>(v2, v4, 9));

		graph.showVertexEdgesView();

		GraphContraction<Integer, Integer> graphContraction = new GraphContraction<>();
		graphContraction.contract(graph,
				Integer::sum,
				(s1, s2) -> s1 + "," + s2);

		System.out.println("Graph after contraction ...");
		graph.showVertexEdgesView();

		return graph;
	}

}
