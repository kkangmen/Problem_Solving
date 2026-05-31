import java.util.*;

class Solution {
    
    static Map<String, Integer> dictionary = new HashMap<>();
    static int index = 0;
    
    public List<Integer> solution(String msg) {
        List<Integer> answer = new ArrayList<>();
        
        for (char ch = 'A'; ch <= 'Z'; ch++){
            dictionary.put(String.valueOf(ch), ++index);
        }
        
        for (int i = 0; i < msg.length(); ){
            
            String word = String.valueOf(msg.charAt(i));
            int nxtIdx = i+1;
            
            while (nxtIdx < msg.length() && dictionary.containsKey(word + msg.charAt(nxtIdx))){
                word += msg.charAt(nxtIdx);
                nxtIdx++;
            }
            
            answer.add(dictionary.get(word));
            
            if (nxtIdx < msg.length()){
                dictionary.put(word + msg.charAt(nxtIdx), ++index);
            }
            
            i = nxtIdx;
        }
        return answer;
    }
}