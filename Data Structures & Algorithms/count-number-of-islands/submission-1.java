class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean visited[][] = new boolean[n][m];
        int count = 0;
        int dr[] = {0 , 0 , -1 , 1};
        int dc[] = {-1 , 1 , 0 , 0};
        Queue<int[]>q = new LinkedList<>();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == '1' && !visited[i][j]){
                    count++;
                    visited[i][j] = true;
                    q.add(new int[]{i , j});
                    while(!q.isEmpty()){
                        int curr[] = q.remove();
                        int r = curr[0];
                        int c = curr[1];
                        for(int x = 0; x < 4; x++){
                            int nr = r + dr[x];
                            int nc = c + dc[x];
                            if(nr >= 0 && nr < n && nc < m && nc >= 0 && !visited[nr][nc] && grid[nr][nc] == '1'){
                                visited[nr][nc] = true;
                                q.add(new int[]{nr , nc});
                            }
                        }
                    }
                }
            }
        }
        return count;
    }
}
