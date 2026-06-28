import java.util.*;

class Solution {
    
    Queue<Integer> waiting = new LinkedList<>();
    Queue<Integer> bridge_queue = new LinkedList<>();
    
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int time = 0;
        
        // 초기화
        for (int i : truck_weights){
            waiting.offer(i);
        }
        int totalWeight = 0;
        
        while (!waiting.isEmpty()){
            
            if (bridge_queue.size() == bridge_length){
                totalWeight -= bridge_queue.poll();
            }
            
            if (totalWeight + waiting.peek() <= weight){
                int cur = waiting.poll();
                bridge_queue.offer(cur);
                totalWeight += cur;
            } else {
                bridge_queue.offer(0);
            }
            time++;
        }
        
        return time + bridge_length;
    }
}