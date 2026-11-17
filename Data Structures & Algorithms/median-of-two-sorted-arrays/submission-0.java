class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int left =   0;
        int right = 0;
        int n = nums1.length;
        int m = nums2.length;
        int merge[] = new int[n + m];
        int idx = 0;
        while(left < n && right < m){
            if(nums1[left] < nums2[right]){
                merge[idx++] = nums1[left++];
            }else{
                merge[idx++] = nums2[right++];
            }
        }     
        while(left < n){
            merge[idx++] = nums1[left++];
        }
        while(right < m){
            merge[idx++] = nums2[right++];
        }
        int totallength = merge.length;
        if(totallength % 2 == 1){
            return merge[totallength / 2];
        }else{
            return (merge[totallength / 2] + merge[totallength / 2 - 1]) / 2.0;
        }
    }
}
