package pahinave.algorithms.graphs;

import java.lang.ref.WeakReference;

public class Edge<T, S> {
	private WeakReference<Vertex<T>> from;
	private WeakReference<Vertex<T>> to;
	private S obj;
	private final boolean directed;
	private boolean explored;

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
		return "[E " + from.get() + (directed ? "->" : "-") + to.get() + " w" + obj + "]";
	}

	public boolean isSelfLoop() {
		return from == to;
	}

	public Vertex<T> getTo(Vertex<T> from) {
		// if condition is applicable for both
		// directed and undirected graphs
		if (this.getFrom() == from)
			return this.getTo();
		else if (!directed && this.getTo() == from) {
			return this.getFrom();
		}

		return null;
	}

	public boolean isExplored() {
		return explored;
	}

	public void setExplored(boolean explored) {
		this.explored = explored;
	}

	public boolean isDirected() {
		return directed;
	}

	public void setFrom(WeakReference<Vertex<T>> from) {
		this.from = from;
	}

	public void setTo(WeakReference<Vertex<T>> to) {
		this.to = to;
	}

	public boolean isNotExplored() {
		return !explored;
	}

	public void setExplored() {
		this.explored = true;
	}

	public void markExplored() {
		this.explored = true;
	}

	public void unExplore() {
		this.explored = false;
	}
}
