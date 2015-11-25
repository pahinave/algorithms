package pahinave.algorithms.graphs;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BinaryOperator;

public class BellmanFord {
	public <T, S extends Comparable<S>> Map<Vertex<T>, PathInfo<T, S>> singleSourceShortestPath(Graph<T, S> graph,
			Vertex<T> start, S zero, S infinity, BinaryOperator<S> edgeLengthAdder) {

		Map<Vertex<T>, PathInfo<T, S>> pathInfo = new HashMap<>();

		for (Vertex<T> v : graph.vertices()) {
			pathInfo.put(v, new PathInfo<T, S>(v, infinity, null));
		}

		pathInfo.get(start).setLength(zero);

		for (int i = 0; i < graph.vertexCount() - 1; i++) {
			// relax each edge and check if the revised path
			// length is less than current path length for 
			// edge's "TO" vertex
			for (Edge<T, S> edge : graph.getAllEdges()) {
				PathInfo<T, S> fromPathInfo = pathInfo.get(edge.getFrom());
				PathInfo<T, S> toPathInfo = pathInfo.get(edge.getTo());				
				S newLength = edgeLengthAdder.apply(fromPathInfo.getLength(), edge.getTag());
				S oldLength = toPathInfo.getLength();
				if (newLength.compareTo(oldLength) < 0) {
					toPathInfo.setLength(newLength);
					toPathInfo.setPrevious(edge.getFrom());
				}
			}
		}

		// Check if we "simulate" relaxing of each edge one
		// more time will reduce length of any path. If yes,
		// then there is negative weight cycle
		for (Edge<T, S> edge : graph.getAllEdges()) {
			PathInfo<T, S> fromPathInfo = pathInfo.get(edge.getFrom());
			PathInfo<T, S> toPathInfo = pathInfo.get(edge.getTo());
			S newLength = edgeLengthAdder.apply(fromPathInfo.getLength(), edge.getTag());
			S oldLength = toPathInfo.getLength();
			if (newLength.compareTo(oldLength) < 0) {
				System.out.println("Negative weight cycle exists in graph");
			}
		}

		return pathInfo;

	}
}
