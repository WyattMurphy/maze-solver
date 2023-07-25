
/**
 * Maze class that builds and stores maze to be solved Maze units 0 -> open
 * space, 1 -> open space part of path, -1 -> wall
 * 
 * @author wyattsmac
 *
 *
 */
import java.util.Random;

public class Maze {

	private final int MAX_SIZE = 16; // sets max hieght/width to 32
	private int[][] maze; // sets 32x32 int array

	Maze() {
		this.maze = new int[MAX_SIZE][MAX_SIZE];
		// FIXME build actual maze
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

	protected void setElement(int x, int y, int newElement) {

		if ((x > (MAX_SIZE - 1)) || ((MAX_SIZE - 1) > 31)) {
			System.out.println("Index too large: IOB");
			return;
		}
		this.maze[x][y] = newElement;
	}

	/**
	 * Randomly generates maze with at least one path to success
	 */
	protected void generateMaze() {
		Random rand = new Random();
		int wall = -1;
		int upper = MAX_SIZE - 2;
		// int int_random = rand.nextInt(upper);
		int wallStart = 1;
		int wallDepth;

		while (wallStart <= upper) {
			wallStart += ((rand.nextInt(upper)) % 6);
			wallDepth = rand.nextInt(upper);

			for (int y = 0; y <= wallDepth; y++) {

				setElement(wallStart, y, wall);

			}

		}

	}

	protected void clearMaze() {

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
