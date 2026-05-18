import java.util.*;

class Solution {
    
    int answer = Integer.MAX_VALUE;
    boolean[] isVisited;
    
    public boolean canBeNext(String curWord, String nxtWord){
        int diffCount = 0;
        for (int i = 0; i < curWord.length(); i++){
            if (curWord.charAt(i) != nxtWord.charAt(i)){
                diffCount++;
            }
        }
        
        if (diffCount == 1){
            return true;
        }
        return false;
    }
    
    public void dfs(int count, String curWord, String target, String[] words){
        if (curWord.equals(target)){
            answer = Math.min(count, answer);
        }
        
        for (int i = 0; i < words.length; i++){
            if (canBeNext(curWord, words[i]) && !isVisited[i]){
                isVisited[i] = true;
                dfs(count+1, words[i], target, words);
                isVisited[i] = false;
            }
        }
        
    }
    
    public int solution(String begin, String target, String[] words) {
        isVisited = new boolean[words.length];
        
        dfs(0, begin, target, words);
        
        if (answer == Integer.MAX_VALUE){
            return 0;
        }
        return answer;
    }
}