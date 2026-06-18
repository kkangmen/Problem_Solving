import java.util.*;

class Solution {
    
    Queue<Integer> bridge = new LinkedList<>();
    Queue<Integer> q = new LinkedList<>();
    
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int time = 0;
        
        for (int i : truck_weights){
            q.offer(i);
        }
        
        int tBW = 0;
        while (!q.isEmpty()){
            
            // brideg에 자리가 없으면 빼고 시작.
            if (bridge.size() == bridge_length){
                tBW -= bridge.poll();
            }
            
            if (tBW + q.peek() <= weight){
                bridge.offer(q.peek());
                tBW += q.poll();
                time++;
            } else { // 자리가 있는데 무게 초과일 경우
                bridge.offer(0);
                time++;
            }
        }
        
        return time + bridge_length;
    }
}