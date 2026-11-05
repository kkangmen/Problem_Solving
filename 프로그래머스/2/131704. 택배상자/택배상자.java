import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        
        int[] arr = new int[order.length];
        for (int i = 0; i < arr.length; i++){
            arr[i] = i+1;
        }
        
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < order.length; i++){
            s.push(arr[i]);
            
            while (!s.isEmpty() && s.peek() == order[answer]){
                answer++;
                s.pop();
            }
        }
        return answer;
    }
}