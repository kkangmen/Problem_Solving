import java.util.*;

class Solution {
    public int solution(int sticker[]) {
        int answer = 0;

        // 스티커가 한장인 경우
        if (sticker.length == 1){
            return sticker[0];
        }
        
        // 첫번째 선택
        int[] dp = new int[sticker.length];
        dp[0] = sticker[0];
        dp[1] = sticker[0];
        for (int i = 2; i < sticker.length-1; i++){
            dp[i] = Math.max(dp[i-1], dp[i-2] + sticker[i]); 
        }
        
        // 첫번째 선택 x
        int[] dp2 = new int[sticker.length];
        dp2[0] = 0;
        dp2[1] = sticker[1];
        for (int i = 2; i < sticker.length; i++){
            dp2[i] = Math.max(dp2[i-1], dp2[i-2] + sticker[i]);
        }
        
        for (int i = 0; i < sticker.length; i++){
            answer = Math.max(answer, Math.max(dp[i], dp2[i]));
        }
        return answer;
    }
}