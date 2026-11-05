import java.util.*;

class Solution {
    public List<Integer> solution(int k, int[] score) {
        List<Integer> answer = new ArrayList<>();
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (int i : score){
            pq.offer(i);
            
            if (pq.size() > k){
                pq.poll();
            }
            
            answer.add(pq.peek());
        }
        return answer;
    }
}