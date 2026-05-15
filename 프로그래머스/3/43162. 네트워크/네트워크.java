import java.util.*;

class Solution {
    
    static Map<Integer, List<Integer>> graph = new HashMap<>();
    static boolean[] isVisited;
    static Queue<Integer> q = new LinkedList<>();
    
    public void bfs(int start){
        isVisited[start] = true;
        q.offer(start);
        
        while (!q.isEmpty()){
            int curNode = q.poll();
            for (int i = 0; i < graph.get(curNode).size(); i++){
                int nxtNode = graph.get(curNode).get(i);
                if (!isVisited[nxtNode]){
                    isVisited[nxtNode] = true;
                    q.offer(nxtNode);
                }
            }
        }
    }
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        // graph 초기화
        for (int i = 0; i < n; i++){
            graph.put(i, new ArrayList<>());
        }
        isVisited = new boolean[n];
        
        // graph에 연결 정보 대입
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                if (i == j){
                    continue;
                }
                if (computers[i][j] == 1){
                    graph.get(i).add(j);
                }
            }
        }
        
        // bfs 탐색
        for (int i = 0; i < n; i++){
            if (!isVisited[i]){
                answer++;
                bfs(i);
            }
        }
    
        // // 출력
        // for (int i = 0; i < n; i++){
        //     for (int j = 0; j < graph.get(i).size(); j++){
        //         System.out.print(graph.get(i).get(j) + " ");
        //     }
        //     System.out.println();
        // }
        return answer;
    }
}