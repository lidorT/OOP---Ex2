package dataStructure;

import java.util.HashMap;
import java.util.Set;
import java.io.Serializable;
import java.util.Collection;

public class DGraph implements graph,Serializable{

	private static final long serialVersionUID = 1L;
	private int MC;
	private int nodeSize;
	private int edgeSize;

	public HashMap <Integer,node_data> NodeMap;
	public HashMap <node_data, HashMap<Integer, edge_data>> EdgeMap;

	public DGraph(){

		this.nodeSize=0;
		this.edgeSize=0;
		this.MC=0;
		this.NodeMap=new HashMap<Integer,node_data>();
		this.EdgeMap=new HashMap <node_data, HashMap<Integer, edge_data>> ();
	}

	public node_data getNode(int key) { 
		
		return this.NodeMap.get(key);
	}

	public edge_data getEdge(int src, int dest) {

		node_data temp_node = NodeMap.get(src);
		edge_data temp_edge = EdgeMap.get(temp_node).get(dest);
		return temp_edge;
	}


	public void addNode(node_data n) {

		if (!this.NodeMap.containsKey(n.getKey())) {
			this.NodeMap.put(n.getKey(), n);
			this.EdgeMap.put(n,new HashMap<Integer,edge_data>());
			nodeSize++;
			MC++;
		}
	}


	public void connect(int src, int dest, double w) {

		if (this.NodeMap.containsKey(src)) {
			node_data temp_node = NodeMap.get(src);
			EdgeMap.get(temp_node).put(dest, new Edge(src,dest,w));
			edgeSize++;
			MC++;
		}
	}


	public Collection<node_data> getV() {

		return NodeMap.values();
	}

	public Collection<edge_data> getE(int node_id) {
		
		node_data temp_node = NodeMap.get(node_id);
		return EdgeMap.get(temp_node).values(); 
	}

	public node_data removeNode(int key) {
		
		if (NodeMap.containsKey(key)) {
			node_data temp_node = NodeMap.get(key);
			Set<node_data> node_set = EdgeMap.keySet();
			for (node_data node_data : node_set) {
				if (EdgeMap.get(node_data).remove(key)!=null) {
				edgeSize--;
				}
			}
			edgeSize = (edgeSize) - (EdgeMap.get(temp_node).size());
			EdgeMap.remove(temp_node);
			MC++;
			nodeSize--;
			return NodeMap.remove(key);
		}
		return null;
	}
	
	public edge_data removeEdge(int src, int dest) {

		node_data temp_node = NodeMap.get(src);
		if (EdgeMap.get(temp_node).containsKey(dest)) {
			edgeSize--;
			MC++;
			return EdgeMap.get(temp_node).remove(dest);
		}
		return null;
	}

	public int nodeSize() {
		return this.nodeSize;
	}

	public int edgeSize() {
		return this.edgeSize;
	}

	public int getMC() {
		return this.MC;
	}

}