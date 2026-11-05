import java.util.*;

class Solution {
    int solution(int[][] land) {
        int answer = 0;
        int[][] dp = new int[land.length][land[0].length];
        
        // 초기화
        for (int i = 0; i < 4; i++){
            dp[0][i] = land[0][i];
        }
        
        // dp에 값 채워넣기
        for (int i = 1; i < land.length; i++){
            for (int j = 0; j < 4; j++){
                for (int k = 0; k < 4; k++){
                    if (j == k){
                        continue;
                    }
                    dp[i][j] = Math.max(dp[i-1][k], dp[i][j]);
                }
                dp[i][j] += land[i][j];
            }
        }
        
        // 출력
        for (int i = 0; i < 4; i++){
            answer = Math.max(answer, dp[land.length-1][i]);
        }
        return answer;
    }
}