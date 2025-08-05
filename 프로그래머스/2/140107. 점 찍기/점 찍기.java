import java.util.*;

class Solution {
    public long solution(int k, int d) {
        long answer = 0;
        
        long dS = (long)Math.pow(d, 2);
        for (int i = 0; i <= d; i+= k){
            long b_sqr = (long)Math.pow(i, 2);
            
            answer += Math.floor(Math.sqrt(dS - b_sqr))/k + 1;
            
        }
        return answer;
    }
}