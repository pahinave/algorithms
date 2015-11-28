package pahinave.algorithms.graphs;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

import pahinave.algorithms.datastructures.UnionFind;

public class KruskalMST {

	public <T, S extends Comparable<S>> Graph<T, S> mst(Graph<T, S> graph, Vertex<T> start) {

		// MST not supported for directed graphs
		if (graph.isDirected()) {
			return null;
		}

		Graph<T, S> result = new AdjacencyGraph<>();
		UnionFind<Vertex<T>> unionFind = new UnionFind<>();

		for (Vertex<T> v : graph.vertices()) {
			result.addVertex(v);
			unionFind.addLeader(v);
		}
		unionFind.show();

		Queue<Edge<T, S>> edgeQueue = new PriorityQueue<>(Comparator.comparing(Edge::getTag));
		for (Edge<T, S> edge : graph.getAllEdges()) {
			edgeQueue.add(edge);
		}

		int nVertices = 0;
		while (edgeQueue.size() > 0 && nVertices < graph.vertexCount()) {

			Edge<T, S> nextEdge = edgeQueue.remove();
			if (unionFind.memberOfDiffComponents(nextEdge.getFrom(), nextEdge.getTo())) {
				result.addEdge(nextEdge);
				unionFind.union(nextEdge.getFrom(), nextEdge.getTo());
			}
			unionFind.show();
		}
		System.out.println("MST Found after scanning number of edges = " + (graph.edgeCount() - edgeQueue.size())
				+ " (out of " + graph.edgeCount() + ")");

		return result;
	}
}
