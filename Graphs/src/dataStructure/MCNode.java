package dataStructure;

import java.util.List;

public class MCNode {

	int src;
	int dest;
	int MC;
	List<node_data> shortestPath;
	List<node_data> TSP;
	boolean IsConnected;
	double shortestPathDist;
	
	
	public MCNode(){
		

		
	}
	

	
	public int getSrc() {
		return src;
	}
	public void setSrc(int src) {
		this.src = src;
	}
	public int getMC() {
		return MC;
	}
	public void setMC(int MC) {
		this.MC = MC;
	}
	public int getDest() {
		return dest;
	}
	public void setDest(int dest) {
		this.dest = dest;
	}
	public List<node_data> getShortestPath() {
		return shortestPath;
	}
	public void setShortestPath(List<node_data> shortestPath) {
		this.shortestPath = shortestPath;
	}
	public List<node_data> getTSP() {
		return TSP;
	}
	public void setTSP(List<node_data> tSP) {
		TSP = tSP;
	}
	public boolean IsConnected() {
		return IsConnected;
	}
	public void setIsConnected(boolean isConnected) {
		IsConnected = isConnected;
	}
	public double getShortestPathDist() {
		return shortestPathDist;
	}
	public void setShortestPathDist(double shortestPathDist) {
		this.shortestPathDist = shortestPathDist;
	}

	
}
