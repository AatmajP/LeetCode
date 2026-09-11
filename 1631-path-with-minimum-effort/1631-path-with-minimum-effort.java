
import java.util.*;

class Solution {
    public int minimumEffortPath(int[][] heights) {

        int row = heights.length;
        int col = heights[0].length;

        // Minimum effort to reach each cell
        int[][] dist = new int[row][col];

        for (int i = 0; i < row; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        // Starting cell
        dist[0][0] = 0;

        // Min Heap: [row, col, effort]
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> a[2] - b[2]
        );

        pq.offer(new int[]{0, 0, 0});

        // Directions: up, down, left, right
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while (!pq.isEmpty()) {

            int[] cells = pq.poll();

            int r = cells[0];
            int c = cells[1];
            int effort = cells[2];

            // Destination reached
            if (r == row - 1 && c == col - 1) {
                return effort;
            }

            for (int d = 0; d < 4; d++) {

                int nr = r + dr[d];
                int nc = c + dc[d];

                // Check boundary
                if (nr >= 0 && nr < row &&
                    nc >= 0 && nc < col) {

                    // Effort of this move
                    int currentDifference =
                        Math.abs(heights[r][c] - heights[nr][nc]);

                    // Maximum effort along this path
                    int newEffort =
                        Math.max(effort, currentDifference);

                    // Found a better path
                    if (newEffort < dist[nr][nc]) {

                        dist[nr][nc] = newEffort;

                        pq.offer(new int[]{
                            nr, nc, newEffort
                        });
                    }
                }
            }
        }

        return 0;
    }
}