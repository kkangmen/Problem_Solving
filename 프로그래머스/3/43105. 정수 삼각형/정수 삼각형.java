import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        
        int n = triangle.length;
        int[][] dp = new int[n][n];
        
        dp[0][0] = triangle[0][0];
        for (int i = 1; i < n; i++){
            for (int j = 0; j < triangle[i].length; j++){
                // 1열일 경우
                if (j == 0){
                    dp[i][j] = dp[i-1][j] + triangle[i][j];
                } else if (j == triangle[i].length-1){
                    dp[i][j] = dp[i-1][j-1] + triangle[i][j];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-1]) + triangle[i][j];
                }
            }
        }
        
        for (int j = 0; j < n; j++){
            answer = Math.max(dp[n-1][j], answer);
        }
        return answer;
    }
}