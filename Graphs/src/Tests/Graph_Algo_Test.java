package Tests;

import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import algorithms.Graph_Algo;
import dataStructure.DGraph;
import dataStructure.Node;
import dataStructure.graph;
import dataStructure.node_data;
import utils.Point3D;

public class Graph_Algo_Test {

	private DGraph g = new DGraph();
	private Graph_Algo GA = new Graph_Algo();
	
	@Before
	public void setUp() throws Exception {
		
		g = Graph_factory();
		this.GA.init(g);
	}
	
	@Test
	public void InitGraph() {
		
		System.out.println("InitGraph: ");
		Graph_Algo ga = new Graph_Algo();
		ga.init(g);
		System.out.println("InitGraph success!");
	}

	@Test
	public void InitString() { //init(String file_name)
		
		System.out.println("InitString: ");
		Graph_Algo ga = new Graph_Algo();
		ga.init(g);
		ga.save("Graph_to_file.txt");
		Graph_Algo gaInit = new Graph_Algo();
		gaInit.init("Graph_to_file.txt");
		System.out.println("Original Graph_Algo before save to file, is connect? "+gaInit.isConnected());
		System.out.println("New Graph_Algo that Init from String, is connect? "+ga.isConnected());
		System.out.println();
	}

	@Test
	public void Save() {
		
		System.out.println("Save: ");
		GA.save("Graph_to_file.txt");
		System.out.println("save was success!");
		System.out.println();
		
	}

	@Test
	public void IsConnected() {

		System.out.println("IsConnected: ");
		System.out.println("a currect Graph_Algo: "+GA.isConnected());
		DGraph g = new DGraph();
		Graph_Algo ga = new Graph_Algo();
		ga.init(g);
		System.out.println("an empty Graph_Algo: "+ga.isConnected());
		System.out.println();
	}

	@Test
	public void ShortestPathDist() {
		
		System.out.println("ShortestPathDist: ");

		double dist = GA.shortestPathDist(1, 2);
		System.out.println(dist);
		try{
		double dist1 = GA.shortestPathDist(1, 22); //there is no vertix 22
		}
		catch(Exception e){
			System.out.println("Error, there is no src or dest vertix.");
		}
		System.out.println();	
	}

	@Test
	public void ShortestPath() {

		System.out.println("ShortestPath: ");
		List<node_data> ans  = GA.shortestPath(5,18);
		
		for(node_data node: ans){
			System.out.print(" --> "+node.getKey());
		}
		try{
			double dist1 = GA.shortestPathDist(1, 22); //there is no vertix 22
			}
			catch(Exception e){
				System.out.println();
				System.out.println("Error, there is no src or dest vertix.");
			}
		System.out.println();
		System.out.println();
	}

	@Test
	public void TSP() {

		System.out.println("TSP: ");
		List<Integer> targets = new ArrayList<Integer>();
		targets.add(6);
		targets.add(4);
		targets.add(12);
		targets.add(14);
		targets.add(9);
		List<node_data> ans = GA.TSP(targets);
	
		for(node_data node: ans){
			System.out.print(" --> "+node.getKey());
		}
		
		try{
			targets.add(25);
			targets.add(90); //there is no vertixs 25,90
			List<node_data> ans1 = GA.TSP(targets);
			
			for(node_data node: ans1){
				System.out.print(" --> "+node.getKey());
			}
			}
			catch(Exception e){
				System.out.println();
				System.out.println("Error, there is no src or dest vertix.");
			}
		
		System.out.println();
		System.out.println();
	}

