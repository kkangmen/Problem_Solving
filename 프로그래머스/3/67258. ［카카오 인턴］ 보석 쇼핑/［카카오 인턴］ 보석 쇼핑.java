import java.util.*;

class Solution {
    
    Set<String> gemSet = new HashSet<>();
    Map<String, Integer> map = new HashMap<>();
    
    public int[] solution(String[] gems) {
        int[] answer = new int[2];
        
        for (String s : gems){
            gemSet.add(s);
        }
        int totalKind = gemSet.size();
        
        // 슬라이딩 윈도우 시작
        int startIdx = 0;
        int endIdx = -1;
        int minGap = gems.length+1;
        while (startIdx < gems.length){
            
            // 만약 갯수가 부족하다면 endIdx 증가
            if (map.size() < totalKind){
                endIdx++;
                if (endIdx == gems.length){
                    break;
                }
                map.put(gems[endIdx], map.getOrDefault(gems[endIdx], 0) + 1);
            }
            // 갯수가 충분하면 startIdx 증가
            else {
                map.put(gems[startIdx], map.get(gems[startIdx]) -1);
                
                // 0이 되면 제거
                if (map.get(gems[startIdx]) == 0){
                    map.remove(gems[startIdx]);
                }
                
                startIdx++;
            }
            
            // System.out.println(startIdx + " " + endIdx);
            // 최신화된 현재 갯수가 totalKind와 같을 경우
            if (map.size() == totalKind){
                // System.out.println("가능");
                // 기존 길이보다 짧을 경우 정답 갱신
                int curGap = endIdx-startIdx+1;
                if (minGap > curGap){
                    minGap = curGap;
                    answer[0] = startIdx+1;
                    answer[1] = endIdx+1;
                }
            }
        }
        
        return answer;
    }
}