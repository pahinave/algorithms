package pahinave.algorithms.graphs;

import java.util.List;
import java.util.function.BinaryOperator;

public class GraphContraction<T, S> {
	public void contract(Graph<T, S> graph, BinaryOperator<T> vertexObjMergeOperator, BinaryOperator<String> vertexNameMergeOperator) {
		// while there are more than 2 vertices
		// randomly choose edge
		// fuse the endpoints of the edge
		// create a new node with name combination of both nodes
		// for all edges outbound from end point nodes, add those edges to new
		// node

		//TODO: add comments
		
		while (graph.vertexCount() > 2) {
			List<Edge<T, S>> allEdges = graph.getAllEdges();
			// Graph is disconnected
			if (allEdges.isEmpty()) {
				return;
			}

			Edge<T, S> edgeToContract = allEdges.get((int)(Math.random() * 10 * graph.edgeCount() % graph.edgeCount() - 1));
			
			Vertex<T> from = edgeToContract.getFrom();
			Vertex<T> to = edgeToContract.getTo();
			Vertex<T> forgedVertex = new Vertex<>(
					vertexNameMergeOperator.apply(from.getName(),to.getName()),
					vertexObjMergeOperator.apply(from.getObj(), to.getObj()));
			
			graph.addVertex(forgedVertex);

			// add outbound edges from "from" to forgedVertex
			// skip edges to "to" vertex
			
			if (graph.isDirected()) {
				for (Edge<T, S> edge : graph.getEdges(from)) {
					if(edge.isSelfLoop())
						continue;

					if (edge.getFrom() == from && edge.getTo() != to) {
						graph.addEdge(new Edge<>(forgedVertex, edge.getTo(), edge.getObj()));
					}

				}

				for (Edge<T, S> edge : graph.getEdges(to)) {
					if(edge.isSelfLoop())
						continue;

					if (edge.getFrom() == to && edge.getTo() != from) {
						graph.addEdge(new Edge<>(forgedVertex, edge.getTo(), edge.getObj()));
					}
				}
				
				for (Edge<T, S> edge : graph.getIncomingDirectedEdges(from)) {
					if(edge.isSelfLoop())
						continue;

					if(edge.getFrom() != to) {
						graph.addEdge(new Edge<>(edge.getFrom(), forgedVertex, edge.getObj()));
					}

				}
				
				for (Edge<T, S> edge : graph.getIncomingDirectedEdges(to)) {
					if(edge.isSelfLoop())
						continue;

					if(edge.getFrom() != from) {
						graph.addEdge(new Edge<>(edge.getFrom(), forgedVertex, edge.getObj()));
					}

				}
				
				
			} else {
				for(Edge<T, S> edge : graph.getEdges(from)) {
					Vertex<T> OtherEnd = edge.getFrom() == from ? edge.getTo() : edge.getFrom();
					if(from == OtherEnd) {
						continue;
					}
					
					if(OtherEnd != to) {
						graph.addEdge(new Edge<>(forgedVertex, OtherEnd, edge.getObj()));
					}
				}
				
				for(Edge<T, S> edge : graph.getEdges(to)) {
					Vertex<T> OtherEnd = edge.getFrom() == to ? edge.getTo() : edge.getFrom();
					if(to == OtherEnd) {
						continue;
					}
					
					if(OtherEnd != from) {
						graph.addEdge(new Edge<>(forgedVertex, OtherEnd, edge.getObj()));
					}
				}
			}

			graph.removeVertex(from);
			graph.removeVertex(to);
		}
	}
}
