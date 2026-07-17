import java.util.*;

class Solution {
    
    Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
    
    public long solution(int n, int[] works) {
        long answer = 0;
        
        for (int work : works){
            pq.offer(work);
        }
        
        while (n > 0 && pq.peek() != 0){
            pq.offer(pq.poll() - 1);
            n--;
        }
        
        for (int work : pq){
            answer += Math.pow(work, 2);
        }
        
        return answer;
    }
}