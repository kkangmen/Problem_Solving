import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        
        int[] alphabet = new int['Z'-'A'+1];
        Arrays.fill(alphabet, 101);
        
        for (String s : keymap){
            for (int i = 0; i < s.length(); i++){
                char ch = s.charAt(i);
                
                if (alphabet[ch-'A'] > i){
                    alphabet[ch-'A'] = i+1;
                }
            }
        }
        
        for (int i = 0; i < targets.length; i++){
            String s = targets[i];
            int sum = 0;
            for (char ch : s.toCharArray()){
                if (alphabet[ch-'A'] == 101){
                    sum = -1;
                    break;
                }
                sum += alphabet[ch-'A'];
            }
            answer[i] = sum;
        }
        return answer;
    }
}