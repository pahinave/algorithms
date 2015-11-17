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

	public void showNeighbors();

	public Graph<T, S> setDirectedGraph(boolean directed);

}
