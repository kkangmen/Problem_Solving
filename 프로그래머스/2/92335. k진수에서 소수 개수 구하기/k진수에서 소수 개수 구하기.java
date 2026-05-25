import java.util.*;

class Solution {
    public boolean isPrimeNumber(long number){
        if (number == 1){
            return false;
        }
        
        for (long l = 2; l <= Math.sqrt(number); l++){
            if (number % l == 0){
                return false;
            }
        }
        return true;
    }
    
    public int solution(int n, int k) {
        int answer = 0;
        
        String toKBinary = Integer.toString(n, k);
        String[] nums = toKBinary.split("0");
        
        for (String s : nums){
            if (s.equals("")){
                continue;
            }
            if (isPrimeNumber(Long.valueOf(s))){
                answer += 1;
            }
        }
        
        return answer;
    }
}