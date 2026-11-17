class Solution {
    public int[][] merge(int[][] intervals) {
        ArrayList<int[]> list = new ArrayList<>();
        Arrays.sort(intervals , (a , b) -> a[0] - b[0]);
        list.add(intervals[0]);
        for(int i = 0; i < intervals.length; i++){
            int s[] = intervals[i];
            int e[] = list.get(list.size() - 1);
            if(s[0] <= e[1]){
                s[0] = Math.min(s[0] , e[0]);
                e[1] = Math.max(s[1] , e[1]);
            }else{
               list.add(intervals[i]);
            }
        }
        int res[][] = new int[list.size()][2];
        for(int i = 0; i < list.size(); i++){
            res[i] = list.get(i);
        }
        return res;
    }
}
