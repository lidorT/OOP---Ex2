package dataStructure;



import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.util.Collection;

public class DGraph implements graph{

	private int vertices;
	private HashMap<Node,List<Edge>> NodeMap =  new HashMap<>();
	private HashMap<Integer,Edge> EdgeMap =  new HashMap<>();
	public node_data getNode(int key) { 

		return (node_data) this.NodeMap.get(key);
	}

	
	public edge_data getEdge(int src, int dest) {
			
			Edge temp = new Edge();
			temp = this.EdgeMap.get(src);
			if (temp.getDest()==dest) {
				return temp;
				
			}
			temp=temp.; // Java HashMap should make an array list in case of collotion wtf?
			
			
		
		return null;
		
	}

	
	public void addNode(node_data n) {
	
	
		if(!NodeMap.containsKey(n)) {
			vertices++;
			NodeMap.put((Node) n, new ArrayList<Edge>());
			Node pointer =  new Node();
			pointer = (Node) n;
			Iterator<Edge> iter = pointer.edges.iterator();

			while (iter.hasNext()){
				Edge temp = iter.next();
				EdgeMap.put(temp.getSrc(), temp);
						
				}
			
		}
	}

	
	public void connect(int src, int dest, double w) {
		
		
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

}
