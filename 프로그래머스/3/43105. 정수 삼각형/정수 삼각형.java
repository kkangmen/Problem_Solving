import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        
        int row = triangle.length;
        int col = triangle[row-1].length;
        
        int[][] dp = new int[row][col];
        
        dp[0][0] = triangle[0][0];
        
        for (int i = 1; i < row; i++){
            for (int j = 0; j <= i; j++){
                
                if (j == 0){
                    dp[i][j] = dp[i-1][j] + triangle[i][j];
                }
                else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-1]) + triangle[i][j];
                }
            }
        }
        
        for (int i = 0; i < col; i++){
            answer = Math.max(answer, dp[row-1][i]);
        }
        return answer;
    }
}