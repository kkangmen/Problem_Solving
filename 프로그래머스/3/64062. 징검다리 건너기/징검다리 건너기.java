import java.util.*;

class Solution {
        
    public boolean isPossible(int mid, int[] stones, int k){
        int[] stonesCopy = Arrays.copyOf(stones, stones.length);
        
        for (int i = 0; i < stonesCopy.length; i++){
            stonesCopy[i] -= mid;
            if (stonesCopy[i] < 0){
                stonesCopy[i] = 0;
            }
        }
        
        int cnt = 0;
        int totalCnt = 0;
        for (int i = 0; i < stonesCopy.length; i++){
            if (stonesCopy[i] == 0){
                cnt++;
                totalCnt = Math.max(cnt, totalCnt);
            } else {
                cnt = 0;
            }
        }
        
        if (totalCnt >= k){
            return false;
        }
        return true;
    }
    
    public int solution(int[] stones, int k) {
        int answer = 0;
        int left = 1;
        int right = 200000000;
        while (left <= right){
            
            int mid = (left+right)/2;
            // System.out.println(mid);
            // 징검다리를 건널 수 없으면, 
            if (!isPossible(mid, stones, k)){
                right = mid - 1;
            }
            // 징검다리를 충분히 건널 수 있을 경우
            else {
                left = mid + 1;
                answer = mid;
            }
        }
        
        return answer+1;
    }
}