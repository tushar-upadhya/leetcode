import java.util.*;

class Solution {
    public int minimumObstacles(int[][] grid) {
        int nRows = grid.length;
        int nCols = grid[0].length;
        
        // Directions for moving up, right, down, and left
        int diffs[][] = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        
        // A deque to perform 0-1 BFS
        Deque<int[]> deque = new ArrayDeque<>();
        
        // Distance array initialized to a large value
        int[][] distance = new int[nRows][nCols];
        for (int[] row : distance) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        
        // Start from the top-left corner
        deque.offerFirst(new int[]{0, 0});
        distance[0][0] = 0;

        // Perform BFS
        while (!deque.isEmpty()) {
            int[] current = deque.pollFirst();
            int i = current[0], j = current[1];

            // Check all 4 possible directions
            for (int[] diff : diffs) {
                int newI = i + diff[0];
                int newJ = j + diff[1];

                // Check if the new position is within bounds
                if (newI >= 0 && newI < nRows && newJ >= 0 && newJ < nCols) {
                    int newDistance = distance[i][j] + grid[newI][newJ];

                    // If a shorter path to this cell is found, update it
                    if (newDistance < distance[newI][newJ]) {
                        distance[newI][newJ] = newDistance;

                        // Push to front or back of deque based on cell value
                        if (grid[newI][newJ] == 0) {
                            deque.offerFirst(new int[]{newI, newJ});
                        } else {
                            deque.offerLast(new int[]{newI, newJ});
                        }
                    }
                }
            }
        }

        // Return the distance to the bottom-right corner
        return distance[nRows - 1][nCols - 1];
    }
}