import java.util.*;

class Solution {
    public String solution(String number, int k) {
        StringBuilder answer = new StringBuilder();
        
        int numLength = number.length() - k;
        int startIdx = 0;
        for (int i = 0; i < numLength; i++){
            char ch = '0' - 1;
            
            for (int j = startIdx; j < i+k+1; j++){
                if (ch < number.charAt(j)){
                    ch = number.charAt(j);
                    startIdx = j+1;
                }                
            }
            answer.append(String.valueOf(ch));
        }
        return answer.toString();
    }
}