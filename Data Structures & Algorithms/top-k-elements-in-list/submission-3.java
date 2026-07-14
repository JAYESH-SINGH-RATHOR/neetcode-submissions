class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer , Integer> map = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>((a , b) -> map.get(a) - map.get(b));
        for(int ele : nums){
            if(!map.containsKey(ele)){
                map.put(ele , 0);
            }
            int freq = map.get(ele);
            map.put(ele , freq + 1);
        }
        for(int val : map.keySet()){
            pq.add(val);
            while(pq.size() > k){
                pq.remove();
            }
        }
       int ans[] = new int[k];
       for(int i = k - 1; i >= 0; i--){
        ans[i] = pq.remove();
       }
       return ans;
    }
}
