class Solution {
    public int findDuplicate(int[] nums) {
        HashMap<Integer , Integer> map = new HashMap<>();
        for(int n : nums){
            if(!map.containsKey(n)){
                map.put(n , 0);
            }
            int freq = map.get(n);
            map.put(n , freq + 1);
        }
        for(int key : map.keySet()){
            int freq = map.get(key);
            if(freq > 1){
                return key;
            }
        }
        return -1;
    }
}
