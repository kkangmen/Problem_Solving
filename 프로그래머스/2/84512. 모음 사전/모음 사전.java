import java.util.*;

class Solution {
    private static List<String> dictionary = new LinkedList<>();
    private static String[] vowel = {"A", "E", "I", "O", "U"};
    
    public void dfs(String s, int depth){
        dictionary.add(s);
        if (s.length() == 5){
            return;
        }
        
        for (int i = 0; i < 5; i++){
            dfs(s + vowel[i], depth+1);
        }
    }
    
    public int solution(String word) {
        int answer = 0;        
        dfs("", 0);
        
        return dictionary.indexOf(word);
    }
}