import java.util.*;

class Solution {
    public String solution(String s, String skip, int index) {
        StringBuilder answer = new StringBuilder();
            
        for (char ch : s.toCharArray()){
            int count = 0;
            while (count < index){
                ch += 1;
                if (ch > 'z'){
                    ch = 'a';
                }
                
                if (skip.contains(String.valueOf(ch))){
                    // System.out.println(ch + " 포함");
                }
                else{
                    count++;
                }
            }
            // System.out.println(ch);
            answer.append(String.valueOf(ch));
        }    
        return answer.toString();
    }
}

// abcde fghij 5 => klmno