class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        Queue<int[]> q = new LinkedList<>();
        int dist[] = new int[n];
        Arrays.fill(dist , Integer.MAX_VALUE);
        dist[src] = 0;
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }
        for(int e[] : flights){
            int u = e[0];
            int v = e[1];
            int wt = e[2];
            adj.get(u).add(new int[]{v , wt});
        }
        q.add(new int[]{src , 0 , 0});
        while(!q.isEmpty()){
            int curr[] = q.remove();
            int currnode = curr[0];
            int cost = curr[1];
            int stop = curr[2];
            if(stop > k){
                continue;
            }
            for(int e[] : adj.get(currnode)){
                int nextnode = e[0];
                int wt = e[1];
                if(cost + wt < dist[nextnode] && stop <= k){
                    dist[nextnode] = cost + wt;
                    q.add(new int[]{ nextnode, dist[nextnode] ,  stop + 1});
                }
            }
        }
        if(dist[dst] == Integer.MAX_VALUE){
            return -1;
        }
        return dist[dst];
    }
}
