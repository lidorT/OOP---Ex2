package gui;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Collection;
import java.util.LinkedList;

import javax.swing.JFrame;

import dataStructure.Edge;
import dataStructure.edge_data;
import dataStructure.graph;
import dataStructure.node_data;
import utils.Point3D;

public class Window extends JFrame implements ActionListener, MouseListener
{
	LinkedList<Point3D> points = new LinkedList<Point3D>();
	graph graph;
	
	public Window()
	{
		initGUI();
	}
	
	public Window(graph graph)
	{
		initGUI();
		this.graph=graph;
		getPoints(this.graph);
	}
	
	
	private void initGUI() 
	{
		this.setSize(1000, 850);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		MenuBar menuBar = new MenuBar();
		Menu menu = new Menu("Menu");
		menuBar.add(menu);
		this.setMenuBar(menuBar);
		
		MenuItem item1 = new MenuItem("Item 1");
		item1.addActionListener(this);
		
		MenuItem item2 = new MenuItem("Item 2");
		item2.addActionListener(this);
	
		MenuItem item3 = new MenuItem("Save");
		item3.addActionListener(this);
		
		MenuItem item4 = new MenuItem("Load");
		item4.addActionListener(this);
		
		menu.add(item1);
		menu.add(item2);
		menu.add(item3);
		menu.add(item4);
		
		this.addMouseListener(this);
	}

	public void paint(Graphics g)
	{
		super.paint(g);
		
		//Point3D prev = null;
		
		for (Point3D p : points) 
		{
			g.setColor(Color.BLUE);
			g.fillOval((int)p.x(), (int)p.y(), 10, 10);
		}
		
		for (node_data newNode : this.graph.getV()) 
		{
			g.setColor(Color.RED);
			
			for (edge_data newEdge : this.graph.getE(newNode.getKey())) {
				
				g.drawLine(this.graph.getNode(newEdge.getSrc()).getLocation().x(), this.graph.getNode(newEdge.getSrc()).getLocation().y(), this.graph.getNode(newEdge.getDest()).getLocation().x(), this.graph.getNode(newEdge.getDest()).getLocation().y());
				
			}
			
			
			//g.fillOval((int).x(), (int)p.y(), 10, 10);
		}
		
		
		
//			if(prev != null)
//			{
//				g.setColor(Color.RED);
//				g.drawLine((int)p.x(), (int)p.y(), 
//						(int)prev.x(), (int)prev.y());
//				
//				g.drawString("5", (int)((p.x()+prev.x())/2),(int)((p.y()+prev.y())/2));
//			}
			
		//	prev = p;
		
	}
	
	

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		String str = e.getActionCommand();
		
		if(str.equals("Item 1"))
		{
			Point3D p1 = new Point3D(100,100);
			Point3D p2 = new Point3D(50,300);
			Point3D p3 = new Point3D(400,150);
			
			points.add(p1);
			points.add(p2);
			points.add(p3);
			
			repaint();
		}
		
		if(str.equals("Save"))
		{
			System.out.println("Lunch Save to file function");
			// TODO saveToFile()
			repaint();
		}
		
		if(str.equals("Load"))
		{
			System.out.println("Lunch init from file function");
			// TODO initFromFile()
			repaint();
		}
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		//System.out.println("mouseClicked");
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
//		int x = e.getX();
//		int y = e.getY();
//		Point3D p = new Point3D(x,y);
//		points.add(p);
//		repaint();
//		System.out.println("mousePressed");
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		//System.out.println("mouseReleased");
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		//System.out.println("mouseEntered");
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		//System.out.println("mouseExited");
	}
	
	/////// Private Methods /////////////
	
	
	private void getPoints (graph g){
		
		Collection<node_data> nodes = g.getV();
		
		for (node_data node : nodes) 
		{
			this.points.add(node.getLocation());
		}
			
	}
	
	
	
}