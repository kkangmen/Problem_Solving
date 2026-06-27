import java.util.*;

class Solution {
    
    HashMap<Integer, Integer> map = new LinkedHashMap<>();
    
    public boolean isPossible(int i, int j){
        if ((i*3 == j*2) || (i*2 == j) || (i*4 == j*3)){
            return true;
        }
        return false;
    }
    
    public long solution(int[] weights) {
        long answer = 0;
        
        Arrays.sort(weights);
        
        for (int i : weights){
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        
        List<Integer> list = new ArrayList<>(map.keySet());
        
        for (int i : map.keySet()){
            int num = map.get(i);
            if (num > 1){
                answer += (long)num*(num-1)/2;
            }
        }
        
        for (int i = 0; i < list.size()-1; i++){
            for (int j = i+1; j < list.size(); j++){
                int weight1 = list.get(i);
                int weight2 = list.get(j);
                if (isPossible(weight1, weight2)){
                    answer += (long)map.get(weight1)*(long)map.get(weight2);
                }
            }
        }
        return answer;
    }
}