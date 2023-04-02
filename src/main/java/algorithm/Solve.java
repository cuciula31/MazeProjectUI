package algorithm;

public class Solve {

    public List<Chamber> solveMazeBFS() {
        Queue<Chamber> queue = new LinkedList<>();
        Set<Chamber> visited = new HashSet<>();
        Map<Chamber, Chamber> parents = new HashMap<>();

        queue.add(chambers[man.getX()][man.getY()]);
        visited.add(chambers[man.getX()][man.getY()]);

        while (!queue.isEmpty()) {
            Chamber currentChamber = queue.poll();
            if (currentChamber.hasExit()) {
                // Build the path from the exit to the start
                List<Chamber> path = new ArrayList<>();
                Chamber chamber = currentChamber;
                while (chamber != null) {
                    path.add(chamber);
                    chamber = parents.get(chamber);
                }
                Collections.reverse(path);
                return path;
            }

            for (int[] dir : new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}}) {
                int row = currentChamber.getRow() + dir[0];
                int col = currentChamber.getCol() + dir[1];
                if (row < 0 || row >= numRows || col < 0 || col >= numCols) {
                    continue; // Chamber is out of bounds
                }
                Chamber neighbor = getChamber(row, col);
                if (neighbor.isWall() || visited.contains(neighbor)) {
                    continue; // Chamber is a wall or has been visited
                }
                queue.add(neighbor);
                visited.add(neighbor);
                parents.put(neighbor, currentChamber);
            }
        }

        return null; // No path to an exit was found
    }

}
