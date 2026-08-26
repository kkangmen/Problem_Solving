import java.util.*;

class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
    
        int curSpot = 1;
        int width = w*2 + 1;
        for (int station : stations){
            int gap = (station-w) - curSpot;
            
            answer += (gap + (width-1)) / width;
            curSpot = station + w + 1;
        }
        // System.out.println(answer);
        
        if (curSpot <= n){
            // System.out.println("마지막");
            int gap = n - curSpot + 1;
            
            answer += (gap + (width-1))/width;
        }
        return answer;
    }
}