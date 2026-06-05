import java.util.*;

class Solution {
    
    static Stack<Integer> belt = new Stack<>();
    
    public int solution(int[] order) {
        int answer = 0;
        
        for (int i = 1; i <= order.length; i++){
            belt.push(i);
            
            while (!belt.isEmpty() && belt.peek() == order[answer]){
                answer++;
                belt.pop();
            }
        }
        
        return answer;
    }
}