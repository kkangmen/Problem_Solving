import java.util.*;

class Solution {
    static List<String> word1 = new LinkedList<>();
    static List<String> word2 = new LinkedList<>();
    static List<String> temp = new LinkedList<>(word1);
    
    public int solution(String str1, String str2) {
        List<String> inter = new LinkedList<>(); // 1, 2, 2
        List<String> union = new LinkedList<>(); // 1, 1, 2, 2, 3
        
        devide(str1, word1);
        devide(str2, word2);
        
        if (word1.size() == 0 && word2.size() == 0){
            return 65536;
        }
        
        for (String s : word1){
            if (word2.remove(s)){
                inter.add(s);
            }
            union.add(s);
        }
        
        union.addAll(word2);
        
        double answer = (double)inter.size()/(double)union.size() * 65536;
        return (int)answer;
    }
    
    public void devide(String word, List<String> word1){
        for (int i = 0; i < word.length()-1; i++){
            String s = word.substring(i, i+2).toUpperCase();
            
            if ('A' <= s.charAt(0) && s.charAt(0) <= 'Z'){
                if ('A' <= s.charAt(1) && s.charAt(1) <= 'Z'){
                    word1.add(s);
                }
            }
        }
    }
}