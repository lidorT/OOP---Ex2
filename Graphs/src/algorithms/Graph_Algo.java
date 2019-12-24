package algorithms;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Collections;
import dataStructure.DGraph;
import dataStructure.edge_data;
import dataStructure.graph;
import dataStructure.node_data;

/**
 * This empty class represents the set of graph-theory algorithms
 * which should be implemented as part of Ex2 - Do edit this class.
 * @author 
 */
public class Graph_Algo implements graph_algorithms,Serializable{

	private static final long serialVersionUID = 1L;
	graph ga; 

	
	/**
	 * This function initializes ga from a given graph.
	 */
	public void init(graph g) {

		this.ga=g;
	}


	/**
	 * 
	 */
	public void init(String file_name) {

		try {
			FileInputStream fileIn = new FileInputStream(file_name);
			ObjectInputStream objectIn = new ObjectInputStream(fileIn);

			this.ga= (graph) objectIn.readObject();

			System.out.println("The Object has been read from the file");
			objectIn.close();
			fileIn.close();
		} 
		catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * 
	 */
	public void save(String file_name) {

		try {
			FileOutputStream f = new FileOutputStream(new File(file_name));
			ObjectOutputStream o = new ObjectOutputStream(f);

			o.writeObject(this.ga);
			o.close();
			f.close();
		}
		catch (IOException e) {
			e.printStackTrace();
			System.out.println("could not read file");
		}
	}

	/**
	 * 
	 */
	public boolean isConnected() {

		boolean flag = true;
		Collection<node_data> vertex_collect = this.ga.getV();
		node_data[] Nodes_arr = vertex_collect.toArray(new node_data[vertex_collect.size()]);
		Queue<node_data> Nq = new LinkedList<node_data>();
		int visitCounter = 0;

		for (int i=0;i<Nodes_arr.length && flag ;i++) {

			ClearTags();
			node_data current = Nodes_arr[i];
			current.setTag(1);
			Nq.add(current);
			visitCounter = 0;

			while(!Nq.isEmpty()) {

				node_data head = Nq.peek();
				Collection<edge_data> edges_collect = this.ga.getE(head.getKey());

				for (edge_data myEdge: edges_collect) {

					if(ga.getNode(myEdge.getDest()).getTag() != 2)
						ga.getNode(myEdge.getDest()).setTag(1);

					if(ga.getNode(myEdge.getDest()).getTag() != 2 && !Nq.contains(ga.getNode(myEdge.getDest()))){
						Nq.add(ga.getNode(myEdge.getDest()));
					}
				}
				head.setTag(2);
				if(Nq.peek().getTag() == 2){

					Nq.poll();
					visitCounter++;
				}
			}
			if(visitCounter != Nodes_arr.length){

				flag = false;
			}
		}	
		return flag;
	}

	
	/**
	 * 
	 */
	public double shortestPathDist(int src, int dest) {

		//if(ga.getNode(src).getWeight() != 0 ) 
		dijkstra(src);
		return ga.getNode(dest).getWeight();
	}

	
	/**
	 * 
	 */
	public List<node_data> shortestPath(int src, int dest) {

		//if(ga.getNode(src).getWeight() != 0) 
		dijkstra(src);

		List<node_data> ans = new ArrayList<node_data>();
		node_data tempNode = ga.getNode(dest);

		while(tempNode.getKey() != src){

			ans.add(tempNode);
			tempNode = ga.getNode(Integer.parseInt(tempNode.getInfo()));
		}
		ans.add(tempNode);
		Collections.reverse(ans);
		return ans;
	}

	
	/**
	 * 
	 */
	public List<node_data> TSP(List<Integer> targets) {
		// TODO Auto-generated method stub
		return null;
	}

	
	/**
	 * This function return a deep copy graph of this.ga
	 */
	public graph copy() {

		graph temp = new DGraph();
		Collection<node_data> Nodes = ga.getV();

		for (node_data Node : Nodes) {
			temp.addNode(Node);
			Collection<edge_data> Edges = ga.getE(Node.getKey());

			for (edge_data Edge : Edges) {
				temp.connect(Edge.getSrc(), Edge.getDest(), Edge.getWeight());
			}
		}
		return temp;
	}

	

     /////////////////////////////////////////////////
	/////////////// Private Methods /////////////////
   /////////////////////////////////////////////////
	
	
	/**
	 * This function changes all Tags to 0
	 */
	private void ClearTags() {

		Collection<node_data> NodesCollection = ga.getV();

		for (node_data temp: NodesCollection) {
			temp.setTag(0);
		}
	}

	
	/**
	 * This function changes all Nodes Tag to 0 and weight to infinity
	 */
	private void resetNodes() {

		Collection<node_data> NodesCollection = ga.getV();
		for (node_data node: NodesCollection) 
		{
			node.setTag(0);
			node.setWeight(Double.MAX_VALUE);
		}
	}


	/**
	 * 
	 * @param src - Integer that represent node key
	 */
	private void dijkstra(int src) {

		resetNodes();
		Queue<node_data> Nq = new LinkedList<node_data>();
		ga.getNode(src).setWeight(0);
		Nq.add(ga.getNode(src));

		while(!Nq.isEmpty()){

			node_data temp1 = Nq.poll();
			Collection<edge_data> Edges = ga.getE(temp1.getKey());

			for(edge_data edge: Edges){

				double weightNode = temp1.getWeight();
				node_data temp2 = ga.getNode(edge.getDest());
				double weightEdge = edge.getWeight();

				if(temp2.getTag() != 1)
					if(weightEdge + weightNode < temp2.getWeight()) 
					{
						Nq.remove(temp2);
						temp2.setWeight(weightEdge + weightNode);
						temp2.setInfo("" + temp1.getKey());
						Nq.add(temp2);
					}
			}
		}
	}



}