class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {

        int n = grid.length;

        // Starting cell blocked hai toh path possible nahi hai
        if (grid[0][0] == 1) return -1;

        // Har cell tak pahunchne ki shortest distance store karega
        int[][] dist = new int[n][n];
        dist[0][0] = 1;

        // BFS ke liye queue use kar rahe hain
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0});

        // 8 possible directions: horizontal, vertical aur diagonal
        int[] dr = {-1,-1,-1,0,0,1,1,1};
        int[] dc = {-1,0,1,-1,1,-1,0,1};

        while (!q.isEmpty()) {

            // Queue se current cell nikalo
            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];

            // Current cell ke 8 neighbours check karo
            for (int i = 0; i < 8; i++) {

                int nr = r + dr[i];
                int nc = c + dc[i];

                // Boundary ke andar, open cell aur unvisited hona chahiye
                if (nr >= 0 && nr < n &&
                    nc >= 0 && nc < n &&
                    grid[nr][nc] == 0 &&
                    dist[nr][nc] == 0) {

                    // Current distance + 1
                    dist[nr][nc] = dist[r][c] + 1;

                    // Neighbour ko BFS queue mein daalo
                    q.offer(new int[]{nr, nc});
                }
            }
        }

        // Destination unreachable hai toh -1, warna shortest distance
        return dist[n-1][n-1] == 0 ? -1 : dist[n-1][n-1];
    }
}