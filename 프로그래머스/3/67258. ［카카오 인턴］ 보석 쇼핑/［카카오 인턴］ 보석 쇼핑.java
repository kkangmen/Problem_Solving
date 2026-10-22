import java.util.*;
class Solution {
    public int[] solution(String[] gems) {
        int[] answer = new int[]{1, gems.length};
        
        // 각 잼마다 set에 저장하여 갯수 세기
        Set<String> set = new HashSet<>();
        for (String gem : gems){
            set.add(gem);
        }
        int kind = set.size();
        
        // 슬라이딩 윈도우
        // left = 0, right = 0 시작
        Map<String, Integer> map = new HashMap<>();
        int left = 0;
        // right 끝까지
        for (int right = 0; right < gems.length; right++){
            String gem = gems[right];
            
            // map에다가 right 인덱스 잼 저장
            map.put(gem, map.getOrDefault(gem, 0) + 1);
            
            // map의 size()가 kind와 같다면 계속
            while (map.size() == kind){
                String leftGem = gems[left];
                
                // left를 map -1
                map.put(leftGem, map.get(leftGem)-1);
                
                // 해당 left가 0이 되면 remove
                if (map.get(leftGem) == 0){
                    map.remove(leftGem);
                }
                
                // 길이 최신화
                if ((right-left) < answer[1]-answer[0]){
                    answer = new int[]{left+1, right+1};
                }
                left++;
            }
        }
        
        return answer;
    }
}