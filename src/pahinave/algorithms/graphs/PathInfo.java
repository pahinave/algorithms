package pahinave.algorithms.graphs;

public class PathInfo <T,S extends Comparable<S>> implements Comparable<PathInfo<T,S>> {
	Vertex<T> vertex;
	S length;
	Vertex<T> previous;

	public PathInfo(Vertex<T> vertex, S length, Vertex<T> previous) {
		super();
		this.vertex = vertex;
		this.length = length;
		this.previous = previous;
	}

	public Vertex<T> getVertex() {
		return vertex;
	}

	public void setVertex(Vertex<T> vertex) {
		this.vertex = vertex;
	}

	public S getLength() {
		return length;
	}

	public void setLength(S length) {
		this.length = length;
	}

	public Vertex<T> getPrevious() {
		return previous;
	}

	public void setPrevious(Vertex<T> previous) {
		this.previous = previous;
	}

	@Override
	public int compareTo(PathInfo<T,S> o) {
		return this.getLength().compareTo(o.getLength());
	}

	@Override
	public String toString() {
		return "PathInfo [vertex=" + vertex + ", length=" + length + ", previous=" + previous + "]";
	}
}
