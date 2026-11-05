import java.util.*;

class Solution {
    
    Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
    
    public long solution(int n, int[] works) {
        long answer = 0;
            
        for (int work : works){
            pq.offer(work);
        }
        
        while (n > 0){
            pq.offer(pq.poll()-1);
            n--;
        }
        
        for (int i : pq){
            if (i > 0){
                answer += Math.pow(i, 2);
            }
        }
        return answer;
    }
}