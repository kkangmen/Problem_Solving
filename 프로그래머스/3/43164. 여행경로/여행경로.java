import java.util.*;

class Solution {
    
    boolean[] isVisited;
    boolean flag = false;
    List<String> answer;
    
    public void dfs(String dest, List<String> cur, String[][] tickets){
        
        cur.add(dest);
        
        // 전체 다 갈 수 있는 경로일 경우
        if (cur.size() == tickets.length+1){
            answer = new ArrayList<>(cur);
            flag = true;
            return;
        }
        
        for (int i = 0; i < tickets.length; i++){
            String[] ticket = tickets[i];
            
            if (ticket[0].equals(dest) && !isVisited[i]){
                isVisited[i] = true;
                dfs(ticket[1], cur, tickets);
                if (flag){
                    return;
                }
                isVisited[i] = false;
            }
        }
        
        cur.remove(cur.size()-1);
    }
    
    public String[] solution(String[][] tickets) {
        List<String> cur = new ArrayList<>();
        
        Arrays.sort(tickets, (o1, o2) -> o1[1].compareTo(o2[1]));
        isVisited = new boolean[tickets.length];
        
        for (int i = 0; i < tickets.length; i++){
            String[] ticket = tickets[i];
            if (ticket[0].equals("ICN") && !flag){
                cur.add("ICN");
                isVisited[i] = true;
                dfs(ticket[1], cur, tickets);
                cur.remove(cur.size()-1);
                isVisited[i] = false;
            }    
        }
        
        return answer.toArray(new String[answer.size()]);
    }
}