import java.util.*;

class Solution {
    Queue<Integer> pq = new PriorityQueue<>();
    Queue<Integer> pqReverse = new PriorityQueue<>(Collections.reverseOrder());
    
    public int removeMaximum(Queue<Integer> pq){
        while (!pq.isEmpty()){
            pqReverse.offer(pq.poll());
        }
        
        int num = pqReverse.poll();
        while (!pqReverse.isEmpty()){
            pq.offer(pqReverse.poll());
        }
        
        return num;
    }
    
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        
        for (String operation : operations){
            String order = operation.split(" ")[0];
            int num = Integer.parseInt(operation.split(" ")[1]);
            
            if (order.equals("I")){
                pq.offer(num);
            } else { // D인 경우
                if (pq.isEmpty()){ // 큐가 비어있으면 무시
                    continue;
                }
                if (num == 1){ // 최댓값 삭제
                    removeMaximum(pq);
                } else { // 최솟값 삭제
                    pq.poll();
                }
            }
        }
        
        if (pq.isEmpty()){
            answer[0] = 0;
            answer[1] = 0;
        } else if (pq.size() == 1){
            int num = pq.poll();
            answer[0] = num;
            answer[1] = num;
        } else {
            answer[0] = removeMaximum(pq);
            answer[1] = pq.poll();
        }
        return answer;
    }
}