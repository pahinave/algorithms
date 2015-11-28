package pahinave.algorithms.graphs.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import pahinave.algorithms.graphs.AdjacencyGraph;
import pahinave.algorithms.graphs.Edge;
import pahinave.algorithms.graphs.Graph;
import pahinave.algorithms.graphs.KruskalMST;
import pahinave.algorithms.graphs.Vertex;

public class KruskalMSTTest {
	@Test
	public void testKruskalMST() throws Exception {
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

		KruskalMST p = new KruskalMST();
		Graph<Integer, Integer> mst = p.mst(graph, v1);
		Assert.assertNotNull(mst);

		mst.showVertexEdgesView();

		Integer edgeWeightSum = mst.getAllEdges().stream().map(Edge::getTag).reduce(Integer::sum).get();
		System.out.println("Total edge weight: " + edgeWeightSum);
		Assert.assertEquals(7, edgeWeightSum.intValue());
	}

	@Test
	public void testKruskalMST2() throws Exception {
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

		KruskalMST p = new KruskalMST();
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

		KruskalMST m = new KruskalMST();
		Graph<Integer, Integer> mst = m.mst(graph, v1);

		assertNull(mst);
	}

	@Test
	public void testName() throws Exception {
		Graph<Integer, Integer> graph = new AdjacencyGraph<>();

		Vertex<Integer> a = new Vertex<>("A");
		Vertex<Integer> b = new Vertex<>("B");
		Vertex<Integer> c = new Vertex<>("C");
		Vertex<Integer> d = new Vertex<>("D");
		Vertex<Integer> e = new Vertex<>("E");
		Vertex<Integer> f = new Vertex<>("F");
		Vertex<Integer> g = new Vertex<>("G");
		Vertex<Integer> h = new Vertex<>("H");

		Edge<Integer, Integer> edgeAB = graph.addEdge(new Edge<>(a, b, 1));
		Edge<Integer, Integer> edgeBC = graph.addEdge(new Edge<>(b, c, 3));
		Edge<Integer, Integer> edgeAE = graph.addEdge(new Edge<>(a, e, 2));
		graph.addEdge(new Edge<>(e, d, 5)); // Edge<Integer, Integer> edgeED =
											// graph.addEdge(new Edge<>(e, d,
											// 5));
		Edge<Integer, Integer> edgeEH = graph.addEdge(new Edge<>(e, h, 6));
		graph.addEdge(new Edge<>(a, g, 10)); // Edge<Integer, Integer> edgeAG =
												// graph.addEdge(new Edge<>(a,
												// g, 10));
		Edge<Integer, Integer> edgeGF = graph.addEdge(new Edge<>(g, f, 9));
		Edge<Integer, Integer> edgeCD = graph.addEdge(new Edge<>(c, d, 4));
		graph.addEdge(new Edge<>(d, h, 8)); // Edge<Integer, Integer> edgeDH =
											// graph.addEdge(new Edge<>(d, h,
											// 8));
		Edge<Integer, Integer> edgeHF = graph.addEdge(new Edge<>(h, f, 7));

		graph.showVertexEdgesView();

		KruskalMST m = new KruskalMST();
		Graph<Integer, Integer> result = m.mst(graph, a);
		System.out.println("===== Minimum Spanning tree =====");
		result.showVertexEdgesView(true);

		assertEquals(graph.vertexCount(), result.vertexCount());

		List<Edge<Integer, Integer>> resultEdges = result.getAllEdges();
		assertEquals(graph.vertexCount() - 1, resultEdges.size());
		assertEquals(true, resultEdges.contains(edgeAB));
		assertEquals(true, resultEdges.contains(edgeBC));
		assertEquals(true, resultEdges.contains(edgeCD));
		assertEquals(true, resultEdges.contains(edgeAE));
		assertEquals(true, resultEdges.contains(edgeEH));
		assertEquals(true, resultEdges.contains(edgeHF));
		assertEquals(true, resultEdges.contains(edgeGF));

	}

	@Test
	public void testLineGraph() throws Exception {

		Graph<Integer, Integer> graph = new AdjacencyGraph<>();

		Vertex<Integer> a = new Vertex<>("A");
		Vertex<Integer> b = new Vertex<>("B");
		Vertex<Integer> c = new Vertex<>("C");
		Vertex<Integer> d = new Vertex<>("D");

		Edge<Integer, Integer> edgeAB = graph.addEdge(new Edge<>(a, b, 1));
		Edge<Integer, Integer> edgeBC = graph.addEdge(new Edge<>(b, c, 3));
		Edge<Integer, Integer> edgeCD = graph.addEdge(new Edge<>(c, d, 2));

		graph.showVertexEdgesView();

		KruskalMST m = new KruskalMST();
		Graph<Integer, Integer> result = m.mst(graph, a);
		System.out.println("===== Minimum Spanning tree FAIL =====");
		result.showVertexEdgesView(true);

		assertEquals(graph.vertexCount(), result.vertexCount());

		List<Edge<Integer, Integer>> resultEdges = result.getAllEdges();
		assertEquals(graph.vertexCount() - 1, resultEdges.size());
		assertEquals(true, resultEdges.contains(edgeAB));
		assertEquals(true, resultEdges.contains(edgeBC));
		assertEquals(true, resultEdges.contains(edgeCD));

	}
}
