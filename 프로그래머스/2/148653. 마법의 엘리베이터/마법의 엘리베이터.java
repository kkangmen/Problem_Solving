import java.util.*;

class Solution {
    public int solution(int storey) {
        int answer = 0;
        
        while (storey > 0){
            int remain = storey % 10; // 5
            storey /= 10; // 25
            
            if (remain < 5){
                answer += remain;
            } else if (remain > 5){
                storey += 1;
                answer += 10 - remain;
            } else { // 나머지가 5인 경우
                if (storey % 10 >= 5){
                    storey += 1;
                } 
                answer += 5;
            }
        }
        return answer;
    }
}