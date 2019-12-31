package gui;

import java.awt.Font;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import dataStructure.DGraph;
import dataStructure.Node;
import dataStructure.edge_data;
import dataStructure.graph;
import algorithms.*;
import dataStructure.node_data;
import utils.Point3D;
import utils.StdDraw;

public class stdGui {
	
	static LinkedList<Point3D> points = new LinkedList<Point3D>();
	graph graph;
	
	public static void main(String[] args) {
		
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
		
		List<Integer> targets = new ArrayList<Integer>();
		targets.add(6);
		targets.add(4);
		targets.add(5);
		targets.add(1);
		
		Graph_Algo ga = new Graph_Algo();
		ga.init(g);
		System.out.println(g.getMC());
		System.out.println(ga.isConnected());
		g.removeEdge(5,6);
		//System.out.println(g.getMC());
		//System.out.println(ga.getMC());
		//System.out.println(ga.isConnected());
		
		//List<node_data> ans = ga.TSP(targets);
		
		//System.out.println(ans);
//		for(node_data noderrr: ans){
//			System.out.print(" "+noderrr.getKey()+"-->");
//		}

		stdGui test = new stdGui();
		test.run(g);
	}
	
	
	public void run(graph g) {
		initSettings();
		initGraph(g);
		initPoints();

	}
	
	public void initSettings() {
       StdDraw.setCanvasSize(600,650);
	}
	
	public void initGraph(graph graph)
	{
		this.graph=graph;
		getPoints(this.graph);
	}
	
	
	public  void initPoints() {
		
        for (Point3D p : points) 
		{
        	StdDraw.setPenRadius(0.02);
            StdDraw.setPenColor(StdDraw.RED);
            StdDraw.point(p.x(), p.y());
		}
      
        
		for (node_data newNode : this.graph.getV()) 
		{
			StdDraw.setPenRadius(0.004);
            StdDraw.setPenColor(StdDraw.BLUE);
			
			for (edge_data newEdge : this.graph.getE(newNode.getKey())) {
				
				double x0 =this.graph.getNode(newEdge.getSrc()).getLocation().x();
				double y0 =this.graph.getNode(newEdge.getSrc()).getLocation().y();
				double x1 =this.graph.getNode(newEdge.getDest()).getLocation().x();
				double y1 = this.graph.getNode(newEdge.getDest()).getLocation().y();
				String str = String.valueOf(newEdge.getWeight());
				
				StdDraw.line(x0, y0, x1,y1);
				
				Font font = new Font("Arial", Font.BOLD, 12);
				StdDraw.setFont(font);
	            StdDraw.setPenColor(StdDraw.BLACK);
				StdDraw.text((x0+3*x1)/4,(y0+3*y1)/4,str);
				StdDraw.setPenColor(StdDraw.BLUE);
				StdDraw.setPenRadius(0.02);
	            StdDraw.setPenColor(StdDraw.MAGENTA);
	            StdDraw.point((x0+5*x1)/6,(y0+5*y1)/6);
				StdDraw.setPenColor(StdDraw.BLUE);
				StdDraw.setPenRadius(0.004);
			
			}
			
			
			
			
		}
		 
	}
		
		
		
		
		
	///////////////////////////
   ///// Private Methods /////
  ///////////////////////////
	
	private void getPoints (graph g){
		
		double max = 0.0;
		double min = 0.0;
		
		Collection<node_data> nodes = g.getV();
		
		for (node_data node : nodes) 
		{
			if(node.getLocation().x() > max) max = node.getLocation().x();
        	if(node.getLocation().x() < min) min = node.getLocation().x();
			this.points.add(node.getLocation());
		}	
		min -= 2*min;
		StdDraw.setScale(min, max*2);
	}
	
	
	
	
}
