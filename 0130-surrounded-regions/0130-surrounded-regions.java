import java.util.*;

class Solution {
    public void solve(char[][] board) {

        int row = board.length;
        int co = board[0].length;

        Queue<int[]> q = new LinkedList<>();

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        // Left and right boundary
        for (int i = 0; i < row; i++) {

            if (board[i][0] == 'O') {
                q.offer(new int[]{i, 0});
                board[i][0] = '#';
            }

            if (board[i][co - 1] == 'O') {
                q.offer(new int[]{i, co - 1});
                board[i][co - 1] = '#';
            }
        }

        // Top and bottom boundary
        for (int j = 0; j < co; j++) {

            if (board[0][j] == 'O') {
                q.offer(new int[]{0, j});
                board[0][j] = '#';
            }

            if (board[row - 1][j] == 'O') {
                q.offer(new int[]{row - 1, j});
                board[row - 1][j] = '#';
            }
        }

        // BFS
        while (!q.isEmpty()) {

            int[] cells = q.poll();

            int r = cells[0];
            int c = cells[1];

            for (int d = 0; d < 4; d++) {

                int nr = r + dr[d];
                int nc = c + dc[d];

                if (nr >= 0 && nr < row &&
                    nc >= 0 && nc < co &&
                    board[nr][nc] == 'O') {

                    board[nr][nc] = '#';
                    q.offer(new int[]{nr, nc});
                }
            }
        }

        // Convert remaining O → X
        // Convert safe # → O
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < co; j++) {

                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                else if (board[i][j] == '#') {
                    board[i][j] = 'O';
                }
            }
        }
    }
}