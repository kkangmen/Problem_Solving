import java.util.*;

class Solution {
    
    Stack<Integer> s = new Stack();
    
    public int solution(int[] order) {
        int answer = 0;
        
        for (int i = 1; i <= order.length; i++){
            s.push(i);
            
            while (!s.isEmpty() && order[answer] == s.peek()){
                s.pop();
                answer++;
            }
        }
        return answer;
    }
}