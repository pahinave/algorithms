package pahinave.algorithms.graphs;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.Collectors;

public class PrimMST {
	public <T, S extends Comparable<S>> Graph<T, S> slowMst(Graph<T, S> graph, Vertex<T> start) {

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

	public <T, S extends Comparable<S>> Graph<T, S> mst(Graph<T, S> graph, Vertex<T> start) {
		// TODO Auto-generated method stub

		class QueueNode implements Comparable<QueueNode> {
			Vertex<T> vertex;
			Edge<T, S> edge;

			public Vertex<T> getVertex() {
				return vertex;
			}

			public Edge<T, S> getEdge() {
				return edge;
			}

			public void setEdge(Edge<T, S> edge) {
				this.edge = edge;
			}

			public QueueNode(Vertex<T> vertex, Edge<T, S> edge) {
				super();
				this.vertex = vertex;
				this.edge = edge;
			}

			public int compareTo(QueueNode o) {
				if (this.getEdge() == null && o.getEdge() == null) {
					return 0;
				} else if (this.getEdge() == null) {
					return 1; // vertices with null edges in node dont cross the
								// cut
				} else if (o.getEdge() == null) {
					return -1;
				} else {
					return this.getEdge().getTag().compareTo(o.getEdge().getTag());
				}
			}

			@Override
			public String toString() {
				return "QueueNode [vertex=" + vertex + ", edge=" + edge + "]";
			};

		}

		// minimum spanning tree"/graph"
		Graph<T, S> result = new AdjacencyGraph<>();

		// vertex to QueueNode map - stores the QueueNodes for the
		// vertices which are not yet added to the MST
		// This map is referred while updating the min edges for
		// non-visited vertices (to easily remove object / add updated
		// object to the priority queue)
		Map<Vertex<T>, QueueNode> vertexQueueNodeMap = new HashMap<>();

		// Priority queue of the vertices not yet added to the mst
		// ordered as per the weight of min-edge(so far) incident
		// on that vertex
		Queue<QueueNode> queue = new PriorityQueue<>();
		for (Vertex<T> v : graph.vertices()) {
			result.addVertex(v);

			// "start" need not be added to the queue/map
			if (v == start)
				continue;
			// Initially add non-start vertices min edge
			// set to null
			QueueNode qn = new QueueNode(v, null);
			vertexQueueNodeMap.put(v, qn);
			queue.add(qn);
		}

		Vertex<T> nextVertex = null;
		for (int i = 0; i < graph.vertexCount(); i++) {

			if (i == 0) {
				nextVertex = start;
			} else {
				QueueNode minQueueNode = queue.remove();
				System.out.println("Next queue node: " + minQueueNode);

				nextVertex = minQueueNode.getVertex();
				result.addEdge(minQueueNode.getEdge());

				// the vertex from min queue node should not be
				// visited again, so remove it from map
				// so that progream does not update its min edge
				vertexQueueNodeMap.remove(nextVertex);
			}

			for (Edge<T, S> edge : graph.getEdges(nextVertex)) {
				System.out.println("Checking next outbound edge from " + nextVertex);
				QueueNode qn = vertexQueueNodeMap.get(edge.getTo(nextVertex));
				System.out.println(edge);
				System.out.println(qn);
				if (qn != null) { // vertex in qn is not added to mst
					// edge for qn may be infinity (does not exist)
					// or bigger than current edge
					if (qn.getEdge() == null || edge.getTag().compareTo(qn.getEdge().getTag()) < 0) {
						System.out.println("** Min edge changed to " + edge);
						queue.remove(qn);
						qn.setEdge(edge);
						queue.add(qn);
					}
				}
			}
		}

		return result;
	}

}
