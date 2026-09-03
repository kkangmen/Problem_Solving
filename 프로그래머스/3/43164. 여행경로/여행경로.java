import java.util.*;

class Solution {
    List<String> answer = new ArrayList<>();
    boolean[] visited;
    boolean found = false;
    
    public void dfs(String cur, int count, String[][] tickets, List<String> path) {
        path.add(cur);
        
        if (count == tickets.length) {
            answer = new ArrayList<>(path);  // 복사본 저장
            found = true;
            return;
        }
        
        for (int i = 0; i < tickets.length; i++) {
            if (!visited[i] && tickets[i][0].equals(cur)) {
                visited[i] = true;
                dfs(tickets[i][1], count + 1, tickets, path);
                if (found) return;      // 첫 정답을 찾으면 즉시 종료
                visited[i] = false;     // 백트래킹
            }
        }
        
        path.remove(path.size() - 1);   // 실패했으니 되돌리기
    }
    
    public String[] solution(String[][] tickets) {
        // 알파벳 순 정렬: 사전순으로 앞선 경로를 먼저 탐색
        Arrays.sort(tickets, (a, b) -> {
            if (!a[0].equals(b[0])) return a[0].compareTo(b[0]);
            return a[1].compareTo(b[1]);
        });
        
        visited = new boolean[tickets.length];
        dfs("ICN", 0, tickets, new ArrayList<>());
        
        return answer.toArray(new String[0]);
    }
}