import java.util.*;

class Solution {
    
    public boolean possible(int n, int[] times, long mid){
        long count = 0;
        
        for (int time : times){
            count += mid / (long)time;
        }
        
        if ((long)n <= count){
            return true;
        } else {
            return false;
        }
    }
    
    public long solution(int n, int[] times) {
        long answer = 0;
        
        
        long left = 1;
        long right = 0;
        for (int time : times){
            right = Math.max(right, time);
        }
        right = right*n;
        
        while (left <= right){
            long mid = (left+right)/2;
            
            // 가능한경우
            if (possible(n, times, mid)){
                answer = mid;
                right = mid-1;
            } else {
                left = mid+1;
            }
        }
        return answer;
    }
}