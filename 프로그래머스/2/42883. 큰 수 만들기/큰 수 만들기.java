import java.util.*;

class Solution {
    public String solution(String number, int k) {
        StringBuilder answer = new StringBuilder();
        
        int maxIndex = 0;
        for (int i = 0; i < number.length()-k; i++){
            
            char maxChar = '0'-1;
            for (int j = maxIndex; j < k+1+i; j++){
                char curChar = number.charAt(j);
                
                if (maxChar < curChar){
                    maxChar = curChar;
                    maxIndex = j;
                }
            }
            maxIndex += 1;
            answer.append(String.valueOf(maxChar));
        }
        return answer.toString();
    }
}