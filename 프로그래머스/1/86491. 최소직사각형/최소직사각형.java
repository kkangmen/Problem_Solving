import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        for (int[] i : sizes){
            Arrays.sort(i);
        }
        
        int max_w = 0;
        int max_h = 0;
        for (int[] i : sizes){
            if (i[0] > max_h){
                max_h = i[0];
            }
            if (i[1] > max_w){
                max_w = i[1];
            }
        }
        
        answer = max_w * max_h;
        return answer;
    }
}