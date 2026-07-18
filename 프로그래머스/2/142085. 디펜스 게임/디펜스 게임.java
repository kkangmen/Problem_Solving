import java.util.*;

class Solution {
    Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
    
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        
        int soilders = n;
        int pass = k;
        for (int i = 0; i < enemy.length; i++){
            soilders -= enemy[i];
            pq.offer(enemy[i]);
            
            if (soilders < 0){
                if (pass > 0){
                    pass--;
                    soilders += pq.poll();
                } else {
                    break;
                }
            }
            
            answer++;
        }
        return answer;
    }
}