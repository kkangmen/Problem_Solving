import java.util.*;

class Solution {
    public boolean isCorrect(String concate){
        Stack<Character> stack = new Stack<>();
        
        for (char ch : concate.toCharArray()){
            if (ch == '(' || ch == '[' || ch == '{'){
                stack.push(ch);
            }
            else {
                if (!stack.isEmpty() && ch == ')' && stack.peek() == '('){
                    stack.pop();
                }
                else if (!stack.isEmpty() && ch == '}' && stack.peek() == '{'){
                    stack.pop();
                }
                else if (!stack.isEmpty() && ch == ']' && stack.peek() == '['){
                    stack.pop();
                }
                else {
                    return false;
                }
            }
        }
        
        if (!stack.isEmpty()){
            return false;
        }
        return true;
    }
    
    public int solution(String s) {
        int answer = 0;
        
        for (int i = 0; i < s.length(); i++){
            String preString = s.substring(0, i);
            String postString = s.substring(i);
            
            if(isCorrect(postString+preString)){
                answer++;
            }
        }
        
        return answer;
    }
}