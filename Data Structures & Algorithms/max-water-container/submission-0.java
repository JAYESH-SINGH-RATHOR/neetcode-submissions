class Solution {
    public int maxArea(int[] heights) {
        int maxwater = 0;
        int left = 0;
        int right = heights.length - 1;
        while(left < right){
            int height = Math.min(heights[left] , heights[right]);
            int width = right - left;
            int water = height * width;
            maxwater = Math.max(maxwater , water);
            if(heights[left]<heights[right]){
                left++;
            }else{
                right--;
            }
        }
        return maxwater;
    }
}
