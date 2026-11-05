import java.util.*;

class Solution {
    public long solution(int[] sequence) {
        long answer = 0;
        
        long[] dp1 = new long[sequence.length];
        long[] dp2 = new long[sequence.length];
        
        for (int i = 0; i < sequence.length; i++){
            if (i%2 == 0){
                dp2[i] = -sequence[i];
                dp1[i] = sequence[i];
            } else {
                dp2[i] = sequence[i];
                dp1[i] = -sequence[i];
            }
        }
        
        long cur1 = dp1[0];
        long max1 = dp1[0];
        for (int i = 1; i < dp1.length; i++){
            cur1 = Math.max(dp1[i], cur1+dp1[i]);
            max1 = Math.max(cur1, max1);
        }
        
        long cur2 = dp2[0];
        long max2 = dp2[0];
        for (int i = 1; i < dp2.length; i++){
            cur2 = Math.max(dp2[i], cur2+dp2[i]);
            max2 = Math.max(cur2, max2);
        }
        
        return Math.max(max1, max2);
    }
}