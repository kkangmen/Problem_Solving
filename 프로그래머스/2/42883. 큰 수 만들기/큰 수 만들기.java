import java.util.*;

class Solution {
    public String solution(String number, int k) {
        StringBuilder answer = new StringBuilder();
        
        int maxIdx = 0;
        for (int i = 0; i < number.length()-k; i++){
            char maxChar = '0'-1;
            
            for (int j = maxIdx; j <= k+i; j++){
                char curChar = number.charAt(j);
                if (maxChar < curChar){
                    maxChar = curChar;
                    maxIdx = j+1;
                }
            }
            answer.append(maxChar);
        }
        return answer.toString();
    }
}