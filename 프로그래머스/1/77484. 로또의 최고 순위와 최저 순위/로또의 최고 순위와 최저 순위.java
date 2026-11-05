import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        
        int sameNumCount = 0;
        int countZero = 0;
        for (int i : lottos){
            if (i == 0){
                countZero++;
                continue;
            }
            for (int j : win_nums){
                if (i == j){
                    sameNumCount++;
                }
            }
        }
        
        // 0 => 2개, 맞은 개수 => 2개
        // 최대 => 4개, 최소 2개
        int maxRate = 7 - (countZero + sameNumCount);
        int minRate = 7 - sameNumCount;
        
        if (maxRate == 7){
            maxRate = 6;    
        }
        
        if (sameNumCount == 0){
            minRate = 6;
        }  
        
        answer[0] = maxRate;
        answer[1] = minRate;
        return answer;
    }
}