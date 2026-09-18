import java.util.*;

class Solution {
    Map<String, List<String>> map = new HashMap<>();
    Map<String, boolean[]> isVisited = new HashMap<>();
    boolean flag = false;
    List<String> answer = new ArrayList<>();
    
    public void dfs(String point, String[][] tickets, List<String> cur){
        cur.add(point);                        // 수정 1
        
        if (cur.size() == tickets.length + 1){
            answer = new ArrayList<>(cur);
            flag = true;
            return;
        }
        
        List<String> nexts = map.getOrDefault(point, Collections.emptyList());  // 수정 3
        boolean[] visited = isVisited.getOrDefault(point, new boolean[0]);
        
        for (int i = 0; i < nexts.size(); i++){
            if (!visited[i]){
                visited[i] = true;
                dfs(nexts.get(i), tickets, cur);
                if (flag) return;
                visited[i] = false;
            }
        }
        
        cur.remove(cur.size() - 1);            // 수정 2
    }
    
    public String[] solution(String[][] tickets) {
        for (String[] ticket : tickets){
            map.computeIfAbsent(ticket[0], k -> new ArrayList<>()).add(ticket[1]);
        }
        for (String s : map.keySet()){
            Collections.sort(map.get(s));                          // 정렬 먼저
            isVisited.put(s, new boolean[map.get(s).size()]);
        }
        
        dfs("ICN", tickets, new ArrayList<>());
        return answer.toArray(new String[0]);  // 수정 5
    }
}