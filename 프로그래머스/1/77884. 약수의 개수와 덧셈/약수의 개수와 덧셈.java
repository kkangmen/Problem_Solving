import java.util.*;

class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        
        for (int i = left; i <= right; i++){
            int num = (int)Math.sqrt(i);
            if (num*num == i){
                answer -= i;
            }
            else {
                answer += i;
            }
        }
        return answer;
    }
}