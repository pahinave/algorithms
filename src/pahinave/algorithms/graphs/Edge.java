package pahinave.algorithms.graphs;

public class Edge<T, S> {
	Vertex<T> from;
	Vertex<T> to;
	S obj;

	public Vertex<T> getFrom() {
		return from;
	}

	public void setFrom(Vertex<T> from) {
		this.from = from;
	}

	public Vertex<T> getTo() {
		return to;
	}

	public void setTo(Vertex<T> to) {
		this.to = to;
	}

	public S getObj() {
		return obj;
	}

	public void setObj(S obj) {
		this.obj = obj;
	}

	public Edge(Vertex<T> from, Vertex<T> to, S obj) {
		super();
		this.from = from;
		this.to = to;
		this.obj = obj;
	}

	public Edge(Vertex<T> from, Vertex<T> to) {
		super();
		this.from = from;
		this.to = to;
	}

	public Edge<T, S> reverse() {
		return new Edge<T, S>(this.getTo(), this.getFrom(), this.getObj());
	}

	@Override
	public String toString() {
		return "[E " + from + "->" + to + " " + obj + "]";
	}

}
