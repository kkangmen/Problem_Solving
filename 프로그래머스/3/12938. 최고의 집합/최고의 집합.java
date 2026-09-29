import java.util.*;

class Solution {
    public int[] solution(int n, int s) {
        
        if (n > s){
            return new int[]{-1};
        }
        
        int[] answer = new int[n];
        
        int quot = s/n;
        int remain = s%n;
        
        Arrays.fill(answer, quot);
        
        for (int i = 0; i < remain; i++){
            answer[n-i-1]++;
        }
        return answer;
    }
}