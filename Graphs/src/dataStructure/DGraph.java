package dataStructure;



import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.util.Collection;

public class DGraph implements graph{

	private int vertices;
	private HashMap<Integer,Node> NodeMap =  new HashMap<Integer,Node>();
	//private HashMap<Integer,Edge> EdgeMap =  new HashMap<>();
	
	
	
	
	public node_data getNode(int key) { 

		return this.NodeMap.get(key);
	}

	
	public edge_data getEdge(int src, int dest) {
			
		Edge temp = new Edge();
		temp = this.NodeMap.get(src).edges.get(dest);
		
		
		return temp;
		
	}

	
	public void addNode(node_data n) {
	
		if (!this.NodeMap.containsKey(n.getKey())) {
		this.NodeMap.put(n.getKey(), (Node) n);
		vertices++;
		}
	}

	
	public void connect(int src, int dest, double w) {
		
		if (this.NodeMap.containsKey(src)) {
			Edge temp = new Edge(src,dest,w);
			
			this.NodeMap.get(src).edges.put(dest, temp);
		
			
		}
	}


	public Collection<node_data> getV() {
		return null;
	}

	public Collection<edge_data> getE(int node_id) {
		return null;
	}

	public node_data removeNode(int key) {
		return null;
	}

	public edge_data removeEdge(int src, int dest) {
		return null;
	}

	public int nodeSize() {
		return 0;
	}

	public int edgeSize() {
		return 0;
	}

	
	public int getMC() {
		return 0;
	}

	
	// Private methods
	
	
	
	public Node srcGetNode(int src) {
		
		return null;
		
		
	}
	
	
}
