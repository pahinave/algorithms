package pahinave.algorithms.graphs;

import java.lang.ref.WeakReference;

public class Edge<T, S> {
	WeakReference<Vertex<T>> from;
	WeakReference<Vertex<T>> to;
	S obj;
	final boolean directed;

	public Vertex<T> getFrom() {
		return from.get();
	}

	public void setFrom(Vertex<T> from) {
		this.from = new WeakReference<Vertex<T>>(from);
	}

	public Vertex<T> getTo() {
		return to.get();
	}

	public void setTo(Vertex<T> to) {
		this.to = new WeakReference<Vertex<T>>(to);
	}

	public S getObj() {
		return obj;
	}

	public void setObj(S obj) {
		this.obj = obj;
	}

	public Edge(Vertex<T> from, Vertex<T> to, S obj) {
		this(from, to, obj, false);
	}
	
	public Edge(Vertex<T> from, Vertex<T> to, S obj, boolean directed) {
		super();
		this.from = new WeakReference<Vertex<T>>(from);
		this.to = new WeakReference<Vertex<T>>(to);
		this.obj = obj;
		this.directed = directed;
	}

	public Edge(Vertex<T> from, Vertex<T> to) {
		this(from, to, false);
	}
	
	public Edge(Vertex<T> from, Vertex<T> to, boolean directed) {
		super();
		this.from = new WeakReference<Vertex<T>>(from);
		this.to = new WeakReference<Vertex<T>>(to);
		this.directed = directed;
	}

	@Override
	public String toString() {
		return "[E " + from.get() + (directed ? "->" : "-") + to.get() + " " + obj + "]";
	}

}
