class Solution {
    public boolean hasDuplicate(int[] nums) {
        int n = nums.length;
        HashMap<Integer , Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i] , 0);
            }
            int freq = map.get(nums[i]);
            map.put(nums[i] , freq + 1);
            // System.out.print(map);
            if(map.get(nums[i]) > 1){
                return true;
            }
        }
        return false;
    }
}