import java.util.*;

class Solution {
    
    int answer = Integer.MAX_VALUE;
    
    public int[][] cost = new int[][]{
        {1, 1, 1},
        {5, 1, 1},
        {25, 5, 1}
    };
    
    public int calculate(int index, int start, int end, String[] minerals){
        int sum = 0;
        for (int i = start; i < end; i++){
            switch(minerals[i]){
                case "diamond":
                    sum += cost[index][0];
                    break;
                case "iron":
                    sum += cost[index][1];
                    break;
                default:
                    sum += cost[index][2];
            }
        }
        return sum;
    }
    
    public void dfs(int[] picks, int mineralIdx, String[] minerals, int sum){
        // System.out.println("dfs: " + "mineralIdx=" + mineralIdx + " sum= " + sum);
        
        // 곡괭이가 더 이상 없거나, 광물을 다 캤으면 종료
        if ((picks[0] == 0 && picks[1] == 0 && picks[2] == 0)
           || mineralIdx == minerals.length){
            answer = Math.min(answer, sum);
            // System.out.println("return");
            return;
        }
        
        for (int i = 0; i < picks.length; i++){
            if (picks[i] > 0){
                // 곡괭이로 5개를 캐고 다음 dfs로
                int end = Math.min(mineralIdx+5, minerals.length);
                int totalCost = calculate(i, mineralIdx, end, minerals);
                picks[i]--;
                dfs(picks, end, minerals, sum+totalCost);
                picks[i]++;
            }
        }
    }
    
    public int solution(int[] picks, String[] minerals) {
        dfs(picks, 0, minerals, 0);
        return answer;
    }
}