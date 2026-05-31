import java.util.*;

class Solution {
    
    static int[] dp = new int[60001];
    static int divider = 1000000007;
    public int solution(int n) {
        
        dp[1] = 1;
        dp[2] = 2;
        
        for (int i = 3; i <= n; i++){
            dp[i] = (dp[i-1] + dp[i-2]) % divider;
        }
        
        return dp[n];
    }
}