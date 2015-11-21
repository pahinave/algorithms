package pahinave.algorithms.graphs;

import java.util.List;

public interface Graph<T, S> {

	public void addVertex(Vertex<T> vertex);

	public Vertex<T> addVertex(String name, T obj);

	public Vertex<T> addVertex(String name);

	public void addEdge(Edge<T, S> edge);

	public Vertex<T> getVertex(String name);

	public List<Edge<T, S>> getEdges(Vertex<T> vertex);

	public void removeEdge(Edge<T, S> edge);
	
	public void removeEdges(Vertex<T> from, Vertex<T> to);

	public void showNeighbors();

	public void addAllVertices(List<Vertex<T>> vertices);

	public void addAllEdges(List<Edge<T, S>> edges);
	
	public List<Edge<T, S>> findAllEdges(Vertex<T> from, Vertex<T> to);
	
	public List<Edge<T, S>> findEdges(Vertex<T> from, Vertex<T> to, int limit);
	
	public void removeVertex(Vertex<T> vertex);

}