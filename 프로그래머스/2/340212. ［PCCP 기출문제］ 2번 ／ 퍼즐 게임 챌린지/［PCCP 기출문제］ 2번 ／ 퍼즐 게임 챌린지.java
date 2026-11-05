import java.util.*;
class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = 0;
        
        // 이분 탐색
     
        int left = 1;
        // diff의 최대값
        int right = Arrays.stream(diffs).max().getAsInt();
            
        // 이분탐색 시작
        while (left <= right){
            
            int level = (left+right)/2;
            long totalTime = 0;
            // 각 diffs 마다
            for (int i = 0; i < diffs.length; i++){
                int diff = diffs[i];
                
                // diff <= level이라면 += time_cur
                if (diff <= level){
                    totalTime += times[i];
                }
                // diff > level이라면 (time_cur+prev_cur)*(diff-level) + time_cur
                else {
                    totalTime += (times[i]+times[i-1])*(diff-level) + times[i];
                }
            }
            // 총 시간이 limit 이하라면
            if (totalTime <= limit){
                // answer 최신화 및 level 하향조정
                answer = level;
                right = level-1;
            }
            // 총 시간이 limit 초과라면
            else {
                // level 상향
                left = level+1;
            }
        }
        return answer;
    }
}