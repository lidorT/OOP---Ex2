package gui;
import javax.swing.JFrame;

import dataStructure.DGraph;
import dataStructure.Node;
import utils.Point3D;


public class Graph_GUI {

	public static void main(String[] args) 
	{
		//Window window = new Window();
		//window.setVisible(true);
		
		
		DGraph g = new DGraph();
		Point3D p1 = new Point3D (5,5,5);
		Point3D p2 = new Point3D (4,4,4);
		Point3D p3 = new Point3D (3,3,3);
		Point3D p4 = new Point3D (2,2,2);
		Point3D p5 = new Point3D (1,1,1);
		
		Node n1 = new Node (5, 5.2, p1);
		Node n2 = new Node (6, 5.2, p2);
		Node n3 = new Node (7, 5.2, p3);
		Node n4 = new Node (8, 5.2, p4);
		Node n5 = new Node (9, 5.2, p5);
		
		g.addNode(n1);
		g.addNode(n2);
		g.addNode(n3);
		g.addNode(n4);
		g.addNode(n5);
		
		g.connect(5,6, 5.2);
		g.connect(5,7, 5.2);
		g.connect(7,5, 5.2);
		g.connect(5,8, 5.2);
		g.connect(5,9, 5.2);
		g.connect(6,8, 5.2);
		g.connect(7,9, 5.2);
		
		
		System.out.println("Node Size is :"+g.nodeSize());
		System.out.println("Edge Size is :"+g.edgeSize());
		System.out.println("MC Size is :"+g.getMC());
		
		//System.out.println("ah sheli");
		
		//System.out.println(g.getV());
		g.getE(5);
		
		
		//System.out.println(g.getE(5));
		
		
		
		//System.out.println(g.removeNode(5));
		System.out.println(g.removeEdge(7,5));
		System.out.println("After shit: ");
		System.out.println("Node Size is :"+g.nodeSize());
		System.out.println("Edge Size is :"+g.edgeSize());
		System.out.println("MC Size is :"+g.getMC());
		
		
		
	}

	
	
	
}
