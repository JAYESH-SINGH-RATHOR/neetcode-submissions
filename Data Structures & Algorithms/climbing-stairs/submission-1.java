// optimized appraoch

// class Solution {
//     public int climbStairs(int n) {
//         int dp[] = new int[n + 1];
//         dp[0] = 1;
//         dp[1] = 1;
//         for(int i = 2; i <= n; i++){
//             dp[i] = dp[i  - 1] + dp[i - 2];
//         }
//         return dp[n];
//     }
// }

// optimized appraoch using memoization

class Solution {
    public int climbStairs(int n) {
        if(n <= 2){
            return n;
        }
        int dp[] = new int[n + 1];
        return rec(n , dp);
    }
    int rec(int n , int dp[]){
        if(n <= 2){
            return n;
        }
        if(dp[n] != 0){
            return dp[n];
        }
        dp[n] = rec(n - 1 , dp) + rec(n - 2 , dp);
        return dp[n];
    }
}