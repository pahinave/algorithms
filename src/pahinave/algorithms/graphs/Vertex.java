package pahinave.algorithms.graphs;

public class Vertex<T> {
	String name;
	T obj;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public T getObj() {
		return obj;
	}

	public void setObj(T obj) {
		this.obj = obj;
	}

	public Vertex(String name, T obj) {
		super();
		this.name = name;
		this.obj = obj;
	}

	public Vertex(String name) {
		super();
		this.name = name;
	}

	@Override
	public String toString() {
		return "[V " + name + " w" + obj + "]";
	}

}
