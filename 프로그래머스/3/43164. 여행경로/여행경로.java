import java.util.*;

class Solution {
    
    boolean[] isVisited;
    boolean flag = false;
    
    public void dfs(int index, String dest, String[][] tickets, List<String> answer){
        // System.out.println(tickets[index][0] + " " + dest);
        
        isVisited[index] = true;
        answer.add(tickets[index][0]);
        
        // 종료 조건
        if (answer.size() == tickets.length){
            // System.out.println("종료조건");
            
            flag = true;
            answer.add(tickets[index][1]);
            // for (String s : answer){
            //     System.out.print(s + " ");
            // }
            // System.out.println();
            return;
        }
        
        for (int i = 0; i < tickets.length; i++){
            if (!isVisited[i] && tickets[i][0].equals(dest)){
                dfs(i, tickets[i][1], tickets, answer);
                if (flag) return;
            }
        }
        
        isVisited[index] = false;
        answer.remove(answer.size()-1);
    }
    
    public String[] solution(String[][] tickets) {
        List<String> answer = new LinkedList<>();
        
        Arrays.sort(tickets, (s1, s2) -> s1[1].compareTo(s2[1]));
        isVisited = new boolean[tickets.length];
        
        for (int i = 0; i < tickets.length; i++){
            if (tickets[i][0].equals("ICN")){
                dfs(i, tickets[i][1], tickets, answer);
                if (flag) break;
            }
        }
        
        return answer.toArray(new String[0]);
    }
}