

class Solution {
    public int numIslands(char[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;

        boolean[][] visited = new boolean[rows][cols];

        int count = 0;

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < cols; j++) {

                if (grid[i][j] == '1' && !visited[i][j]) {

                    count++;

                    Queue<int[]> q = new LinkedList<>();

                    visited[i][j] = true;
                    q.offer(new int[]{i, j});

                    while (!q.isEmpty()) {

                        int[] cell = q.poll();

                        int row = cell[0];
                        int col = cell[1];

                        for (int d = 0; d < 4; d++) {

                            int nr = row + dr[d];
                            int nc = col + dc[d];

                            if (nr >= 0 && nr < rows &&
                                nc >= 0 && nc < cols) {

                                if (grid[nr][nc] == '1' &&
                                    !visited[nr][nc]) {

                                    visited[nr][nc] = true;
                                    q.offer(new int[]{nr, nc});
                                }
                            }
                        }
                    }
                }
            }
        }

        return count;
    }
}