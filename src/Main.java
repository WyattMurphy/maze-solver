
public class Main {

	public static void main(String[] args) {
		System.out.println("Begin");
		// test maze display
		Maze myMaze = new Maze();

		myMaze.displayGrid();

		MazeSolver mySolver = new MazeSolver();
		mySolver.solved(myMaze);
		mySolver.displaySolved();
	}

}
