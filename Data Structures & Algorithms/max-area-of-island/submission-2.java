class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int dr[] = {0 , 0 , 1 , -1};
        int dc[] = {-1 , 1 , 0 , 0};
        boolean visited[][] = new boolean[n][m];
        int max = 0;
        Queue<int[]>q = new LinkedList<>();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(!visited[i][j] && grid[i][j] == 1){
                    visited[i][j] = true;
                    q.add(new int[]{i , j});
                    int count = 0;
                    while(!q.isEmpty()){
                        int curr[] = q.remove();
                        int r = curr[0];
                        int c = curr[1];
                        count++;
                        for(int k = 0; k < 4; k++){
                            int nr = r + dr[k];
                            int nc = c + dc[k];
                            if(nr >= 0 && nr < n && nc >=0 && nc < m && !visited[nr][nc] && grid[nr][nc] == 1){
                                visited[nr][nc] = true;
                                q.add(new int[]{nr , nc});
                            }
                        }
                    }
                    max = Math.max(count , max);
                }
            }
        }
        return max;
    }
}
