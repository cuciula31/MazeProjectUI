import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create a 10x10 maze with 2 exits and a man at (0, 0)
        Maze maze = new Maze(10, 10, 2, 0, 0);

        // Loop until the man reaches an exit or the user quits
        while (true) {
            // Print the current state of the maze
            printMaze(maze);

            // Prompt the user for a direction to move
            System.out.print("Enter a direction (up/down/left/right) or q to quit: ");
            String input = scanner.nextLine();

            // Move the man or quit the game
            if (input.equals("q")) {
                System.out.println("Goodbye!");
                break;
            } else if (input.equals("up")) {
                maze.moveMan(-1, 0);
            } else if (input.equals("down")) {
                maze.moveMan(1, 0);
            } else if (input.equals("left")) {
                maze.moveMan(0, -1);
            } else if (input.equals("right")) {
                maze.moveMan(0, 1);
            } else {
                System.out.println("Invalid input.");
            }

            // Check if the man has reached an exit
            if (maze.getChamber(maze.getMan().getX(), maze.getMan().getY()).hasExit()) {
                System.out.println("Congratulations, you've reached an exit!");
                break;
            }
        }
    }

    private static void printMaze(Maze maze) {
        System.out.println("  " + "-".repeat(maze.getNumCols() * 2 - 1));
        for (int i = 0; i < maze.getNumRows(); i++) {
            System.out.print("|");
            for (int j = 0; j < maze.getNumCols(); j++) {
                if (maze.getChamber(i, j).hasPerson()) {
                    System.out.print("M");
                } else if (maze.getChamber(i, j).hasExit()) {
                    System.out.print("E");
                } else {
                    System.out.print(" ");
                }
                if (j < maze.getNumCols() - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println("|");
        }
        System.out.println("  " + "-".repeat(maze.getNumCols() * 2 - 1));
    }
}
