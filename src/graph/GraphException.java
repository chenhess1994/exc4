package graph;
/**
 * A class inheriting Exception and intended for errors
 * @author Idan Abergel & Hen Hess
 */
@SuppressWarnings("serial")
public class GraphException extends Exception{
	public GraphException(String msg) {
		super(msg);
	}
}
