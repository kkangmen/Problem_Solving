import java.util.*;

class Solution {
    
    public void bTracking(String curWord, String word, int index, int endCount, Map<String,Integer> dictionary){
        if (curWord.length() == endCount){
            // System.out.println(curWord);
            dictionary.put(curWord, dictionary.getOrDefault(curWord, 0) + 1);
            return;
        }
        
        for (int i = index; i < word.length(); i++){
            bTracking(curWord + word.charAt(i), word, i+1, endCount, dictionary);
        }
    }
    
    public  List<String> solution(String[] orders, int[] course) {
        List<String> answer = new ArrayList<>();
        
        for (int i = 0; i < orders.length; i++){
            String s = orders[i];
            char[] sArray = s.toCharArray();
            
            Arrays.sort(sArray);
            
            orders[i] = new String(sArray);
        }
        
        for (int i = 0; i < course.length; i++){
            int endCount = course[i]; // 2
            
            // 백트래킹 시작
            Map<String, Integer> dictionary = new HashMap<>();
            
            for (int j = 0; j < orders.length; j++){
                bTracking("", orders[j], 0, endCount, dictionary);
            }
            
            // 가장 많이 주문된 메뉴
            int max = 0;
            for (String menu : dictionary.keySet()){
                int count = dictionary.get(menu);
                if (max <= count){
                    max = count;
                }
            }
            
            // 2개 이상만 정답
            if (max == 1){
                continue;
            }
            for (String menu : dictionary.keySet()){
                if (dictionary.get(menu) == max){
                    answer.add(menu);
                }
            }
        }
        
        Collections.sort(answer);
        return answer;
    }
}