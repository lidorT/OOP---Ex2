package dataStructure;

import java.io.Serializable;

public class Edge implements edge_data,Serializable{
	
	public int src;
	public int dest;
	public int tag;
	public double weight;
	public String info;

	
	public Edge(){
		
		this.src=0;
		this.dest=0;
		this.tag=0;
		this.weight=0.0;
		this.info = null;
		
	}
	
	public Edge(int src, int dest, double weight){
		
		this.src=src;
		this.dest=dest;
		this.weight=weight;
		
	
		
	}

	
	public int getSrc() {
		
		return this.src;
	}


	public int getDest() {
		
		return this.dest;
	}


	public double getWeight() {
		
		return this.weight;
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
		this.tag=t;
		
	}

}