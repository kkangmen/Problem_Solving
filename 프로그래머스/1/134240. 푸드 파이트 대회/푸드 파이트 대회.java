import java.util.*;

class Solution {
    public String solution(int[] food) {
        StringBuilder sb = new StringBuilder();
        StringBuilder answer = new StringBuilder();
        
        for (int i = 1; i < food.length; i++){
            int num = food[i]/2;
            
            for (int j = 0; j < num; j++){
                String s = String.valueOf(i);
                sb.append(s);
                answer.append(s);
            }
        }
        sb.append("0");
        
        answer.append(sb.reverse());
        
        return answer.toString();
    }
}