package dataStructure;

import java.io.Serializable;
import utils.Point3D;

public class Node implements node_data,Serializable{

	private static final long serialVersionUID = 1L;
	public int key;

	private Point3D location;
	public double weight;
	public String info;
	int tag=0;
	
	public Node(){
		
		this.key=0;
		this.location= new Point3D(0,0,0);
		this.weight=0;
		this.info=null;
		this.tag=0;
	}
	
	public Node (int key,double weight, Point3D point){
		
		this.key=key;
		this.weight=weight;
		this.location =new Point3D (point);
	}
	
	public int getKey() {
		return this.key;
	}


	public Point3D getLocation() {
		return this.location;
	}


	public void setLocation(Point3D p) {
		this.location = new Point3D(p);
	}


	public double getWeight() {
		return this.weight;
	}

	
	public void setWeight(double w) {
		this.weight=w;
	}


	public String getInfo() {
		return this.info;
	}


	public void setInfo(String s) {
		this.info=s;
	}


	public int getTag() {
		return this.tag;
	}


	public void setTag(int t) {
		this.tag = t;
	}
}