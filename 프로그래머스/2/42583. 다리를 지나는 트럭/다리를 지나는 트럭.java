import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int sum = 0;
        int time = 0;
        Queue<Integer> q = new LinkedList<>();
        
        for (int i : truck_weights){
            
            while(true){
                if(q.isEmpty()){
                    q.offer(i);
                    sum += i;
                    time++;
                    break;
                }
                else if (q.size() == bridge_length){
                    sum -= q.poll();
                }
                else {
                    if (sum + i <= weight){
                        q.offer(i);
                        sum += i;
                        time++;
                        break;
                    }
                    else {
                        q.offer(0);
                        time++;
                    }
                }
            }
        }
        
        return time+bridge_length;
    }
}