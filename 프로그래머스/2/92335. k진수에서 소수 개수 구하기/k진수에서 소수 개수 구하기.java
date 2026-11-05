import java.util.*;

class Solution {
    
    public boolean isPrimeNum(Long num){
        if (num == 1L){
            return false;
        }
        
        Long sqrtNum = (long) Math.sqrt(num);
        
        for (int i = 2; i <= sqrtNum; i++){
            if (num % i == 0){
                return false;
            }
        }
        return true;
    }
    
    public int solution(int n, int k) {
        int answer = 0;
        
        String knary = Integer.toString(n, k);
        
        String[] nums = knary.split("0");
        
        for (String s : nums){
            if (s.equals("")){
                continue;
            }
            
            if (isPrimeNum(Long.parseLong(s))){
               answer++; 
            }
        }
        return answer;
    }
}