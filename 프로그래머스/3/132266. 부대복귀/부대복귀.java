import java.util.*;

class Solution {
    
    int[] dest;
    Map<Integer, List<Integer>> graph = new HashMap<>();
    Queue<Integer> q = new LinkedList<>();
    
    public void bfs(int start){
        dest[start] = 0;
        q.offer(start);
        
        while (!q.isEmpty()){
            int curNode = q.poll();
            
            for (int i = 0; i < graph.get(curNode).size(); i++){
                int nxtNode = graph.get(curNode).get(i);
                if (dest[nxtNode] == -1){
                    q.offer(nxtNode);
                    dest[nxtNode] = dest[curNode] + 1;
                }
            }
        }
    }
    
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        List<Integer> answer = new LinkedList<>();
        
        // 초기화
        for (int i = 0; i <= n; i++){
            graph.put(i, new LinkedList<>());
        }
        
        for (int[] road : roads){
            graph.get(road[0]).add(road[1]);
            graph.get(road[1]).add(road[0]);
        }
        
        dest = new int[n+1];
        Arrays.fill(dest, -1);
        
        bfs(destination);
        
        for (int source : sources){
            answer.add(dest[source]);
        }
        return answer.stream().mapToInt(i -> i).toArray();
    }
}