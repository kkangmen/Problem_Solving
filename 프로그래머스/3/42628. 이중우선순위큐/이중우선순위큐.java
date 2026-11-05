import java.util.*;

class Solution {
    
    Queue<Integer> pq = new PriorityQueue<>();
    
    public int removeBiggest(){
        Stack<Integer> s = new Stack<>();
        while (!pq.isEmpty()){
            s.push(pq.poll());
        }
        int num = s.pop();
        while (!s.isEmpty()){
            pq.offer(s.pop());
        }
        return num;
    }
    
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        
        for (String s : operations){
            String order = s.split(" ")[0];
            int number = Integer.parseInt(s.split(" ")[1]);
            
            if (order.equals("I")){
                pq.offer(number);
            } else {
                // 우선순위 큐가 비어있으면 무시
                if (pq.isEmpty()){
                    continue;
                }
                
                if (number == 1){
                    removeBiggest();
                } else {
                    pq.poll();
                }
            }
        }    
        
        if (pq.isEmpty()){
            answer[0] = 0;
            answer[1] = 0;
        } else {
            answer[0] = removeBiggest();
            if (pq.isEmpty()){
                answer[1] = answer[0];
            } else {
                answer[1] = pq.poll();                
            }
        }
        return answer;
    }
}