class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int dr[] = {0 , 0 , 1 , -1};
        int dc[] = {-1 , 1 , 0 , 0};
        boolean visited[][] = new boolean[n][m];
        Queue<int[]>q = new LinkedList<>();
        int freshoranges = 0;
        int time = 0;
        for(int i = 0; i < n; i++){
            for(int j  = 0; j < m; j++){
                if(grid[i][j] == 1 && !visited[i][j]){
                    freshoranges++;
            }else if(grid[i][j] == 2 && !visited[i][j]){
                visited[i][j] = true;
                q.add(new int[]{i , j});
            }
        }
        }
        while(!q.isEmpty() && freshoranges > 0){
            int size = q.size();
            for(int x = 0; x < size; x++){
                int curr[] = q.remove();
                int r = curr[0];
                int c = curr[1];
                for(int k = 0; k < 4; k++){
                    int nr = r + dr[k];
                    int nc = c + dc[k];
                    if(nr >= 0 && nr < n && nc >= 0 && nc < m && !visited[nr][nc]&& grid[nr][nc] == 1 ){
                        visited[nr][nc] = true;
                        grid[nr][nc] = 2;
                        q.add(new int[]{nr , nc});
                        freshoranges--;
                    }
                }
            }
            time++;
        }
        return freshoranges == 0 ? time : -1;
    }
}
