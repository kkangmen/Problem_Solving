import java.util.*;

class Solution {
    public List<Integer> solution(String s) {
        List<Integer> answer = new ArrayList<>();
        
        int[] alphabet = new int[27];
        
        Arrays.fill(alphabet, -1);
        
        for (int i = 0; i < s.length(); i++){
            int num = s.charAt(i) - 'a';
            
            if(alphabet[num] == -1){
                answer.add(-1);
                alphabet[num] = i;
            }
            else {
                int gap = i - alphabet[num];
                answer.add(gap);
                alphabet[num] = i;
            }
        }
        return answer;
    }
}