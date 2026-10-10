import java.util.*;

class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = 0;
        
        int left = 1;
        int right = 100000;
        
        while (left <= right){
            int level = (left+right)/2;
            // System.out.print("level = " + level);
            long sum = 0;
            
            for (int i = 0; i < diffs.length; i++){
                if ((diffs[i] > level) && (i > 0)){
                    sum += (times[i] + times[i-1]) * (diffs[i]-level) + times[i];
                } else {
                    sum += times[i];
                }
            }
            // System.out.println(" sum = " + sum);
            if (sum <= limit){
                answer = level;
                right = level - 1;
            } else {
                left = level + 1;
            }
        }
        return answer;
    }
}