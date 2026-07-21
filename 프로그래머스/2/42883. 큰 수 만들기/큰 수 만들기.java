import java.util.*;

class Solution {
    public String solution(String number, int k) {
        StringBuilder answer = new StringBuilder();
        
        Stack<Character> s = new Stack<>();
        int keep = number.length() - k;
        for (int i = 0; i < number.length(); i++){
            char ch = number.charAt(i);
            
            while (!s.isEmpty() && k > 0 && s.peek() < ch){
                s.pop();
                k--;
            }
            s.push(ch);
        }
        
        while (!s.isEmpty()){
            answer.append(String.valueOf(s.pop()));
        }
        
        
        return answer.reverse().substring(0, keep);
    }
}