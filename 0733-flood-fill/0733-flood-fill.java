import java.util.*;

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        int originalColor = image[sr][sc];

        // Already the required color
        if (originalColor == color) {
            return image;
        }

        Queue<int[]> q = new LinkedList<>();

        // Start BFS
        q.offer(new int[]{sr, sc});
        image[sr][sc] = color;

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while (!q.isEmpty()) {

            int[] cell = q.poll();

            int row = cell[0];
            int col = cell[1];

            // Check 4 neighbours
            for (int d = 0; d < 4; d++) {

                int nr = row + dr[d];
                int nc = col + dc[d];

                // Boundary + same original color
                if (nr >= 0 && nr < image.length &&
                    nc >= 0 && nc < image[0].length &&
                    image[nr][nc] == originalColor) {

                    // Change color
                    image[nr][nc] = color;

                    // Add neighbour to queue
                    q.offer(new int[]{nr, nc});
                }
            }
        }

        return image;
    }
}