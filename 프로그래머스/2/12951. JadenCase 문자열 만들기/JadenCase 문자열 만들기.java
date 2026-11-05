import java.util.*;

class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        

        
        boolean isFirstChar = true;
        for (char ch : s.toCharArray()){
            
            // 첫문자면 true로
            ch = isFirstChar ? Character.toUpperCase(ch) : Character.toLowerCase(ch);
            
            // 공백이 나오면 다시 true로 바꾼다.
            isFirstChar = (ch == ' ') ? true : false;
            
            sb.append(ch);
        }
        return sb.toString();
    }
}