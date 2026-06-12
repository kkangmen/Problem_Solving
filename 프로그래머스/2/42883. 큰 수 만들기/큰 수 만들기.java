import java.util.*;

class Solution {
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();
        int bigIdx = 0;
        
        for (int i = 0; i < number.length()-k; i++){
            char max = '0';
            for (int j = bigIdx; j <= i+k; j++){
                if (max < number.charAt(j)){
                    max = number.charAt(j);
                    bigIdx = j+1;
                }
            }
            sb.append(String.valueOf(max));
        }
        return sb.toString();
    }
}