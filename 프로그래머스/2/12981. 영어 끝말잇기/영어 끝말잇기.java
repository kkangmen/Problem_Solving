import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        
        List<String> usedWords = new ArrayList<>();
        int personNum = 1;
        int rotate = 1;
        int count = 2;
        String firstWord = words[0];
        char lastChar = firstWord.charAt(firstWord.length()-1);
        usedWords.add(firstWord);
        
        for (int i = 1; i < words.length; i++){
            String word = words[i];
            // System.out.println(word);
            
            char firstChar = word.charAt(0);
            // System.out.println(lastChar + " " + firstChar);
            if (lastChar != firstChar || usedWords.contains(word)){
                // System.out.println("종료 조건");
                answer[0] = count;
                answer[1] = rotate;
                break;
            }
            
            usedWords.add(word);
            lastChar = word.charAt(word.length()-1);
            count++;
            if (count == n+1){
                rotate += 1;
                count = 1;
            }
            // System.out.println("rotate: " + rotate + " " + "count: " + count);
        }

        return answer;
    }
}