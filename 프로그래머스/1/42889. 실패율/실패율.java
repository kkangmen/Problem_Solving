import java.util.*;

class Solution {
    public class difficulty{
        private int stages;
        private double failure;

        difficulty(int stages, double failure){
            this.stages = stages;
            this.failure = failure;
        }
    }
    
    public List<Integer> solution(int N, int[] stages) {
        List<Integer> answer = new ArrayList<>();
        List<difficulty> list = new ArrayList<>();
        //         1  2  3  4  5  6
        // trying [1  3  2  1  0  1]
        // dp     [8  7  4  2  1  1]
        
        int[] trying = new int[N+2];
        int[] dp = new int[N+2];
        
        for (int i : stages){
            trying[i]++;
        }
        
        dp[N+1] = trying[N+1];
        for (int i = N; i >= 1; i--){
            dp[i] = dp[i+1] + trying[i];
        }
        
        for (int i = 1; i <= N; i++){
            if (dp[i] == 0){
                list.add(new difficulty(i, 0));
                continue;
            }
            
            double d = (double)trying[i]/dp[i];
            
            list.add(new difficulty(i, d));
        }
        
        Collections.sort(list, (difficulty a, difficulty b) -> {
           if (a.failure == b.failure){
                return Integer.compare(a.stages, b.stages);   
           }
            return Double.compare(b.failure, a.failure);
        });
        
        Iterator<difficulty> iter = list.iterator();
        while (iter.hasNext()){
            difficulty d = iter.next();
            answer.add(d.stages);
        }
        // for (int i = 1; i <= N; i++){
        //     System.out.print(dp[i] + " ");
        // }
        return answer;
    }
}