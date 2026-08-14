import java.util.*;

class Solution {
    
    Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
    public int solution(int[][] routes) {
        int answer = 0;
        
        Arrays.sort(routes, (o1, o2) -> {
            return o1[1] - o2[1];
        });
        
        for (int[] route : routes){
            int start = route[0];
            int end = route[1];
            
            if (pq.isEmpty()){
                pq.offer(end);
            } else {
                if (pq.peek() <= end && pq.peek() >= start){
                    continue;
                } else {
                    pq.offer(end);
                }
            }
        }
        return pq.size();
    }
}