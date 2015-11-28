package pahinave.algorithms.graphs;

public class Vertex<T> {
	private String name;
	private T tag;
	private boolean explored;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public T getTag() {
		return tag;
	}

	public void setTag(T obj) {
		this.tag = obj;
	}

	public Vertex(String name, T obj) {
		super();
		this.name = name;
		this.tag = obj;
	}

	public Vertex(String name) {
		super();
		this.name = name;
	}

	@Override
	public String toString() {
		return "[V " + name + (tag == null ? "" : " w" + tag) + "]";
	}

	public boolean isExplored() {
		return explored;
	}

	public void setExplored(boolean explored) {
		this.explored = explored;
	}

	public boolean isNotExplored() {
		return !explored;
	}

	public void markExplored() {
		if (!explored) {
			this.explored = true;
		}
	}

	public void unExplore() {
		this.explored = false;
	}

}
