import java.util.*;

class Solution {
    public int[] solution(int n, int s) {
        int[] answer = new int[n];
        
        int quote = s/n;
        int remain = s%n;
        
        if (n > s){
            answer = new int[1];
            answer[0] = -1;
            return answer;
        }
        Arrays.fill(answer, s/n);
        
        for (int i = n-1; i > n-1-remain; i--){
            answer[i] += 1;
        }
        return answer;
    }
}