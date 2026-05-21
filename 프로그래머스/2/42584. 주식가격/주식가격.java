import java.util.*;

class Solution {
    Stack<Integer> stack = new Stack<>();
    
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        
        for (int i = 0; i < prices.length; i++){
            // 가격이 떨어졌다면
            while (!stack.isEmpty() && prices[stack.peek()] > prices[i]){
                answer[stack.peek()] = i - stack.peek();
                stack.pop();
            }
            stack.push(i);
        }
            
        // 끝까지 떨어지지 않은 종목들
        while (!stack.isEmpty()){
            int index = stack.pop();
            answer[index] = (prices.length-1)-index;
        }
        return answer;
    }
}