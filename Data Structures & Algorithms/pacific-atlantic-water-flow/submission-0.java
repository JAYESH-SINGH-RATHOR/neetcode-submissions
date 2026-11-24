class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        boolean pacific[][] = new boolean[n][m];
        boolean atlantic[][] = new boolean[n][m];
        int dr[] = {0 , 0 , 1 , -1};
        int dc[] = {-1 , 1 , 0 ,0};
        Queue<int[]> q = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();

        // for top row 
        for(int i = 0; i < m; i++){
            if(!pacific[0][i]){
                pacific[0][i] = true;
                q.add(new int[]{0 , i});
            }
        }

        // for left row

        for(int i = 0; i < n; i++){
            if(!pacific[i][0]){
                pacific[i][0] = true;
                q.add(new int[]{i , 0});
            }
        }

        while(!q.isEmpty()){
            int curr[] = q.remove();
            int r = curr[0];
            int c = curr[1];
            for(int k = 0; k < 4; k++){
                int nr = r + dr[k];
                int nc = c + dc[k];
                if(nr >= 0 && nr < n && nc >= 0 && nc < m && !pacific[nr][nc] && heights[nr][nc] >= heights[r][c]){
                    pacific[nr][nc] = true;
                    q.add(new int[]{nr, nc});
                }
            }
        }

        // for bottom side 
        for(int i = 0; i < m; i++){
            if(!atlantic[n - 1][i]){
                atlantic[n - 1][i] = true;
                q.add(new int[]{n - 1 , i});
            }
        }

        // for right side 
        for(int i = 0; i < n; i++){
            if(!atlantic[i][m - 1]){
                atlantic[i][m - 1] = true;
                q.add(new int[]{i , m - 1});
            }
        }
        while(!q.isEmpty()){
            int curr[] = q.remove();
            int r = curr[0];
            int c = curr[1];
            for(int k = 0; k < 4; k++){
                int  nr = r + dr[k];
                int nc = c + dc[k];
                if(nr >= 0 && nr < n && nc >= 0 && nc < m && !atlantic[nr][nc] 
                && heights[nr][nc] >= heights[r][c]){
                    atlantic[nr][nc] = true;
                    q.add(new int[]{nr , nc});
                }
            }
        }
       for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(pacific[i][j] && atlantic[i][j]){
                    res.add(Arrays.asList(i, j));
                }
            }
        }
        return res;
    }
}
