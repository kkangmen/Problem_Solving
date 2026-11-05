import java.util.*;

class Solution {
    
    public int split(String p){
        int count = 0;
        int index = 0;
        for (int i = 0; i < p.length(); i++){
            char ch = p.charAt(i);
            if (ch == '('){
                count++;
            } else {
                count--;
            }
            
            if (count == 0){
                index = i;
                break;
            }
        }
        return index;
    }
    
    public boolean possible(String p){
        Stack<Character> s = new Stack<>();
        
        for (char ch : p.toCharArray()){
            if (ch == '('){
                s.push('(');
            } else {
                if (s.isEmpty()){
                    return false;
                } else {
                    s.pop();
                }
            }
        }
        
        if (s.isEmpty()){
            return true;
        } else {
            return false;
        }
    }
    
    public String recursive(String p){
        // System.out.println("recursive = " + p);
        if (possible(p)){
            return p;
        }    
        
        // 균형잡힌 문자열로 나눈다.
        int index = split(p);
        String u = p.substring(0, index+1);
        String v = p.substring(index+1);
        // System.out.println("u = " + u);
        // System.out.println("v = " + v);
        // u가 "올바른 괄호"라면
        if (possible(u)){
            return u + recursive(v);
        } else {
            // u의 앞뒤 문자 제거 ...
            StringBuilder sb = new StringBuilder();
            String remove = u.substring(1, u.length()-1);
            // System.out.println("remove = " + remove);
            for (int i = 0; i < remove.length(); i++){
                char temp = (remove.charAt(i) == '(') ? ')' : '(';
                sb.append(temp);
            }
            // System.out.println("sb = " + sb.toString());
            u = sb.toString();
            // System.out.println("바꾼 u = " + u);
            return "(" + recursive(v) + ")" + u;
        }
    }
    
    public String solution(String p) {
        return recursive(p);
    }
}