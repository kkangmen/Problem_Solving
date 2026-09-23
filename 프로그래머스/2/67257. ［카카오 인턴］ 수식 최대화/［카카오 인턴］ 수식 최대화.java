import java.util.*;

class Solution {
    
    String[][] priorities = new String[][]{
        {"*", "+", "-"},
        {"*", "-", "+"},
        {"+", "*", "-"},
        {"+", "-", "*"},
        {"-", "+", "*"},
        {"-", "*", "+"}
    };
   
    public Long apply(Long num1, Long num2, String op){
        switch (op){
            case "+": return num1+num2;
            case "-": return num1-num2;
            default: return num1*num2;
        }    
    }
    
    public List<String> calculate(List<String> tokens, String op){
        Stack<String> s = new Stack<>();
        
        for (int i = 0; i < tokens.size(); i++){
            String token = tokens.get(i);
            // 연산자가 일치하면
            if (token.equals(op)){
                Long num1 = Long.parseLong(s.pop());
                Long num2 = Long.parseLong(tokens.get(++i));
                s.push(String.valueOf(apply(num1, num2, op)));
            } else {
                s.push(token);
            }
        }
        
        // 해당 연산자로 계산한 것들을 다시 반환
        List<String> result = new ArrayList<>(s);
        return result;
    }
    
    public long solution(String expression) {
        long answer = 0;
        
        List<String> tokens = new ArrayList<>();
        StringBuilder num = new StringBuilder();
        for (char ch : expression.toCharArray()){
            
            // 숫자라면
            if ('0' <= ch && ch <= '9'){
                num.append(String.valueOf(ch));
            } else {
                tokens.add(num.toString());
                num.setLength(0);
                tokens.add(String.valueOf(ch));
            }
        }
        tokens.add(num.toString());
        
        for (String[] priority : priorities){
            List<String> copy = new ArrayList<>(tokens);
            
            for (String op : priority){
                copy = calculate(copy, op);
            }
            
            answer = Math.max(answer, Math.abs(Long.parseLong(copy.get(0))));
        }
        return answer;
    }
}