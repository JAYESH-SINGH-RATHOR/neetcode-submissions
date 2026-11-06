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
        for(int i = 0; i < numCourses; i++){
            if(!visited[i]){
                if(canfinish(i , adj , visited , pathvisited)){
                    return false;
                }
            }
        }
        return true;
    }
    boolean canfinish(int curr , ArrayList<ArrayList<Integer>> adj , boolean visited[] , boolean pathvisited[]){
        visited[curr] = true;
        pathvisited[curr] = true;
        for(int e : adj.get(curr)){
            if(pathvisited[e]){
                return true;
            }
            if(!visited[e]){
                if(canfinish(e , adj , visited, pathvisited)){
                    return true;
                }
            }
        }
        pathvisited[curr] = false;
        return false;
    }
}
