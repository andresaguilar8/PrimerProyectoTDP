package Grafo;

import java.util.ArrayList;
import java.util.Iterator;

public class Graph {

	ArrayList<Integer> nodes;
	ArrayList<Edge> edges;
	
	public Graph() {
		nodes = new ArrayList<Integer>();
		edges = new ArrayList<Edge>();
	}
	public void addNode(int node) {
		boolean encontre = false;
		Iterable<Integer> iterable = nodes;
		Iterator<Integer> it = iterable.iterator();
		while (it.hasNext() && !encontre)
			if (it.next().equals(node))
				encontre = true;
		if (!encontre) {
			nodes.add(node);
			System.out.println("agrego un nodo");
		}
		else
			System.out.println("no agrego porque ya estaba");
	}
	public void addEdge(int node1, int node2) {
		boolean encontre = false;
		Edge arcoNuevo;
		for (Edge arco: edges)
			if (!(arco.getOrigen() == node1) && !(arco.getDestino() == node2))
				 arcoNuevo = new Edge(node1,node2);
			
	}
	public void removeNode(int node) {
		
	}
	public void removeEdge(int node1, int node2) {
		
	}
	public ArrayList<Integer> getNodes() {
		return nodes;
	}
}
