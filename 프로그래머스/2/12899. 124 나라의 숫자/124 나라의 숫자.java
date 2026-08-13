import java.util.*;

class Solution {
    
    String[] arr = new String[]{"4", "1", "2"};
    
    public String solution(int n) {
        StringBuilder sb = new StringBuilder();
        
        while (n > 0){
            int remainder = n % 3;
            n = n/3;
            
            if (remainder == 0){
                n -= 1;
            }
            
            sb.append(String.valueOf(remainder));
        }
        
        String answer = sb.reverse().toString();
        System.out.println(answer);
        sb = new StringBuilder();
        
        for (int i = 0; i < answer.length(); i++){
            sb.append(arr[Integer.valueOf(String.valueOf(answer.charAt(i)))]);
        }
        return sb.toString();
    }
}