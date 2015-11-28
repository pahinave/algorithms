package pahinave.algorithms.graphs;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface Graph<T, S extends Comparable<S>> {

	public void addVertex(Vertex<T> vertex);

	public Vertex<T> addVertex(String name, T obj);

	public Vertex<T> addVertex(String name);

	public Edge<T,S> addEdge(Edge<T, S> edge);

	public Vertex<T> getVertex(String name);

	public List<Edge<T, S>> getEdges(Vertex<T> vertex);

	public void removeEdge(Edge<T, S> edge);

	public void removeEdges(Vertex<T> from, Vertex<T> to);

	public void showVertexEdgesView();

	public void showVertexEdgesView(boolean ifVertexIsFrom);

	public void addAllVertices(List<Vertex<T>> vertices);

	public void addAllEdges(List<Edge<T, S>> edges);

	public List<Edge<T, S>> findAllEdges(Vertex<T> from, Vertex<T> to);

	public List<Edge<T, S>> findEdges(Vertex<T> from, Vertex<T> to, int limit);

	public void removeVertex(Vertex<T> vertex);

	public int vertexCount();

	public int edgeCount();

	public List<Edge<T, S>> getAllEdges();

	public boolean isDirected();

	public List<Edge<T, S>> getIncomingDirectedEdges(Vertex<T> vertex);

	public List<Vertex<T>> bfs(Vertex<T> start);

	public List<Vertex<T>> dfs(Vertex<T> start);

	public void unexploreAll();

	public void unexploreVertices();

	public void unexploreEdges();

	public Map<Vertex<T>, Integer> shortestPaths(Vertex<T> start);

	public List<List<Vertex<T>>> findConnectedComponents();

	public List<Vertex<T>> topologicalSort();

	public Set<Vertex<T>> vertices();

}
