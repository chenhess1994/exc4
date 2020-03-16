package graph;
/**
 * Manage The class will describe a two-dimensional 
 * location within a square
 * 
 * @author Idan Abergel & Hen Hess
 */

public class Place implements Comparable<Place>{
	private int x, y;
	/**
	 * Contractor of class Place
	 * @param x       <Int> number of x 
	 * @param y       <Int> number of y
	 * @param bound   <Int> number of bound
	 * @throw IllegalArgumentException when x or y out of <b>bound</b> range.
	 */
	public Place(int x, int y, int bound) {

		if (x < 0 || x > bound - 1 || y < 0 || y > bound - 1)
				throw new IllegalArgumentException("bad1");// run time exeption
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}

	/**
	 * implements the methods equal for interface.
	 * 
	 * @param o  <Object>  compare between to numbers
	 * @return <Boolean> true if its equal false otherwise.
	 */
	@Override
	public boolean equals(Object o) {
		if(o==null) 
			throw new IllegalArgumentException("bad1");// run time exeption
		if ((Place) o == this)
			return true;
		if (!(o instanceof Place))
			return false;
		return ((Place) o).x == x && ((Place) o).y == y;
	}
	/**
	 * implements the metods HashCode.
	 * @return <int> the number of place empty in the hash.
	 */
	@Override
	public int hashCode() { 
		return (int)(6*x+7*y+8);
	}
	/**
	 * implements the methods compareTo for comparable interface.
	 * @param o  <Place>  compare between to numbers
	 * @return <int> the equal number.
	 */
	@Override
	public int compareTo(Place o) {
		if(o==null) 
			throw new IllegalArgumentException("bad1");// run time exeption

		if(x > o.getX() && y > o.getY()) return 1;
		if(x < o.getX() && y < o.getY()) return -1;
		
		return 0;
	}

}
