import java.util.*;

class Solution {
    
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    
    public int solution(int x, int y, int n) {
        int answer = 0;
        
        int[] dp = new int[1000001];
        Arrays.fill(dp, 1000000);
        dp[x] = 0;
        pq.offer(x);
        while (true){
            if (pq.isEmpty()){
                return -1;
            }
            
            int num = pq.poll();
            if(num == y){
                return dp[num];
            }
            
            if (num+n <= 1000000){
                if (dp[num+n] > dp[num]+1){
                    dp[num+n] = dp[num] + 1;
                    pq.offer(num+n);
                }              
            }
            
            if (num*2 <= 1000000){
                if (dp[num*2] > dp[num]+1){
                    dp[num*2] = dp[num] + 1;
                    pq.offer(num*2);
                }               
            }
    
            if (num*3 <= 1000000){
                if (dp[num*3] > dp[num]+1){
                    dp[num*3] = dp[num] + 1;
                    pq.offer(num*3);
                }
            }
        }
    }
}