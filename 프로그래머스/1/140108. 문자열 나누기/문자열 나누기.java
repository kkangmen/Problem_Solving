import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        
        int sameChar = 0;
        int diffChar = 0;
        char pointChar = '0';
        for (int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            
            if (pointChar == '0'){
                pointChar = ch;
                sameChar++;
                continue;
            }
            
            if (pointChar != ch){
                diffChar++;
            }
            else {
                sameChar++;
            }
            
            // check
            if (sameChar == diffChar){
                answer++;
                sameChar = 0;
                diffChar = 0;
                pointChar = '0';
            }
        }
        
        if (sameChar != 0){
            answer++;
        }
        return answer;
    }
}