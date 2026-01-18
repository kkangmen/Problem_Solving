import java.util.*;

class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        
        Long standard = Long.parseLong(p);
        
        for (int i = 0; i < t.length() - p.length()+1; i++){
            String subStr = t.substring(i, i+p.length());
            
            Long compare = Long.parseLong(subStr);
            
            if (compare <= standard){
                answer++;
            }
        }
        return answer;
    }
}