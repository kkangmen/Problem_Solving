import java.util.*;

class Solution {
    
    public String[][] operation = {
        {"*", "+", "-"},
        {"*", "-", "+"},
        {"+", "*", "-"},
        {"+", "-", "*"},
        {"-", "*", "+"},
        {"-", "+", "*"}
    };
    
    public long execute(long num1, long num2, String operator){
        switch(operator){
            case ("*"): return num1*num2;
            case ("+"): return num1+num2;
            default: return num1-num2;
        }
    }
    
    public List<String> calculate(List<String> copy, String operator){
        Stack<String> s = new Stack<>();
        
        for (int i = 0; i < copy.size(); i++){
            String token = copy.get(i);
            
            if (token.equals(operator)){
                long num1 = Long.parseLong(s.pop());
                long num2 = Long.parseLong(copy.get(++i));
                s.push(String.valueOf(execute(num1, num2, token)));
            } else {
                s.push(token);
            }
        }
        
        List<String> result = new ArrayList<>(s);
        return result;
    }
    
    public long solution(String expression) {
        long answer = 0;
        
        // 연산자 분리
        List<String> express = new ArrayList<>();
        
        StringBuilder sb = new StringBuilder();
        for (char ch : expression.toCharArray()){
            if (Character.isDigit(ch)){
                sb.append(ch);
            } else {
                express.add(sb.toString());
                sb.setLength(0);
                express.add(String.valueOf(ch));
            }
        }
        express.add(sb.toString());
        
        // 각 operation마다 반복
        for (String[] oper : operation){
            
            List<String> copy = new ArrayList<>(express);
            
            for (String operator : oper){
                copy = calculate(copy, operator);
            }
            
            // 정답 최신화
            answer = Math.max(answer, Math.abs(Long.parseLong(copy.getFirst())));
        }
        
        return answer;
    }
}