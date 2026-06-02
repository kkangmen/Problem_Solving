import java.util.*;

class Solution {
    
    static String[] vowels = {"A", "E", "I", "O", "U"};
    static String[] words = new String[5];
    static List<String> wordsOrder = new ArrayList<>();
    
    public void bF(int count){
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++){
            sb.append(words[i]);
        }
        wordsOrder.add(sb.toString());
        
        if (count == 5){
            return;
        }
        
        for (int i = 0; i < 5; i++){
            words[count] = vowels[i];
            bF(count+1);
        }
    }
    
    public int solution(String word) {    
        int answer = 0;
        
        bF(0);
        
        answer = wordsOrder.indexOf(word);
        return answer;
    }
}