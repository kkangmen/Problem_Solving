import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;

        Stack<Integer> stack = new Stack<>();
        for (char ch : s.toCharArray()){
            if (ch == '('){
                stack.push(0);
            }
            else {
                if (!stack.isEmpty()){
                    stack.pop();
                }
                else {
                    answer = false;
                    return answer;
                }
            }
        }

        if (!stack.isEmpty()){
            answer = false;
        }
        return answer;
    }
}