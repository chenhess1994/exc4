package graph;

import java.util.Collection;
import java.util.HashSet;
/**
 * Class that defines the maze
 * 
 * @author Idan Abergel & Hen Hess
 */

public class Maze implements GraphInterface<Place> {
	private int startx, starty, endx, endy, size;
	private Place[][] matrix;
	/**
	 * Contractor of class Maze
	 * @param startx       <Int> start maze x
	 * @param starty       <Int> start maze y
	 * @param endx         <Int> end maze x
	 * @param endy         <Int> end maze y
	 * @param starty       <Int> size of maze
	 * @param bound   <Int> number of bound
	 */
	public Maze(int size, int startx, int starty, int endx, int endy) {
		this.size = size;
		this.startx = startx;
		this.starty = starty;
		this.endx = endx;
		this.endy = endy;
		matrix = new Place[size][size];
	}
	/**
	 * Put a wall in the place.
	 * 
	 * @param x  <int>  x 
	 * @param y  <int>  y 
	 * @return <Boolean> true if its empty and put the wall
	 * otherwise false its full place.
	 */
	public boolean addWall(int x, int y) {

		if (startx > size || starty > size || endx > size || endy > size || size < 0)
			throw new IllegalArgumentException();
		if (x < startx || x > endx || y < starty || y > endy)
			throw new IndexOutOfBoundsException();
		// if it's on the start or the end or on the wall.
		if (matrix[x][y] != null || (x == startx && y == starty) || (x == endx && y == endy))
			return false;
		// add wall to the matrix
		matrix[x][y] = new Place(x, y, size);
		return true;
	}
	/**
	 * Returns representation in the string of the maze
	 */
	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();

		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if ((i == startx && j == starty))
					s.append("S");
				else if ((i == endx && j == endy))
					s.append("E");
				else if (matrix[i][j] != null)
					s.append("@");
				else
					s.append(".");
			}
			s.append("\n");
		}

		return s.toString();
	}
	/**
	 * It will produce <Graph> Place, insert the induced graph.
	 * 
	 * @return <Boolean> true if its solvable graph
	 * otherwise false if its not solvable
	 */
	public boolean isSolvable() {

		Graph<Place> newMaze = new Graph<>();
		// This loop creates all the vertexes.
		for (int i = 0; i < size; i++)
			for (int j = 0; j < size; j++)
				if (matrix[i][j] == null)
					try {
						newMaze.addVertex(new Place(i, j, size));
					} catch (GraphException e) {
						e.printStackTrace();
					}

		// This loop creates all the edges
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				// its a wall
				if (matrix[i][j] != null)
					continue;
				// check left-colmun
				if (j > 0 && matrix[i][j - 1] == null && !newMaze.hasEdge(new Place(i, j, size), new Place(i, j - 1, size))) {
					try {
						newMaze.addEdge(new Place(i, j, size), new Place(i, j - 1, size));
					} catch (GraphException e) {
						e.printStackTrace();
					}

				}
				// check right-colmun
				if ( j < size - 1 && matrix[i][j + 1] == null && !newMaze.hasEdge(new Place(i, j, size), new Place(i, j + 1, size))) {
					try {
						newMaze.addEdge(new Place(i, j, size), new Place(i, j + 1, size));
					} catch (GraphException e) {
						e.printStackTrace();
					}

				}
				// check up-row
				if (i > 0 && matrix[i - 1][j] == null && !newMaze.hasEdge(new Place(i, j, size), new Place(i-1, j, size))) {
					try {
						newMaze.addEdge(new Place(i, j, size), new Place(i - 1, j, size));
					} catch (GraphException e) {
						e.printStackTrace();
					}

				}
				// check down-row
				if (i < size - 1 && matrix[i + 1][j] == null && !newMaze.hasEdge(new Place(i, j, size), new Place(i+1, j, size))) {
					try {
						newMaze.addEdge(new Place(i, j, size), new Place(i + 1, j, size));
					} catch (GraphException e) {
						e.printStackTrace();
					}

				}

			}
		}
		
		try {
			if(newMaze.connected(new Place(startx,starty, size) , new Place(endx,endy,size)))
				return true;
		}
			catch (GraphException e) {
				e.printStackTrace();
			}
				return false;
		}
	/**
	 * 	Each location will return its legal neighbors.
	 * @param p  <Place>  p the position
	 * @return <Collection> return collection of 
	 * neighbors of this place
	 */
	@Override
	public Collection<Place> neighbours(Place p) {
			
		Collection<Place> n= new HashSet<>();
		if (p.getX() > 0 && matrix[p.getX() - 1][p.getY()]==null)
			n.add(new Place(p.getX() - 1, p.getY(), size));
		
		if (p.getX() < size - 1 && matrix[p.getX() + 1][p.getY()]==null)
			n.add(new Place(p.getX() + 1, p.getY(), size));
		
		if (p.getY()< size - 1 && matrix[p.getX()][p.getY() + 1]==null)
			n.add(new Place(p.getX(), p.getY() + 1, size));
		
		if (p.getY() > 0 && matrix[p.getX()][p.getY() - 1]==null)
			n.add(new Place(p.getX(), p.getY() - 1, size));
		return n;
	}
			
	}

