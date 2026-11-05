import java.util.*;

class Solution {
    
    int[][] value = new int[][]{
        {1, 1, 1},
        {5, 1, 1},
        {25, 5, 1}
    };
    
    int answer = Integer.MAX_VALUE;
    
    public int calculate(int pick, int start, int end, String[] minerals){
        
        int sum = 0;
        
        for (int i = start; i < end; i++){
            switch (minerals[i]){
                case "diamond": 
                    sum += value[pick][0];
                    break;
                case "iron":
                    sum += value[pick][1];
                    break;
                default:
                    sum += value[pick][2];
            }
        }
        
        // System.out.println("start: " + start + " end: " + end + " sum: " + sum);
        return sum;
    }
    
    public void dfs(int[] picks, int index, String[] minerals, int maxIdx, int sum){
        
        if (index == maxIdx){
            answer = Math.min(answer, sum);    
            // System.out.println("answer: " + answer);
            return;
        }
        
        for (int i = 0; i < picks.length; i++){
            if (picks[i] > 0){
                int start = index;
                int end = Math.min(start+5, maxIdx);
                int temp = calculate(i, start, end, minerals);
                picks[i]--;
                dfs(picks, end, minerals, maxIdx, sum+temp);
                picks[i]++;
            }
        }
    }
    
    public int solution(int[] picks, String[] minerals) {
        
        int totalPick = 0;
        for (int pick : picks){
            totalPick += pick;
        }
        
        int maxIdx = Math.min(totalPick*5, minerals.length);
        dfs(picks, 0, minerals, maxIdx, 0);
        
        return answer;
    }
}