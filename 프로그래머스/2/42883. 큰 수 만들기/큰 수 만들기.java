import java.util.*;

class Solution {
    public String solution(String number, int k) {
        StringBuilder answer = new StringBuilder();
        
        int maxIdx = 0;
        for (int i = 0; i < number.length()-k; i++){
            char maxChar = '0'-1;
            for (int j = maxIdx; j <= k+i; j++){
                if (maxChar < number.charAt(j)){
                    maxChar = number.charAt(j);
                    maxIdx = j+1;
                }
            }
            answer.append(String.valueOf(maxChar));
        }
        return answer.toString();
    }
}