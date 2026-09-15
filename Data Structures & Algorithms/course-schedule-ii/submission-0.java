class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        Stack<Integer> st = new Stack<>();
        boolean visited[] = new boolean[numCourses];
        boolean pathvisited[] = new boolean[numCourses];
        for(int i = 0; i < numCourses; i++){
            adj.add(new ArrayList<>());
        }
        for(int e[] : prerequisites){
            int u = e[0];
            int v = e[1];
            adj.get(v).add(u);
        }
        for(int i = 0; i < numCourses; i++){
            if(!visited[i]){
                if(dfsUtil(adj , i , visited , pathvisited , st)){
                    return new int[0];
                }
            }
        }
        int res[] = new int[numCourses];
        int idx = 0;
        while(!st.isEmpty()){
            res[idx++] = st.pop();
        }
        return res;
    }
    boolean dfsUtil(ArrayList<ArrayList<Integer>> adj , int curr ,
    boolean visited[] , boolean pathvisited[] , Stack<Integer> st){
        visited[curr] = true;
        pathvisited[curr] = true;
        for(int e : adj.get(curr)){
            if(pathvisited[e]){
                return true;
            }
            if(!visited[e]){
                if(dfsUtil(adj ,e , visited , pathvisited , st)){
                    return true;
                }
            }
        }
        pathvisited[curr] = false;
        st.push(curr);
        return false;
    }
}
