import java.util.*;

class Solution {

    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int time = 0;
        int tBW = 0;
        int idx = 0;
        Queue<Integer> bridge = new LinkedList<>();
        
        while (idx < truck_weights.length){
            int cTW = truck_weights[idx];
            
            // 다리가 다 찼다면 빼고 시작
            if (bridge.size() == bridge_length){
                tBW -= bridge.poll();
            }
            
            // 다리에 들어올 수 있다면
            if (tBW + cTW <= weight){
                bridge.offer(cTW);
                tBW += cTW;
                idx++;
            } else {
                bridge.offer(0);
            }
            time++;
        }
        
        return time + bridge_length;
    }
}