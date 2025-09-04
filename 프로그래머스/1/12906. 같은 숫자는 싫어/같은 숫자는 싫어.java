import java.util.*;

public class Solution {
    public List<Integer> solution(int []arr) {
        List<Integer> answer = new LinkedList<>();
        
        Stack<Integer> stack = new Stack<>();
        
        for (int i : arr){
            if (stack.isEmpty()){
                stack.push(i);
            }
            else if (stack.peek() != i){
                stack.push(i);
            }
        }        
        
        while(!stack.isEmpty()){
            answer.add(stack.pop());
        }
        
        Collections.reverse(answer);
        return answer;
    }
}