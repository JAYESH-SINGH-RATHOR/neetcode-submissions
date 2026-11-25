class Solution {
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        boolean visited[][] = new boolean[n][m];
        int dr[] = {0, 0, 1, -1};
        int dc[] = {-1, 1, 0, 0};
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // if(board[0][j] == 'O' || board[i][0] == 'O' || board[n-1][j] == 'O' || board[i][m
                // - 1] == 'O'){
               if(i == 0 || j == 0 || i == n-1 || j == m-1) {
                    if (!visited[i][j] && board[i][j] == 'O') {
                        visited[i][j] = true;
                        q.add(new int[] {i, j});
                        while (!q.isEmpty()) {
                            int curr[] = q.remove();
                            int r = curr[0];
                            int c = curr[1];
                            for (int k = 0; k < 4; k++) {
                                int nr = r + dr[k];
                                int nc = c + dc[k];
                                if (nr >= 0 && nr < n && nc >= 0 && nc < m && !visited[nr][nc] && board[nr][nc] == 'O') {
                                    visited[nr][nc] = true;
                                    q.add(new int[] {nr, nc});
                                }
                            }
                        }
                    }
                }
            }
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(board[i][j] == 'O' && !visited[i][j]){
                   board[i][j] = 'X';
                }
            }
        }
    }
}
