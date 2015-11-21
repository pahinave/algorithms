package pahinave.algorithms.graphs;

public class Vertex<T> {
	private String name;
	private T obj;
	private boolean explored;

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

	public boolean isExplored() {
		return explored;
	}

	public void setExplored(boolean explored) {
		this.explored = explored;
	}
	
	

}