	@Test
	public void Copy() {
		
		System.out.println("Copy: ");
		graph g = GA.copy();
		System.out.println("copied graph edge size: "+g.edgeSize());
		System.out.println("copied graph node size: "+g.nodeSize());
		System.out.println("copy was success!");
		System.out.println();
	}
	
	
	public static DGraph Graph_factory(){
		
		Point3D p1 = new Point3D (7,3,10);
		Point3D p2 = new Point3D (5,8,9);
		Point3D p3 = new Point3D (15,10,11);
		Point3D p4 = new Point3D (12,7,0.4);
		Point3D p5 = new Point3D (2,6,0.5);
		Point3D p6 = new Point3D (8,1,0.5);
		Point3D p7 = new Point3D (4,2,4);
		Point3D p8 = new Point3D (12,5,0.4);
		Point3D p9 = new Point3D (7,3.6,0.5);
		Point3D p10 = new Point3D (9,1.3,0.5);
		Point3D p11 = new Point3D (11,4.8,4);
		Point3D p12 = new Point3D (6,9.6,0.4);
		Point3D p13 = new Point3D (6.7,6,0.5);
		Point3D p14 = new Point3D (8,8,0.5);
		Point3D p15 = new Point3D (4,2,4);
		Point3D p16 = new Point3D (1,7,0.4);
		Point3D p17 = new Point3D (2,7.2,0.5);
		Point3D p18 = new Point3D (6.6,2.3,0.5);
		Point3D p19 = new Point3D (2.8,5.7,4);
		
		Node n1 = new Node (1, 9, p1);
		Node n2 = new Node (2, 5.5, p2);
		Node n3 = new Node (3, 5.3, p3);
		Node n4 = new Node (4, 2, p4);
		Node n5 = new Node (5, 5.7, p5);
		Node n6 = new Node (6,4,p6);
		Node n7 = new Node (7,9,p7);
		Node n8 = new Node (8, 7, p8);
		Node n9 = new Node (9, 5.2, p9);
		Node n10 = new Node (10, 1, p10);
		Node n11 = new Node (11, 3.6, p11);
		Node n12 = new Node (12, 3, p12);
		Node n13 = new Node (13,1.5,p13);
		Node n14 = new Node (14,3,p14);
		Node n15 = new Node (15, 4, p15);
		Node n16 = new Node (16, 5.6, p16);
		Node n17 = new Node (17, 6, p17);
		Node n18 = new Node (18, 5.8, p18);
		Node n19 = new Node (19, 8, p19);
		
		DGraph g = new DGraph();
		
		g.addNode(n1);
		g.addNode(n2);
		g.addNode(n3);
		g.addNode(n4);
		g.addNode(n5);
		g.addNode(n6);
		g.addNode(n7);
		g.addNode(n8);
		g.addNode(n9);
		g.addNode(n10);
		g.addNode(n11);
		g.addNode(n12);
		g.addNode(n13);
		g.addNode(n14);
		g.addNode(n15);
		g.addNode(n16);
		g.addNode(n17);
		g.addNode(n18);
		g.addNode(n19);
	
		g.connect(1,2,3);
		g.connect(2,1,11);
		g.connect(2,3,5.9);
		g.connect(3,2,8);
		g.connect(3,4,5.2);
		g.connect(4,3,5);
		g.connect(5,4,6);
		g.connect(4,5,2.7);
		g.connect(1,6,5);
		g.connect(6,1,3.8);
		g.connect(6,5,8.6);
		g.connect(5,6,8.6);
		g.connect(7,8,3);
		g.connect(8,7,11);
		g.connect(8,9,5.9);
		g.connect(9,8,5.9);
		g.connect(9,10,8);
		g.connect(10,9,5.9);
		g.connect(10,8,5.2);
		g.connect(10,6,5);
		g.connect(10,11,5.9);
		g.connect(11,10,5.9);
		g.connect(11,6,6);
		g.connect(12,13,2.7);
		g.connect(6,12,5);
		g.connect(13,14,3.8);
		g.connect(14,13,8.6);
		g.connect(15,2,8.6);
		g.connect(2,16,3);
		g.connect(16,17,2);
		g.connect(16,10,5.9);
		g.connect(15,3,8);
		g.connect(17,4,5.2);
		g.connect(8,18,5);
		g.connect(18,16,6);
		g.connect(18,5,2.7);
		g.connect(18,12,5);
		g.connect(9,18,3.8);
		g.connect(19,1,8.6);
		g.connect(18,19,8.6);
		g.connect(12,3,2);
		g.connect(12,2,2);
		g.connect(3,8,2);
		g.connect(9,11,2);
		g.connect(14,12,2);
		g.connect(16,5,2);
		g.connect(17,19,2);
		g.connect(19,17,2);
		g.connect(5,16,2);
		g.connect(15,19,2);
		g.connect(19,15,2);
		g.connect(16,6,2);
		g.connect(6,16,2);
		
		return g;
	}
	

}
