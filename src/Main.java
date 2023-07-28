import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		System.out.println("Begin");
		// test maze display
		Maze myMaze = new Maze();
//		String proceed = "y";
//		do {
//			Scanner scanner = new Scanner(System.in); // Create a Scanner object
//			System.out.println("Enter: y to continue; x to quit");
		myMaze.displayGrid();
		System.out.println();
		System.out.println();
		System.out.println("Start Recursion");
//			proceed = scanner.nextLine();  // Read user input
//		} while (proceed != "x");
		MazeSolver mySolver = new MazeSolver();
		mySolver.solved(myMaze);
		mySolver.displaySolved();
	}

}
