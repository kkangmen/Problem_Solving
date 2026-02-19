import java.util.*;

class Solution {
    static List<List<Integer>> graph = new LinkedList<>();
    static boolean[] isVisited;
    static int[] distance;
    static Queue<Integer> q = new LinkedList<>();
    static int maxDistance = 0;
    
    public void bfs(int start){
        isVisited[start] = true;
        q.offer(start);
        
        while (!q.isEmpty()){
            int node = q.poll();
            
            for (int i = 0; i < graph.get(node).size(); i++){
                int n_node = graph.get(node).get(i);
                if (!isVisited[n_node]){
                    q.offer(n_node);
                    isVisited[n_node] = true;
                    distance[n_node] = distance[node] + 1;
                    maxDistance = distance[n_node];
                }
            }
        }
    }
    
    public int solution(int n, int[][] edge) {
        int answer = 0;
        
        isVisited = new boolean[n+1];
        distance = new int[n+1];
        
        for (int i = 0; i <= n; i++){
            graph.add(new LinkedList<>());
        }
        
        for (int[] e : edge){
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }
        
        bfs(1);
        
        for (int i = 1; i <= n; i++){
            if (distance[i] == maxDistance){
                answer++;
            }
        }
        
        return answer;
    }
}