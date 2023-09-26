
/**
 * 	Maze class; builds and stores maze to be solved Maze 
 *  0 -> open space
 *  1 -> open space (part of path)
 *  -1 -> wall
 * 
 * @author wyattsmac
 *
 */
import java.util.Random;

public class Maze {

	private final int MAX_SIZE = 16; // sets max hieght/width to 16
	private int[][] maze; // sets 16x16 int array
	private final int START_X, START_Y;
	private final int END_X, END_Y;

	Maze() {
		this.maze = new int[MAX_SIZE][MAX_SIZE];
		this.START_X = 0;
		this.START_Y = 0;
		this.END_X = MAX_SIZE - 1;
		this.END_Y = MAX_SIZE - 1;
	}

	/**
	 * 
	 * @param x -> x coordinate of element
	 * @param y -> y coordinate of element
	 * @return int value of element
	 */
	protected int getElement(int x, int y) {
		return this.maze[x][y];
	}

	protected int getSize() {
		return this.MAX_SIZE;
	}

	protected void setElement(int x, int y, int newElement) {

		if ((x >= MAX_SIZE)) {
			System.out.println("Index too large: IOB");
			System.out.println("Attempted index was: " + x + ", " + y);
			return;
		}
		this.maze[x][y] = newElement;
	}

	/**
	 * Randomly generates maze with at least one path to success
	 */
	protected void generateMaze() {
		Random rand = new Random();

		setElement(this.START_X, this.START_Y, 8);
		setElement(this.END_X, this.END_Y, 9);
		// set start , finish indexes

		int wall = -1;
		int upper = MAX_SIZE - 1;
		int wallStart = 1;
		int wallDepth;
		// walls to alternate vertical side of origin
		boolean up = false;

		while (wallStart <= upper) {
			wallDepth = rand.nextInt(upper);
			if (up) {
				for (int y = 0; y <= wallDepth; y++) {
					setElement(wallStart, upper - y, wall);
				}
			} else {
				for (int y = 0; y <= wallDepth; y++) {
					setElement(wallStart, y, wall);
				}
			}
			wallStart +=  3;
			// change upper to accomodate rand.nextInt() fixed nature
			upper = wallDepth + 1;
			up = !up;
		}

	}

	protected void clearMaze() {
		//fixme; add method
	}

	public String toString() {
		return "";
	}

	public void displayGrid() {
		generateMaze();
		for (int x = 0; x < MAX_SIZE; x++) {
			for (int y = 0; y < MAX_SIZE; y++) {
				System.out.print(getElement(y, x));
				System.out.print(" ");
			}
			System.out.println();
		}
	}

}
