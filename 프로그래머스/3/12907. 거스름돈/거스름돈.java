import java.util.*;

class Solution {
    
    int[][] dp;
    
    public int solution(int n, int[] money) {
        int answer = 0;
            
        dp = new int[money.length+1][n+1];
        
        for (int i = 1; i <= money.length; i++){
            int m = money[i-1];
            for (int j = 0; j <= n; j++){
                if (j == 0){
                    dp[i][j] = 1;
                } else if (j >= m){
                    dp[i][j] = (dp[i-1][j] + dp[i][j-m]) % 1000000007;
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        
        // for (int i = 1; i <= money.length; i++){
        //     for (int j = 0; j <= n; j++){
        //         System.out.print(dp[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        return dp[money.length][n];
    }
}