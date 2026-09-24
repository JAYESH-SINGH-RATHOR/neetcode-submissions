class Solution {
    public int countComponents(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }
        int count = 0;
        for(int e[] : edges){
            int u = e[0];
            int v = e[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        boolean visited[] = new boolean[n];
        for(int i = 0; i < n; i++){
            if(!visited[i]){
                dfsUtil(i , adj , visited);
                count++;
            }
        }
        return count;
    }
    void dfsUtil(int curr , ArrayList<ArrayList<Integer>> adj , boolean visited[]){
        visited[curr] = true;
        for(int e : adj.get(curr)){
            if(!visited[e]){
                dfsUtil(e , adj , visited);
            }
        }
    }
}
