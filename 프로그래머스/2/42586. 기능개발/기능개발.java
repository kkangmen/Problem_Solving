import java.util.*;

class Solution {
    public List<Integer> solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new LinkedList<>();
        Queue<Integer> q = new LinkedList<>();
        
        for (int i = 0; i < progresses.length; i++){
            double days = (100 - progresses[i]) / (double)speeds[i];
            days = Math.ceil(days);
            
            q.offer((int)days);
        }
        
        while (!q.isEmpty()){
            int count = 1;
            int pivot = q.poll();
            while (!q.isEmpty() && pivot >= q.peek()){
                q.poll();
                count++;
            }
            answer.add(count);
        }
        return answer;
    }
}