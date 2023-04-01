import java.util.LinkedList;
import java.util.Queue;

public class LevelSearch {
    public static final int[] dx = {0, 0, 1, -1};
    public static final int[] dy = {1, -1, 0, 0};

    public static boolean search(Maze maze) {
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
                    continue;
                }
                if (visited[nextX][nextY]) {
                    continue;
                }
                visited[nextX][nextY] = true;
                Chamber nextChamber = maze.getChamber(nextX, nextY);
                if (nextChamber.hasExit()) {
                    return true;
                }
                if (!visited[nextX][nextY]) {
                    Man next = new Man(nextX, nextY);
                    queue.add(next);
                }
            }
        }
        return false;
    }
}
