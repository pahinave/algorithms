package pahinave.algorithms.graphs.tests;

import pahinave.algorithms.graphs.AdjacencyGraph;
import pahinave.algorithms.graphs.Edge;
import pahinave.algorithms.graphs.Graph;
import pahinave.algorithms.graphs.GraphContraction;
import pahinave.algorithms.graphs.Vertex;

public class GraphContractionTest {

	public static void main(String[] args) {
		 testGraphContraction(false);
		//testGraphContraction(true);

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

		// NOTE2 - Marker start
		// If this block is enabled and NOTE3 block is disabled
		// then graph is disconnected into two groups
		// v1 to v4 and v5 to v8. Program should output
		// graph is disconnected, so no cut can be found

//		 Vertex<Integer> v5 = graph.addVertex("5", 5);
//		 Vertex<Integer> v6 = graph.addVertex("6", 6);
//		 Vertex<Integer> v7 = graph.addVertex("7", 7);
//		 Vertex<Integer> v8 = graph.addVertex("8", 8);
//		
//		 graph.addEdge(new Edge<>(v5, v6, 10));
//		 graph.addEdge(new Edge<>(v6, v7, 11));
//		 graph.addEdge(new Edge<>(v8, v7, 12));
//		 graph.addEdge(new Edge<>(v8, v5, 13));
//		 graph.addEdge(new Edge<>(v6, v8, 14));

		// NOTE2 - Marker end

		// NOTE3 - Marker start
		// If note 2 block is enabled and NOTE3 block
		// is enabled, then below edge connects
		// two disconnected graphs and you will find
		// a cut

//		 graph.addEdge(new Edge<>(v4, v5, 15));

		// NOTE3 - Marker end

		graph.showVertexEdgesView();

		GraphContraction<Integer, Integer> graphContraction = new GraphContraction<>();
		graphContraction.contract(graph, Integer::sum, (s1, s2) -> s1 + "," + s2);

		System.out.println("Graph after contraction ...");
		graph.showVertexEdgesView();

		if (graph.edgeCount() == 0) {
			System.out.println("Graph is disconnected");
		}

		return graph;
	}
}
