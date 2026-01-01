import java.util.*;

class Solution {
    public List<Integer> solution(int k, int[] score) {
        List<Integer> answer = new ArrayList<>();
        
        List<Integer> scoreList = new ArrayList<>();
        
        for (int daliyScore : score){
            scoreList.add(daliyScore);
            
            Collections.sort(scoreList);
            
            if (scoreList.size() > k){
                scoreList.remove(0);
            }
            
            answer.add(scoreList.get(0));
            
            // for (int i : scoreList){
            //     System.out.print(i + " ");
            // }
            // System.out.println();
        }
        return answer;
    }
}