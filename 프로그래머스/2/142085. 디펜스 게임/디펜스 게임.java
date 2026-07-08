import java.util.*;
class Solution {
    
    Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
    
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        
        int curN = n;
        int curK = k;
        for (int enemyCnt : enemy){
            curN -= enemyCnt;
            pq.offer(enemyCnt);
            
            if (curN < 0){
                if (curK > 0){
                    curN += pq.poll();
                    curK --;
                } else {
                    break;
                }
            }
            
            answer++;
        }
        
        return answer;
    }
}