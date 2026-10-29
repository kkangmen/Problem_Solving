import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        // 참가자들을 map에 등록
        Map<String, Integer> map = new HashMap<>();
        for (String p : participant){
            map.put(p, map.getOrDefault(p, 0) + 1);
        }
        
        // 완주한 참가자들을 순서대로 맵에서 제거
        for (String c : completion){
            map.put(c, map.get(c) - 1);
            
            // 해당 이름의 사람이 존재하지 않으면 제거.
            if (map.get(c) == 0){
                map.remove(c);
            }
        }
        
        // 마지막 남아있는 사람이 정답
        for (String k : map.keySet()){
            answer = k;
        }
        return answer;
    }
}