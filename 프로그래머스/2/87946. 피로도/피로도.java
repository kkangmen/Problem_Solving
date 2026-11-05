import java.util.*;

class Solution {
    public boolean[] isVisited;
    public int answer = 0;
    
    public int solution(int k, int[][] dungeons) {
        isVisited = new boolean[dungeons.length];
        
        backTracking(0, k, dungeons);
        
        return answer;
    }
    
    public void backTracking(int depth, int k, int[][] dungeons){
        for (int i = 0; i < dungeons.length; i++){
            if (!isVisited[i] && k >= dungeons[i][0]){
                isVisited[i] = true;
                backTracking(depth + 1, k - dungeons[i][1], dungeons);
                isVisited[i] = false;
            }
        }
        
        answer = Math.max(depth, answer);
    }
}