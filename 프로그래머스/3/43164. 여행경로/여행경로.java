import java.util.*;

class Solution {
    
    boolean[] isVisited;
    boolean flag = false;
    List<String> answer;
    
    public void dfs(int index, List<String> cur, String[][] tickets){
        // System.out.println("index = " + index);
        
        cur.add(tickets[index][0]);
        isVisited[index] = true;
        
        if (cur.size() == tickets.length){
            cur.add(tickets[index][1]);
            answer = new ArrayList<>(cur);
            flag = true;
        }
        
        for (int i = 0; i < tickets.length; i++){
            if (tickets[index][1].equals(tickets[i][0])
               && !isVisited[i]){
                dfs(i, cur, tickets);
                if (flag){
                    return;
                }
            }
        }
        
        cur.remove(cur.size()-1);
        isVisited[index] = false;
    }
    
    public List<String> solution(String[][] tickets) {
        List<String> cur = new ArrayList<>();
        
        Arrays.sort(tickets, (o1, o2) -> {
           return o1[1].compareTo(o2[1]); 
        });
        isVisited = new boolean[tickets.length];
        
        for (int i = 0; i < tickets.length; i++){
            String[] ticket = tickets[i];
            
            if (ticket[0].equals("ICN") && !flag){
                dfs(i, cur, tickets);
            }
        }
        
        return answer;
    }
}