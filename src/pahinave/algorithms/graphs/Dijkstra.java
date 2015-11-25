package pahinave.algorithms.graphs;

import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.function.BinaryOperator;

public class Dijkstra<T, S extends Comparable<S>> {

	public HashMap<Vertex<T>, PathInfo<T, S>> singleSourceShortedPath(Graph<T, S> graph, Vertex<T> source,
			S sourceLength, BinaryOperator<S> edgeMergeOpearator) {

		if (graph.isDirected() == false) {
			return null;
		}

		graph.unexploreAll();

		HashMap<Vertex<T>, PathInfo<T, S>> pathInfoMap = new HashMap<>();
		Queue<PathInfo<T, S>> priorityQueue = new PriorityQueue<>();

		// path info for starting vertex
		PathInfo<T, S> forSource = new PathInfo<T, S>(source, sourceLength, null);
		priorityQueue.add(forSource);
		pathInfoMap.put(source, forSource);
		source.markExplored();

		while (priorityQueue.isEmpty() == false) {

			// Find the vertex with smallest path length
			// (it will be at front of the queue)
			PathInfo<T, S> pathInfo = priorityQueue.remove();
			pathInfo.getVertex().markExplored();

			for (Edge<T, S> edge : graph.getEdges(pathInfo.getVertex())) {

				// Try to find path for length for vertex at the end
				// of the edge only if the vertex shortest path is not
				// found yet (i.e. not explored)
				if (edge.getTo().isNotExplored()) {

					// newLength is the length of the path if this edge
					// is part of path
					S newLength = edgeMergeOpearator.apply(pathInfo.getLength(), edge.getTag());

					// check if some other path exist for the to vertex,
					// and if exist, remove path if its length is bigger than
					// new path length
					PathInfo<T, S> oldPathInfo = pathInfoMap.get(edge.getTo());
					if (oldPathInfo != null) {
						if (oldPathInfo.getLength().compareTo(newLength) < 0) {
							// old path length is smaller than new path length,
							// continue without revising path length
							continue;
						} else {
							// old path length is bigger than new path length,
							// remove the old path info from the priority queue
							priorityQueue.remove(oldPathInfo);
						}
					}

					// update path info map with new/revised path and also add
					// new/revised path to the priority queue
					PathInfo<T, S> newPathInfo = new PathInfo<T, S>(edge.getTo(), newLength, pathInfo.getVertex());
					pathInfoMap.put(edge.getTo(), newPathInfo);
					priorityQueue.add(newPathInfo);
				}
			}
		}

		graph.unexploreAll();

		return pathInfoMap;
	}

}
