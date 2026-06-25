import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = enemy.length;
        
        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        int soldier = n;
        int pass = k;
        for (int i = 0; i < enemy.length; i++){
            soldier -= enemy[i];
            pq.offer(enemy[i]);
            
            if (soldier < 0){
                // 무적권이 남아있을 때
                if (pass > 0){
                    pass -= 1;
                    soldier += pq.poll();
                } else { // 무적권이 없을 경우
                    answer = i;
                    break;
                }
            }
        }
        return answer;
    }
}