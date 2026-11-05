import java.util.*;

class Solution {
    
    Queue<Integer> q = new LinkedList<>();
    int[] distance;
    
    public boolean checkOneDiff(String pivot, String word){
        int diffCount = 0;
        for (int i = 0; i < pivot.length(); i++){
            if (pivot.charAt(i) != word.charAt(i)){
                diffCount++;
            }
        }
        if (diffCount == 1){
            return true;
        }
        return false;
    }
        
    public void bfs(String[] words){
        while (!q.isEmpty()){
            int wordIdx = q.poll();
            
            for (int i = 0; i < words.length; i++){
                if (distance[i] == 0 && checkOneDiff(words[wordIdx], words[i])){
                    q.offer(i);
                    distance[i] = distance[wordIdx] + 1;
                }
            }
        }
    }
    
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        
        distance = new int[words.length];
        for (int i = 0; i < words.length; i++){
            if (checkOneDiff(begin, words[i])){
                q.offer(i);
                distance[i] = 1;
            }
        }
        bfs(words);
        
        for (int i = 0; i < words.length; i++){
            if (words[i].equals(target)){
                return distance[i];
            }
        }
        return 0;
    }
}