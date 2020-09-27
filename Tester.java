package Grafo;

public class Tester {

	public static void main (String [] args) {
		Graph grafo = new Graph();
		grafo.addNode(4);
		grafo.addNode(5);
		grafo.addNode(5);
		grafo.addEdge(4, 5);
		grafo.addEdge(4, 5);
		grafo.removeNode(4);
		grafo.removeNode(4);
		grafo.removeNode(3);
		grafo.removeEdge(4, 5);
		grafo.removeEdge(2, 3);
		grafo.addEdge(2,3);
		grafo.addNode(2);
		grafo.addNode(3);
		grafo.addEdge(2,3);
		grafo.removeNode(3);
		grafo.removeEdge(2,3);
		grafo.addNode(4);
		grafo.addEdge(2,4);
	}
}
