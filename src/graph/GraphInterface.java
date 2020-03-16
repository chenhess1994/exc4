package graph;
/**
 * This interface has a method, which, 
 * given a vertex, knows how to retrieve a collection 
 * of the vertices that are its neighbors.
 * @author Idan Abergel & Hen Hess
 */
import java.util.Collection;

public interface GraphInterface<V> {
	public Collection<V> neighbours(V v);
	
}
