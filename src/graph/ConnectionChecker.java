package graph;
/**
 *Checks whether two vertices are attached 
 *to the graph
 * 
 * @author Idan Abergel & Hen Hess
 */

import java.util.LinkedList;
import java.util.List;

public class ConnectionChecker<V>{
	private GraphInterface<V> g;
	private List<V> succsess = new LinkedList<>();
	
	/**
	 *Initializes the class with the given graph.
	 * 
	 * @param g       <GraphInterface> g the graph. 
	 */	
	public ConnectionChecker(GraphInterface<V> g) {
		this.g=g;
	}
	/**
	 * Returns whether you can get from v1 to v2.
	 * 
	 * @param v1       <V> v1 vertex
	 * @param v2       <V> v2 vertex
	 * @return boolean
	 */	
	public boolean check(V v1,V v2) {
		boolean solution=false;	
		for(V i:g.neighbours(v1)) {
			if(succsess.contains(i))
				continue;
			if(i.equals(v2))
				solution=true;
			else		
				succsess.add(i);
			solution=solution||check(i, v2);
		}
		return solution;
	}

}
