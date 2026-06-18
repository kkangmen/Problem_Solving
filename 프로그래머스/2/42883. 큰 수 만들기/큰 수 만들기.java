import java.util.*;

class Solution {
    public String solution(String number, int k) {
        StringBuilder answer = new StringBuilder();
        
        int firstIdx = 0;
        for (int i = 0; i < number.length()-k; i++){
            
            int max = -1;
            for (int j = firstIdx; j <= i+k; j++){
                int num = number.charAt(j)-'0';
                if (max < num){
                    max = num;
                    firstIdx = j+1;
                }
            }
            
            answer.append(String.valueOf(number.charAt(firstIdx-1)));
        }
        return answer.toString();
    }
}