package pahinave.algorithms.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdjacencyGraph<T, S> implements Graph<T, S> {
	Map<Vertex<T>, List<Edge<T, S>>> adjList;
	Map<String, Vertex<T>> vertexNameMap;
	boolean directed;

	public AdjacencyGraph() {
		adjList = new HashMap<>();
		vertexNameMap = new HashMap<>();
	}

	@Override
	public void addVertex(Vertex<T> vertex) {
		adjList.put(vertex, new ArrayList<Edge<T, S>>());
		vertexNameMap.put(vertex.getName(), vertex);
	}

	@Override
	public Vertex<T> addVertex(String name, T obj) {
		Vertex<T> vertex = new Vertex<>(name, obj);
		adjList.put(vertex, new ArrayList<Edge<T, S>>());
		vertexNameMap.put(name, vertex);
		return vertex;
	}

	@Override
	public void addEdge(Edge<T, S> edge) {
		adjList.computeIfAbsent(edge.getFrom(), v1 -> new ArrayList<>());
		adjList.computeIfAbsent(edge.getTo(), v1 -> new ArrayList<>());

		adjList.get(edge.getFrom()).add(edge);
		if (!directed && edge.getFrom() != edge.getTo()) {
			adjList.get(edge.getTo()).add(edge.reverse());
		}
	}

	@Override
	public Vertex<T> getVertex(String name) {
		return vertexNameMap.get(name);
	}

	@Override
	public List<Edge<T, S>> getEdges(Vertex<T> vertex) {
		return adjList.get(vertex);
	}

	@Override
	public void removeEdge(Edge<T, S> edge) {
		adjList.get(edge.getFrom()).remove(edge);

		// TODO: what if there are parallel edges
		if (!directed) {
			adjList.get(edge.getTo()).remove(edge.reverse());
		}
	}

	@Override
	public Vertex<T> addVertex(String name) {
		Vertex<T> vertex = new Vertex<>(name);
		addVertex(vertex);
		return vertex;
	}

	@Override
	public void showNeighbors() {
		System.out.println("Neighbors in adjacency graph");
		for (Map.Entry<Vertex<T>, List<Edge<T, S>>> entry : adjList.entrySet()) {

			System.out.println(entry.getKey());
			for (Edge<T, S> edge : entry.getValue()) {
				System.out.println(edge);
			}
		}
	}

	public void setDirected(boolean directed) {
		this.directed = directed;
	}

	public boolean isDirected() {
		return directed;
	}

	@Override
	public Graph<T, S> setDirectedGraph(boolean directed) {
		this.setDirected(directed);
		return this;
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
}
