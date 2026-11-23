class Solution {
    public int findJudge(int n, int[][] trust) {
        if(n == 1){
            return 1;
        }
        int indegree[] = new int[n + 1];
        int outdegree[] = new int[n + 1];
        for(int e[] : trust){
            int u = e[0];
            int v = e[1];
            outdegree[u]++;
            indegree[v]++;
        }
        for(int i = 0; i <= n; i++){
            if(indegree[i] == n - 1 && outdegree[i] == 0){
                return i;
            }
        }
        return -1;
    }
}