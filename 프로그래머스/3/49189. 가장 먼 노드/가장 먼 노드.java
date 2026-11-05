import java.util.*;

class Solution {
    
    int[] distance;
    Map<Integer, List<Integer>> graph = new HashMap<>();
    Queue<Integer> q = new LinkedList<>();
    
    public void bfs(int start){
        q.offer(start);
        distance[start] = 0;
        
        while (!q.isEmpty()){
            int node = q.poll();
            
            for (int i = 0; i < graph.get(node).size(); i++){
                int nNode = graph.get(node).get(i);
                
                if (distance[nNode] == -1){
                    q.offer(nNode);
                    distance[nNode] = distance[node]+1;
                }
            }
        }
    }
    
    public int solution(int n, int[][] edge) {
        int answer = 0;
        
        // 초기화
        distance = new int[n];
        for (int i = 0; i < n; i++){
            graph.put(i, new LinkedList<>());
        }
        Arrays.fill(distance, -1);
        
        for (int[] row : edge){
            graph.get(row[0]-1).add(row[1]-1);
            graph.get(row[1]-1).add(row[0]-1);
        }
        
        // bfs
        bfs(0);
        
        int maxDistance = 0;
        for (int i : distance){
            maxDistance = Math.max(maxDistance, i);
        }
        
        for (int i : distance){
            if (maxDistance == i){
                answer++;
            }
        }
        return answer;
    }
}