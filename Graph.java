package Grafo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Graph {

	ArrayList<Integer> nodes;
	ArrayList<Edge> edges;
	private static Logger logger;
	
	public Graph() {
		nodes = new ArrayList<Integer>();
		edges = new ArrayList<Edge>();
		if (logger == null) {
			logger = logger.getLogger(Graph.class.getName());
			
			Handler hnd = new ConsoleHandler();
			hnd.setLevel(Level.INFO);
			logger.addHandler(hnd);
			
			logger.setLevel(Level.INFO);
			
			Logger rootLogger = logger.getParent();
			for (Handler h: rootLogger.getHandlers())
				h.setLevel(Level.OFF);
		}
	}
	public void addNode(int node) {
		if (!estaNodo(node)) {
			nodes.add(node);
			logger.info("agrego el nodo: "+node);
		}
		else
			logger.warning("no agrego el nodo "+node+" porque ya estaba");		
	}
	public void addEdge(int node1, int node2) {
		Edge arcoNuevo;	
		if (estaNodo(node1) && (estaNodo(node2)))
			if (edges.size() == 0) {
				arcoNuevo = new Edge(node1,node2);
				edges.add(arcoNuevo);
				logger.info("agrego un arco entre el nodo "+node1+" y el "+node2);
			}
			else
				if (!estaArco(node1,node2)) {
					arcoNuevo = new Edge(node1,node2);
					edges.add(arcoNuevo);
					logger.info("agrego un arco entre el nodo "+node1+" y el "+node2);
				}
				else
					logger.warning("no se pudo agregar el arco entre el nodo "+node1+" y el "+node2+" porque ya existe");
		else
			logger.warning("no se pudo agregar el arco");
	}	
	public void removeNode(int node) {
		boolean encontre = false;
		for (Integer n: nodes) {
			if (n.equals(node)) {
				nodes.remove(n);
				logger.info("removio el nodo "+n);
				encontre = true;
				break;
			}
		}
		if (encontre == false)
			logger.warning("removeNode no removio ningun nodo porque el nodo "+node+" no se pertenece a la estructura");
	}
	public void removeEdge(int node1, int node2) {
		boolean encontre = false;
		for (Edge arco: edges) {
			if ((arco.getOrigen() == node1) && (arco.getDestino() == node2)) {
				edges.remove(arco);
				logger.info("removio el arco que unia el nodo "+node1+" con el nodo "+node2);
				encontre = true;
				break;
			}
		}
		if (encontre == false)
			logger.warning("removeEdge no removio ningun arco porque el arco formado por los nodos "+node1+" y "+node2+" no pertenecen a la estructura");
	}
	private boolean estaNodo(int node) {
		for (Integer i: nodes) {
			if (i.equals(node)) 
				return true;	
		}
		return false;
	}
	private boolean estaArco(int node1, int node2) {
		for (Edge arco: edges) {
			if ((arco.getOrigen() == node1) && (arco.getDestino() == node2)) 
				return true;
		}
		return false;
	}
	public ArrayList<Integer> getNodes() {
		return nodes;
	}
	public ArrayList<Edge> getEdges() {
		return edges;
	}
}
