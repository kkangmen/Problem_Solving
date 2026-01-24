import java.util.*;

class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        
        boolean isFirstChar = true;
        for (char ch : s.toCharArray()){
            ch = isFirstChar ? Character.toUpperCase(ch) : Character.toLowerCase(ch);
            isFirstChar = (ch == ' ') ? true : false;
            
            sb.append(String.valueOf(ch));
        }
        return sb.toString();
    }
}