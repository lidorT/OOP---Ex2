package Tests;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import com.sun.corba.se.impl.orbutil.graph.Graph;

import algorithms.Graph_Algo;
import dataStructure.DGraph;
import dataStructure.Node;
import utils.Point3D;

public class Graph_Algo_Test {

	private DGraph g = null;
	private Graph_Algo GA = null;
	
	@Before
	public void setUp() throws Exception {
		g = Graph_factory();
	}
	
	@Test
	public void InitGraph() {

		Graph_Algo GA = new Graph_Algo();
		GA.init(g);
	}

	@Test
	public void InitString() {
		fail("Not yet implemented");
	}

	@Test
	public void Save() {
		fail("Not yet implemented");
	}

	@Test
	public void IsConnected() {
		fail("Not yet implemented");
	}

	@Test
	public void ShortestPathDist() {
		fail("Not yet implemented");
	}

	@Test
	public void ShortestPath() {
		fail("Not yet implemented");
	}

	@Test
	public void TSP() {
		fail("Not yet implemented");
	}

	@Test
	public void Copy() {
		fail("Not yet implemented");
	}
	
	public static DGraph Graph_factory(){
		
		Point3D p1 = new Point3D (7,3,10);
		Point3D p2 = new Point3D (05,8,9);
		Point3D p3 = new Point3D (15,10,11);
		Point3D p4 = new Point3D (12,7,0.4);
		Point3D p5 = new Point3D (2,6,0.5);
		Point3D p6 = new Point3D (8,1,0.5);
		Point3D p7 = new Point3D (4,2,4);
		
		Node n1 = new Node (1, 5.2, p1);
		Node n2 = new Node (2, 5.2, p2);
		Node n3 = new Node (3, 5.2, p3);
		Node n4 = new Node (4, 5.2, p4);
		Node n5 = new Node (5, 5.2, p5);
		Node n6 = new Node (6,5.2,p6);
		Node n7 = new Node (7,0,p7);
		
		DGraph g = new DGraph();
		
		g.addNode(n1);
		g.addNode(n2);
		g.addNode(n3);
		g.addNode(n4);
		g.addNode(n5);
		g.addNode(n6);
		g.addNode(n7);
		
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
		
		return g;
	}
	

}
