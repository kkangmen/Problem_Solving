import java.util.*;

class Solution {
    public int solution(int n, int w, int num) {
        int answer = 1;
        int val = (num-1)/w + 1;
        
        while (num <= n){
            num += (w*val - num) * 2 + 1;
            val++;
            answer++;
            
            //System.out.print("val: " + val + " ");
            //System.out.print("num: " + num);
            //System.out.println();
        }
        
        return answer-1;
    }
}