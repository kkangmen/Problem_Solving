import java.util.*;

class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        Stack<Integer> stack = new Stack();
        List<Integer> list = new ArrayList<>();
        
        for (int i : ingredient){
            stack.push(i);
            
            if (stack.size() >= 4){
                int num1 = stack.pop();
                int num2 = stack.pop();
                int num3 = stack.pop();
                int num4 = stack.pop();
                
                if (num1 == 1 && num2 == 3 && num3 == 2 && num4 == 1){
                    answer++;
                }
                else {
                    stack.push(num4);
                    stack.push(num3);
                    stack.push(num2);
                    stack.push(num1);
                }
            }
        }
        return answer;
    }
    
    
}