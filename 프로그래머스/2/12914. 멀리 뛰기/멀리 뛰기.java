import java.util.*;

class Solution {
    public long solution(int n) {
        long[] dp = new long[2001];
        
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++){
            dp[i] = (dp[i-1] + dp[i-2]) % 1234567;
        }
        return dp[n];
    }
}

//     n == 1 => 1
//     n == 2 => 2
//     n == 3 => 3
//     n == 4 => 5
//     n == 5 => 
//     1 1 1 1 1
//     1 1 1 2
//     1 1 2 1
//     1 2 1 1
//     2 1 1 1
//     1 2 2
//     2 2 1
//     2 1 2
    