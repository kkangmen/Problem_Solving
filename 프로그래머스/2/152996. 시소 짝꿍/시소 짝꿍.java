import java.util.*;

class Solution {
    
    Map<Integer, Long> map = new LinkedHashMap<>();
    public boolean checkPossible(int small, int big){
        if ((small * 4 == big * 3)
           || (small * 4 == big * 2)
           || (small * 3 == big * 2)){
            return true;
        }
        return false;
    }
    
    public long solution(int[] weights) {
        long answer = 0;
        
        Arrays.sort(weights);
        
        for (int weight : weights){
            map.put(weight, map.getOrDefault(weight, 0L) + 1L);
        }    
        
        for (int key1 : map.keySet()){
            for (int key2 : map.keySet()){
                if (key1 == key2){
                 continue;   
                } else {
                    if(checkPossible(key1, key2)){
                        answer += map.get(key1) * map.get(key2);
                    }
                }
            }
        }
        
        for (long value : map.values()){
            if (value >=2){
                answer += value*(value-1)/2;
            }
        }
        return answer;
    }
}