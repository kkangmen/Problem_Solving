import java.util.*;

class Solution {
    public List<Integer> solution(long n) {
        List<Integer> answer = new LinkedList<>();
        
        String s = Long.toString(n);
        
        for (int i = s.length()-1; i >= 0; i--){
            answer.add(Character.getNumericValue(s.charAt(i)));
        }
        
        return answer;
    }
}