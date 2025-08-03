import java.util.*;

class Solution {
    static List<List<Integer>> graph = new LinkedList<>();
    static boolean[] isVisited;
    static int[] distance;
    static Queue<Integer> q = new LinkedList<>();
    
    public void bfs(int start){
        isVisited[start] = true;
        distance[start] = 0;
        q.offer(start);
        
        while(!q.isEmpty()){
            int x = q.poll();
            for (int i = 0; i < graph.get(x).size(); i++){
                int y = graph.get(x).get(i);
                if (!isVisited[y]){
                    q.offer(y);
                    isVisited[y] = true;
                    distance[y] = distance[x] + 1;
                }
            }
        }
    }
    
    public int solution(int n, int[][] edge) {
        int count = 0;
        
        isVisited = new boolean[n];
        distance = new int[n];
        for (int i = 0; i < n; i++){
            graph.add(new ArrayList<>());
        }
        
        for (int[] e : edge){
            graph.get(e[0]-1).add(e[1]-1);
            graph.get(e[1]-1).add(e[0]-1);
        }
        
        bfs(0);
        
        int max = 0;
        for (int i = 0; i < n; i++){
            max = Math.max(max, distance[i]);
        }
        
        for (int i = 0; i < n; i++){
            if (distance[i] == max){
                count++;
            }
        }
        return count;
    }
}