import java.util.*;

class Solution {
    
    Map<Integer, Long> map = new LinkedHashMap<>();
    
    public boolean checkPossible(int weight1, int weight2){
        if ((weight1*2 == weight2) 
            || (weight1*3 == weight2*2)
            || (weight1*4 == weight2*3)){
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
        
        List<Integer> weightList = new ArrayList<>(map.keySet());
        for (int i = 0; i < weightList.size()-1; i++){
            for (int j = i+1; j < weightList.size(); j++){
                int weight1 = weightList.get(i);
                int weight2 = weightList.get(j);
                if (checkPossible(weight1, weight2)){
                    // System.out.println(weight1 + " " + weight2);
                    answer += map.get(weight1) * map.get(weight2);
                }   
            }
        }
        // System.out.println(answer);
        // 같은 숫자 쌍
        for (int weight : map.keySet()){
            long num = map.get(weight);
            if (num >= 2){
                answer += num*(num-1)/2;
            }
        }
        return answer;
    }
}