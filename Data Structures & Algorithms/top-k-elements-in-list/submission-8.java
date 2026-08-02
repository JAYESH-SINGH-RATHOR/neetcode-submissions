class Solution {
    public int[] topKFrequent(int[] nums, int k) {
    HashMap<Integer , Integer> map = new HashMap<>();
   PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> map.get(a) - map.get(b));

    for(int e : nums){
        if(!map.containsKey(e)){
            map.put(e , 0);
        }
        int freq = map.get(e);
        map.put(e , freq + 1);
    }
    for(int e : map.keySet()){
        pq.add(e);
        while(pq.size() > k){
            pq.remove();
        }
    }
    int res[] = new int[k];
    for(int i = k  - 1; i >= 0; i--){
        if(!pq.isEmpty()){
            res[i] = pq.remove();
        }
    }
    return res;
    }
}
