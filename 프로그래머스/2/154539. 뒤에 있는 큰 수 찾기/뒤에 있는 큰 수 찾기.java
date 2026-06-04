import java.util.*;

class Solution {
    
    static Stack<Integer> s = new Stack<>();
    
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        
        s.push(0);
        
        for (int i = 1; i < numbers.length; i++){
            while (!s.isEmpty() && numbers[s.peek()] < numbers[i]){
                answer[s.pop()] = numbers[i];
            }
            s.push(i);
        }
        
        while (!s.isEmpty()){
            answer[s.pop()] = -1;
        }
        return answer;
    }
}