import java.util.*;

class Solution {
    public long count(long mid, int[] times){
        long cnt = 0;
        for (int time : times){
            cnt += mid / time;
        }
        return cnt;
    }
    
    public long solution(int n, int[] times) {
        long answer = 0;
        
        // 이분탐색
        // 30분 -> 4 + 3 = 7
        // 28분 -> 4 + 2 = 6
        long left = 1;
        
        int max = Arrays.stream(times).max().getAsInt();
        long right = (long)max*n;
        
        while (left <= right){
            long mid = (left+right)/2;
            // System.out.println(mid);
            long cnt = count(mid, times);
            
            // n보다 가능하고 크거나 같으면 더 줄여도 된다는 뜻.
            if (cnt >= n){
                right = mid-1;
                answer = mid;
            }
        
            // n보다 작으면 시간 더 늘려야.
            else {
                left = mid+1;
            }
        }
        
        return answer;
    }
}