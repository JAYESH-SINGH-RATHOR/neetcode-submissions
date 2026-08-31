// bruteforce appraoch
// class Solution {
//     public int[] maxSlidingWindow(int[] nums, int k) {
//         int arr[]  = new int[nums.length - k + 1];
//         int idx = 0;
//         for(int i = 0; i <= nums.length - k; i++){
//             int max = nums[i];
//              for (int j = i; j < i + k; j++) {
//                 max = Math.max(max, nums[j]);
//             }
//             arr[idx++] = max;
//         }
//         return arr;
//     }
// }

// optimized appraoch

class Solution {

    public int[] maxSlidingWindow(int[] nums, int k) {

        PriorityQueue<Integer> pq =
            new PriorityQueue<>(Collections.reverseOrder());

        int[] res = new int[nums.length - k + 1];

        int left = 0;
        int idx = 0;

        for (int i = 0; i < nums.length; i++) {

            pq.add(nums[i]);

            if (i >= k - 1) {

                res[idx++] = pq.peek();

                pq.remove(nums[left]);

                left++;
            }
        }

        return res;
    }
}