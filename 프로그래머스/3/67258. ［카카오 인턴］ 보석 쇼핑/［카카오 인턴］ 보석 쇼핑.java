import java.util.*;

class Solution {
    
    Set<String> set = new HashSet<>();
    Map<String, Integer> map = new HashMap<>();
    
    public int[] solution(String[] gems) {
        int[] answer = new int[]{1, gems.length};
        
        for (String gem : gems){
            set.add(gem);
        }
        int kind = set.size();
        
        int start = 0;
        for (int end = 0; end < gems.length; end++){
            map.put(gems[end], map.getOrDefault(gems[end], 0) + 1);
            
            while (map.size() == kind){
                // System.out.println("start: " + start + " end: " + end);
                // 값 최신화
                int gap = answer[1] - answer[0];
                if (gap > end - start){
                    answer[0] = start+1;
                    answer[1] = end+1;
                }
                
                // 맨 앞 원소 제거
                map.put(gems[start], map.get(gems[start])-1);
                
                if (map.get(gems[start]) == 0){
                    map.remove(gems[start]);
                }
                start++;
            }
        }
        return answer;
    }
}