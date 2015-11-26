package pahinave.algorithms.graphs;

import java.util.Comparator;
import java.util.stream.Collectors;

public class PrimMST {
	public <T, S extends Comparable<S>> Graph<T, S> mst(Graph<T, S> graph, Vertex<T> start) {

		// mst only support undirected graphs
		if (graph.isDirected()) {
			return null;
		}
		Graph<T, S> result = new AdjacencyGraph<>();

		result.addVertex(start);
		start.markExplored();
		for (int i = 1; i < graph.vertexCount(); i++) {
			Edge<T, S> nextEdge = result.vertices().stream().map(v -> graph.getEdges(v)).flatMap(s -> s.stream())
					.filter(e -> e.getFrom().isNotExplored() || e.getTo().isNotExplored())
					.sorted(Comparator.comparing(Edge::getTag)).limit(1).collect(Collectors.toList()).get(0);

			if (nextEdge.getFrom().isNotExplored()) {
				nextEdge.getFrom().markExplored();
				result.addVertex(nextEdge.getFrom());
			}

			if (nextEdge.getTo().isNotExplored()) {
				nextEdge.getTo().markExplored();
				result.addVertex(nextEdge.getTo());
			}

			result.addEdge(nextEdge);

		}

		return result;
	}
}
