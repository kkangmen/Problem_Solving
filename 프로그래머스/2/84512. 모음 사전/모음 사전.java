import java.util.*;

class Solution {
    
    String[] words = {"A", "E", "I", "O", "U"};
    List<String> wordList = new LinkedList<>();
    
    public void bTracking(String curWord,int index){
        if (curWord.length() == 6){
            return;
        }
        
        // System.out.println(curWord);
        wordList.add(curWord);
        
        for (int i = 0; i < 5; i++){
            bTracking(curWord + words[i], i);
        }
    }
    
    public int solution(String word) {
        int answer = 0;
    
        bTracking("", 0);
        return wordList.indexOf(word);
    }
}