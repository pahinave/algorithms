package pahinave.algorithms.graphs;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class KruskalMST {
	public <T, S extends Comparable<S>> Graph<T, S> slowMst(Graph<T, S> graph, Vertex<T> start) {

		// MST not supported for directed graphs
		if (graph.isDirected()) {
			return null;
		}

		Graph<T, S> result = new AdjacencyGraph<>();

		for (Vertex<T> v : graph.vertices()) {
			result.addVertex(v);
		}

		Queue<Edge<T, S>> edgeQueue = new PriorityQueue<>(Comparator.comparing(Edge::getTag));
		for (Edge<T, S> edge : graph.getAllEdges()) {
			edgeQueue.add(edge);
		}

		result.unexploreAll();

		while (edgeQueue.size() > 0) {
			Edge<T, S> nextEdge = edgeQueue.remove();
			if (nextEdge.getFrom().isNotExplored() || nextEdge.getTo().isNotExplored()) {
				result.addEdge(nextEdge);
				nextEdge.getFrom().markExplored();
				nextEdge.getTo().markExplored();
			}
		}

		return result;
	}
}
