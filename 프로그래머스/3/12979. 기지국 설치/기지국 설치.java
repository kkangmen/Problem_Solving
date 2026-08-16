import java.util.*;

class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int coverage = 2*w + 1;
        
        int pivot = 1;
        
        for (int station : stations){
            int start = Math.max(0, station-w);
            int end = Math.min(n, station+w);
            
            int gap = start - pivot;
            if (gap > 0){
                answer += (gap + coverage -1)/ coverage; 
            }
            
            pivot = end+1;
        }
        
        // 끝까지
        if (pivot <= n){
            int gap = n - pivot + 1;
            answer += (gap + coverage -1)/coverage;
        }
        return answer;
    }
}