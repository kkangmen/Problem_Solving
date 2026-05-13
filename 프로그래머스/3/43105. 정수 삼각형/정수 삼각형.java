import java.util.*;

class Solution {
    
    static int[][] dp;
    
    public int solution(int[][] triangle) {
        int answer = 0;
            
        int height = triangle.length;
        dp = new int[height][height];
        
        dp[0][0] = triangle[0][0];
        
        for (int i = 1; i < height; i++){
            for (int j = 0; j <= i; j++){
                if (j == 0){
                    dp[i][j] = dp[i-1][j] + triangle[i][j];
                } 
                else if (j == i){
                    dp[i][j] = dp[i-1][j-1] + triangle[i][j];
                }
                else {
                    dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + triangle[i][j];
                }
            }
        }
        
        for (int i = 0; i < height; i++){
            answer = Math.max(answer, dp[height-1][i]);
        }
        
        // System.out.println(answer);
        // for (int i = 0; i < height; i++){
        //     for (int j = 0; j <= i; j++){
        //         System.out.print(dp[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        return answer;
    }
}