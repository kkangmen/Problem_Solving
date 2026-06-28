import java.util.*;

class Solution {
    
    Stack<Integer> s = new Stack();
    
    public int solution(int[] order) {
        int index = 0;
        for (int i = 1; i <= order.length; i++){
            s.push(i);
            
            while (!s.isEmpty() && s.peek() == order[index]){
                s.pop();
                index++;
            }
        }
        return index;
    }
}