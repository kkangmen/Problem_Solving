import java.util.*;

class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int right = 0;
        int left = 100001;
        for (int i = 0; i < diffs.length; i++){
            right = Math.max(right, diffs[i]);
            left = Math.min(left, diffs[i]);
        }
        int answer = right;
        int result = 1;
        while (left <= right){
            System.out.print("left = " + left + " ");
            System.out.print("right = " + right + " ");
            result = (left + right)/2;
            long sum = 0;
            for (int i = 0; i < diffs.length; i++){
                if (diffs[i] <= result){
                    sum += times[i];
                }
                else {
                    sum += (times[i-1] + times[i]) * (diffs[i] - result) + times[i];
                }
            }
            if (sum <= limit){
                if (answer > result){
                    answer = result;
                }
                right = result - 1;
            }
            else {
                left = result + 1;
            }
        }
        
        return answer;
    }
}