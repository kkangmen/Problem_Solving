import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        
        Set<String> reportSet = new HashSet<>(List.of(report));
        Map<String, Integer> reportMap = new HashMap<>();
        
        for (String s : id_list){
            reportMap.put(s, 0);
        }
        
        for (String s : reportSet){
            String reported = s.split(" ")[1];
            
            reportMap.put(reported, reportMap.getOrDefault(reported, 0) + 1);
        }
        
        List<String> bannedList = new ArrayList<>();
        for (String s : id_list){
            if (k <= reportMap.get(s)){
                bannedList.add(s);
            }
        }
        
        List<String> id_listArray = List.of(id_list);
        for (String s : reportSet){
            String reporter = s.split(" ")[0];
            String reported = s.split(" ")[1];
            
            int index = id_listArray.indexOf(reporter);
            if (bannedList.contains(reported)){
                answer[index]++;
            }
        }
        // Iterator<String> iter = reportSet.iterator();
        // while (iter.hasNext()){
        //     System.out.println(iter.next());
        // }
        return answer;
    }
}