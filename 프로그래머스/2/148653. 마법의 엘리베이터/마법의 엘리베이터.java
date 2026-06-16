import java.util.*;

class Solution {
    public int solution(int storey) {
        int answer = 0;
        
        while (storey > 0){
            int remain = storey%10;
            storey /= 10;
            
            // 나머지가 5인 경우
            if (remain == 5){
                // 그 다음 숫자가 5이상이라면
                if (storey%10 >= 5){
                    storey += 1;
                }
                answer += remain;
            }
            // 나머지가 5초과인 경우
            else if (remain > 5){
                answer += 10 - remain;
                storey += 1;
            }
            else {
                answer += remain;
            }
        }
        return answer;
    }
}