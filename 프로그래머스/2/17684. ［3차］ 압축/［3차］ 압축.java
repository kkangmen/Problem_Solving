import java.util.*;

class Solution {
    
    static HashMap<String, Integer> dictionary = new HashMap<>();
    static int index = 0;
    
    public List<Integer> solution(String msg) {
        List<Integer> answer = new ArrayList<>();
        
        for (char ch = 'A'; ch <= 'Z'; ch++){
            dictionary.put(String.valueOf(ch), ++index);        
        }
        
        String word = "";
        int prevIndex = 0;
        for (int i = 0; i < msg.length(); i++){
            word += msg.charAt(i);
            
            if(!dictionary.containsKey(word)){
                dictionary.put(word, ++index);
                word = "";
                i--;
                answer.add(prevIndex);
            } else{
                prevIndex = dictionary.get(word);
            }
        }
        
        answer.add(dictionary.get(word));
        
        return answer;
    }
}