
class Solution {
    public int minCost(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        // dist[i][j] = minimum cost to reach cell (i, j)
        int[][] dist = new int[rows][cols];

        // Initially, we don't know the cost to reach any cell
        Arrays.fill(dist[0], Integer.MAX_VALUE);
        for (int i = 1; i < rows; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        // We start from the top-left cell, so its cost is 0
        dist[0][0] = 0;

        // 0-1 BFS uses a deque instead of a normal queue
        Deque<int[]> deque = new ArrayDeque<>();

        // Start BFS from (0, 0)
        deque.addFirst(new int[]{0, 0});

        // Directions: right, left, down, up
        int[] dr = {0, 0, 1, -1};
        int[] dc = {1, -1, 0, 0};

        while (!deque.isEmpty()) {

            // Take the next cell from the front
            int[] cur = deque.pollFirst();

            int row = cur[0];
            int col = cur[1];

            // Try all 4 possible directions
            for (int i = 0; i < 4; i++) {

                // Find the neighboring cell
                int nr = row + dr[i];
                int nc = col + dc[i];

                // Ignore the neighbor if it is outside the grid
                if (nr >= 0 && nr < rows &&
                    nc >= 0 && nc < cols) {

                    /*
                     * If the cell's arrow points in this direction,
                     * we follow the arrow, so cost = 0.
                     *
                     * Otherwise, we change the arrow, so cost = 1.
                     */
                    int cost = (grid[row][col] == i + 1) ? 0 : 1;

                    // Cost to reach the neighbor through the current cell
                    int newD = dist[row][col] + cost;

                    // If this is a cheaper way to reach the neighbor
                    if (newD < dist[nr][nc]) {

                        // Save the new minimum cost
                        dist[nr][nc] = newD;

                        /*
                         * Cost 0 means this path is cheaper immediately,
                         * so process it from the front.
                         *
                         * Cost 1 means process it from the back.
                         */
                        if (cost == 0) {
                            deque.addFirst(new int[]{nr, nc});
                        } else {
                            deque.addLast(new int[]{nr, nc});
                        }
                    }
                }
            }
        }
        return dist[rows - 1][cols - 1];
    }
}