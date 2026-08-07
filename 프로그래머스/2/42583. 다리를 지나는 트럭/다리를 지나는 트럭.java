import java.util.*;

class Solution {
    
    Queue<Integer> waiting = new LinkedList<>();
    Queue<Integer> bridge = new LinkedList<>();
    
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        
        for (int i : truck_weights){
            waiting.offer(i);
        }
        
        int totalWeight = 0;
        while (!waiting.isEmpty()){
            
            if (bridge.size() == bridge_length){
                totalWeight -= bridge.poll();
            }
            
            int truckWeight = waiting.peek();
            if (totalWeight + truckWeight <= weight){
                bridge.offer(truckWeight);
                totalWeight += truckWeight;
                waiting.poll();
            } else {
                bridge.offer(0);
            }
            answer++;
        }    
        return answer+bridge_length;
    }
}