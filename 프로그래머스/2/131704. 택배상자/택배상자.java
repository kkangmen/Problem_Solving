import java.util.*;

class Solution {
    Stack<Integer> stack = new Stack<>();
    
    public int solution(int[] order) {
        List<Integer> answer = new ArrayList<>();
        
        int index = 0;
        for (int i = 1; i <= order.length; i++){
            stack.push(i);
            
            while (!stack.isEmpty() && order[index] == stack.peek()){
                answer.add(stack.pop());
                index++;
            }
        }
        
        return answer.size();
    }
}