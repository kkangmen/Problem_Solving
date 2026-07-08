import java.util.*;

class Solution {
    public String solution(int n) {
        StringBuilder answer = new StringBuilder();
        
        while (n > 0){
            int remainder = n%3;
            
            if (n%3 == 0){
                n = n/3 -1;
            } else {
                n = n/3;
            }
            
            answer.append(String.valueOf(remainder));
        }
        
        String word = answer.reverse().toString();
        answer.setLength(0);
        for (char ch : word.toCharArray()){
            if (ch == '0'){
                answer.append("4");
            } else {
                answer.append(String.valueOf(ch));
            }
        }
        return answer.toString();
    }
}