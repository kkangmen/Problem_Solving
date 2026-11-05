import java.util.*;

class Solution {
    
    static Queue<Long> q1 = new LinkedList<>();
    static Queue<Long> q2 = new LinkedList<>();
    
    public int solution(int[] queue1, int[] queue2) {
        long sumQ1 = 0;
        long sum = 0;
        for (int i = 0; i < queue1.length; i++){
            sumQ1 += (long)queue1[i];
            sum += (long)queue1[i];
            sum += (long)queue2[i];
        }
        
        // // 합이 홀수면 불가능
        // if (sum % 2 != 0){
        //     return -1;
        // }
        
        for (int i = 0; i < queue1.length; i++){
            q1.offer((long)queue1[i]);
            q2.offer((long)queue2[i]);
        }
        
        int tryCount = 0;
        while (tryCount != (q1.size() + q2.size())*2){
            
            // 정답
            if (sumQ1 == sum/2){
                return tryCount;
            }
            else if (sumQ1 < sum/2){
                sumQ1 += q2.peek();
                q1.offer(q2.poll());
            }
            else {
                sumQ1 -= q1.peek();
                q2.offer(q1.poll());
            }
            tryCount++;
        }
        
        return -1;
    }
}