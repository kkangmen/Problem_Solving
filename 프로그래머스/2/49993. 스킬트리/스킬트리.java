import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        List<String> cleanSkill = new ArrayList<>();
        
        for (String s : skill_trees){
            String word = s;
            for (int i = 0; i < s.length(); i++){
                boolean hasChar = false;
                for (int j = 0; j < skill.length(); j++){
                    if (s.charAt(i) == skill.charAt(j)){
                        hasChar = true;
                    }
                }
                if (!hasChar){
                    word = word.replace(String.valueOf(s.charAt(i)), "");
                }
            }
            cleanSkill.add(word);
        }
        
        for (String s : cleanSkill){
            // System.out.println(s);
            if (skill.startsWith(s)){
                // System.out.println("증가");
                answer++;
            }
        }
        return answer;
    }
}