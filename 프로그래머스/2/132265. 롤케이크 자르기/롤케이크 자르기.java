import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        
        for (int i : topping){
            map2.put(i, map2.getOrDefault(i, 0) + 1);
        }
        
        if (map1.size() == map2.size()){
            answer += 1;
        }
        
        for (int i = 0; i < topping.length; i++){
            int num = topping[i];
            map2.put(num, map2.getOrDefault(num, 0) - 1);
            if (map2.getOrDefault(num, 0) == 0){
                map2.remove(num);
            }
            map1.put(num, map1.getOrDefault(num, 0) + 1);
            
            // System.out.println(map1.size() + " " + map2.size());
            if (map1.size() == map2.size()){
                answer += 1;
            }
        }
        return answer;
    }
}