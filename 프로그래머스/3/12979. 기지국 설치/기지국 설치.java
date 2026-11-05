import java.util.*;

class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;

        List<Integer> gap = new ArrayList<>();
        
        int start = 1;
        for (int station : stations){
            
            int station_start = (station-w >= 1) ? station-w : 1;
            int station_end = (station+w <= n) ? station+w : n;
            
            if (station_start - start > 0){
                gap.add(station_start-start);
            }
            
            start = station_end+1;
        }
        if (start <= n){
            gap.add(n+1 - start);            
        }
        
        int cover = 2*w+1;
        for (int i : gap){
            answer += (i-1)/cover + 1;
        }
        return answer;
    }
}