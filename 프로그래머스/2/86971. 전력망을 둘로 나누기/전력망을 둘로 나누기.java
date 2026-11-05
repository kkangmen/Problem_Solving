import java.util.*;

class Solution {
    
    Map<Integer, List<Integer>> graph;
    boolean[] isVisited;
    
    public int bfs(int start){
        Queue<Integer> q = new LinkedList<>();
        
        int count = 1;
        q.offer(start);
        isVisited[start] = true;
        
        while (!q.isEmpty()){
            int cur = q.poll();
            for (int i = 0; i < graph.get(cur).size(); i++){
                int nCur = graph.get(cur).get(i);
                if (!isVisited[nCur]){
                    q.offer(nCur);
                    isVisited[nCur] = true;
                    count++;
                }
            }
        }
        return count;
    }
    
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        
        for (int i = 0; i < wires.length; i++){
            graph = new HashMap<>();
            isVisited = new boolean[n];
            
            for (int k = 0; k < n; k++){
                graph.put(k, new ArrayList<>());
            }
            
            // 그래프 그리기
            for (int j = 0; j < wires.length; j++){
                if (i == j){
                    continue;
                }
                
                graph.get(wires[j][0]-1).add(wires[j][1]-1);
                graph.get(wires[j][1]-1).add(wires[j][0]-1);
            }
            
            boolean flag = false;
            int num1 = 0;
            int num2 = 0;
            for (int k = 0; k < n; k++){
                if (!isVisited[k] && !flag){
                    num1 = bfs(k);
                    flag = true;
                }
                else if (!isVisited[k] && flag){
                    num2 = bfs(k);
                }
            }
            answer = Math.min(answer, Math.abs(num1 - num2));
        }
        return answer;
    }
}