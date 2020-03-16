package graph;
/**
 * A class to describe a graph whose 
 * vertices are of the abstract type V.
 * 
 * @author Idan Abergel & Hen Hess
 */
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Graph<V> {

	private Set<V> vertices = new HashSet<>();
	private Map<V, Set<V>> edges = new HashMap<V, Set<V>>();
	private Set<V> agree = new HashSet<>();
	/**
	 * Adds the node to the graph
	 * @param v       <V> v the vertex 
	 */
	public void addVertex(V v) throws GraphException {
		if (vertices.contains(v))
			throw new GraphException("v exsist in the graph");
		vertices.add(v);
		edges.put(v, new HashSet<V>());
	}
	/**
	 * add a bow connecting the two vertices
	 * @param v1       <V> v1 the vertex 1 
	 * @param v2       <V> v2 the vertex 2
	 */
	public void addEdge(V v1, V v2) throws GraphException {
		if(v1 == null || v2 == null )
			throw new GraphException("v1 or v2 null");
		
		if (!vertices.contains(v1))
			throw new GraphException(v1 + " doesn't exist");
		if (!vertices.contains(v2))
			throw new GraphException(v2 + " doesn't exist");
		
		if(hasEdge(v1, v2))
			throw new GraphException("Edge already exist");
		if(hasEdge(v2, v1))
			throw new GraphException("Edge already exist");
		edges.get(v1).add(v2);
		edges.get(v2).add(v1);

	}
	/**
	 * Will return true if there is an arc between v1 and v2
	 * @param v1       <V> v1 the vertex 1 
	 * @param v2       <V> v2 the vertex 2
	 */
	public boolean hasEdge(V v1, V v2) {
		// v1 contains all his neighbors. if v2 is not a neighbor return false. 
		return edges.get(v1).contains(v2) ||edges.get(v2).contains(v1);
	}
	/**
	 * Will return true if v1 connected to v2
	 * @param v1       <V> v1 the vertex 1 
	 * @param v2       <V> v2 the vertex 2
	 */
	public boolean connected(V v1, V v2) throws GraphException {
		agree.clear();
		if(v1 == null || v2 == null )
			throw new GraphException("v1 or v2 null");
		
		if (vertices.contains(v1)==false)
			throw new GraphException("v1 don't exist");
		if (vertices.contains(v2)==false)
			throw new GraphException("v2 don't exist");
		if (v1.equals(v2)==true)
			return true;
		
		return bfs(v1, v2);
	}
	/**
	 * check neighbors methods bfs if its true.
	 * @param n       <V> neighbor vertex
	 * @param d       <V> destination. vretex
	 */
	private boolean bfs(V n, V d) {

		boolean sol = false;
		for (V i : edges.get(n)) {
			if (agree.contains(i)==true)
				continue;
			
			if (i != null && i.equals(d)==true)
				return true;
			else {
				agree.add(i);
				sol = sol || bfs(i, d);
			}
		}
		return sol;
	}
}
