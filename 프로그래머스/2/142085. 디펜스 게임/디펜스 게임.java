import java.util.*;

class Solution {
    
    Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
    
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        
        int soilders = n;
        int shield = k;
        
        for (int i : enemy){
            soilders -= i;
            pq.offer(i);
            
            if (soilders < 0){
                if (shield > 0){
                    shield--;
                    soilders += pq.poll();
                } else { // 무적권이 없다면
                    break;
                }
            }
            answer++;
        }
        return answer;
    }
}