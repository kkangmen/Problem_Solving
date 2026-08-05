import java.util.*;

class Solution {
    
    public int solution(int storey) {
        int answer = 0;
        
        while (storey > 0){
            int remain = storey % 10;
            storey = storey / 10;
            
            if (remain < 5){
                answer += remain;
            } else if (remain > 5){
                storey += 1;
                answer += 10 - remain;
            } else {
                int forwardNum = storey % 10;
                if (forwardNum >= 5){
                    storey += 1;
                } 
                answer += 5;
            }
        }
        return answer;
    }
}