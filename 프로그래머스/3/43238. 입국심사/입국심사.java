import java.util.*;

class Solution {
    public boolean isPossible(int n, int[] times, long mid){
        long cnt = 0;
        for (int time : times){
            cnt += mid/time;
        }
        
        if (cnt >= n){
            return true;
        }
        return false;
    }
    
    public long solution(int n, int[] times) {
        long answer = 0;
        
        Arrays.sort(times);
        long left = 1;
        long right = times[times.length-1] * (long) n;
        
        while (left <= right){
            
            long mid = (left+right)/2;
            
            if (isPossible(n, times, mid)){
                right = mid-1;
                answer = mid;
            } else {
                left = mid+1;
            }
        }
        return answer;
    }
}