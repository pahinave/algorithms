package pahinave.algorithms.graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class AdjacencyGraph<T, S> implements Graph<T, S> {
	// TODO: should vertex name be key?
	// will it improve the lookup time by reducing the hash value generation
	Map<Vertex<T>, List<Edge<T, S>>> adjList;
	Map<Vertex<T>, List<Edge<T, S>>> incomingEdgeList;
	List<Edge<T, S>> edges;
	Map<String, Vertex<T>> vertexNameMap;
	final boolean directed;

	public AdjacencyGraph() {
		this(false);
	}

	public AdjacencyGraph(boolean directed) {
		adjList = new HashMap<>();
		vertexNameMap = new HashMap<>();
		edges = new ArrayList<>();
		this.directed = directed;
		if (directed) {
			incomingEdgeList = new HashMap<>();
		}
	}

	@Override
	public void addVertex(Vertex<T> vertex) {
		adjList.put(vertex, new ArrayList<Edge<T, S>>());
		vertexNameMap.put(vertex.getName(), vertex);
	}

	@Override
	public Vertex<T> addVertex(String name, T obj) {
		Vertex<T> vertex = new Vertex<>(name, obj);
		addVertex(vertex);
		return vertex;
	}

	@Override
	public void addEdge(Edge<T, S> edge) {
		List<Edge<T, S>> fromList = adjList.computeIfAbsent(edge.getFrom(), v1 -> new ArrayList<>());
		List<Edge<T, S>> toList = adjList.computeIfAbsent(edge.getTo(), v1 -> new ArrayList<>());

		fromList.add(edge);
		edges.add(edge);

		// edge should be checked if its directed
		// or we should not allow user to create and add edge,
		// we should accept the vertices and return the created edge
		if (edge.getFrom() != edge.getTo()) {
			if (!directed) {
				toList.add(edge);
			} else if (directed) {
				List<Edge<T, S>> incomingList = incomingEdgeList.computeIfAbsent(edge.getTo(), v1 -> new ArrayList<>());
				incomingList.add(edge);
			}
		}
	}

	@Override
	public Vertex<T> getVertex(String name) {
		return vertexNameMap.get(name);
	}

	@Override
	public List<Edge<T, S>> getEdges(Vertex<T> vertex) {
		// TODO dont return original list
		return Collections.unmodifiableList(adjList.get(vertex));
	}

	@Override
	public void removeEdge(Edge<T, S> edge) {

		// TODO can it be made faster
		if (edges.contains(edge) == false) {
			return;
		}

		// TODO set vertex refereces to null or else object
		// may not get released
		adjList.get(edge.getFrom()).remove(edge);
		// System.out.println("removed from" + edge.getFrom());
		if (edge.getFrom() != edge.getTo()) {
			if (!directed) {
				adjList.get(edge.getTo()).remove(edge);
				// System.out.println("removed to not directed" + edge.getTo());
			} else if (directed) {
				// System.out.println("removed to incoming" + edge.getFrom());
				incomingEdgeList.get(edge.getTo()).remove(edge);
			}
		}

		edges.remove(edge);
	}

	@Override
	public Vertex<T> addVertex(String name) {
		Vertex<T> vertex = new Vertex<>(name);
		addVertex(vertex);
		return vertex;
	}

	@Override
	public void showVertexEdgesView() {
		System.out.println("Vertex - Edges view");
		for (Map.Entry<Vertex<T>, List<Edge<T, S>>> entry : adjList.entrySet()) {

			System.out.println(entry.getKey());
			for (Edge<T, S> edge : entry.getValue()) {
				System.out.println(edge);
			}
		}
	}

	public boolean isDirected() {
		return directed;
	}

	@Override
	public void addAllVertices(List<Vertex<T>> vertices) {
		for (Vertex<T> vertex : vertices) {
			this.addVertex(vertex);
		}

	}

	@Override
	public void addAllEdges(List<Edge<T, S>> edges) {
		for (Edge<T, S> edge : edges) {
			this.addEdge(edge);
		}

	}

	@Override
	public List<Edge<T, S>> findAllEdges(Vertex<T> from, Vertex<T> to) {
		return findEdges(from, to, -1);
	}

	@Override
	public List<Edge<T, S>> findEdges(Vertex<T> from, Vertex<T> to, int limit) {

		List<Edge<T, S>> foundEdges = null;

		Predicate<Edge<T, S>> edgeFilter = null;
		if (directed) {
			edgeFilter = e -> e.getTo() == to;
		} else {
			edgeFilter = e -> ((e.getFrom() == from && e.getTo() == to) || (e.getFrom() == to && e.getTo() == from));
		}

		if (limit > 0) {
			foundEdges = adjList.get(from).stream().filter(edgeFilter).limit(limit).collect(Collectors.toList());
		} else {
			foundEdges = adjList.get(from).stream().filter(edgeFilter).collect(Collectors.toList());
		}

		return foundEdges;

	}

	@Override
	public void removeEdges(Vertex<T> from, Vertex<T> to) {
		for (Edge<T, S> edge : findAllEdges(from, to)) {
			removeEdge(edge);
		}
	}

	@Override
	public void removeVertex(Vertex<T> vertex) {
		List<Edge<T, S>> edgesToRemove = new ArrayList<>(adjList.get(vertex));
		if (directed) {
			edgesToRemove.addAll(incomingEdgeList.computeIfAbsent(vertex, v -> Collections.<Edge<T, S>> emptyList()));
		}

		for (Edge<T, S> edge : edgesToRemove) {
			removeEdge(edge);
		}

		vertexNameMap.remove(vertex);
		adjList.remove(vertex);
		if (directed) {
			incomingEdgeList.remove(vertex);
		}
	}

	@Override
	public int vertexCount() {
		return adjList.size();
	}

	@Override
	public int edgeCount() {
		return edges.size();
	}

	@Override
	public List<Edge<T, S>> getAllEdges() {
		return Collections.unmodifiableList(edges);
	}

	@Override
	public List<Edge<T, S>> getIncomingDirectedEdges(Vertex<T> vertex) {
		if (directed) {
			return incomingEdgeList.computeIfAbsent(vertex, v -> Collections.<Edge<T, S>> emptyList());
		}
		return Collections.<Edge<T, S>> emptyList();
	}

	@Override
	public List<Vertex<T>> bfs(Vertex<T> start) {
		return bfsAndDfs(start, q -> q.removeFirst());
	}

	@Override
	public List<Vertex<T>> dfs(Vertex<T> start) {
		return bfsAndDfs(start, q -> q.removeLast());
	}

	public List<Vertex<T>> bfsAndDfs(Vertex<T> start, Function<LinkedList<Vertex<T>>, Vertex<T>> nextVertexSelector) {
		List<Vertex<T>> visitOrder = new LinkedList<>();
		LinkedList<Vertex<T>> queue = new LinkedList<>();

		// reset explore status of edges and vertices
		this.unexploreAll();

		// visit start
		start.markExplored();
		queue.add(start);

		while (queue.isEmpty() == false) {
			Vertex<T> nextVertexToVisit = nextVertexSelector.apply(queue);
			visitOrder.add(nextVertexToVisit);

			for (Edge<T, S> edge : this.getEdges(nextVertexToVisit)) {
				if (edge.isExplored()) {
					continue;
				} else {
					edge.markExplored();
				}
				// no need to check for null,
				// as the from vertex is taken from edge
				Vertex<T> otherEnd = edge.getTo(nextVertexToVisit);
				if (otherEnd.isNotExplored()) {
					otherEnd.markExplored();
					queue.addLast(otherEnd);
				}
			}
		}

		this.unexploreAll();
		return visitOrder;
	}

	@Override
	public void unexploreAll() {
		unexploreEdges();
		unexploreVertices();
	}

	@Override
	public void unexploreVertices() {
		for (Vertex<T> v : this.adjList.keySet()) {
			v.unExplore();
		}
	}

	@Override
	public void unexploreEdges() {
		for (Edge<T, S> edge : this.getAllEdges()) {
			edge.unExplore();
		}

	}

	@Override
	public Map<Vertex<T>, Integer> shortestPaths(Vertex<T> start) {
		Map<Vertex<T>, Integer> shortedPathDistances = new HashMap<>();
		LinkedList<Vertex<T>> queue = new LinkedList<>();

		// reset explore status of edges and vertices
		this.unexploreAll();

		// visit start
		start.markExplored();
		queue.add(start);
		shortedPathDistances.put(start, 0);

		while (queue.isEmpty() == false) {
			Vertex<T> nextVertexToVisit = queue.removeFirst();

			for (Edge<T, S> edge : this.getEdges(nextVertexToVisit)) {
				if (edge.isExplored()) {
					continue;
				} else {
					edge.markExplored();
				}
				// no need to check for null,
				// as the from vertex is taken from edge
				Vertex<T> otherEnd = edge.getTo(nextVertexToVisit);
				if (otherEnd.isNotExplored()) {
					shortedPathDistances.put(otherEnd, shortedPathDistances.get(nextVertexToVisit) + 1);
					otherEnd.markExplored();
					queue.addLast(otherEnd);
				}
			}
		}

		this.unexploreAll();
		return shortedPathDistances;
	}

}
