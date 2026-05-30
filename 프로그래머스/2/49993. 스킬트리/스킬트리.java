import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        for (String s : skill_trees){
            String replacedWord = s.replaceAll("[^" + skill + "]", "");
            // System.out.println(replacedWord);
            
            for (int i = 0; i <= skill.length(); i++){
                if (replacedWord.equals(skill.substring(0, i))){
                    answer += 1;
                    break;
                }
            }
        }
        
        // for (String s : skill_trees){
        //     System.out.println(s);
        // }
        return answer;
    }
}