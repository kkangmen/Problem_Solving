import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        
        int sameChar = 0;
        int diffChar = 0;
        char pointChar = '0';
        for (char ch : s.toCharArray()){
            
            if (pointChar == '0'){
                answer++;
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
                sameChar = 0;
                diffChar = 0;
                pointChar = '0';
            }
        }
        
        // if (sameChar != 0){
        //     answer++;
        // }
        return answer;
    }
}