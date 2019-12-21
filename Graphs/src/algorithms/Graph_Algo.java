package algorithms;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.List;
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
		
		
		
		
		return false;
	}

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
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
}
	
	