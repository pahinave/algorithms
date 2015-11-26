package pahinave.algorithms.graphs.tests;

import static org.junit.Assert.assertNull;

import org.junit.Assert;
import org.junit.Test;

import pahinave.algorithms.graphs.AdjacencyGraph;
import pahinave.algorithms.graphs.Edge;
import pahinave.algorithms.graphs.Graph;
import pahinave.algorithms.graphs.PrimMST;
import pahinave.algorithms.graphs.Vertex;

public class PrimMSTTest {
	@Test
	public void testPrimMST() throws Exception {
		Graph<Integer, Integer> graph = new AdjacencyGraph<>();

		Vertex<Integer> v1 = new Vertex<>("one");
		Vertex<Integer> v2 = new Vertex<>("two");
		Vertex<Integer> v3 = new Vertex<>("three");
		Vertex<Integer> v4 = new Vertex<>("four");

		graph.addVertex(v1);
		graph.addVertex(v2);
		graph.addVertex(v3);
		graph.addVertex(v4);

		graph.addEdge(new Edge<>(v1, v2, 1));
		graph.addEdge(new Edge<>(v2, v3, 2));
		graph.addEdge(new Edge<>(v1, v3, 3));
		graph.addEdge(new Edge<>(v1, v4, 4));
		graph.addEdge(new Edge<>(v4, v3, 5));

		PrimMST p = new PrimMST();
		Graph<Integer, Integer> mst = p.mst(graph, v1);
		Assert.assertNotNull(mst);

		mst.showVertexEdgesView();

		Integer edgeWeightSum = mst.getAllEdges().stream().map(Edge::getTag).reduce(Integer::sum).get();
		System.out.println("Total edge weight: " + edgeWeightSum);
		Assert.assertEquals(7, edgeWeightSum.intValue());
	}

	@Test
	public void testPrimMST2() throws Exception {
		Graph<Integer, Integer> graph = new AdjacencyGraph<>();

		Vertex<Integer> v1 = new Vertex<>("one");
		Vertex<Integer> v2 = new Vertex<>("two");
		Vertex<Integer> v3 = new Vertex<>("three");
		Vertex<Integer> v4 = new Vertex<>("four");

		graph.addVertex(v1);
		graph.addVertex(v2);
		graph.addVertex(v3);
		graph.addVertex(v4);

		graph.addEdge(new Edge<>(v1, v2, 1));
		graph.addEdge(new Edge<>(v2, v3, 2));
		graph.addEdge(new Edge<>(v1, v3, 1));
		graph.addEdge(new Edge<>(v1, v4, 4));
		graph.addEdge(new Edge<>(v4, v3, 5));

		PrimMST p = new PrimMST();
		Graph<Integer, Integer> mst = p.mst(graph, v1);

		Assert.assertNotNull(mst);
		mst.showVertexEdgesView();

		Integer edgeWeightSum = mst.getAllEdges().stream().map(Edge::getTag).reduce(Integer::sum).get();
		System.out.println("Total edge weight: " + edgeWeightSum);
		Assert.assertEquals(6, edgeWeightSum.intValue());
	}

	@Test
	public void mstNotSupportedForDirected() throws Exception {
		Graph<Integer, Integer> graph = new AdjacencyGraph<>(true);

		Vertex<Integer> v1 = graph.addVertex("one");

		PrimMST m = new PrimMST();
		Graph<Integer, Integer> mst = m.mst(graph, v1);

		assertNull(mst);
	}
}
