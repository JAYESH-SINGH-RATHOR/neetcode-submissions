class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        boolean visited[] = new boolean[numCourses];
        boolean pathvisited[] = new boolean[numCourses];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < numCourses; i++){
            adj.add(new ArrayList<>());
        }       
        for(int e[] : prerequisites){
            int u = e[0];
            int v = e[1];
           adj.get(v).add(u);
        }
        for(int i = 0; i <  numCourses; i++){
            if(!visited[i]){
                if(dfsUtil(i  , visited , pathvisited , adj)){
                    return false;
                }
            }
        }
        return true;
    }
    boolean dfsUtil(int curr , boolean visited[] ,  boolean pathvisited[] , ArrayList<ArrayList<Integer>> adj ){
        visited[curr] = true;
        pathvisited[curr] = true;
        for(int e : adj.get(curr)){
            if(!visited[e]){
               if( dfsUtil(e , visited ,pathvisited, adj)){
                return true;
               }
            }
            if(pathvisited[e]){
                return true;
            }
        }
        pathvisited[curr] = false;
        return false;
    }
}
