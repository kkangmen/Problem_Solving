import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        
        // clothes를 순회하면서 map에 종류별로 삽입
        Map<String, Integer> map = new HashMap<>();
        for (String[] c : clothes){
            map.put(c[1], map.getOrDefault(c[1], 0) + 1);
        }
        
        // map 사이즈가 1인 경우 -> 그냥 map.get(0) 리턴
        if (map.size() == 1){
            return map.get(clothes[0][1]);
        }
        // 사이즈가 1보다 크다면
        // 각 원소에 1을 더해서 계속 곱하고 마지막에 1 뺴줌
        else {
            for (String key : map.keySet()){
                answer *= map.get(key)+1;
            }
        }
        return answer-1;
    }
}