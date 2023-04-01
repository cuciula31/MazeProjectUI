package algorithm;

import javafx.animation.PauseTransition;
import javafx.event.Event;
import javafx.scene.layout.GridPane;
import javafx.util.Duration;
import util.MazeUtil;

import java.util.LinkedList;
import java.util.Queue;

public class LevelSearch {
    public static final int[] dx = {0, 0, 1, -1};
    public static final int[] dy = {1, -1, 0, 0};

    public static boolean search(GridPane gridPane, Maze maze) {
        Queue<Man> queue = new LinkedList<>();
        boolean[][] visited = new boolean[maze.getNumRows()][maze.getNumCols()];
        Man man = maze.getMan();
        queue.add(man);
        visited[man.getX()][man.getY()] = true;

        while (!queue.isEmpty()) {

            Man curr = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nextX = curr.getX() + dx[i];
                int nextY = curr.getY() + dy[i];
                if (nextX < 0 || nextX >= maze.getNumRows() || nextY < 0 || nextY >= maze.getNumCols()) {
                    PauseTransition pauseTransition = new PauseTransition(Duration.millis(500));
                    pauseTransition.setOnFinished(Event->{
                        MazeUtil.printMaze(gridPane,maze);

                    });
                    pauseTransition.play();
                    MazeUtil.printMaze(gridPane,maze);
                    continue;
                }
                if (visited[nextX][nextY]) {
                    PauseTransition pauseTransition = new PauseTransition(Duration.millis(500));
                    pauseTransition.setOnFinished(Event->{
                        MazeUtil.printMaze(gridPane,maze);

                    });
                    pauseTransition.play();
                    MazeUtil.printMaze(gridPane,maze);

                    continue;
                }
                visited[nextX][nextY] = true;
                Chamber nextChamber = maze.getChamber(nextX, nextY);
                if (nextChamber.hasExit()) {
                    PauseTransition pauseTransition = new PauseTransition(Duration.millis(500));
                    pauseTransition.setOnFinished(Event->{
                        MazeUtil.printMaze(gridPane,maze);

                    });
                    pauseTransition.play();

                    return true;
                }
                if (!visited[nextX][nextY]) {
                    Man next = new Man(nextX, nextY);
                    PauseTransition pauseTransition = new PauseTransition(Duration.millis(500));
                    pauseTransition.setOnFinished(Event->{
                        MazeUtil.printMaze(gridPane,maze);
                    });
                    pauseTransition.play();

                    queue.add(next);
                }
            }
        }
        return false;
    }
}
