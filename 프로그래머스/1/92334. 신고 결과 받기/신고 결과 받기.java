import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        
        Set<String> reportSet = new HashSet<>(Arrays.asList(report));
        
        Map<String, Integer> reportCount = new HashMap<>();
        for (String s : reportSet){
            String reported = s.split(" ")[1];
            
            reportCount.put(reported, reportCount.getOrDefault(reported, 0) + 1);
        }
        
        Set<String> bannedList = new HashSet<>();
        for (String s : reportCount.keySet()){
            if (reportCount.get(s) >= k){
                bannedList.add(s);
            }
        }
        
        for (String s : reportSet){
            String reporter = s.split(" ")[0];
            String reported = s.split(" ")[1];
            
            if (bannedList.contains(reported)){
                int index = Arrays.asList(id_list).indexOf(reporter);
                answer[index]++;
            }
        }
        return answer;
    }
}