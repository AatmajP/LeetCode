import java.util.*;

class Solution {
    public int[][] updateMatrix(int[][] mat) {

        int rows = mat.length;
        int cols = mat[0].length;

        int[][] dist = new int[rows][cols];

        // -1 means not visited
        for (int i = 0; i < rows; i++) {
            Arrays.fill(dist[i], -1);
        }

        // Queue stores row and column
        Queue<int[]> q = new LinkedList<>();

        // Put ALL zeros into the queue
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                if (mat[i][j] == 0) {
                    dist[i][j] = 0;
                    q.offer(new int[]{i, j});
                }
            }
        }

        // Four directions
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        // Multi-source BFS
        while (!q.isEmpty()) {

            int[] cell = q.poll();

            int row = cell[0];
            int col = cell[1];

            for (int d = 0; d < 4; d++) {

                int nr = row + dr[d];
                int nc = col + dc[d];

                // Check boundary
                if (nr >= 0 && nr < rows &&
                    nc >= 0 && nc < cols) {

                    // If not visited
                    if (dist[nr][nc] == -1) {

                        dist[nr][nc] = dist[row][col] + 1;

                        q.offer(new int[]{nr, nc});
                    }
                }
            }
        }

        return dist;
    }
}