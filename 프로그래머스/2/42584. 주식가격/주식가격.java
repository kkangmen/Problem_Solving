import java.util.*;

class Solution {
    
    Stack<Integer> s = new Stack<>();
    
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        
        for (int i = 0; i < prices.length; i++){
            while (!s.isEmpty() && prices[s.peek()] > prices[i]){
                answer[s.peek()] = i - s.peek();
                s.pop();
                // System.out.println(index + " popped");
            }
            s.push(i);
        }
        
        while (!s.isEmpty()){
            int index = s.pop();
            answer[index] = prices.length - index - 1;
        }
        return answer;
    }
}