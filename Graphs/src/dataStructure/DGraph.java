package dataStructure;



import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.util.Collection;

public class DGraph implements graph{

	private int vertices;
	private HashMap<Node,List<Edge>> NodeMap =  new HashMap<>();
	private HashMap<Edge,List<Edge>> EdgeMap =  new HashMap<>();
	public node_data getNode(int key) { 

		return (node_data) this.NodeMap.get(key);
	}

	
	public edge_data getEdge(int src, int dest) {
		/// not good but nice,
		//// the idea of returning with O(1) is based on the add Node to the Graph,
		// each time we add a node we also add Pointers to his Edges to the EdgesHashMap
		// Then we can return it withing o(1) on the average case 
		// But notice that if we enter a 10 edges graph (look image) it may be O(n/2) issue???
		Node pointer =  new Node();
		pointer = (Node) this.NodeMap.get(src);
		Iterator<Edge> iter = pointer.edges.iterator();
		
		while (iter.hasNext()){
			Edge temp = iter.next();
			if (temp.dest==dest){
				return temp;
					
			}
			
		}
		return null;
		
	}

	
	public void addNode(node_data n) {
	
	
		if(!Map.containsKey(n)) {
			vertices++;
			Map.put((Node) n, new ArrayList<Edge>());
			
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
