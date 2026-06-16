import java.util.*;

class Solution {
    
    Map<Integer, Long> map = new LinkedHashMap<>();
    List<Integer> list;
    long answer = 0;
    
    public void gcp(int num1, int num2){
        int a = num1;
        int b = num2;
        
        while (b != 0){
            int temp = a % b;
            a = b;
            b = temp;
        }
        if ((num1 / a == 2 && num2 / a == 3) ||
            (num1 / a == 1 && num2 / a == 2) ||
            (num1 / a == 3 && num2 / a == 4)){
            answer += map.get(num1) * map.get(num2);
        }

    }
    
    public long solution(int[] weights) {
        
        Arrays.sort(weights);
        
        for (int i : weights){
            map.put(i, map.getOrDefault(i, 0L) + 1L);
        }
        
        list = new ArrayList<>(map.keySet());
        
        for (int i = 0; i < list.size()-1; i++){
            for (int j = i+1; j < list.size(); j++){
                int num1 = list.get(i);
                int num2 = list.get(j);
            
                gcp(num1, num2);
            }
        }
        
        for (long num : map.values()){
            answer += num*(num-1)/2;
        }
        return answer;
    }
}