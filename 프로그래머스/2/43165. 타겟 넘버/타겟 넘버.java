import java.util.*;

class Solution {
    
    static int answer = 0;
    public void pruning(int index, int sum, int length, int target, int[] numbers){
        if (index == length){
            if (sum == target){
                answer++;
            }
            return;
        }
        
        pruning(index+1, sum+numbers[index], length, target, numbers);
        pruning(index+1, sum-numbers[index], length, target, numbers);
    }
    
    public int solution(int[] numbers, int target) {
        
        pruning(0, 0, numbers.length, target, numbers);
        return answer;
    }
}