package gui;

import java.util.List;
import dataStructure.DGraph;
import dataStructure.Node;
import dataStructure.node_data;
import utils.Point3D;
import algorithms.Graph_Algo;
import algorithms.graph_algorithms;

public class Graph_GUI {

	public static void main(String[] args) 
	{
		
		Point3D p1 = new Point3D (1,1,1);
		Point3D p2 = new Point3D (2,2,2);
		Point3D p3 = new Point3D (3,3,3);
		Point3D p4 = new Point3D (4,4,4);
		Point3D p5 = new Point3D (5,5,5);
		//Point3D p6 = new Point3D (6,6,6);
		//Point3D p7 = new Point3D (7,7,7);
		//Point3D p8 = new Point3D (8,8,8);
		//Point3D p9 = new Point3D (9,9,9);
		//Point3D p10 = new Point3D (10,10,10);
		
		Node n1 = new Node (1, 5.2, p1);
		Node n2 = new Node (2, 5.2, p2);
		Node n3 = new Node (3, 5.2, p3);
		Node n4 = new Node (4, 5.2, p4);
		Node n5 = new Node (5, 5.2, p5);
		//Node n6 = new Node (6, 5.2, p6);
		//Node n7 = new Node (7, 5.2, p7);
		//Node n8 = new Node (8, 5.2, p8);
		//Node n9 = new Node (9, 5.2, p9);
		//Node n10 = new Node (10,5.2, p10);
		
		//g.addNode(n1);
		//g.addNode(n2);
		//g.addNode(n3);
	//	g.addNode(n4);
	//	g.addNode(n5);
		
//		g.connect(5,6, 5.2);
//		g.connect(5,7, 5.2);
//		g.connect(7,5, 5.2);
//		g.connect(5,8, 5.2);
//		g.connect(5,9, 5.2);
//		g.connect(6,8, 5.2);
//		g.connect(7,9, 5.2);
//		g.connect(8,5, 5.2);
//		g.connect(9,6, 5.2);
		
		//g.addNode(n1);
		
//		
//		System.out.println("Node Size is :"+g.nodeSize());
//		System.out.println("Edge Size is :"+g.edgeSize());
//		System.out.println("MC Size is :"+g.getMC());
	
		DGraph g = new DGraph();
		g.addNode(n1);
		g.addNode(n2);
		g.addNode(n3);
		g.addNode(n4);
		g.addNode(n5);
		
		g.connect(1,2, 3);
		g.connect(2,1, 11);
		g.connect(2,3, 5.9);
		g.connect(3,2, 8);
		g.connect(3,4, 5.2);
		g.connect(4,3, 5);
		g.connect(4,1, 4);
		g.connect(1,4, 3);
		g.connect(5,4, 6);
		g.connect(4,5, 2.5);
		
		graph_algorithms g1 = new Graph_Algo();
		g1.init(g);
		boolean t = g1.isConnected();
		System.out.println(t);
		
		double w = g1.shortestPathDist(1,5);
		System.out.println(w);
		
		List<node_data> ans = g1.shortestPath(1,5);
		System.out.println(ans);
		
		//System.out.println("Node Size is :"+g1.nodeSize());
		//System.out.println("Edge Size is :"+g1.edgeSize());
		//System.out.println("MC Size is :"+g1.getMC());
	
		
	//	System.out.println(test.isConnected());
		
//		graph test2 = new DGraph();
//		
//		test2 = test.copy();
//		System.out.println(test2);
//		
//		System.out.println(test.MyDFS(g.getNode(6),g.getNode(5)));
//		
		
//		test.save("test1.txt");
//		
//		test2.init("test1.txt");
//		
//		System.out.println("but thats alright");
		
	}

	
	
	
}