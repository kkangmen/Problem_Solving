import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for (int i : score){
            pq.offer(i);
        }
        
        int count = 0;
        while (!pq.isEmpty()){
            int num = pq.poll();
            count++;
            
            if (count == m){
                count = 0;
                answer += num*m;
            }
        }
        
        return answer;
    }
}