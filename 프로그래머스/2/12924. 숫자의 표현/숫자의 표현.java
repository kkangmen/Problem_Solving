import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        
        int[] dp = new int[n+1];
        
        dp[0] = 0;
        for (int i = 1; i <= n; i++){
            dp[i] = dp[i-1] + i;
        }
        
        for (int i = 0; i <= n-1; i++){
            for (int j = i+1; j <= n; j++){
                if (dp[j] - dp[i] == n){
                    answer++;
                    break;
                }
                if (dp[j] - dp[i] > n){
                    break;
                }
            }
        }
        return answer;
    }
}

// [0 1 3 6 10 15 21 28 36 45 55]
// 투포인터 O(n) = 100,000,000