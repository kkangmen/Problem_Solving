import java.util.*;

class Solution {
    
    static long[][] dp;
    static boolean[][] isWater;
    
    public long solution(int m, int n, int[][] puddles) {
        long answer = 0;
        dp = new long[n][m];
        isWater = new boolean[n][m];
        
        // 초기화
        dp[0][0] = 1;
        for (int i = 1; i < n; i++){
            dp[i][0] = 1;
        }
        for (int i = 1; i < m; i++){
            dp[0][i] = 1;
        }
        
        // 웅덩이를 지도에 표시
        for (int i = 0; i < puddles.length; i++){
            int col = puddles[i][0];
            int row = puddles[i][1];
            
            isWater[row-1][col-1] = true;
        }
    
        
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                if (i == 0 && j == 0){
                    continue;
                }
                
                // 물 웅덩이라면,
                if (isWater[i][j]){
                    dp[i][j] = 0;
                } else { // 물 웅덩이가 아니라면,
                    // i가 0일 경우
                    if (i == 0){
                        dp[i][j] = dp[i][j-1];
                    }
                    else if (j == 0){
                        dp[i][j] = dp[i-1][j];
                    }
                    else {
                        dp[i][j] = (dp[i-1][j] + dp[i][j-1]) % 1000000007;
                    }
                }
            }
        }
        
        answer = dp[n-1][m-1];
        
//         // 출력
//         for (int i = 0; i < n; i++){
//             for (int j = 0; j < m; j++){
//                 System.out.print(dp[i][j] + " ");
//             }
//             System.out.println();
//         }
        return answer;
    }
}