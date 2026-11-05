import java.util.*;

class Solution {
    
    Stack<Integer> stack = new Stack();
    
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        
        for (int i = 0; i < numbers.length; i++){
            
            // 스택이 비어있지 않고, peek이 현재 수보다 작으면
            while (!stack.isEmpty() && numbers[stack.peek()] < numbers[i]){
                answer[stack.peek()] = numbers[i];
                stack.pop();
            }
            
            stack.push(i);
        }
        
        while (!stack.isEmpty()){
            answer[stack.pop()] = -1;
        }
        return answer;
    }
}