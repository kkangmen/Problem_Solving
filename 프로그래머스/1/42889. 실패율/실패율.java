import java.util.*;

class Solution {
    public class difficulty {
        int stage;
        double percentage;
        
        difficulty(int stage, double percentage){
            this.stage = stage;
            this.percentage = percentage;
        }
    }
    
    public List<Integer> solution(int N, int[] stages) {
        List<Integer> answer = new ArrayList<>();

        int[] trying = new int[N+2];
        int[] dp = new int[N+2];
        
        for (int i : stages){
            trying[i]++;
        }
        
        dp[N+1] = trying[N+1];
        for (int i = N; i >= 1; i--){
            dp[i] = dp[i+1] + trying[i];
        }
        
        List<difficulty> list = new ArrayList<>();
        for (int i = 1; i <= N; i++){
            if (dp[i] == 0){
                list.add(new difficulty(i, 0));
            }
            else {
                double d = (double)trying[i] / (double)dp[i];
                list.add(new difficulty(i, d));
            }
        }
        
        Collections.sort(list, (difficulty a, difficulty b) -> {
            if (a.percentage == b.percentage){
                return Integer.compare(a.stage, b.stage);
            }
            return Double.compare(b.percentage, a.percentage);
        });
        
        // 출력
        Iterator<difficulty> iter = list.iterator();
        
        while(iter.hasNext()){
            difficulty d = iter.next();
            answer.add(d.stage);
            System.out.println(d.stage + ", " + d.percentage);
        }
        return answer;
    }
}