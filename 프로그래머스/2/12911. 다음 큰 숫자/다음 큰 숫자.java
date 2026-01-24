import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = n;
        
        String n_binary = Integer.toString(n, 2);
        n_binary = n_binary.replace("0", "");
        int n_count = n_binary.length();
        
        while (true){
            answer++;
            String answer_binary = Integer.toString(answer, 2);
            answer_binary = answer_binary.replace("0", "");
            int answer_count = answer_binary.length();
            if (n_count == answer_count){
                break;
            }
        }
        return answer;
    }
}