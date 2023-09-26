/**
 * Backtracking Maze Solver
 * @author Wyatt Murphy
 * 
 */


public class MazeSolver {

	private Maze themaze;
	private int MAX_SIZE;
	private final int path = 2;

	MazeSolver() {

	}

	public void displaySolved() {
		themaze.displayGrid();
	}

	/**
	 * accepts unsolved maze and returns solved maze
	 * 
	 * @param unSolved unsolved Maze object
	 * @return solved Maze object
	 */
	public boolean solved(Maze unSolved) {
		this.themaze = unSolved;
		this.MAX_SIZE = unSolved.getSize();

		return solver(0, 0);
	}

	/**
	 * recursive backtracking algorithm to solve maze
	 * 
	 * @param maze
	 * @return
	 */
	private boolean solver(int x, int y) {
		System.out.println("call to recursive method : solver");
		System.out.println("Coordinates of call: (" + x + ", " + y + ")");
		System.out.println();
		this.displaySolved();
		System.out.println();
		// decision space - maze
		// key choice - making 0 cell part of path to finish
		// constraints
		// - place 2 cell only if valid move
		// - move right, down, up as far as possible
		// backtrack 
		// - Stop when fair path reaches end square

		// base case : 0 -> solution
		if (x == (this.MAX_SIZE - 1) && y == this.MAX_SIZE - 1) {
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();

			System.out.println("YOU MADE IT!!!!!");

			System.out.println();
			System.out.println();
			System.out.println();

			return true;

		}
		// mark current position as part of path
		if (isValidMove(x, y)) {
			this.themaze.setElement(x, y, path);

			if (solver(x + 1, y)) {
				return true;
			}
			if (solver(x, y + 1)) {
				return true;
			}
			if (solver(x, y - 1)) {
				return true;
			}

			// backtrack, mark position as open space
			this.themaze.setElement(x, y, 0);

		}

		return false;
	}

	/**
	 * checks if move is valid
	 * @param x x coordinate
	 * @param y y coordinate
	 * @return boolean of moves validity
	 */
	private boolean isValidMove(int x, int y) {

		// case : 0 -> index out of bounds
		if (x >= (this.MAX_SIZE) || y >= (this.MAX_SIZE) || ((x < 0) || (y < 0))) {
			return false;
		}

		// case : 1 -> occupied cell
		if (this.themaze.getElement(x, y) == 2) {
			return false;
		}

		// case : 2 -> space is a wall
		if (this.themaze.getElement(x, y) == -1) {
			return false;
		}
		return true;
	}
}
