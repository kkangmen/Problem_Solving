import java.util.*;

class Solution {
    public String solution(int n) {
        String answer = "";
        
        int[] arr = {4, 1, 2};
        StringBuilder sb = new StringBuilder();
        
        while (n > 0){
            int remainder = n % 3;
            n = n/3;
            
            if (remainder == 0){
                n -= 1;
            }
            
            answer = String.valueOf(remainder) + answer;
        }
        
        for (int i = 0; i < answer.length(); i++){
            sb.append(arr[answer.charAt(i)-'0']);
        }
        
        return sb.toString();
    }
}