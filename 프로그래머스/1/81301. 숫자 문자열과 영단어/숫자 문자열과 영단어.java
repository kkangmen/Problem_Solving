import java.util.*;

class Solution {
    public Integer solution(String s) {
        StringBuilder answer = new StringBuilder();
        
        Map<String, Integer> map = new HashMap<>();
        
        map.put("zero", 0);
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);
        map.put("four", 4);
        map.put("five", 5);
        map.put("six", 6);
        map.put("seven", 7);
        map.put("eight", 8);
        map.put("nine", 9);
        
        String sb = "";
        for (char c : s.toCharArray()){
            if (c >= '0' && c <= '9'){
                answer.append(String.valueOf(c));
            }
            else {
                sb += String.valueOf(c);
                
                if (map.get(sb) != null){
                    answer.append(String.valueOf(map.get(sb)));
                    sb = "";
                }
            }
        }
        // for(String str : map.keySet()){
        //     System.out.println(map.get(str));
        // }
        return Integer.valueOf(answer.toString());
    }
}