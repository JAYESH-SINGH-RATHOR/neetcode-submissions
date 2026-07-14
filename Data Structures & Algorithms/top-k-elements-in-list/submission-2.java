class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer , Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i] , 0);
            }
            int freq = map.get(nums[i]);
            map.put(nums[i] , freq + 1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a , b) -> map.get(a) - map.get(b));
        for(int e : map.keySet()){
            pq.add(e);
            while(pq.size() > k){
                pq.remove();
            }
        }
        int ans[] = new int[k];
        for(int i = k - 1;  i >= 0; i--){
            ans[i] = pq.remove();
        }
        return ans;
    }
}
