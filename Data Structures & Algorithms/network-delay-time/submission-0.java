class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int dist[] = new int[n + 1];
        Arrays.fill(dist , Integer.MAX_VALUE);
        dist[k] = 0;
        for(int i = 1; i <= n; i++){
            for(int e[] : times){
                int u = e[0];
                int v = e[1];
                int wt = e[2];
                if(dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v]){
                    dist[v] = dist[u] + wt;
                }
            }
        }
        int res = 0;
        for(int i = 1; i <= n; i++){
            if(dist[i]  == Integer.MAX_VALUE){
                return -1;
            }
            res = Math.max(res , dist[i]);
        }
        return res;
    }
}
