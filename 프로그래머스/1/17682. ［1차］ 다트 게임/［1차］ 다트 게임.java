import java.util.*;

class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        
        int num = 0;
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < dartResult.length(); i++){
            char c = dartResult.charAt(i);
            if (c >= '0' && c<= '9'){
                char c_next = dartResult.charAt(i+1);
                if (c == '1' && c_next == '0'){
                    num = 10;
                    i++;
                }
                else {
                    num = (int)(c-'0');
                }
                System.out.println(num);
                stack.push(num);
                continue;
            }
            if (c == 'S' || c == 'D' || c == 'T'){
                if (c == 'D'){
                    int k = (int)Math.pow(stack.pop(), 2);
                    stack.push(k);
                }
                else if (c == 'T'){
                    int k = (int)Math.pow(stack.pop(), 3);
                    stack.push(k);
                }
                continue;
            }
            if (c == '*' || c == '#'){
                if (c == '*' && stack.size() == 1){
                    int k = stack.pop();
                    stack.push(k*2);
                }
                else if (c == '*' && stack.size() > 1){
                    int k = stack.pop();
                    int y = stack.pop();
                    stack.push(y*2);
                    stack.push(k*2);
                }
                else if (c == '#'){
                    int k = stack.pop();
                    stack.push(k*(-1));
                }
            }
        }
        
        while (!stack.isEmpty()){
            int n = stack.pop();
            answer += n;
        }
        return answer;
    }
}