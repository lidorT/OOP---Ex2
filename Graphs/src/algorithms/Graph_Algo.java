package algorithms;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;




import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;


import dataStructure.DGraph;
import dataStructure.Edge;
import dataStructure.Node;
import dataStructure.edge_data;
import dataStructure.graph;
import dataStructure.node_data;

/**
 * This empty class represents the set of graph-theory algorithms
 * which should be implemented as part of Ex2 - Do edit this class.
 * @author 
 *
 */
public class Graph_Algo implements graph_algorithms,Serializable{


	graph ga; 


	public void init(graph g) {

		this.ga=g;

	}

	@Override
	public void init(String file_name) {


		try {

			FileInputStream fileIn = new FileInputStream(file_name);
			ObjectInputStream objectIn = new ObjectInputStream(fileIn);

			this.ga= (graph) objectIn.readObject();

			System.out.println("The Object has been read from the file");
			objectIn.close();
			fileIn.close();

		} catch (Exception ex) {
			ex.printStackTrace();

		}


	}


	public void save(String file_name) {

		try {
			FileOutputStream f = new FileOutputStream(new File(file_name));
			ObjectOutputStream o = new ObjectOutputStream(f);

			o.writeObject(this.ga);
			o.close();
			f.close();
		}

		catch (IOException e) 
		{
			e.printStackTrace();
			System.out.println("could not read file");
		}
	}

	public boolean isConnected() {

		boolean flag = true;
		Collection<node_data> vertex_collect = this.ga.getV();
		node_data[] Nodes_arr = vertex_collect.toArray(new node_data[vertex_collect.size()]);
		Queue<node_data> Nq = new LinkedList<node_data>();
		int visitCounter = 0;
		
		for (int i=0;i<Nodes_arr.length && flag ;i++) {

			//clearTag
			node_data current = Nodes_arr[i];
			current.setTag(1);
			Nq.add(current);
			
			while(!Nq.isEmpty()) {
				
				node_data head = Nq.peek();
				Collection<edge_data> edges_collect = this.ga.getE(head.getKey());
				
				for (edge_data myEdge: edges_collect) {
					ga.getNode(myEdge.getDest()).setTag(1);
					if(ga.getNode(myEdge.getDest()).getTag()!=2 && !Nq.contains(ga.getNode(myEdge.getDest()))){
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




	//	public boolean isConnected() {
	//		
	//		boolean flag = false;
	//		Collection<node_data> Nodes = ga.getV();
	//		
	//		node_data start = null;
	//		for (node_data Node : Nodes) {
	//			if (Node != null) {
	//				flag = true;
	//				start = Node;
	//				break;
	//			}
	//		}
	//		
	//		int visitedAll = DFS(ga, start.getKey(), 0);
	//		if (visitedAll != ga.nodeSize()) return false;
	//
	//		Collection<node_data> ver = ga.getV();
	//		graph reverse = new DGraph();
	//
	//		for (node_data v : ver) {
	//			reverse.addNode(v);
	//		}
	//
	//		for (node_data v : ver) {
	//			LinkedList<edge_data> source = (LinkedList<edge_data>)ga.getE(v.getKey());
	//			for (edge_data e : source) {
	//				reverse.connect(e.getDest(), e.getSrc(), e.getWeight());
	//			}
	//		}
	//
	//		visitedAll = DFS(reverse, start.getKey(), 0);
	//		if (visitedAll != reverse.nodeSize())
	//			return false;
	//
	//		return true;
	//	}

	@Override
	public double shortestPathDist(int src, int dest) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<node_data> shortestPath(int src, int dest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<node_data> TSP(List<Integer> targets) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
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


	private int DFS (graph check ,int start, int visited) {

		if (ga.nodeSize() == visited) {
			return visited;
		}
		else {
			visited++;
			node_data startNode = check.getNode(start);
			startNode.setTag(2);
			Collection<edge_data> edges =check.getE(start);
			for (edge_data e : edges) {
				node_data des = check.getNode(e.getDest());
				if(des.getTag() != 2) {
					return DFS(check, e.getDest(), visited);
				}
			}
		}
		return -1;
	}


	/////////////// Private Methods /////////////////

	private void ClearTags() {

		Collection<node_data> NodesCollection = ga.getV();


		for (node_data temp : NodesCollection) {

			temp.setTag(0);

		}
	}

	public boolean MyDFS (node_data start, node_data end) {

		Collection<edge_data> edges_collect = this.ga.getE(start.getKey());

		for (edge_data myEdge: edges_collect) {

			if (myEdge.getDest()==end.getKey()) {

				return true;

			}


		}
		return false;



	}



}



