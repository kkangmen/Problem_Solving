import java.util.*;

class Solution {
    
    Map<String, Integer> dictionary = new HashMap<>();
    int index = 1;
    String word = "";
    int findIndex = 0;
    
    public List<Integer> solution(String msg) {
        List<Integer> answer = new ArrayList<>();
        
        for (char ch = 'A'; ch <= 'Z'; ch++){
            dictionary.put(String.valueOf(ch), index++);
        }
        
        for (int i = 0; i < msg.length(); i++){
            word += msg.charAt(i);
            
            // 사전에 해당 단어가 없다면 추가
            if (!dictionary.containsKey(word)){
                dictionary.put(word, index++);  
                // System.out.println(findIndex);
                answer.add(findIndex);
                word = "";
                i--;
            } else {
                findIndex = dictionary.get(word);
            }
        }
        
        // 마지막 문자
        // System.out.println(findIndex);
        answer.add(findIndex);
        return answer;
    }
}