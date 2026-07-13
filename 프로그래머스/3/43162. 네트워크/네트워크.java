import java.util.*;

class Solution {
    
    Map<Integer, List<Integer>> graph = new HashMap<>();
    boolean[] isVisited;
    Queue<Integer> q = new LinkedList<>();
    
    public void bfs(int start){
        isVisited[start] = true;
        q.offer(start);
        
        while (!q.isEmpty()){
            int node = q.poll();
            
            for (int i = 0; i < graph.get(node).size(); i++){
                int nNode = graph.get(node).get(i);
                
                if (!isVisited[nNode]){
                    q.offer(nNode);
                    isVisited[nNode] = true;
                }
            }
        }
    }
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        // 초기화
        for (int i = 0; i < n; i++){
            graph.put(i, new LinkedList<>());
        }
        for (int i = 0; i < computers.length; i++){
            for (int j = 0; j < n; j++){
                if (i != j && computers[i][j] == 1){
                    graph.get(i).add(j);
                }
            }
        }
        isVisited = new boolean[n];
        
        for (int i = 0; i < n; i++){
            if (!isVisited[i]){
                answer++;
                bfs(i);
            }
        }
        // for (int i : graph.keySet()){
        //     for (int j = 0; j < graph.get(i).size(); j++){
        //         System.out.print(graph.get(i).get(j));
        //     }
        //     System.out.println();
        // }
        return answer;
    }
}