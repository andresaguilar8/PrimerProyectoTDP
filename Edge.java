package Grafo;

public class Edge {

	int origen, destino; 	
	
	public Edge(int origen, int destino) {
		this.origen = origen;
		this.destino = destino;
	}
	
	public int getOrigen() {
		return origen;
	}
	public int getDestino() {
		return destino;
	}
}
