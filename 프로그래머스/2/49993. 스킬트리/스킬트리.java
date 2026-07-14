import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        for (String s : skill_trees){
            s = s.replaceAll("[^" + skill + "]", "");
            
            for (int i = 0; i <= skill.length(); i++){
                String subStr = skill.substring(0, i);
                
                if (s.equals(subStr)){
                    answer++;
                    break;
                }
            }
        }
        return answer;
    }
}