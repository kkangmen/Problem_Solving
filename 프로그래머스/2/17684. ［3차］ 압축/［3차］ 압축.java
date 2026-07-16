import java.util.*;

class Solution {
    
    Map<String, Integer> dictionary = new HashMap<>();
    
    public List<Integer> solution(String msg) {
        List<Integer> answer = new LinkedList<>();
        
        int index = 1;
        for (char ch = 'A'; ch <= 'Z'; ch++){
            dictionary.put(String.valueOf(ch), index++);        
        }
        
        String word = "";
        int wordIndex = 0;
        for (int i = 0; i < msg.length(); i++){
            word = word + String.valueOf(msg.charAt(i));
            
            if (dictionary.containsKey(word)){
                wordIndex = dictionary.get(word);
            } else {
                dictionary.put(word, index++);
                answer.add(wordIndex);
                word = "";
                i--;
            }
        }
        answer.add(dictionary.get(word));
        
        return answer;
    }
}