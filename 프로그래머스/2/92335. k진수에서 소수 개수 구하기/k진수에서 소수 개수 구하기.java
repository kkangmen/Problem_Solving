import java.util.*;

class Solution {
    
    public boolean isPrime(long number){
        if (number == 1){
            return false;
        }
        
        for (long l = 2; l <= Math.sqrt(number); l++){
            if(number % l == 0){
                return false;
            }
        }
        return true;
    }
    
    public int solution(int n, int k) {
        int answer = 0;
        
        String num = Integer.toString(n, k);
        String[] nums = num.split("0");
        
        for (String s : nums){
            if (s.equals("")){
                continue;
            }
            
            if (isPrime(Long.valueOf(s))){
                answer++;
            }
        }
        return answer;
    }
}